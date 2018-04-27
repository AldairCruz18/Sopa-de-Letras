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
public class OrigeList {
    Or cb;
    Or at;
    public void Pegar(Or or){
        if(cb==null){
            this.cb=or;
            this.at=or;
        }else{
            at.setNext(or);
            at=or;
        }
    }

    public Or getHead() {
        return cb;
    }
    
    public void printList(){
        Or crr = cb;
        while(crr!=null){
            System.out.println(crr.toString());
            crr=crr.getNext();
        }
    }
}
