package com.mycompany.unipar.central.exceptions;

public class FindRetornadoException extends Exception{
    public FindRetornadoException(String tabela){
        System.out.println("A consulta para retornar todos os registros de ("+tabela+") não teve nenhum retorno");
    }

    public FindRetornadoException(String tabela, int id){
        System.out.println("A consulta para retornar todos os registros de ("+tabela+") com o parametro "+id+" não teve nenhum retorno");
    }

}
