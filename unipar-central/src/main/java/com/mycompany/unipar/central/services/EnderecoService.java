package com.mycompany.unipar.central.services;

import com.mycompany.unipar.central.exceptions.CampoLimiteTamanhoException;
import com.mycompany.unipar.central.exceptions.CampoNaoInformadoException;
import com.mycompany.unipar.central.exceptions.EntidadeNaoInformadaException;
import com.mycompany.unipar.central.models.Endereco;

public class EnderecoService {
    public void validar(Endereco endereco) throws EntidadeNaoInformadaException, CampoLimiteTamanhoException, CampoNaoInformadoException {
        if (endereco == null){
            throw new EntidadeNaoInformadaException(("Endereco"));
        }
        if (endereco.getCidade() == null){
            throw new EntidadeNaoInformadaException(("Endereco(Cidade)"));
        }

        if(endereco.getLogradouro() == null ||
                endereco.getLogradouro().isEmpty() ||
                endereco.getLogradouro().isBlank()){
            throw new CampoNaoInformadoException(("Endereco(Logradouro)"));
        }

        if(endereco.getBairro() == null ||
                endereco.getBairro().isEmpty() ||
                endereco.getBairro().isBlank()){
            throw new CampoNaoInformadoException(("Endereco(Bairro)"));
        }
        if(endereco.getNumero() == null ||
                endereco.getNumero().isEmpty() ||
                endereco.getNumero().isBlank()){
            throw new CampoNaoInformadoException(("Endereco(Numero)"));
        }
        if(endereco.getCep() == null ||
                endereco.getCep().isEmpty() ||
                endereco.getCep().isBlank()){
            throw new CampoNaoInformadoException(("Endereco(Cep)"));
        }
        if (endereco.getCep().length() > 8){
            throw new CampoLimiteTamanhoException("Endereco(Cep)", "8");
        }



    }
}
