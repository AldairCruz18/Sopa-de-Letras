/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sopadeletras;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Aldair Cruz
 */
public class Escribir {
   
        public void escribir(File f, String cont) throws FileNotFoundException, IOException{
    

          try ( 
                FileWriter fw = new FileWriter(f);
          ) {
            fw.append(cont);
          }
    }
       
    
}
