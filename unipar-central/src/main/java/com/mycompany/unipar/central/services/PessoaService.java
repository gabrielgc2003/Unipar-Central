package com.mycompany.unipar.central.services;

import com.mycompany.unipar.central.exceptions.CampoLimiteTamanhoException;
import com.mycompany.unipar.central.exceptions.CampoNaoInformadoException;
import com.mycompany.unipar.central.exceptions.EntidadeNaoInformadaException;
import com.mycompany.unipar.central.models.*;
import com.mycompany.unipar.central.repositories.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class PessoaService {
    public void validar(Pessoa pessoa) throws EntidadeNaoInformadaException, CampoLimiteTamanhoException, CampoNaoInformadoException {
        if (pessoa == null){
            throw new EntidadeNaoInformadaException(("Pessoa"));
        }

        if(pessoa.getRa() == null ||
                pessoa.getRa().isEmpty() ||
                pessoa.getRa().isBlank()){
            throw new CampoNaoInformadoException(("Pessoa(Ra)"));
        }

        if(pessoa.getEmail() == null ||
                pessoa.getEmail().isBlank()||
                pessoa.getEmail().isEmpty()){
            throw new CampoNaoInformadoException(("Pessoa(Email)"));
        }

        if (pessoa.getEmail().length() > 120){
            throw new CampoLimiteTamanhoException("Endereco(Cep)", "120");
        }

    }

    public void insert(Pessoa pessoa, PessoaFisica pessoaFisica, PessoaJuridica pessoaJuridica, ArrayList<Endereco> listaEndereco, ArrayList<Telefone> listaTelefone) throws SQLException, CampoLimiteTamanhoException, EntidadeNaoInformadaException, Exception{
        int idPessoa;

        validar(pessoa);
        PessoaDAO pessoaDAO = new PessoaDAO();
        idPessoa = pessoaDAO.insert(pessoa);

        if (pessoaFisica != null){
            PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
            pessoaFisicaDAO.insert(pessoaFisica, idPessoa);
        }
        if (pessoaJuridica != null){
            PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
            pessoaJuridicaDAO.insert(pessoaJuridica, idPessoa);
        }

        if (!listaEndereco.isEmpty()) {
            for (int i = 0; i < listaEndereco.size(); i++) {
                EnderecoDAO enderecoDAO = new EnderecoDAO();
                enderecoDAO.insert(listaEndereco.get(i), idPessoa);
            }
        }

        if (!listaTelefone.isEmpty()) {
            for (int i = 0; i < listaTelefone.size(); i++) {
                TelefoneDAO telefoneDAO = new TelefoneDAO();
                telefoneDAO.insert(listaTelefone.get(i), idPessoa);
            }
        }




    }

}
