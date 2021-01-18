/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.make.impresoraetiquetas;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Sebas Abril
 */
public class ConfiguracionInicial implements Serializable {

    public Object nombreImpresora = null;
    public String informacionContenido = null;
    public ArrayList<String> histInfoCont = new ArrayList<>();
}
