/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.make.impresoraetiquetas;

import com.formdev.flatlaf.FlatLightLaf;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Antes de ejecutar la aplicación, primero se debe instalar los drivers de la
 * impresora, cuando se ejecuta la aplicación, seleccionar la impresora con
 * nombre: 4BARCODE 4B-2054L.
 *
 * @author Sebas Abril
 */
public class APP {

    public static ConfiguracionInicial configInit;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        crearDirectorioRaiz();
        configInit = leerConfiguracionInicio();
        if (configInit == null) {
            configInit = new ConfiguracionInicial();
        }

        // TODO code application logic here
        //FlatDarkLaf.install();
        FlatLightLaf.install();
        //FlatIntelliJLaf.install();
        //FlatDarculaLaf.install();

        java.awt.EventQueue.invokeLater(() -> {
            InterfazImpresion interfaz = new InterfazImpresion();
            interfaz.setVisible(true);
        });

    }

    private static ConfiguracionInicial leerConfiguracionInicio() {
        FileInputStream fis = null;
        ObjectInputStream entrada = null;
        ConfiguracionInicial config = null;
        try {
            // Lee el fichero con el objeto serializado.
            fis = new FileInputStream("APP/ini.dat");
            entrada = new ObjectInputStream(fis);
            config = (ConfiguracionInicial) entrada.readObject(); //es necesario el casting
        } catch (FileNotFoundException ex) {
            Logger.getLogger(APP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(APP.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(APP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return config;
    }

    public static void guardarConfiguracionInicio() {
        FileOutputStream fos = null;
        ObjectOutputStream salida = null;

        try {
            //Se crea el fichero
            fos = new FileOutputStream("APP/ini.dat");
            salida = new ObjectOutputStream(fos);
            //Se escribe el objeto en el fichero
            salida.writeObject(APP.configInit);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InterfazImpresion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(InterfazImpresion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Cierro el enlace virtual y fisico al archivo.
            try {
                if (fos != null) {
                    fos.close();
                }
                if (salida != null) {
                    salida.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(InterfazImpresion.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    
    public static void crearDirectorioRaiz(){
        File directorio = new File("APP");
        if (!directorio.exists()) {
            if (!directorio.mkdirs()) {
                System.err.println("Error al crear directorio raiz");
                System.exit(0);
            }
        }
    }
}
