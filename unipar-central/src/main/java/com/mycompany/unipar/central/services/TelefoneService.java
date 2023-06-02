package com.mycompany.unipar.central.services;

import com.mycompany.unipar.central.exceptions.CampoLimiteTamanhoException;
import com.mycompany.unipar.central.exceptions.CampoNaoInformadoException;
import com.mycompany.unipar.central.exceptions.EntidadeNaoInformadaException;
import com.mycompany.unipar.central.models.Endereco;
import com.mycompany.unipar.central.models.Telefone;

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

        if(telefone.getOperadora() == 0){
            throw new CampoNaoInformadoException(("Telefone(Operadora)"));
        }

        if (telefone.getNumero().length() > 9){
            throw new CampoLimiteTamanhoException("Telefone(Numero)", "9");
        }
        if (String.valueOf(telefone.getNumero()).length() > 3){
            throw new CampoLimiteTamanhoException("Telefone(Operadora)", "3");
        }



    }
}
