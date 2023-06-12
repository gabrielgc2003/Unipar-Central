package com.mycompany.unipar.central.exceptions;

public class IdMenorZeroException extends Exception{

    public IdMenorZeroException(String campo){
        System.out.println("O campo ("+campo+") não aceita valores menores que 0.");
    }

}
