/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.unipar.central;

import com.mycompany.unipar.central.enums.OperadoraEnum;
import com.mycompany.unipar.central.exceptions.CampoLimiteTamanhoException;
import com.mycompany.unipar.central.exceptions.CampoNaoInformadoException;
import com.mycompany.unipar.central.exceptions.EntidadeNaoInformadaException;
import com.mycompany.unipar.central.models.*;
import com.mycompany.unipar.central.repositories.PaisDAO;
import com.mycompany.unipar.central.services.*;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabri
 */
public class UniparCentral {

    public static void main(String[] args) throws Exception {

        /*Teste de Pessoa*/
        /*
        ArrayList<Endereco> listaEndereco = new ArrayList<>();
        Endereco endereco1 = new Endereco();
        endereco1.setRa("00240526");
        endereco1.setCep("85935000");
        endereco1.setComplemento("Apartamento");
        endereco1.setBairro("Jardim Parana");
        endereco1.setCidade(new CidadeService().findById(4127700));
        endereco1.setLogradouro("Rua Cascavel");
        endereco1.setNumero("145");

        Endereco endereco2= new Endereco();
        endereco2.setRa("00240526");
        endereco2.setCep("85903170");
        endereco2.setComplemento("Apartamento");
        endereco2.setBairro("Jardim Panorama");
        endereco2.setCidade(new CidadeService().findById(4127700));
        endereco2.setLogradouro("Rua Maripa");
        endereco2.setNumero("188");

        Endereco endereco3= new Endereco();
        endereco3.setRa("00240526");
        endereco3.setCep("85935000");
        endereco3.setComplemento("Casa");
        endereco3.setBairro("Jardim Santa Maria");
        endereco3.setCidade(new CidadeService().findById(4127700));
        endereco3.setLogradouro("Rua Joaquim");
        endereco3.setNumero("789");

        listaEndereco.add(endereco1);
        listaEndereco.add(endereco2);
        listaEndereco.add(endereco3);

        ArrayList<Telefone> listaTelefone = new ArrayList<>();
        Telefone telefone1 = new Telefone();
        telefone1.setNumero("44997454545");
        telefone1.setRa("00240526");
        telefone1.setOperadoraEnum(OperadoraEnum.TIM);

        Telefone telefone2 = new Telefone();
        telefone2.setNumero("4489856598");
        telefone2.setRa("00240526");
        telefone2.setOperadoraEnum(OperadoraEnum.CLARO);
        listaTelefone.add(telefone1);
        listaTelefone.add(telefone2);


        Pessoa pessoa = new Pessoa();
        pessoa.setEmail("gabrielgarciagarcia@gmail.com");
        pessoa.setRa("00240526");
        pessoa.setListaEndereco(listaEndereco);
        pessoa.setListaTelefone(listaTelefone);

        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        pessoaJuridica.setCnpj("68.206.426/0001-30");
        pessoaJuridica.setFantasia("Lojinha do Turbina");
        pessoaJuridica.setRazaoSocial("Loja Turbina LTDA");
        pessoaJuridica.setCnaePrincipal("VAREJO");

        PessoaService pessoaService = new PessoaService();
        pessoaService.insert(pessoa, null, pessoaJuridica);
        */


    }
}
