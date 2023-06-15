package com.mycompany.unipar.central.models;

import java.util.ArrayList;
import java.util.Date;

public class Pessoa extends AbstractAcademico{
    private String email;
    private ArrayList<Endereco> listaEndereco;
    private ArrayList<Telefone> listaTelefone;
    private int id;

    public Pessoa() {
    }

    public Pessoa( String email, ArrayList<Endereco> listaEndereco, ArrayList<Telefone> listaTelefone,int id) {
        this.email = email;
        this.listaEndereco = listaEndereco;
        this.listaTelefone = listaTelefone;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "  id='" + getId() + '\'' +
                ", ra='" + getRa() + '\'' +
                ", email='" + email + '\'' +
                ", listaEndereco=" + listaEndereco +
                ", listaTelefone=" + listaTelefone +
                '}';
    }
}
