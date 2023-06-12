package com.mycompany.unipar.central.repositories;

import com.mycompany.unipar.central.models.Pessoa;
import com.mycompany.unipar.central.models.PessoaFisica;
import com.mycompany.unipar.central.utils.db.DatabaseUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaDAO {
    private static final String INSERT = "INSERT INTO PESSOAFISICA (NOME, CPF, RG, DATANASCIMENTO, PESSOA_ID)" +
            "VALUES (?, ?, ?, ?, ?)";
    private static final String FIND_ALL = "SELECT PESSOA.ID," +
                                                 " PESSOA.EMAIL," +
                                                 " PESSOA.RA ," +
                                                 " PESSOAFISICA.NOME," +
                                                 " PESSOAFISICA.CPF," +
                                                 " PESSOAFISICA.RG," +
                                                 " PESSOAFISICA.DATANASCIMENTO " +
                                            "FROM PESSOA, PESSOAFISICA " +
            "                               WHERE PESSOA.ID = PESSOAFISICA.PESSOA_ID";
    private static final String FIND_BY_ID = "SELECT PESSOA.ID," +
                                                    "PESSOA.EMAIL," +
                                                    "PESSOA.RA ," +
                                                    "PESSOAFISICA.NOME," +
                                                    "PESSOAFISICA.CPF," +
                                                    "PESSOAFISICA.RG," +
                                                    "PESSOAFISICA.DATANASCIMENTO " +
                                               "FROM PESSOA, PESSOAFISICA " +
                                               "WHERE PESSOA.ID = PESSOAFISICA.PESSOA_ID " +
                                                 "AND PESSOA.ID = ?";
    private static final String DELETE_BY_ID = "DELETE FROM PESSOAFISICA WHERE PESSOA_ID = ?";
    private static final String UPDATE = "UPDATE PESSOAFISICA SET NOME = ?, CPF = ?, RG = ?, DATANASCIMENTO = ?  WHERE PESSOA_ID = ?";

    public List<PessoaFisica> findAll() throws SQLException {
        ArrayList<PessoaFisica> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();
            while(rs.next()){
                PessoaFisica pessoaFisica = new PessoaFisica();
                pessoaFisica.setId(rs.getInt("ID"));
                pessoaFisica.setEmail(rs.getString("EMAIL"));
                pessoaFisica.setRa(rs.getString("RA"));
                pessoaFisica.setNome(rs.getString("NOME"));
                pessoaFisica.setCpf(rs.getString("CPF"));
                pessoaFisica.setRg(rs.getString("RG"));
                pessoaFisica.setDataNascimento(rs.getDate("DATANASCIMENTO"));

                retorno.add(pessoaFisica);
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

    public PessoaFisica findById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        PessoaFisica retorno = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();

            while(rs.next()){
                retorno = new PessoaFisica();
                retorno.setId(rs.getInt("ID"));
                retorno.setEmail(rs.getString("EMAIL"));
                retorno.setRa(rs.getString("RA"));
                retorno.setNome(rs.getString("NOME"));
                retorno.setCpf(rs.getString("CPF"));
                retorno.setRg(rs.getString("RG"));
                retorno.setDataNascimento(rs.getDate("DATANASCIMENTO"));
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

    public void insert(PessoaFisica pessoaFisica, int idPessoa) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DatabaseUtils().getConnection();
            conn.prepareStatement(INSERT);
            pstmt.setString(1, pessoaFisica.getNome());
            pstmt.setString(2, pessoaFisica.getCpf());
            pstmt.setString(3, pessoaFisica.getRg());
            pstmt.setDate(4, (Date) pessoaFisica.getDataNascimento());
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

    public void update(PessoaFisica pessoaFisica) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, pessoaFisica.getNome());
            pstmt.setString(2, pessoaFisica.getCpf());
            pstmt.setString(3, pessoaFisica.getRg());
            pstmt.setDate(4, (Date) pessoaFisica.getDataNascimento());
            pstmt.setInt(5, pessoaFisica.getId());
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
