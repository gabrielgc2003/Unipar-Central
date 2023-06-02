package com.mycompany.unipar.central.repositories;

import com.mycompany.unipar.central.models.Estado;
import com.mycompany.unipar.central.models.Pais;
import com.mycompany.unipar.central.utils.db.DatabaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstadoDAO {
    private static final String INSERT = "INSERT INTO ESTADO(ID, NOME, SIGLA, RA, PAIS_ID)" +
            "VALUES (?, ?, ?, ?, ?)";

    private static final String FIND_ALL = "SELECT ID, NOME, SIGLA, RA, PAIS_ID  FROM ESTADO";
    private static final String FIND_BY_ID = "SELECT ID, NOME, SIGLA, RA, PAIS_ID  FROM ESTADO WHERE ID = ?";
    private static final String DELETE_BY_ID = "DELETE FROM PAIS ESTADO ID = ?";
    private static final String UPDATE = "UPDATE ESTADO SET NOME = ?, SIGLA = ?, RA = ?, PAIS_ID = ? WHERE ID = ?";

    public List<Estado> findAll() throws SQLException {
        ArrayList<Estado> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Estado estado = new Estado();
                estado.setId(rs.getInt("ID"));
                estado.setNome(rs.getString("NOME"));
                estado.setSigla(rs.getString("SIGLA"));
                estado.setRa(rs.getString("RA"));
                estado.setPais(new PaisDAO().findById(rs.getInt("PAIS_ID")));
                retorno.add(estado);
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
}
