package com.mycompany.unipar.central.repositories;

import com.mycompany.unipar.central.models.PessoaFisica;
import com.mycompany.unipar.central.models.PessoaJuridica;
import com.mycompany.unipar.central.utils.db.DatabaseUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaJuridicaDAO {
    private static final String INSERT = "INSERT INTO PESSOAJURIDICA (RAZAOSOCIAL, CNPJ, CNAEPRINCIPAL, FANTASIA, PESSOA_ID)" +
            "VALUES (?, ?, ?, ?, ?)";
    private static final String FIND_ALL = "SELECT PESSOA.ID," +
                                                  "PESSOA.EMAIL," +
                                                  "PESSOA.RA," +
                                                  "PESSOAJURIDICA.RAZAOSOCIAL," +
                                                  "PESSOAJURIDICA.CNPJ," +
                                                  "PESSOAJURIDICA.CNAEPRINCIPAL," +
                                                  "PESSOAJURIDICA.FANTASIA " +
                                            "FROM PESSOA, PESSOAJURIDICA " +
                                            "WHERE PESSOA.ID = PESSOAJURIDICA.PESSOA_ID";
    private static final String FIND_BY_ID = "SELECT PESSOA.ID," +
                                                    "PESSOA.EMAIL," +
                                                    "PESSOA.RA," +
                                                    "PESSOAJURIDICA.RAZAOSOCIAL," +
                                                    "PESSOAJURIDICA.CNPJ," +
                                                    "PESSOAJURIDICA.CNAEPRINCIPAL," +
                                                    "PESSOAJURIDICA.FANTASIA " +
                                                "FROM PESSOA, PESSOAJURIDICA " +
                                                "WHERE PESSOA.ID = PESSOAJURIDICA.PESSOA_ID " +
                                                "AND PESSOA.ID = ?";
    private static final String DELETE_BY_ID = "DELETE FROM PESSOAJURIDICA WHERE PESSOA_ID = ?";
    private static final String UPDATE = "UPDATE PESSOAJURIDICA SET RAZAOSOCIAL = ?, CNPJ = ?, CNAEPRINCIPAL = ?, FANTASIA = ?  WHERE PESSOA_ID = ?";

    public List<PessoaJuridica> findAll() throws SQLException {
        ArrayList<PessoaJuridica> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();
            while(rs.next()){
                PessoaJuridica pessoaJuridica = new PessoaJuridica();
                pessoaJuridica.setId(rs.getInt("ID"));
                pessoaJuridica.setEmail(rs.getString("EMAIL"));
                pessoaJuridica.setRa(rs.getString("RA"));
                pessoaJuridica.setRazaoSocial(rs.getString("RAZAOSOCIAL"));
                pessoaJuridica.setCnpj(rs.getString("CNPJ"));
                pessoaJuridica.setCnaePrincipal(rs.getString("CNAEPRINCIPAL"));
                pessoaJuridica.setFantasia(rs.getString("FANTASIA"));

                retorno.add(pessoaJuridica);
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

    public PessoaJuridica findById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        PessoaJuridica retorno = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();

            while(rs.next()){
                retorno = new PessoaJuridica();
                retorno.setId(rs.getInt("ID"));
                retorno.setEmail(rs.getString("EMAIL"));
                retorno.setRa(rs.getString("RA"));
                retorno.setRazaoSocial(rs.getString("RAZAOSOCIAL"));
                retorno.setCnpj(rs.getString("CNPJ"));
                retorno.setCnaePrincipal(rs.getString("CNAEPRINCIPAL"));
                retorno.setFantasia(rs.getString("FANTASIA"));
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

    public void insert(PessoaJuridica pessoaJuridica, int idPessoa) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DatabaseUtils().getConnection();
            conn.prepareStatement(INSERT);
            pstmt.setString(1, pessoaJuridica.getRazaoSocial());
            pstmt.setString(2, pessoaJuridica.getCnpj());
            pstmt.setString(3, pessoaJuridica.getCnaePrincipal());
            pstmt.setString(4, pessoaJuridica.getFantasia());
            pstmt.setInt(5, idPessoa);
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

    public void update(PessoaJuridica pessoaJuridica) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, pessoaJuridica.getRazaoSocial());
            pstmt.setString(2, pessoaJuridica.getCnpj());
            pstmt.setString(3, pessoaJuridica.getCnaePrincipal());
            pstmt.setString(4, pessoaJuridica.getFantasia());
            pstmt.setInt(5, pessoaJuridica.getId());
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
