package com.mycompany.unipar.central.repositories;

import com.mycompany.unipar.central.models.Agencia;
import com.mycompany.unipar.central.models.Banco;
import com.mycompany.unipar.central.utils.db.DatabaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class agenciaDAO {

    private static final String INSERT = "INSERT INTO (CODIGO, DIGITO, RAZAOSOCIAL, CNPJ, RA, BANCO_ID) VALUES (?, ?, ?, ?, ?, ?)";

    private static final String FIND_ALL = "SELECT CODIGO, DIGITO, RAZAOSOCIAL, CNPJ, RA, BANCO_ID FROM AGENCIA WHERE ID = ?";

    private static final String DELETE_BY_ID = "DELETE AGENCIA WHERE ID = ?";

    private static final String UPDATE = "UPDATE AGENCIA SET CODIGO = ?, DIGITO = ?, RAZAOSOCIAL = ?, CNPJ = ?, RA = ?, BANCO_ID = ? WHERE ID = ?";

    private void insert (Agencia agencia) throws SQLException{

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
           conn =  new DatabaseUtils().getConnection();
           pstm = conn.prepareStatement(INSERT);
           pstm.setString(1, agencia.getCodigo());
           pstm.setString(2, agencia.getDigito());
           pstm.setString(3, agencia.getRazaoSocial());
           pstm.setString(4, agencia.getCnpj());
           pstm.setString(5, agencia.getRa());
           pstm.setString(6, agencia.getBanco());
        } finally {

        }

    }

}
