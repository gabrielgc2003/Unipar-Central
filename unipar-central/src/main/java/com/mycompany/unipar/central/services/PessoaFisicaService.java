package com.mycompany.unipar.central.services;


import com.mycompany.unipar.central.exceptions.CampoLimiteTamanhoException;
import com.mycompany.unipar.central.exceptions.CampoNaoInformadoException;
import com.mycompany.unipar.central.exceptions.DataException;
import com.mycompany.unipar.central.exceptions.EntidadeNaoInformadaException;

import com.mycompany.unipar.central.models.*;
import com.mycompany.unipar.central.repositories.PessoaDAO;
import com.mycompany.unipar.central.repositories.PessoaFisicaDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PessoaFisicaService {
    public void validar(PessoaFisica pessoaFisica) throws EntidadeNaoInformadaException, CampoLimiteTamanhoException, CampoNaoInformadoException, DataException {
        if (pessoaFisica == null){
            throw new EntidadeNaoInformadaException(("PessoaFisica"));
        }

        if(pessoaFisica.getNome() == null ||
                pessoaFisica.getNome().isEmpty() ||
                pessoaFisica.getNome().isBlank()){
            throw new CampoNaoInformadoException(("PessoaFisica(Nome)"));
        }

        if(pessoaFisica.getCpf() == null ||
                pessoaFisica.getCpf().isEmpty() ||
                pessoaFisica.getCpf().isBlank()){
            throw new CampoNaoInformadoException(("PessoaFisica(Cpf)"));
        }

        if(pessoaFisica.getRg() == null ||
                pessoaFisica.getRg().isEmpty() ||
                pessoaFisica.getRg().isBlank()){
            throw new CampoNaoInformadoException(("PessoaFisica(Rg)"));
        }

        if(pessoaFisica.getDataNascimento() == null){
            throw new CampoNaoInformadoException(("PessoaFisica(DataNascimento)"));
        }

        if(pessoaFisica.getDataNascimento().after(new Date())){
            throw new DataException(pessoaFisica.getDataNascimento());
        }

        if (pessoaFisica.getNome().length() > 120){
            throw new CampoLimiteTamanhoException("PessoaFisica(Nome)", "120");
        }

        if (pessoaFisica.getCpf().replace(".", "").replace("-", "").length() > 11){
            throw new CampoLimiteTamanhoException("PessoaFisica(Cpf)", "11");
        }

        if (pessoaFisica.getRa().replace(".", "").replace("-", "").length() > 9){
            throw new CampoLimiteTamanhoException("PessoaFisica(Rg)", "9");
        }
    }

    public List<PessoaFisica> findAll() throws SQLException {
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        List<PessoaFisica> listaPessoaFisica = pessoaFisicaDAO.findAll();
        return listaPessoaFisica;
    }

    public PessoaFisica findById(int id) throws SQLException, CampoLimiteTamanhoException, Exception{
        if(id <= 0)
            throw  new CampoLimiteTamanhoException("id","1");
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        PessoaFisica retorno = pessoaFisicaDAO.findById(id);

        if (retorno == null)
            throw new Exception("Não foi possível encontrar uma pessoa" +
                    "com id " + id + " tente outro código.");
        return retorno;
    }

    public void update(PessoaFisica pessoaFisica) throws SQLException, CampoLimiteTamanhoException, EntidadeNaoInformadaException, DataException, Exception{
        validar(pessoaFisica);
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        pessoaFisicaDAO.update(pessoaFisica);
    }

    public void delete(int id) throws SQLException, Exception{
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        pessoaFisicaDAO.delete(id);
    }

    public void insert(PessoaFisica pessoaFisica , int idPessoa) throws SQLException, CampoLimiteTamanhoException, EntidadeNaoInformadaException, DataException, Exception{
        validar(pessoaFisica);
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        pessoaFisicaDAO.insert(pessoaFisica, idPessoa);
    }
}
