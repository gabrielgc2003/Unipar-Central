package com.mycompany.unipar.central.exceptions;

public class CampoNumericoInvalidoException extends Exception{

    public CampoNumericoInvalidoException(String campo){
        System.out.println("O campo ("+campo+") aceita somente valores numéricos.");
    }

}
