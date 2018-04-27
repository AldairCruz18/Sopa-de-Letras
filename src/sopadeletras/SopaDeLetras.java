/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sopadeletras;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Aldair Cruz
 */
public class SopaDeLetras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        // TODO code application logic here
        
       Leer l = new Leer();
        String texto = l.leerSopa("INPUT.txt");
              
        sope sp = new sope(texto);
        sp.det();
        
        System.out.println("Hecho..");
    }
    
}
