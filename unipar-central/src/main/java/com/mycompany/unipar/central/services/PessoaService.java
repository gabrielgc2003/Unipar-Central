package com.mycompany.unipar.central.services;

import com.mycompany.unipar.central.exceptions.CampoLimiteTamanhoException;
import com.mycompany.unipar.central.exceptions.CampoNaoInformadoException;
import com.mycompany.unipar.central.exceptions.DataException;
import com.mycompany.unipar.central.exceptions.EntidadeNaoInformadaException;
import com.mycompany.unipar.central.models.*;
import com.mycompany.unipar.central.repositories.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaService {
    public void validar(Pessoa pessoa) throws EntidadeNaoInformadaException, CampoLimiteTamanhoException, CampoNaoInformadoException, DataException {
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

    public List<Pessoa> findAll() throws SQLException{
        PessoaDAO pessoaDAO = new PessoaDAO();
        List<Pessoa> listaPessoa = pessoaDAO.findAll();
        return listaPessoa;
    }

    public Pessoa findById(int id) throws SQLException, CampoLimiteTamanhoException, Exception{
        if(id <= 0)
            throw  new CampoLimiteTamanhoException("id","1");
        PessoaDAO pessoaDAO = new PessoaDAO();
        Pessoa retorno = pessoaDAO.findById(id);

        if (retorno == null)
            throw new Exception("Não foi possível encontrar uma pessoa" +
                    "com id " + id + " tente outro código.");
        return retorno;
    }

    public void update(Pessoa pessoa) throws SQLException, CampoLimiteTamanhoException, EntidadeNaoInformadaException, Exception{
        validar(pessoa);
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.update(pessoa);
    }

    public void delete(int id) throws SQLException, Exception{
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.delete(id);
    }

    public void insert(Pessoa pessoa, PessoaFisica pessoaFisica, PessoaJuridica pessoaJuridica, ArrayList<Endereco> listaEndereco, ArrayList<Telefone> listaTelefone) throws SQLException, CampoLimiteTamanhoException, EntidadeNaoInformadaException, Exception{

        int idPessoa;
        validar(pessoa);
        PessoaDAO pessoaDAO = new PessoaDAO();
        idPessoa = pessoaDAO.insert(pessoa);

        if (pessoaFisica != null){
            PessoaFisicaService pessoaFisicaService = new PessoaFisicaService();
            pessoaFisicaService.insert(pessoaFisica, idPessoa);
        }
        if (pessoaJuridica != null){
            PessoaJuridicaService pessoaJuridicaService = new PessoaJuridicaService();
            pessoaJuridicaService.insert(pessoaJuridica, idPessoa);
        }

        if (!listaEndereco.isEmpty()) {
            for (int i = 0; i < listaEndereco.size(); i++) {
                EnderecoService enderecoService = new EnderecoService();
                enderecoService.insert(listaEndereco.get(i), idPessoa);
            }
        }

        if (!listaTelefone.isEmpty()) {
            for (int i = 0; i < listaTelefone.size(); i++) {
                TelefoneService telefoneService = new TelefoneService();
                telefoneService.insert(listaTelefone.get(i), idPessoa);
            }
        }

    }

}
