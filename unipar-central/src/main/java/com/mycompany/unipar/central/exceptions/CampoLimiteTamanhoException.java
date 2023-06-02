package com.mycompany.unipar.central.exceptions;

public class CampoLimiteTamanhoException extends Exception{
    public CampoLimiteTamanhoException(String campo, String limite){
        super(campo + " passou do limite de tamanho ("+limite+"). Verifique!");
    }
}
