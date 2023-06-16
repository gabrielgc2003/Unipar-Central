package com.mycompany.unipar.central.services;

import com.mycompany.unipar.central.exceptions.CampoLimiteTamanhoException;
import com.mycompany.unipar.central.exceptions.CampoNaoInformadoException;
import com.mycompany.unipar.central.exceptions.EntidadeNaoInformadaException;
import com.mycompany.unipar.central.models.Estado;
import com.mycompany.unipar.central.models.Pais;
import com.mycompany.unipar.central.repositories.EstadoDAO;
import java.sql.SQLException;

public class EstadoService {
    public void validar(Estado estado) throws EntidadeNaoInformadaException, CampoLimiteTamanhoException, CampoNaoInformadoException {
        if (estado == null){
            throw new EntidadeNaoInformadaException(("Estado"));
        }
        if (estado.getPais() == null){
            throw new EntidadeNaoInformadaException(("Estado(Pais)"));
        }
        if(estado.getNome() == null ||
                estado.getNome().isEmpty() ||
                estado.getNome().isBlank()){
            throw new CampoNaoInformadoException(("Estado(Nome)"));
        }
        if(estado.getSigla() == null ||
                estado.getSigla().isEmpty() ||
                estado.getSigla().isBlank() ){
            throw new CampoNaoInformadoException(("Estado(Sigla)"));
        }
        if (!(estado.getSigla().length() == 2)){
            throw new CampoLimiteTamanhoException("Estado(Sigla)", "2");
        }
        if (estado.getNome().length() > 60){
            throw new CampoLimiteTamanhoException("Estado(Nome)", "60");
        }
    }
    
    public Estado findById(int id) throws SQLException, CampoLimiteTamanhoException, Exception{
        if(id <= 0)
            throw  new CampoLimiteTamanhoException("id","1");
        EstadoDAO estadoDAO = new EstadoDAO();
        Estado retorno = estadoDAO.findById(id);

        if (retorno == null)
            throw new Exception("Não foi possível encontrar um estado" +
                    "com id " + id + " tente outro código.");
        return retorno;
   }

   public void insert(Estado estado) throws SQLException, CampoLimiteTamanhoException, EntidadeNaoInformadaException, Exception{
        validar(estado);
        EstadoDAO estadoDAO = new EstadoDAO();
        estadoDAO.insert(estado);
   }
   public void update(Estado estado) throws SQLException, CampoLimiteTamanhoException, EntidadeNaoInformadaException, Exception{
        validar(estado);
        EstadoDAO estadoDAO = new EstadoDAO();
        estadoDAO.update(estado);
   }

   public void delete(int id) throws SQLException, Exception{
        EstadoDAO estadoDAO = new EstadoDAO();
        estadoDAO.delete(id);
   }

}
