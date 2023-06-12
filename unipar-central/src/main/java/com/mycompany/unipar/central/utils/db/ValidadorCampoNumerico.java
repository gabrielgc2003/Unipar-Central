package com.mycompany.unipar.central.utils.db;

import com.mycompany.unipar.central.exceptions.CampoNumericoInvalidoException;

public class ValidadorCampoNumerico {

    public static boolean isCampoNumericoValido (String valor){
        for (char c : valor.toCharArray()){
            if (!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }

    public static void validarCampoNumerico (String campo, String valor) throws CampoNumericoInvalidoException {
        if (!isCampoNumericoValido(valor)){
            throw new CampoNumericoInvalidoException(campo);
        }
    }

}
