/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;



/**
 *
 * @author Sebastián
 */
public class binaryTree {
    private binaryNode root;

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
            } else if (side == "left" & nodeParent.getLeft() == null){
                nodeParent.setLeft(nodeLeaf);
                nodeLeaf.setparent(nodeParent);
            } else if (side == "right" & nodeParent.getRight() == null){
                nodeParent.setRight(nodeLeaf);
                nodeLeaf.setparent(nodeParent);
            } else{
                System.out.println("Ambos hijos estan llenos");
            }
        }
        
    }
    
    public void preOrder(binaryNode root){
        System.out.println(root.getData());
        if(root.getLeft() != null){
            preOrder(root.getLeft());
        }
        if(root.getRight() != null){
            preOrder(root.getRight());
        }
    }
    
    public void postOrder(binaryNode root){
        if(root.getLeft() != null){
            postOrder(root.getLeft());
        }
        
        if(root.getRight() != null){
            postOrder(root.getRight());
        }
        System.out.println(root.getData());
    }
    
    public void inOrder(binaryNode root){
        if(root.getLeft() != null){
            inOrder(root.getLeft());
        }
        System.out.println(root.getData());
        if(root.getRight() != null){
            inOrder(root.getRight());
        }
    }
    
}
