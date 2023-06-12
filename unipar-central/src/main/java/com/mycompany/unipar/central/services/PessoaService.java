package com.mycompany.unipar.central.services;

import com.mycompany.unipar.central.exceptions.CampoLimiteTamanhoException;
import com.mycompany.unipar.central.exceptions.CampoNaoInformadoException;
import com.mycompany.unipar.central.exceptions.DataException;
import com.mycompany.unipar.central.exceptions.EntidadeNaoInformadaException;
import com.mycompany.unipar.central.models.*;
import com.mycompany.unipar.central.repositories.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaService {
    public void validar(Pessoa pessoa) throws EntidadeNaoInformadaException, CampoLimiteTamanhoException, CampoNaoInformadoException, DataException {
        if (pessoa == null){
            throw new EntidadeNaoInformadaException(("Pessoa"));
        }

        if(pessoa.getRa() == null ||
                pessoa.getRa().isEmpty() ||
                pessoa.getRa().isBlank()){
            throw new CampoNaoInformadoException(("Pessoa(Ra)"));
        }

        if(pessoa.getEmail() == null ||
                pessoa.getEmail().isBlank()||
                pessoa.getEmail().isEmpty()){
            throw new CampoNaoInformadoException(("Pessoa(Email)"));
        }

        if (pessoa.getEmail().length() > 120){
            throw new CampoLimiteTamanhoException("Endereco(Cep)", "120");
        }

    }
}
