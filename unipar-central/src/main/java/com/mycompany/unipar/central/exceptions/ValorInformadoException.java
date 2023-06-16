package com.mycompany.unipar.central.exceptions;

public class ValorInformadoException extends Exception{

    public ValorInformadoException(int valor, String tabela){
        System.out.println("O valor para informado  ("+tabela+") não pode ser menor ou igual a 0. Valor informado ("+valor+")");
    }

    public ValorInformadoException(double valor, String coluna){
        System.out.println("O valor informado para ("+coluna+") não pode ser menor ou igual a 0. Valor informado ("+valor+")");
    }

}
