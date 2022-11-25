/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

public class ArrayNode {
    private String elemento;
    private ArrayNode siguiente;

    public ArrayNode(String elemento) {
        this.elemento = elemento;
        this.siguiente = null;
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public ArrayNode getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(ArrayNode siguiente) {
        this.siguiente = siguiente;
    }
}