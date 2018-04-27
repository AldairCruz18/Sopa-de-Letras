/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sopadeletras;

/**
 *
 * @author Aldair Cruz
 */
public class Palabras {
    pl cb;
    pl at;
    public pl getHd() {
        return cb;
    } 
    
    public void pegar(pl palabra){
        
        if(cb!=null){
            at.setNext(palabra);
            at = palabra;
        
        }else{    
            this.cb = palabra;
            this.at = palabra;
        }                
    }
    
    public void Lista(){
        pl crr = this.cb;
        while(crr!=null){
            System.out.println(crr.toString());
            crr = crr.getNext();
        }
    }
}
