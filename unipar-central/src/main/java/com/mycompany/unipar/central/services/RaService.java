/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.unipar.central.services;

import com.mycompany.unipar.central.exceptions.CampoLimiteTamanhoException;
import com.mycompany.unipar.central.exceptions.CampoNaoInformadoException;
import com.mycompany.unipar.central.exceptions.EntidadeNaoInformadaException;

/**
 *
 * @author rodrigo
 */
public class RaService {
    
    public void ValidarRa(String ra) throws CampoLimiteTamanhoException,
            CampoNaoInformadoException, EntidadeNaoInformadaException, Exception{
        
        if(ra == null ||
           ra.isEmpty() ||
           ra.isBlank()){
           throw new CampoNaoInformadoException(("Registro Acadêmico 'RA'"));
        }
        
        if(ra.length() != 8){
            throw new CampoLimiteTamanhoException("Registro Acadêmico 'RA'", "8");
        }
    }

    
}