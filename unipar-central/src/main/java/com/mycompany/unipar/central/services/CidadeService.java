package com.mycompany.unipar.central.services;

import com.mycompany.unipar.central.exceptions.CampoLimiteTamanhoException;
import com.mycompany.unipar.central.exceptions.CampoNaoInformadoException;
import com.mycompany.unipar.central.exceptions.EntidadeNaoInformadaException;
import com.mycompany.unipar.central.models.Cidade;

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
        
        if (cidade.getNome().length() > 120){
            throw new CampoLimiteTamanhoException("Cidade(Nome)", "60");
        }
        
        
    }
}
