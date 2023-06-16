package com.mycompany.unipar.central.services;

import com.mycompany.unipar.central.exceptions.CampoLimiteTamanhoException;
import com.mycompany.unipar.central.exceptions.CampoNaoInformadoException;
import com.mycompany.unipar.central.exceptions.EntidadeNaoInformadaException;
import com.mycompany.unipar.central.exceptions.NaoExisteDatabaseException;
import com.mycompany.unipar.central.models.Banco;
import com.mycompany.unipar.central.models.Conta;
import com.mycompany.unipar.central.repositories.BancoDAO;
import com.mycompany.unipar.central.repositories.ContaDAO;

import java.sql.SQLException;

public class BancoService {

    public void validar (Banco banco) throws CampoNaoInformadoException, CampoLimiteTamanhoException, EntidadeNaoInformadaException {

        if (banco == null){
            throw new EntidadeNaoInformadaException("Banco");
        }
        if(banco.getNome() == null ||
                banco.getNome().isEmpty() ||
                banco.getNome().isBlank()){
            throw new CampoNaoInformadoException(("Banco(Nome)"));
        }
        if (banco.getNome().length() > 120){
            throw new CampoLimiteTamanhoException("Banco(Nome)", "120");
        }
    }

    public void insert(Banco banco) throws SQLException, CampoLimiteTamanhoException, EntidadeNaoInformadaException, Exception{
        validar(banco);
        BancoDAO bancoDAO = new BancoDAO();
        bancoDAO.insert(banco);
    }

    public void update(Banco banco) throws SQLException, CampoLimiteTamanhoException, EntidadeNaoInformadaException, NaoExisteDatabaseException, Exception{
        validar(banco);
        BancoDAO bancoDAO = new BancoDAO();
        Banco bancoExistente = bancoDAO.findById(banco.getId());
        if (bancoExistente == null) {
            throw new NaoExisteDatabaseException("ID", "Banco");
        }
        bancoDAO.update(banco);
    }

    public void delete(int id) throws SQLException, Exception{
        BancoDAO bancoDAO = new BancoDAO();
        Banco bancoExistente = bancoDAO.findById(id);
        if (bancoExistente == null) {
            throw new NaoExisteDatabaseException("ID", "Banco");
        }
        bancoDAO.deleteById(id);
    }

}
