package com.mycompany.unipar.central.exceptions;

public class EntidadeNaoInformadaException extends Exception{
    public EntidadeNaoInformadaException(String entidade){
        super(entidade + " não foi informado(a) e deve ser preenchido. Verifique!");
    }

}
