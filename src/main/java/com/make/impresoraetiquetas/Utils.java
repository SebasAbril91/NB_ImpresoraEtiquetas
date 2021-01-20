/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.make.impresoraetiquetas;

/**
 *
 * @author sebas
 */
public class Utils {

    public static String converTextToHex(String text) {
        String newText = "";
        char[] charArray = text.toCharArray();

        for (char c : charArray) {
            switch (c) {
                case 'á':
                    newText += "_c3_a1";
                    break;
                case 'é':
                    newText += "_c3_a9";
                    break;
                case 'í':
                    newText += "_c3_ad";
                    break;
                case 'ó':
                    newText += "_c3_b3";
                    break;
                case 'ú':
                    newText += "_c3_ba";
                    break;
                case 'ü':
                    newText += "_c3_bc";
                    break;
                case 'Á':
                    newText += "_c3_81";
                    break;
                case 'É':
                    newText += "_c3_89";
                    break;
                case 'Í':
                    newText += "_c3_8d";
                    break;
                case 'Ó':
                    newText += "_c3_93";
                    break;
                case 'Ú':
                    newText += "_c3_9a";
                    break;
                case 'Ü':
                    newText += "_c3_9c";
                    break;
                case '°':
                    newText += "_c2_b0";
                    break;
                case '¡':
                    newText += "_c2_a1";
                    break;
                case '¿':
                    newText += "_c2_bf";
                    break;
                case 'ñ':
                    newText += "_c3_b1";
                    break;
                case 'Ñ':
                    newText += "_c3_91";
                    break;
                case '_':
                    newText += "_5f";
                    break;
                case '~':
                    newText += "_7e";
                    break;
                case '^':
                    newText += "_5e";
                    break;
                default:
                    newText += c;
                    break;
            }
        }
        return newText;
    }
}
