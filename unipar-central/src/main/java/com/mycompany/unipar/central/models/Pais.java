package com.mycompany.unipar.central.models;

public class Pais extends AbstractAcademico{
    private String nome;
    private String sigla;
    public Pais() {
    }

    public Pais( String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }


    @Override
    public String toString() {
        return "Pais{" +
                ", nome='" + nome + '\'' +
                ", sigla='" + sigla + '\'' +
                ", ra='" + getRa() + '\'' +
                ", id='" + getId() + '\'' +
                '}';
    }
}
