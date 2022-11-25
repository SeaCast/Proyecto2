/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author Martin
 */


public class Stack{
    private StackNode peek;
    private int length;

    public Stack() {
        this.peek = null;
        this.length = 0;
    }

    
    public void push(Object elemento) {
        StackNode nodo = new StackNode(elemento);
        nodo.setNext(getPeek());
        setPeek(nodo);
        setLength(getLength()+ 1);
    }
    
    
    public StackNode pop() {
        if (!isEmpty()){
            StackNode temp = getPeek();
            setPeek(getPeek().getNext());
            temp.setNext(null);
            setLength(getLength() - 1);
            return temp;
        }
        return null;
    }
    
    
    public int getLength() {
        return length;
    }

    public StackNode getPeek() {
        return peek;
    }

    
    public boolean isEmpty() {
        return getPeek() == null;
    }

    public void setPeek(StackNode nodo) {
        this.peek = nodo;
    }


    public void setLength(int length) {
        this.length = length;
    }

    
}
