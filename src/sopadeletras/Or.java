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
public class Or {
    private Or next;
    private Integer x;
    private Integer y;
    
    public Or(Integer x, Integer y){
        this.x = x;
        this.y = y;
    }
    
    public void setNext(Or next) {
        this.next = next;
    }

    public Or getNext() {
        return next;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }
    
    public String toString(){
        return x+" "+y;
    }
}
