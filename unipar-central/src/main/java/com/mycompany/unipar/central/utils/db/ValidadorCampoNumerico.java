package com.mycompany.unipar.central.utils.db;

public class ValidadorCampoNumerico {

    public static boolean isCampoNumericoValido(String valor) {
        for (char c : valor.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
