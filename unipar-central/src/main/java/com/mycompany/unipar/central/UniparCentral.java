/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.unipar.central;

import com.mycompany.unipar.central.exceptions.*;
import com.mycompany.unipar.central.models.*;
import com.mycompany.unipar.central.repositories.PaisDAO;
import com.mycompany.unipar.central.services.*;

import javax.swing.*;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabri
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
        
          //Find_All
        try {
            BancoService bancoService = new BancoService();
            List<Banco> listaBanco = bancoService.findAll();
            if (listaBanco != null) {
                for (Banco banco : listaBanco){
                    System.out.println("ID: "+banco.getId()+ "| Nome: "+banco.getNome() +"| RA: "+ banco.getRa());
                }
            }
            System.out.println("----------------------------------------------------------");
            System.out.println("Todos os dados retornados. Existem "+listaBanco.size()+" registros");
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e.getMessage());
        }

//        Find_By_Id
//        try {
//            int idPesquisa = 12444;
//            BancoService bancoService = new BancoService();
//            Banco banco = bancoService.findById(idPesquisa);
//            if (banco == null)
//                throw new IDInformadoExisteDatabase(idPesquisa, "Banco");
//            System.out.println("ID: "+banco.getId()+ "| Nome: "+banco.getNome() +"| RA: "+ banco.getRa());
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage());
//        }
//


//
//        //Insert
//        try {
//            BancoService bancoService = new BancoService();
//            Banco banco = new Banco();
//            banco.setId(3999);
//            banco.setRa("00240526");
//            banco.setSigla("JP");
//            banco.setNome("Japão");
//            bancoService.insert(banco);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage());
//        }
//
//        //Update
//        try {
//            BancoService bancoService = new BancoService();
//            Banco banco = new Banco();
//            banco.setId(3999);
//            banco.setRa("00240526");
//            banco.setSigla("JP");
//            banco.setNome("Japão");
//            bancoService.update(banco);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage());
//        }
//
//        //Delete
//        try {
//            BancoService bancoService = new BancoService();
//            bancoService.delete(3999);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage());
//        }


        
        
        
    }
}
