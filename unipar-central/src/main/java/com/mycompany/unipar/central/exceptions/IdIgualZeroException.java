package com.mycompany.unipar.central.exceptions;

public class IdIgualZeroException extends Exception{

    public IdIgualZeroException (String campo){
        super ("Você está tentando inserir um valor zerado ao campo ("+campo+");");
    }

}
