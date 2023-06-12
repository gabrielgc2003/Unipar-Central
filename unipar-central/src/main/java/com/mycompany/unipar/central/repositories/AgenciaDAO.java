package com.mycompany.unipar.central.repositories;

import com.mycompany.unipar.central.exceptions.CampoLimiteTamanhoException;
import com.mycompany.unipar.central.exceptions.CampoNaoInformadoException;
import com.mycompany.unipar.central.exceptions.EntidadeNaoInformadaException;
import com.mycompany.unipar.central.models.Agencia;
import com.mycompany.unipar.central.models.Banco;
import com.mycompany.unipar.central.services.AgenciaService;
import com.mycompany.unipar.central.utils.db.DatabaseUtils;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AgenciaDAO {
    private static final String INSERT = "INSERT INTO (CODIGO, DIGITO, RAZAOSOCIAL, CNPJ, RA, BANCO_ID) VALUES (?, ?, ?, ?, ?, ?)";

    private static final String FIND_ALL = "SELECT ID, CODIGO, DIGITO, RAZAOSOCIAL, CNPJ, RA, BANCO_ID FROM AGENCIA WHERE AGENCIA.ID = ?";

    private static final String FIND_BY_ID = "SELECT AGENCIA.ID, CODIGO, DIGITO, RAZAOSOCIAL, CNPJ, AGENCIA.RA, BANCO_ID FROM AGENCIA " +
            "INNER JOIN BANCO b ON (b.id = agencia.banco_id)" +
            "WHERE AGENCIA.ID = ?";



    private static final String DELETE_BY_ID = "DELETE AGENCIA WHERE ID = ?";

    private static final String UPDATE = "UPDATE AGENCIA SET CODIGO = ?, DIGITO = ?, RAZAOSOCIAL = ?, CNPJ = ?, RA = ?, BANCO_ID = ? WHERE ID = ?";

    private void insert (Agencia agencia) throws SQLException{

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            if (agencia.getId() != 0){
                conn =  new DatabaseUtils().getConnection();
                pstm = conn.prepareStatement(INSERT);
                pstm.setString(1, agencia.getCodigo());
                pstm.setString(2, agencia.getDigito());
                pstm.setString(3, agencia.getRazaoSocial());
                pstm.setString(4, agencia.getCnpj());
                pstm.setString(5, agencia.getRa());
                pstm.setInt(6, agencia.getBanco());
            }
        } finally {
            if (conn != null){
                conn.close();
            }
            if (pstm != null){
                pstm.close();
            }
        }
    }

    public Agencia FIND_ALL(int id) throws SQLException{

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Agencia agencia = null;
        Banco banco = null;

        try{
            while(rs.next()){

                conn = new DatabaseUtils().getConnection();
                pstm = conn.prepareStatement(FIND_ALL);
                pstm.setInt(1, id);
                rs = pstm.executeQuery();

                agencia = new Agencia();
                agencia.setId(rs.getInt("ID"));
                agencia.setCodigo(rs.getString("CODIGO"));
                agencia.setDigito(rs.getString("DIGITO"));
                agencia.setRazaoSocial(rs.getString("RAZAOSOCIAL"));
                agencia.setCnpj(rs.getString("CNPJ"));
                agencia.setRa(rs.getString("RA"));
                agencia.setBanco(new BancoDAO().findById(rs.getInt("ID")));
            }
        } finally {
            if (conn != null){
                conn.close();
            }
            if (pstm != null){
                pstm.close();
            }
            if (rs != null){
                rs.close();
            }
        }

        return agencia;
    }

    public Agencia FIND_BY_ID(int id) throws SQLException{

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Agencia agencia = null;
        Banco banco = null;

        try{
            while(rs.next()){

                if (id != 0){
                    conn = new DatabaseUtils().getConnection();
                    pstm = conn.prepareStatement(FIND_BY_ID);
                    pstm.setInt(1, id);
                    rs = pstm.executeQuery();

                    agencia = new Agencia();
                    agencia.setId(rs.getInt("ID"));
                    agencia.setCodigo(rs.getString("CODIGO"));
                    agencia.setDigito(rs.getString("DIGITO"));
                    agencia.setRazaoSocial(rs.getString("RAZAOSOCIAL"));
                    agencia.setCnpj(rs.getString("CNPJ"));
                    agencia.setRa(rs.getString("RA"));
                    agencia.setBanco(new BancoDAO().findById(rs.getInt("ID")));
                }

            }
        } finally {
            if (conn != null){
                conn.close();
            }
            if (pstm != null){
                pstm.close();
            }
            if (rs != null){
                rs.close();
            }
        }

        return agencia;
    }

    public void delete (int id) throws SQLException {

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try{
            conn = new DatabaseUtils().getConnection();
            pstm = conn.prepareStatement(FIND_BY_ID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
        } finally {

            if (conn != null){
                conn.close();
            }
            if (pstm != null){
                pstm.close();
            }
        }

    }

}
