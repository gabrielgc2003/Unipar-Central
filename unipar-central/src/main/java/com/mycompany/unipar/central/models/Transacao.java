package com.mycompany.unipar.central.models;

import com.mycompany.unipar.central.enums.TipoTransacaoEnum;

import java.util.Date;

public class Transacao extends AbstractAcademico {
    private Date dataHora;
    private double valor;
    private TipoTransacaoEnum tipoTransacao;
    private Conta contaOrigem;
    private Conta contaDestino;


}
