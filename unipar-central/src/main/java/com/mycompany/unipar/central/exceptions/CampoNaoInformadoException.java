package com.mycompany.unipar.central.exceptions;

public class CampoNaoInformadoException extends Exception{
    public CampoNaoInformadoException(String campo){
        super(campo + " não foi informado(a) e deve ser preenchido. Verifique!");
    }

}
