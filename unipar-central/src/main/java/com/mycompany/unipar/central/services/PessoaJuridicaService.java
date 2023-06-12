package com.mycompany.unipar.central.services;

import com.mycompany.unipar.central.exceptions.CampoLimiteTamanhoException;
import com.mycompany.unipar.central.exceptions.CampoNaoInformadoException;
import com.mycompany.unipar.central.exceptions.DataException;
import com.mycompany.unipar.central.exceptions.EntidadeNaoInformadaException;
import com.mycompany.unipar.central.models.PessoaFisica;
import com.mycompany.unipar.central.models.PessoaJuridica;
import com.mycompany.unipar.central.repositories.PessoaFisicaDAO;
import com.mycompany.unipar.central.repositories.PessoaJuridicaDAO;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class PessoaJuridicaService {
    public void validar(PessoaJuridica pessoaJuridica) throws EntidadeNaoInformadaException, CampoLimiteTamanhoException, CampoNaoInformadoException {
        if (pessoaJuridica == null){
            throw new EntidadeNaoInformadaException(("PessoaJuridica"));
        }

        if(pessoaJuridica.getRazaoSocial() == null ||
                pessoaJuridica.getRazaoSocial().isEmpty() ||
                pessoaJuridica.getRazaoSocial().isBlank()){
            throw new CampoNaoInformadoException(("PessoaJuridica(RazaoSocial)"));
        }

        if(pessoaJuridica.getCnpj() == null ||
                pessoaJuridica.getCnpj().isEmpty() ||
                pessoaJuridica.getCnpj().isBlank()){
            throw new CampoNaoInformadoException(("PessoaJuridica(Cnpj)"));
        }

        if(pessoaJuridica.getCnaePrincipal() == null ||
                pessoaJuridica.getCnaePrincipal().isEmpty() ||
                pessoaJuridica.getCnaePrincipal().isBlank()){
            throw new CampoNaoInformadoException(("PessoaJuridica(CnaePrincipal)"));
        }

        if(pessoaJuridica.getFantasia() == null ||
                pessoaJuridica.getFantasia().isEmpty() ||
                pessoaJuridica.getFantasia().isBlank()){
            throw new CampoNaoInformadoException(("PessoaJuridica(Fantasia)"));
        }

        if (pessoaJuridica.getRazaoSocial().length() > 120){
            throw new CampoLimiteTamanhoException("PessoaJuridica(RazaoSocial)", "120");
        }

        if (pessoaJuridica.getCnaePrincipal().length() > 9){
            throw new CampoLimiteTamanhoException("PessoaJuridica(CnaePrincipal)", "9");
        }

        if (pessoaJuridica.getFantasia().length() > 120){
            throw new CampoLimiteTamanhoException("PessoaJuridica(Fantasia)", "120");
        }

        if (pessoaJuridica.getCnpj().replace(".", "").replace("-", "").replace("/", "").length() > 14){
            throw new CampoLimiteTamanhoException("PessoaJuridica(Cnpj)", "14");
        }

    }

    public List<PessoaJuridica> findAll() throws SQLException {
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        List<PessoaJuridica> listaPessoaJuridica = pessoaJuridicaDAO.findAll();
        return listaPessoaJuridica;
    }

    public PessoaJuridica findById(int id) throws SQLException, CampoLimiteTamanhoException, Exception{
        if(id <= 0)
            throw  new CampoLimiteTamanhoException("id","1");
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        PessoaJuridica retorno = pessoaJuridicaDAO.findById(id);

        if (retorno == null)
            throw new Exception("Não foi possível encontrar uma pessoa jurídica" +
                    "com id " + id + " tente outro código.");
        return retorno;
    }

    public void update(PessoaJuridica pessoaJuridica) throws SQLException, CampoLimiteTamanhoException, EntidadeNaoInformadaException, Exception{
        validar(pessoaJuridica);
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        pessoaJuridicaDAO.update(pessoaJuridica);
    }

    public void delete(int id) throws SQLException, Exception{
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        pessoaJuridicaDAO.delete(id);
    }

    public void insert(PessoaJuridica pessoaJuridica , int idPessoa) throws SQLException, CampoLimiteTamanhoException, EntidadeNaoInformadaException, Exception{
        validar(pessoaJuridica);
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        pessoaJuridicaDAO.insert(pessoaJuridica, idPessoa);
    }
}
