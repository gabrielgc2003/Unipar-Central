package com.mycompany.unipar.central.services;

import com.mycompany.unipar.central.exceptions.CampoLimiteTamanhoException;
import com.mycompany.unipar.central.exceptions.CampoNaoInformadoException;
import com.mycompany.unipar.central.exceptions.EntidadeNaoInformadaException;
import com.mycompany.unipar.central.models.Banco;

public class BancoService {

    public void validar (Banco banco) throws CampoNaoInformadoException, CampoLimiteTamanhoException, EntidadeNaoInformadaException{

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
}
