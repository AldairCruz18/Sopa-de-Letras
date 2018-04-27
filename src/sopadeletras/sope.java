/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sopadeletras;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import static sopadeletras.Orientacion.error;


/**
 *
 * @author Aldair Cruz
 */


public class sope {
    char[][] tr;
    Integer columnas;
    Integer filas;
    Integer palabra;
    Palabras listaPalabras;
    Palabras renglones;
    
    
     public sope(String cont) throws FileNotFoundException, IOException{
         
        listaPalabras = new Palabras();
        renglones = new Palabras();
        int value=0;
         char[] cd = cont.toCharArray();
        String nuevo="";
        
        int i=0;
        char c;
        while(value!=32){
            value = (int) cd[i];
      
            
            if(value!=32){
                c = (char) value;
                nuevo = nuevo.concat(String.valueOf(c));
                columnas = Integer.valueOf(nuevo);
            }
            
            i++;
        }
        nuevo = "";
        do{
            
            value = (int) cd[i];
          
            if(value!=32){
                c = (char) value;
                nuevo = nuevo.concat(String.valueOf(c));
                filas = Integer.valueOf(nuevo);
            }
            i++;
        }while(value!=32);
       
        nuevo = "";
       
        while(value!=13){
            value = (int) cd[i];
      
            if(value!=13){
                c = (char) value;
                nuevo = nuevo.concat(String.valueOf(c));
                
               
                palabra = Integer.valueOf(nuevo);
                
                nuevo = "";
            }
            i++;
        }
        value = (int) cd[i];
 
        
        for(int k=0;k<palabra;k++){
            
            nuevo = "";
            
            while(value != 13){
                
                value = (int) cd[i];
                
                if(value != 13 && value!=10){
                    c = (char) value;
                    nuevo = nuevo.concat(String.valueOf(c)); 
                    
                }
                i++;
            }
            
            i++;
            value = (int) cd[i];
            listaPalabras.pegar(new pl(nuevo.toCharArray()));
        }
       
        value = (int) cd[i];
        
        for(int k=0;k<filas;k++){
            
            nuevo = "";
            
            while(value != 13 && i<cd.length){
                    
                value = (int) cd[i];
 
                if(value != 13 && value!=10){
                    c = (char) value;
                    nuevo = nuevo.concat(String.valueOf(c)); //cadena de texto
                }
                i++;
            }
            renglones.pegar(new pl(nuevo.toCharArray()));
            i++;
            if(i<cd.length) value = (int) cd[i];
        }      
        bG();
    }
      
     
      public void det() throws IOException, IOException{
        File f = new File("OUTPUT.txt");
        
        try (
        FileWriter wr = new FileWriter(f) 
        ) {
            pl crr = listaPalabras.getHd();
            int count=0;
            while(crr!=null){
                crr.Origedf(columnas, filas, tr);
                crr.solve(columnas, filas, tr);
            if(crr.getStatus() == error)
                    count++;

                crr=crr.getNext();
            }

            wr.append(Integer.toString(count));
            wr.append("\r\n");

            crr = listaPalabras.getHd();

            while(crr!=null){

                wr.append(crr.toString());
                wr.append("\r\n");
                crr=crr.getNext();
            }
        }
        
    }
      
      public void bG(){
        tr= new char[columnas][filas];
        
        pl crr = renglones.getHd();
        for(int i=0; i<filas ;i++){
            for(int j=0; j<columnas ; j++){
                tr[j][i] = crr.getChar(j);
            }           
            crr = crr.getNext();
        }
    }

    public char[][] getTr() {
        return tr;
    }

    public void setTr(char[][] tr) {
        this.tr = tr;
    }

    public Integer getColumnas() {
        return columnas;
    }

    public void setColumnas(Integer columnas) {
        this.columnas = columnas;
    }

    public Integer getFilas() {
        return filas;
    }

    public void setFilas(Integer filas) {
        this.filas = filas;
    }

    public Integer getPalabra() {
        return palabra;
    }

    public void setPalabra(Integer palabra) {
        this.palabra = palabra;
    }

    public Palabras getListaPalabras() {
        return listaPalabras;
    }

    public void setListaPalabras(Palabras listaPalabras) {
        this.listaPalabras = listaPalabras;
    }

    public Palabras getRenglones() {
        return renglones;
    }

    public void setRenglones(Palabras renglones) {
        this.renglones = renglones;
    }
    
    
}
