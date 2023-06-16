package com.mycompany.unipar.central.models;

import com.mycompany.unipar.central.enums.TipoTransacaoEnum;

import java.util.Date;

public class Transacao extends AbstractAcademico {
    private Date dataHora;
    private double valor;
    private TipoTransacaoEnum tipoTransacao;
    private Conta contaOrigem;
    private Conta contaDestino;

    public Transacao(Date dataHora, double valor, TipoTransacaoEnum tipoTransacao, Conta contaOrigem, Conta contaDestino) {
        this.dataHora = dataHora;
        this.valor = valor;
        this.tipoTransacao = tipoTransacao;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
    }

    public Transacao(){

    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public TipoTransacaoEnum getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(TipoTransacaoEnum tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public Conta getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(Conta contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public Conta getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(Conta contaDestino) {
        this.contaDestino = contaDestino;
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "dataHora=" + dataHora +
                ", valor=" + valor +
                ", tipoTransacao=" + tipoTransacao +
                ", contaOrigem=" + contaOrigem +
                ", contaDestino=" + contaDestino +
                '}';
    }
}
