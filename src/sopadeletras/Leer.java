/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sopadeletras;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Aldair Cruz
 */
public class Leer {
    public Leer(){
        
    }
    
    public String leerSopa(String ubicacion) throws FileNotFoundException, IOException{
        File f= new File(ubicacion);
        FileReader fr= new FileReader(f);
        String cont = "";
        int caracter = 0;
        char c;
        while(caracter!=-1){
            caracter = fr.read();
            
            c = (char) caracter;
            
            if(caracter!=-1)
                cont = cont.concat(String.valueOf(c));
            
        }       
        return cont; 
        
    }
  
    
    public File escribirArchivo(String ubicacion, String cont) throws FileNotFoundException, IOException{
        
         File f = new File(ubicacion);
       
          try ( //crear un archivo
                FileWriter wr = new FileWriter(f) //pide un file, input output error
          ) {
            
            wr.append(cont);
          }

        return f;
    }
   
    
    
}
