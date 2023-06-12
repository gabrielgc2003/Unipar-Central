package com.mycompany.unipar.central.services;

import com.mycompany.unipar.central.exceptions.CampoLimiteTamanhoException;
import com.mycompany.unipar.central.exceptions.CampoNaoInformadoException;
import com.mycompany.unipar.central.exceptions.DataException;
import com.mycompany.unipar.central.exceptions.EntidadeNaoInformadaException;
import com.mycompany.unipar.central.models.Endereco;
import com.mycompany.unipar.central.models.Pessoa;
import com.mycompany.unipar.central.models.PessoaFisica;
import com.mycompany.unipar.central.models.Telefone;
import com.mycompany.unipar.central.repositories.PessoaDAO;
import com.mycompany.unipar.central.repositories.PessoaFisicaDAO;
import com.mycompany.unipar.central.repositories.TelefoneDAO;

import java.sql.SQLException;
import java.util.List;

public class TelefoneService {
    public void validar(Telefone telefone) throws EntidadeNaoInformadaException, CampoLimiteTamanhoException, CampoNaoInformadoException {
        if (telefone == null){
            throw new EntidadeNaoInformadaException(("Telefone"));
        }

        if(telefone.getNumero() == null ||
                telefone.getNumero().isEmpty() ||
                telefone.getNumero().isBlank()){
            throw new CampoNaoInformadoException(("Telefone(Numero)"));
        }

        if (telefone.getNumero().length() > 9){
            throw new CampoLimiteTamanhoException("Telefone(Numero)", "9");
        }
    }


    public Telefone findById(int id) throws SQLException, CampoLimiteTamanhoException, Exception{
        if(id <= 0)
            throw  new CampoLimiteTamanhoException("id","1");
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        Telefone retorno = telefoneDAO.findById(id);

        if (retorno == null)
            throw new Exception("Não foi possível encontrar um telefone" +
                    "com id " + id + " tente outro código.");
        return retorno;
    }

    public List<Telefone> findByPessoaAgencia(int idPessoa, int idAgencia) throws SQLException{
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        List<Telefone> listaTelefone = telefoneDAO.findByPessoaAgencia(idPessoa, idAgencia);
        return listaTelefone;
    }

    public void update(Telefone telefone, int idPessoa, int idAgencia) throws SQLException, CampoLimiteTamanhoException, EntidadeNaoInformadaException, Exception{
        validar(telefone);
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        telefoneDAO.update(telefone, idPessoa, idAgencia);
    }

    public void delete(int id) throws SQLException, Exception{
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        telefoneDAO.delete(id);
    }

    public void insert(Telefone telefone , int idPessoa, int idAgencia) throws SQLException, CampoLimiteTamanhoException, EntidadeNaoInformadaException, DataException, Exception{
        validar(telefone);
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        telefoneDAO.insert(telefone, idPessoa, idAgencia);
    }

}
