/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;


/**
 *
 * @author Sebastián
 */
public class binaryNode<T> {
    private T data;
    private binaryNode parent;
    private binaryNode left;
    private binaryNode right;

    /**
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * @return the pNext
     */
    public binaryNode getparent() {
        return parent;
    }

    /**
     * @param pNext the pNext to set
     */
    public void setparent(binaryNode parent) {
        this.parent = parent;
    }

    /**
     * @return the lSon
     */
    public binaryNode getLeft() {
        return left;
    }

    /**
     * @param left the lSon to set
     */
    public void setLeft(binaryNode left) {
        this.left = left;
    }

    /**
     * @return the rBrother
     */
    public binaryNode getRight() {
        return right;
    }

    /**
     * @param right the rBrother to set
     */
    public void setRight(binaryNode right) {
        this.right = right;
    }

    public binaryNode(T data) {
        this.data = data;
        this.parent = null;
        this.left = null;
        this.right = null;
    }
    
    
    
}
