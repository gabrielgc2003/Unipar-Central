package com.mycompany.unipar.central.enums;

public enum TipoTransacaoEnum {
    PIX(1, "Transferência PIX"),
    TED(2, "Transferência Eletrônica Disponível TED"),
    SAQUE(3, "Saque"),
    DEPOSITO(4, "Depósito");

    private int id;
    private String descricao;

    TipoTransacaoEnum(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
}
