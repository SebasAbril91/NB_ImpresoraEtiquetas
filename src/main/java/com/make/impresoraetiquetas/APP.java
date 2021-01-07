/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.make.impresoraetiquetas;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author sebas
 */
public class APP {

    private static APP app;
    public static ConfiguracionInicial configInit;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        app = new APP();
        configInit = new ConfiguracionInicial();

        // TODO code application logic here
        //FlatDarkLaf.install();
        FlatLightLaf.install();
        //FlatIntelliJLaf.install();
        //FlatDarculaLaf.install();

        java.awt.EventQueue.invokeLater(() -> {
            InterfazImpresion2 interfaz = new InterfazImpresion2();
            interfaz.setVisible(true);
        });

        
    }

}
