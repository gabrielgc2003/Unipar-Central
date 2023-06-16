package com.mycompany.unipar.central.models;

import java.util.ArrayList;

public class Agencia extends AbstractAcademico{
    private String codigo;
    private String digito;
    private String razaoSocial;
    private String cnpj;

    private Banco banco;

    private ArrayList<Telefone> listaTelefone;
    int id;

    public Agencia() {
    }

    public Agencia( int id, String codigo, String digito, String razaoSocial, String cnpj, Banco banco,ArrayList<Telefone> listaTelefone) {
        this.id = id;
        this.codigo = codigo;
        this.digito = digito;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.banco = banco;
        this.listaTelefone = listaTelefone;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDigito(){
        return digito;
    }

    public void setDigito(String digito){
        this.digito = digito;
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

    public void setBanco (Banco banco){
        this.banco = banco;
    }

    public int getBanco(){
        return banco.getId();
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
                "codigo='" + codigo + '\'' +
                ", digito='" + digito + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", banco=" + banco +
                ", listaTelefone=" + listaTelefone +
                '}';
    }
}

