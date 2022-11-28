/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

public class ArrayList {

    private ArrayNode cabeza;
    private int length;

    public ArrayList(ArrayNode cabeza) {
        if(cabeza == null){
            length = 0;
        } else {
            length = 1;
        }
        this.cabeza = cabeza;
    }

    public ArrayNode getCabeza() {
        return cabeza;
    }

    public int getLenght() {
        return length;
    }

    public void setCabeza(ArrayNode cabeza) {
        this.cabeza = cabeza;
    }

    public void insertarPrincipio(String array) {
        ArrayNode nodo = new ArrayNode(array);
        if (estaVacia()) {
            setCabeza(nodo);
        } else {
            nodo.setSiguiente(getCabeza());
            setCabeza(nodo);
        }
        length++;
    }

    public void insertarFinal(String array) {
        ArrayNode nodo = new ArrayNode(array);
        if (estaVacia()) {
            setCabeza(nodo);
        } else {
            ArrayNode pointer = getCabeza();
            while (pointer.getSiguiente() != null) {
                pointer = pointer.getSiguiente();
            }
            pointer.setSiguiente(nodo);
        }
        length++;
    }

    public void insertarEnIndice(int pos, String array){
        ArrayNode nodo = new ArrayNode(array);
        if (estaVacia()) {
            setCabeza(nodo);
        } else {
            ArrayNode pointer = getCabeza();
            int cont = 0;
            while (cont < pos && pointer.getSiguiente() != null) {
                pointer = pointer.getSiguiente();
                cont++;
            }
            nodo.setSiguiente(pointer.getSiguiente());
            pointer.setSiguiente(nodo);
        }
        length++;
    }

    public String obtenerNumero(int pos){
        if (estaVacia()) {
            return null;
        } else {
            ArrayNode pointer = getCabeza();
            int cont = 0;
            while (cont < pos && pointer.getSiguiente() != null) {
                pointer = pointer.getSiguiente();
                cont++;
            }
            if (cont == pos) {
                return pointer.getElemento();
            } else {
                return null;
            }
        }
    }

    public void eliminarPrincipio() {
        if (!estaVacia()){
            ArrayNode pointer = getCabeza();
            setCabeza(pointer.getSiguiente());
            pointer.setSiguiente(null);
            length--;
        }
    }

    public void eliminarUltimo(){
        if(!estaVacia()){
            ArrayNode pointer = getCabeza();
            while (pointer.getSiguiente().getSiguiente() != null) {
                pointer = pointer.getSiguiente();
            }
            pointer.setSiguiente(null);
            length--;
        }
    }

    public void eliminarEnIndice(int pos){
        if(!estaVacia()){
            ArrayNode pointer = getCabeza();
            int cont = 0;
            while (cont < (pos - 1) && pointer.getSiguiente() != null) {
                pointer = pointer.getSiguiente();
                cont++;
            }
            ArrayNode temp = pointer.getSiguiente();
            pointer.setSiguiente(temp.getSiguiente());
            temp.setSiguiente(null);
            length--;
        }
    }

    public boolean estaVacia(){
            return getCabeza() == null;
        }
    
    
    
}