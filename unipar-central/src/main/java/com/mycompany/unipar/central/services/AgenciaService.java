package com.mycompany.unipar.central.services;

import com.mycompany.unipar.central.exceptions.*;
import com.mycompany.unipar.central.models.Agencia;
import com.mycompany.unipar.central.models.Banco;
import com.mycompany.unipar.central.utils.db.ValidadorCampoNumerico;
import com.mycompany.unipar.central.utils.db.ValidatorExisteDatabase;

import java.sql.SQLException;

public class AgenciaService {

    public void validar (Agencia agencia) throws CampoNaoInformadoException, CampoLimiteTamanhoException, EntidadeNaoInformadaException, IdIgualZeroException, IdMenorZeroException, CampoNumericoInvalidoException, SQLException, NaoExisteDatabaseException {

        Banco banco = new Banco();

        if (agencia == null){
            throw new EntidadeNaoInformadaException("agencia");
        }
        if (agencia.getId() == 0){
            throw new IdIgualZeroException("agencia(Id)");
        }
        if(agencia.getId() < 0){
            throw new IdMenorZeroException("Agencia(Id)");
        }
        if(!ValidadorCampoNumerico.isCampoNumericoValido(agencia.getCodigo())){
            throw new CampoNumericoInvalidoException("agencia(codigo)");
        }
        if(agencia.getCodigo() == null ||
                agencia.getCodigo().isEmpty() ||
                agencia.getCodigo().isBlank()){
            throw new CampoNaoInformadoException("agencia(Codigo)");
        }
        if (agencia.getCodigo().length() > 10){
            throw new CampoLimiteTamanhoException("agencia(Codigo)", "10");
        }
        if(!ValidadorCampoNumerico.isCampoNumericoValido(agencia.getDigito())){
            throw new CampoNumericoInvalidoException("agencia(digito))");
        }
        if(agencia.getDigito() == null ||
                agencia.getCodigo().isEmpty() ||
                agencia.getCodigo().isBlank()){
            throw new CampoNaoInformadoException(("agencia(Digito)"));
        }
        if (agencia.getDigito().length() > 2){
            throw new CampoLimiteTamanhoException("agencia(Digito)", "2");
        }
        if(!ValidadorCampoNumerico.isCampoNumericoValido(agencia.getRazaoSocial())){
            throw new CampoNumericoInvalidoException("agencia(RazaoSocial)");
        }
        if(agencia.getRazaoSocial() == null ||
                agencia.getRazaoSocial().isEmpty() ||
                agencia.getRazaoSocial().isBlank()){
            throw new CampoNaoInformadoException(("agencia(RazaoSocial)"));
        }
        if (agencia.getRazaoSocial().length() > 120){
            throw new CampoLimiteTamanhoException("agencia(RazaoSocial)", "120");
        }
        if(!ValidadorCampoNumerico.isCampoNumericoValido(agencia.getCnpj())){
            throw new CampoNumericoInvalidoException("agencia(CPNJ)");
        }
        if(agencia.getCnpj() == null ||
                agencia.getCnpj().isEmpty() ||
                agencia.getCnpj().isBlank()){
            throw new CampoNaoInformadoException(("agencia(CPNJ)"));
        }
        if (agencia.getCnpj().length() > 20){
            throw new CampoLimiteTamanhoException("agencia(CPNJ)", "20");
        }
        if(!ValidadorCampoNumerico.isCampoNumericoValido(agencia.getRa())){
            throw new CampoNumericoInvalidoException("agencia(RA)");
        }
        if(agencia.getCnpj() == null ||
                agencia.getCnpj().isEmpty() ||
                agencia.getCnpj().isBlank()){
            throw new CampoNaoInformadoException(("agencia(RA)"));
        }
        if (agencia.getCnpj().length() > 8){
            throw new CampoLimiteTamanhoException("agencia(RA)", "8");
        }

        if (!ValidatorExisteDatabase.existeBanco(banco.getId())){
            throw new NaoExisteDatabaseException("agencia(Banco_id)", "Banco");
        }

    }


}
