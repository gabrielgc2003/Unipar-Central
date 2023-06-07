package com.mycompany.unipar.central.repositories;

import com.mycompany.unipar.central.models.Banco;
import com.mycompany.unipar.central.models.Estado;
import com.mycompany.unipar.central.utils.db.DatabaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BancoDAO {

    private static final String INSERT = "INSERT INTO Banco(ID, NOME, RA)" +
            "VALUES (?, ?, ?)";

    private static final String FIND_ALL = "SELECT ID, NOME, RA FROM BANCO";
    private static final String FIND_BY_ID = "SELECT ID, NOME, RA FROM BANCO WHERE ID = ?";
    private static final String DELETE_BY_ID = "DELETE FROM PAIS BANCO ID = ?";
    private static final String UPDATE = "UPDATE BANCO SET NOME = ?, RA = ? WHERE ID = ?";

    public List<Banco> findAll() throws SQLException {
        ArrayList<Banco> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Banco banco = new Banco();
                banco.setId(rs.getInt("ID"));
                banco.setNome(rs.getString("NOME"));
                banco.setRa(rs.getString("RA"));
                retorno.add(banco);
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
}
