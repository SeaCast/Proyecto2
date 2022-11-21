/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;



/**
 *
 * @author Sebastián
 */
public class binarySearchTree {
    private NodeBST root;

    /**
     * @return the root
     */
    public NodeBST getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    public void setRoot(NodeBST root) {
        this.root = root;
    }
    
    public boolean isEmpty(){
        return root == null;
    }
    
    public NodeBST searchParent(NodeBST current, int data){
        NodeBST found = null;
        if(data < current.getData()){
            if(found != null){
                return found;
            
            } else if (current.getLeft() != null){
                found = this.searchParent(current.getLeft(), data);
            } else {
                return current;
            }
            
        }else if(data > current.getData()){
            if(found != null){
                return found;
                
            } else if (current.getRight() != null){
                found = this.searchParent(current.getRight(), data);
            } else {
                return current;
            }
        }
        return found;
    }
    
    
    public void insert(int data){
        NodeBST toAdd = new NodeBST(data);
        if(this.root == null){
            this.root = toAdd;
        }else{
            NodeBST nodeParent = this.searchParent(this.root, data);
            if (nodeParent == null){
                System.out.println("El valor ya existe en el arbol");
            } else if (nodeParent.getData() > toAdd.getData()){
                nodeParent.setLeft(toAdd);
            } else if (nodeParent.getData() < toAdd.getData()){
                nodeParent.setRight(toAdd);
            }
        }
    }
    
    public void preOrder(NodeBST root){
        System.out.println(root.getData());
        if(root.getLeft() != null){
            preOrder(root.getLeft());
        }
        if(root.getRight() != null){
            preOrder(root.getRight());
        }
    }
    
    public void postOrder(NodeBST root){
        if(root.getLeft() != null){
            postOrder(root.getLeft());
        }
        
        if(root.getRight() != null){
            postOrder(root.getRight());
        }
        System.out.println(root.getData());
    }
    
    public void inOrder(NodeBST root){
        if(root.getLeft() != null){
            inOrder(root.getLeft());
        }
        System.out.println(root.getData());
        if(root.getRight() != null){
            inOrder(root.getRight());
        }
    }
    
    public NodeBST searchLowest(NodeBST root){
        NodeBST found = null;
        if(root.getLeft() == null){
            return root;
        }else{
            found = searchLowest(root.getLeft());
        }
    return found;
    }
    
    public void deleteNode(NodeBST toRemove){
        
        NodeBST parent = searchDelParent(this.root, toRemove.getData());
        if ((toRemove.getLeft() == null && toRemove.getRight() == null) || (toRemove.getLeft() == null && toRemove.getRight() != null)){
            modifyParent(toRemove, parent, 'R');

        }else if (toRemove.getLeft() != null && toRemove.getRight() == null){
                
            modifyParent(toRemove, parent, 'L');

        }else if (toRemove.getLeft() != null && toRemove.getRight() != null){
            NodeBST aux = searchLowest(toRemove.getRight());
            NodeBST auxParent = searchDelParent(this.root, aux.getData());
            modifyParent(aux, auxParent, 'R');
            toRemove.setData(aux.getData());
                
        }
    }
    
    
    
    
    public NodeBST searchNode(int data, NodeBST root){
        NodeBST found = null;
        
        if(root != null){
            if(root.getData() == data || root == null){
                return root;
            }
            if (data < root.getData()){
                found = searchNode(data, root.getLeft());
            }
            if(data > root.getData()){
                found = searchNode(data, root.getRight());
            }
        }
        
    return found;
    }
    
    public void modifyParent(NodeBST son, NodeBST parent, char key){
        
        switch(key){
            case 'L':
                if(parent.getLeft() == son){
                    parent.setLeft(son.getLeft());
                }else{
                    parent.setRight(son.getLeft());
                }
                
            
            default:
                if(parent.getLeft() == son){
                    parent.setLeft(son.getRight());
                        }else{
                    parent.setRight(son.getRight());
                        }
            
        }
    }
    
    public NodeBST searchDelParent(NodeBST current, int data){
        NodeBST found = null;
        if(data < current.getData()){
            if(found != null){
                return found;
            
            } else if (current.getLeft() != null){
                if(current.getLeft().getData() == data){
                    found = current;
                
                }else{
                    found = this.searchDelParent(current.getLeft(), data);}
                
            } else {
                return current;
            }
            
        }else if(data > current.getData()){
            if(found != null){
                return found;
                
            } else if (current.getRight() != null){
                if(current.getRight().getData() == data){
                    found = current;
                
                }else{
                    found = this.searchDelParent(current.getRight(), data);}
                
                
            } else {
                return current;
            }
        }
        return found;
    }
    
}