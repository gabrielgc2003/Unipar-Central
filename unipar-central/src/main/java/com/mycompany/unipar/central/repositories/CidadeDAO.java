/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.unipar.central.repositories;

import java.sql.SQLException;
import com.mycompany.unipar.central.models.Cidade;
import com.mycompany.unipar.central.utils.db.DatabaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author gabri
 */
public class CidadeDAO {
    private static final String INSERT = "INSERT INTO CIDADE (ID, NOME, RA)"
                                        +"VALUES (?, ?, ?)";
    
    private static final String FIND_ALL = "SELECT ID, NOME, RA FROM CIDADE";
    
    private static final String FIND_BY_ID = "SELECT ID, NOME, RA FROM CIDADE "
            + "WHERE ID = ? AND NOME = ?, RA = ?";
    
    private static final String DELETE_BY_ID = "DELETE FROM CIDADE WHERE "
            + "ID = ? AND NOME = ?, RA = ?";
    
    private static final String UPDATE = "UPDATE CIDADE SET ID = ?, NOME = ?, RA = ?"
            + "WHERE ID = ? AND NOME = ?, RA = ? ESTADO_ID = ? WHERE ID = ?";
    
    public List<Cidade> findAll() throws SQLException{
        ArrayList<Cidade> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                Cidade cidade = new Cidade();
                cidade.setId(rs.getInt("ID"));
                cidade.setNome(rs.getString("NOME"));
                cidade.setRa(rs.getString("RA"));
                retorno.add(cidade);
            }
        } finally {
            if(rs != null){
                rs.close();
            }
            
            if(pstmt != null){
                pstmt.close();
            }
            
            if(conn != null){
                conn.close();
            }
        }
        return retorno;
    }
    
    public Cidade findById(int id) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Cidade retorno = null;
        
        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                retorno = new Cidade();
                retorno.setId(rs.getInt("ID"));
                retorno.setRa(rs.getString("RA"));
                retorno.setNome(rs.getString("NOME"));
                retorno.setEstado(new EstadoDAO().findById(
                        rs.getInt("ESTADO_ID")));
                
            }
        } finally {
            if (rs != null) {
                rs.close();
            }

            if (pstmt != null) {
                pstmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        }
        return retorno;
    }
    
    
    public void insert(Cidade cidade) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, cidade.getId());
            pstmt.setString(2, cidade.getNome());
            pstmt.setString(3, cidade.getRa());
            pstmt.executeUpdate();


        } finally {
            if (pstmt != null) {
                pstmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        }
    }

    public void update(Cidade cidade) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, cidade.getNome());
            pstmt.setString(3, cidade.getRa());
            pstmt.setInt(4, cidade.getId());
            pstmt.executeUpdate();


        } finally {
            if (pstmt != null) {
                pstmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        }
    }

    public void delete(int id) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(DELETE_BY_ID);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } finally {
            if (pstmt != null) {
                pstmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        }
    }

}
