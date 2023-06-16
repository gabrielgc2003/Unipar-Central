package com.mycompany.unipar.central.services;

import com.mycompany.unipar.central.exceptions.CampoLimiteTamanhoException;
import com.mycompany.unipar.central.exceptions.CampoNaoInformadoException;
import com.mycompany.unipar.central.exceptions.EntidadeNaoInformadaException;
import com.mycompany.unipar.central.models.Pais;
import com.mycompany.unipar.central.repositories.PaisDAO;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class PaisService {
    private void validar(Pais pais) throws EntidadeNaoInformadaException, CampoLimiteTamanhoException, CampoNaoInformadoException {
        if (pais == null){
            throw new EntidadeNaoInformadaException(("Pais"));
        }
        if(pais.getNome() == null ||
            pais.getNome().isEmpty() ||
            pais.getNome().isBlank()){
            throw new CampoNaoInformadoException(("Pais(Nome)"));
        }
        if(pais.getSigla() == null || pais.getSigla().isEmpty() || pais.getSigla().isBlank() ){
            throw new CampoNaoInformadoException(("Pais(Sigla)"));
        }
        if (!(pais.getSigla().length() == 2)){
            throw new CampoLimiteTamanhoException("Pais(Sigla)", "2");
        }
        if (pais.getNome().length() > 60){
            throw new CampoLimiteTamanhoException("Pais(Nome)", "60");
        }


    }
    
    public List<Pais> findAll() throws SQLException{
        PaisDAO paisDAO = new PaisDAO();
        List<Pais> listaPais = paisDAO.findAll();
        return listaPais;
    }

   public Pais findById(int id) throws SQLException, CampoLimiteTamanhoException, Exception{
        if(id <= 0)
            throw  new CampoLimiteTamanhoException("id","1");
        PaisDAO paisDAO = new PaisDAO();
        Pais retorno = paisDAO.findById(id);

        if (retorno == null)
            throw new Exception("Não foi possível encontrar um pais" +
                    "com id " + id + " tente outro código.");
        return retorno;
   }

   public void insert(Pais pais) throws SQLException, CampoLimiteTamanhoException, EntidadeNaoInformadaException, Exception{
        validar(pais);
        PaisDAO paisDAO = new PaisDAO();
        paisDAO.insert(pais);
   }
   public void update(Pais pais) throws SQLException, CampoLimiteTamanhoException, EntidadeNaoInformadaException, Exception{
        validar(pais);
        PaisDAO paisDAO = new PaisDAO();
        paisDAO.update(pais);
   }

   public void delete(int id) throws SQLException, Exception{
        PaisDAO paisDAO = new PaisDAO();
        paisDAO.delete(id);
   }
}
