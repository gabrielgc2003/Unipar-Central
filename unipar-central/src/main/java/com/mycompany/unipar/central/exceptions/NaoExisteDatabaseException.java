package com.mycompany.unipar.central.exceptions;

public class NaoExisteDatabaseException extends Exception{

    public NaoExisteDatabaseException(String campo, String tabela){
        System.out.println("O valor para informado para ("+campo+") não está registrado na tabela ("+tabela+".");
    }

}
