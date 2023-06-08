package com.mycompany.unipar.central.exceptions;

import java.util.Date;

public class DataException extends Exception{
    public DataException(Date data){
        super("Data de nascimento informada ("+ data + ") não pode ser maior que a data atual. Verifique!");
    }
}
