package com.mycompany.unipar.central.services;

import com.mycompany.unipar.central.exceptions.CampoLimiteTamanhoException;
import com.mycompany.unipar.central.exceptions.CampoNaoInformadoException;
import com.mycompany.unipar.central.exceptions.EntidadeNaoInformadaException;
import com.mycompany.unipar.central.models.Cidade;
import com.mycompany.unipar.central.repositories.CidadeDAO;
import java.sql.SQLException;
import java.util.List;

public class CidadeService {
    public void validar(Cidade cidade) throws EntidadeNaoInformadaException, CampoLimiteTamanhoException, CampoNaoInformadoException {
        if (cidade == null){
            throw new EntidadeNaoInformadaException(("Cidade"));
        }
        if (cidade.getEstado() == null){
            throw new EntidadeNaoInformadaException(("Cidade(Estado)"));
        }
        if(cidade.getNome() == null ||
                cidade.getNome().isEmpty() ||
                cidade.getNome().isBlank()){
            throw new CampoNaoInformadoException(("Cidade(Nome)"));
        }
        if (cidade.getNome().length() > 60){
            throw new CampoLimiteTamanhoException("Cidade(Nome)", "60");
        }
    }
    public List<Cidade> findAll() throws SQLException{
        CidadeDAO cidadeDAO = new CidadeDAO();
        List<Cidade> listaCidade = cidadeDAO.findAll();
        return listaCidade;
    }

   public Cidade findById(int id) throws SQLException, CampoLimiteTamanhoException, Exception{
        if(id <= 0)
            throw  new CampoLimiteTamanhoException("id","1");
        CidadeDAO paisDAO = new CidadeDAO();
        Cidade retorno = paisDAO.findById(id);

        if (retorno == null)
            throw new Exception("Não foi possível encontrar um cidade" +
                    "com id " + id + " tente outro código.");
        return retorno;
   }

   public void insert(Cidade cidade) throws SQLException, CampoLimiteTamanhoException, EntidadeNaoInformadaException, Exception{
        validar(cidade);
        CidadeDAO CidadeDAO = new CidadeDAO();
        CidadeDAO.insert(cidade);
   }
   public void update(Cidade cidade) throws SQLException, CampoLimiteTamanhoException, EntidadeNaoInformadaException, Exception{
        validar(cidade);
        CidadeDAO CidadeDAO = new CidadeDAO();
        CidadeDAO.update(cidade);
   }

   public void delete(int id) throws SQLException, Exception{
        CidadeDAO CidadeDAO = new CidadeDAO();
        CidadeDAO.delete(id);
   }
}
