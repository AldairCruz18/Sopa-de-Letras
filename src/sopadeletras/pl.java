/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sopadeletras;

import static sopadeletras.Orientacion.diagonal;
import static sopadeletras.Orientacion.error;
import static sopadeletras.Orientacion.horizontal;
import static sopadeletras.Orientacion.vertical;


/**
 *
 * @author Aldair Cruz
 */
public class pl {
    String pll;
    Or or;
    Orientacion ort;
    pl next;
    OrigeList orl;
    char[] linea;


    public pl(char[] linea){
        pll = "";
        for(int i=0; i<linea.length; i++){
        pll = pll.concat(String.valueOf(linea[i]));
            
            this.linea = linea;
        this.or = new Or(0,0);
        this.ort = error;
        }
        
    }
    pl() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public pl getNext() {
        return next;
    }
    
    public void setNext(pl next) {
        this.next = next;
    }

    public Orientacion getStatus() {
        return ort;
    }
    
    
    public char getChar(Integer n){
        return linea[n];
    }
    
   
    
    public void solve(Integer dimX, Integer dimY, char[][] tr){
        Or crr = orl.getHead();
        while(crr!=null){ 
           
            int izq   = 0;
            int north = 0;
            int der   = 0;
            int south  = 0;
            int sre    = 0;
            int nro    = 0;
            for(int i=0; i<linea.length; i++){
                if(Validar(dimX, dimY, crr.getX()-i, crr.getY())){
               if(linea[i]==tr[crr.getX()-i][crr.getY()]){
                        izq++;   
               } 
                }
                
                if(Validar(dimX, dimY, crr.getX()+i, crr.getY())){
                    if(linea[i]==tr[crr.getX()+i][crr.getY()])der++;        
                }
                
                if(Validar(dimX, dimY, crr.getX(), crr.getY()+i)){
                    if(linea[i]==tr[crr.getX()][crr.getY()+i]) south++;                    
                }
                if(Validar(dimX, dimY, crr.getX(), crr.getY()-i)){
                    if(linea[i]==tr[crr.getX()][crr.getY()-i]) north++;                    
                }
                if(Validar(dimX, dimY, crr.getX()+i, crr.getY()+i)){
                    if(linea[i]==tr[crr.getX()+i][crr.getY()+i]) sre++;
                }
                if(Validar(dimX, dimY, crr.getX()-i, crr.getY()-i)){
                    if(linea[i]==tr[crr.getX()-i][crr.getY()-i]) nro++;
                }
                
            }

            if(der==linea.length || izq==linea.length){
                this.ort = horizontal; 
                this.or = new Or(crr.getX()+1, crr.getY()+1);
                return;
            }
            
            if(north==linea.length || south==linea.length){
                this.ort=vertical; 
                this.or = new Or(crr.getX()+1, crr.getY()+1);
                return;
            }
            if(sre==linea.length || nro==linea.length){
                this.ort=diagonal; 
                this.or = new Or(crr.getX()+1, crr.getY()+1);
                return;
            }
            
            crr = crr.getNext();
        }
        
    }
    
    public void Origedf(Integer columnas, Integer filas, char[][] tr){
        orl = new OrigeList();
        for(int i=0;i<columnas;i++){
            for(int j=0;j<filas;j++){
                if(tr[i][j] == linea[0]){
                    this.orl.Pegar(new Or(i,j));
                }
            }
        }
    }
    
    
    
    @Override
    public String toString(){
        return this.pll+" "+or.toString()+" "+ort;
    }
    
    private boolean Validar(Integer dimX, Integer dimY, Integer x, Integer y){
        if(x>=0 && x<dimX && y>=0 && y<dimY)return true;
        return false;
            
    }
}

