package com.mycompany.unipar.central.repositories;

import com.mycompany.unipar.central.enums.OperadoraEnum;
import com.mycompany.unipar.central.enums.TipoTransacaoEnum;
import com.mycompany.unipar.central.models.Conta;
import com.mycompany.unipar.central.models.Transacao;
import com.mycompany.unipar.central.utils.db.DatabaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransacaoDAO {

    public static final String INSERT = "INSERT INTO TRANSACAO (DATAHORA, VALOR, TIPO, RA, CONTA_ORIGEM, CONTA_DESTINO) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String FIND_ALL = "SELECT ID, DATAHORA, VALOR, TIPO, RA, CONTA_ORIGEM, CONTA_DESTINO FROM TRANSACAO";

    public static final String FIND_BY_ID = "SELECT ID, DATAHORA, VALOR, TIPO, RA, CONTA_ORIGEM, CONTA_DESTINO FROM TRANSACAO WHERE ID = ?";

    private static final String FIND_BY_CONTA_ORIGEM = "SELECT ID, NUMERO, DIGITO, SALDO, TIPO, AGENCIA, PESSOA, RA FROM CONTA WHERE ID = ?";

    private static final String FIND_BY_CONTA_DESTINO = "SELECT ID, NUMERO, DIGITO, SALDO, TIPO, AGENCIA, PESSOA, RA FROM CONTA WHERE ID = ?";

    private static final String DELETE = "DELETE FROM TRANSACAO WHERE ID ?";

    //Não tem porque da update na transacao

    public Transacao findById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Transacao retorno = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();

            while(rs.next()){
                retorno = new Transacao();
                retorno.setId(rs.getInt("ID"));
                retorno.setDataHora(rs.getDate("DATAHORA"));
                retorno.setValor(rs.getDouble("VALOR"));
                if (rs.getInt("TIPO") == 1){
                    retorno.setTipoTransacao(TipoTransacaoEnum.PIX);
                } else if (rs.getInt("TIPO") == 2) {
                    retorno.setTipoTransacao(TipoTransacaoEnum.TED);
                } else if (rs.getInt("TIPO") == 3) {
                    retorno.setTipoTransacao(TipoTransacaoEnum.SAQUE);
                } else if (rs.getInt("TIPO") == 4) {
                    retorno.setTipoTransacao(TipoTransacaoEnum.DEPOSITO);
                } else {
                    retorno.setTipoTransacao(TipoTransacaoEnum.TIPO_DESCONHECIDO);
                }
                retorno.setRa(rs.getString("RA"));
                retorno.setContaOrigem(new ContaDAO().findById(rs.getString(findById(id))));
                retorno.setContaDestino(new ContaDAO().findById(rs.getString(findById(id))));
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
