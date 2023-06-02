package com.mycompany.unipar.central.models;

import java.util.ArrayList;
import java.util.Date;

public class Pessoa extends AbstractAcademico{
    private String email;
    private ArrayList<Endereco> listaEndereco;
    private ArrayList<Telefone> listaTelefone;

    public Pessoa() {
    }

    public Pessoa( String email, ArrayList<Endereco> listaEndereco, ArrayList<Telefone> listaTelefone) {
        this.email = email;
        this.listaEndereco = listaEndereco;
        this.listaTelefone = listaTelefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Endereco> getListaEndereco() {
        return listaEndereco;
    }

    public void setListaEndereco(ArrayList<Endereco> listaEndereco) {
        this.listaEndereco = listaEndereco;
    }

    public ArrayList<Telefone> getListaTelefone() {
        return listaTelefone;
    }

    public void setListaTelefone(ArrayList<Telefone> listaTelefone) {
        this.listaTelefone = listaTelefone;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                ", email='" + email + '\'' +
                ", listaEndereco=" + listaEndereco +
                ", listaTelefone=" + listaTelefone +
                '}';
    }
}
