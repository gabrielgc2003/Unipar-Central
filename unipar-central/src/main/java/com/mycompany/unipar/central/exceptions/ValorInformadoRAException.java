package com.mycompany.unipar.central.exceptions;

public class ValorInformadoRAException extends Exception{

    public ValorInformadoRAException(String coluna, String RA) {
        System.out.println("O valor informado para ("+coluna+") só pode conter números. Valor informado ("+RA+")");
    }

}
