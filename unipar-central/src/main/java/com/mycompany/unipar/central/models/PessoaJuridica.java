package com.mycompany.unipar.central.models;

import java.util.ArrayList;
import java.util.Date;

public class PessoaJuridica extends Pessoa {
    private String razaoSocial;
    private String cnpj;
    private String cnaePrincipal;
    private String fantasia;

    public PessoaJuridica() {
    }

    public PessoaJuridica( String email, ArrayList<Endereco> listaEndereco, ArrayList<Telefone> listaTelefone,  String razaoSocial, String cnpj, String cnaePrincipal, String fantasia) {
        super( email, listaEndereco, listaTelefone);
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cnaePrincipal = cnaePrincipal;
        this.fantasia = fantasia;
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

    public String getCnaePrincipal() {
        return cnaePrincipal;
    }

    public void setCnaePrincipal(String cnaePrincipal) {
        this.cnaePrincipal = cnaePrincipal;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    @Override
    public String toString() {
        return "PessoaJuridica{" +
                "razaoSocial='" + razaoSocial + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", cnaePrincipal='" + cnaePrincipal + '\'' +
                ", fantasia='" + fantasia + '\'' +
                '}';
    }
}
