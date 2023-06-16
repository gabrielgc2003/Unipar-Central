package com.mycompany.unipar.central.exceptions;

public class IDInformadoExisteDatabase extends Exception{
    public IDInformadoExisteDatabase(int id, String tabela){
        super("O valor de id "+id+" já existe na tabela "+tabela);
    }
}
