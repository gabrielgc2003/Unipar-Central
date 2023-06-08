package com.mycompany.unipar.central.models;

import com.mycompany.unipar.central.enums.OperadoraEnum;

public class Telefone extends AbstractAcademico{
    private String numero;
    private OperadoraEnum operadoraEnum;

    public Telefone() {
    }

    public Telefone(String numero, OperadoraEnum operadoraEnum) {
        this.numero = numero;
        this.operadoraEnum = operadoraEnum;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public OperadoraEnum getOperadoraEnum() {
        return operadoraEnum;
    }

    public void setOperadoraEnum(OperadoraEnum operadoraEnum) {
        this.operadoraEnum = operadoraEnum;
    }

    @Override
    public String toString() {
        return "Telefone{" +
                " id=" + getId() +
                ", ra=" + getRa() +
                ", numero='" + numero + '\'' +
                ", operadoraEnum=" + operadoraEnum +
                '}';
    }
}
