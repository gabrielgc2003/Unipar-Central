package com.mycompany.unipar.central.models;

import java.util.ArrayList;

public class Banco extends AbstractAcademico {

    private String nome;
    private ArrayList<Agencia> listaAgencia;

    public Banco( String nome, ArrayList<Agencia> listaAgencia) {
        this.nome = nome;
        this.listaAgencia = listaAgencia;
    }

    public Banco() {

    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Agencia> getListaAgencia() {
        return listaAgencia;
    }

    public void setListaAgencia(ArrayList<Agencia> listaAgencia) {
        this.listaAgencia = listaAgencia;
    }

    @Override
    public String toString() {
        return "Banco{" +
                ", nome='" + nome + '\'' +
                ", listaAgencia=" + listaAgencia +
                '}';
    }
}
