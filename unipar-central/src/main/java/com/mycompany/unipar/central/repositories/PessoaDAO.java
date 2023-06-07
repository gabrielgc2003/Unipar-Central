package com.mycompany.unipar.central.repositories;

import com.mycompany.unipar.central.models.Pais;
import com.mycompany.unipar.central.models.Pessoa;
import com.mycompany.unipar.central.utils.db.DatabaseUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {
    private static final String INSERT = "INSERT INTO PESSOA(ID, EMAIL, RA)" +
            "VALUES (?, ?, ?)";

    private static final String FIND_ALL = "SELECT ID, EMAIL, RA FROM PESSOA";
    private static final String FIND_BY_ID = "SELECT ID, EMAIL, RA FROM PESSOA WHERE ID = ?";
    private static final String DELETE_BY_ID = "DELETE FROM PESSOA WHERE ID = ?";
    private static final String UPDATE = "UPDATE PESSOA SET EMAIL = ?, RA = ? WHERE ID = ?";

    public List<Pessoa> findAll() throws SQLException {
        ArrayList<Pessoa> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Pessoa pessoa = new Pessoa();
                pessoa.setId(rs.getInt("ID"));
                pessoa.setEmail(rs.getString("EMAIL"));
                pessoa.setRa(rs.getString("RA"));

                retorno.add(pessoa);
            }
        }finally {
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

    public Pessoa findById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Pessoa retorno = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();

            while(rs.next()){
                retorno = new Pessoa();
                retorno.setId(rs.getInt("ID"));
                retorno.setEmail(rs.getString("EMAIL"));
                retorno.setRa(rs.getString("RA"));
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

    public int insert(Pessoa pessoa) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, pessoa.getId());
            pstmt.setString(2, pessoa.getEmail());
            pstmt.setString(3, pessoa.getRa());
            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();

            return rs.getInt(0);


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
    }

    public void update(Pais pais) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, pais.getNome());
            pstmt.setString(2, pais.getSigla());
            pstmt.setString(3, pais.getRa());
            pstmt.setInt(4, pais.getId());
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
