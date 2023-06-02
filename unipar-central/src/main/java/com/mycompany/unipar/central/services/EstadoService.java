package com.mycompany.unipar.central.services;

import com.mycompany.unipar.central.exceptions.CampoLimiteTamanhoException;
import com.mycompany.unipar.central.exceptions.CampoNaoInformadoException;
import com.mycompany.unipar.central.exceptions.EntidadeNaoInformadaException;
import com.mycompany.unipar.central.models.Estado;
import com.mycompany.unipar.central.models.Pais;

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

}
