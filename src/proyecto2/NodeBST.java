/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;


/**
 *
 * @author Sebastián
 */
public class NodeBST {
    private int data;
    private NodeBST left;
    private NodeBST right;

    /**
     * @return the data
     */
    public int getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(int data) {
        this.data = data;
    }

    /**
     * @return the pNext
     */

    /**
     * @return the left
     */
    public NodeBST getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(NodeBST left) {
        this.left = left;
    }

    /**
     * @return the right
     */
    public NodeBST getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(NodeBST right) {
        this.right = right;
    }

    public NodeBST(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    
    
    
}
