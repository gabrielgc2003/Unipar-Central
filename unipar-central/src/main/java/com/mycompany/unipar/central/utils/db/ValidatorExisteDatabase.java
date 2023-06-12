package com.mycompany.unipar.central.utils.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ValidatorExisteDatabase {

    private final static String findBanco = "SELECT ID FROM BANCO WHERE ID = ?";
    private final static String findAgencia = "SELECT ID FROM AGENCIA WHERE ID = ?";

    public static boolean existeBanco(int idBanco) throws SQLException {

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstm = conn.prepareStatement(findBanco);
            pstm.setInt(1, idBanco);
            rs = pstm.executeQuery();
           return  rs.next();
        } finally {
            if (conn != null){
                conn.close();
            }
            if (pstm != null){
                pstm.close();
            }
        }
    }

    public static boolean existeAgencia (int idAgencia) throws SQLException{

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstm = conn.prepareStatement(findAgencia);
            pstm.setInt(1, idAgencia);
            rs = pstm.executeQuery();

            return rs.next();
        } finally {

            if (conn != null){
                conn.close();
            }
            if (pstm != null) {
                pstm.close();
            }

        }

    }

}
