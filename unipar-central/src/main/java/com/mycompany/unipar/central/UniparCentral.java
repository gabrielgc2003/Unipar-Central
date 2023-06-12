/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.unipar.central;

import com.mycompany.unipar.central.exceptions.CampoLimiteTamanhoException;
import com.mycompany.unipar.central.exceptions.CampoNaoInformadoException;
import com.mycompany.unipar.central.exceptions.EntidadeNaoInformadaException;
import com.mycompany.unipar.central.models.*;
import com.mycompany.unipar.central.repositories.PaisDAO;
import com.mycompany.unipar.central.services.*;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodrigo
 */
public class UniparCentral {

    public static void main(String[] args) {
      /*  //Find_All
        try {
            PaisService paisService = new PaisService();
            List<Pais> listaPais = paisService.findAll();
            System.out.println(listaPais.toString());
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e.getMessage());
        }

        //Find_By_Id
        try {
            PaisService paisService = new PaisService();
            Pais pais = paisService.findById(3999);
            System.out.println(pais.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        //Insert
        try {
            PaisService paisService = new PaisService();
            Pais pais = new Pais();
            pais.setId(3999);
            pais.setRa("00240526");
            pais.setSigla("JP");
            pais.setNome("Japão");
            paisService.insert(pais);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        //Update
        try {
            PaisService paisService = new PaisService();
            Pais pais = new Pais();
            pais.setId(3999);
            pais.setRa("00240526");
            pais.setSigla("JP");
            pais.setNome("Japão");
            paisService.update(pais);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        //Delete
        try {
            PaisService paisService = new PaisService();
            paisService.delete(3999);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

*/
    }
}
