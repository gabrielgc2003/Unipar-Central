package com.mycompany.unipar.central.models;

import java.util.ArrayList;

public class Agencia extends AbstractAcademico{
    private String codigo;
    private String razaoSocial;
    private String cnpj;
    private ArrayList<Telefone> listaTelefone;
    private int id;


    public Agencia() {
    }

    public Agencia( String codigo, String razaoSocial, String cnpj, ArrayList<Telefone> listaTelefone,int id) {
        this.codigo = codigo;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.listaTelefone = listaTelefone;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }


    public ArrayList<Telefone> getListaTelefone() {
        return listaTelefone;
    }

    public void setListaTelefone(ArrayList<Telefone> listaTelefone) {
        this.listaTelefone = listaTelefone;
    }

    @Override
    public String toString() {
        return "Agencia{" +
                ", codigo='" + codigo + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", listaTelefone=" + listaTelefone +
                '}';
    }
}
