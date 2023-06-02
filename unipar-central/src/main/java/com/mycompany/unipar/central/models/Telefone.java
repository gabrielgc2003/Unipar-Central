package com.mycompany.unipar.central.models;

public class Telefone extends AbstractAcademico{
    private String numero;
    private int operadora;


    public Telefone() {
    }
    public Telefone( String numero, int operadora) {
        this.numero = numero;
        this.operadora = operadora;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getOperadora() {
        return operadora;
    }

    public void setOperadora(int operadora) {
        this.operadora = operadora;
    }

    @Override
    public String toString() {
        return "Telefone{" +
                ", numero='" + numero + '\'' +
                ", operadora='" + operadora + '\'' +
                '}';
    }
}
