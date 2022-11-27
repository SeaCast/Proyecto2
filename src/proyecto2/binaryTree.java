/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

import javax.swing.JPanel;



/**
 *
 * @author Sebastián
 */
public class binaryTree {
    private binaryNode root;
    private binaryTree tNext;
    int num_nodos;
    int alt;


    /**
     * @return the root
     */
    public binaryNode getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    public void setRoot(binaryNode root) {
        this.root = root;
    }
    
    public boolean isEmpty(){
        return root == null;
    }
    
    
    
    public binaryNode searchParent(binaryNode root, String parent){
        binaryNode found = null;
        if (root.getData() == parent){
            return root;
        }
        if (root.getLeft() != null){
            found = searchParent(root.getLeft(), parent);
        }
        if (root.getRight() != null){
            found = searchParent(root.getRight(), parent);
        }
        return found;
    }
    
    public void addNode(String leaf, String parent, String side){
        
        binaryNode nodeLeaf = new binaryNode(leaf);
        if(this.isEmpty()){
            this.root = nodeLeaf;
        }else{
            binaryNode nodeParent = searchParent(this.root, parent);
            if(nodeParent == null){
                System.out.println("No existe el nodo");
            } else if (side.equalsIgnoreCase("left") & nodeParent.getLeft() == null){
                nodeParent.setLeft(nodeLeaf);
                nodeLeaf.setparent(nodeParent);
            } else if (side.equalsIgnoreCase("right") & nodeParent.getRight() == null){
                nodeParent.setRight(nodeLeaf);
                nodeLeaf.setparent(nodeParent);
            } else{
                System.out.println("Ambos hijos estan llenos");
            }
        }
        
    }
    
    public void insertNode(binaryNode leaf, binaryNode root, String side){
        
        if(side.equalsIgnoreCase("left")){
            root.setLeft(leaf);
            leaf.setparent(root);
            
        }else{
            root.setRight(leaf);
            leaf.setparent(root);
        }
        
    }
    
    public String preOrder(binaryNode root, String data){
        data += root.getData();
        if(root.getLeft() != null){
            data = preOrder(root.getLeft(), data);
        }
        if(root.getRight() != null){
            data = preOrder(root.getRight(), data);
        }
        return data;
    }
    
    public String postOrder(binaryNode root, String data){
        if(root.getLeft() != null){
            data = postOrder(root.getLeft(), data);
        }
        
        if(root.getRight() != null){
            data = postOrder(root.getRight(), data);
        }
        data += root.getData();
        return data;
    }
    
    public String inOrder(binaryNode root, String data){
        if(root.getLeft() != null){
            data = inOrder(root.getLeft(), data);
        }
        data += root.getData();
        if(root.getRight() != null){
            data = inOrder(root.getRight(), data);
        }
        return data;
    }

    /**
     * @return the tNext
     */
    public binaryTree gettNext() {
        return tNext;
    }

    /**
     * @param tNext the tNext to set
     */
    public void settNext(binaryTree tNext) {
        this.tNext = tNext;
    }
        private void altura(binaryNode aux, int nivel) {
        if (aux != null) {
            altura(aux.getLeft(), nivel + 1);
            alt = nivel;
            altura(aux.getRight(), nivel + 1);
        }
    }

    //Devuleve la altura del arbol
    public int getAltura() {
        altura(root, 1);
        return alt;
    }
    
     public JPanel getdibujo() {
        return new ArbolExpresionGrafica(this);
    }
}

