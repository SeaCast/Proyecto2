/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author Martin
 */
public class StackNode {
    private Object element;
    private StackNode next;

    public StackNode(Object element) {
        this.element = element;
        this.next = null;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public StackNode getNext() {
        return next;
    }

    public void setNext(StackNode next) {
        this.next = next;
    }
}