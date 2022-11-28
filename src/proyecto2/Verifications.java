/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author Sebastián
 * @version 11/27/2022
 */
public class Verifications {
    
    public boolean isNumber(String data){
        
        try{
        
            int aux;
            aux = Integer.parseInt(data);
            return true;
            
        }catch(Exception e){
            return false;
        }
        
    }
    
    /**
     * Funcion verificacion de operandos
     * @param data dato a verificar
     * @return booleano estado si es operando o no
     * Se utiliza esta funcion para verificar si algun caracter es un operando
     */
    
    public boolean isOperand(String data){
        if(isNumber(data)){
            return true;
            
        }else{
            char aux = data.charAt(0);
            if(Character.isLetter(aux)){
                return true;
                
            }else{
                return false;
            }  
        }
    }
    
    /**
     * Funcion verificacion de operadores
     * @param data dato a verificar
     * @return booleano estado si es operador o no
     * Se utiliza esta funcion para verificar si algun caracter es un operador
     */
    
    public boolean isOperator(String data){
    
        if (data.equals("+") || data.equals("-") || data.equals("*") || data.equals("/") || data.equals("^")){
            return true;
            
        }else{
            return false;
        }
        
    }
    
//    public boolean isCorrect(String[] data){
//        int aux = 0;
//        if(data.length != 0){
//            for(int i = 0; i < data.length; i++){
//
//                if(isOperand(data[i])){
//                    aux += 1;
//
//                }else{
//                    aux -= 1;
//                }
//
//            }
//
//            if(aux == 1){
//                return true;
//
//            }else{
//                return false;
//            }
//
//
//        }else{
//            return false;
//        }
//    }
    
    /**
     * Prioridad de operador
     * @param data operador
     * @return nivel de prioridad
     * Se ingresa un operador, la funcion verificara que caso es y retornara su nivel de prioridad
     */
    
    public int priorityLevel(String data){
        
        switch(data){
        
            case "+":
            case "-":
                return 0;
            
            case "*":
            case "/":
                return 1;
                
            case "^":
                return 2;
                
            default:
                return -1;
        
        }
    }
    
    /**
     * Constructor de arbol de expresiones
     * @param data expresion de tipo postfija
     * @return arbol de expresion
     * Se construye un arbol de expresion a partir de una expresion postfija, la expresion se evalua por caracter, si es un operando se apila, si es un operador se desapilan dos elementos y se unen al arbol
     */
    
    public binaryTree buildTree(String data){
        String[] splitData = data.split("");
        Stack treeStack = new Stack();
        
        for (int i = 0; i < splitData.length; i++){
            binaryTree current = new binaryTree();
            current.addNode(splitData[i], null, null);
            
            if (isOperator(splitData[i])){
                binaryTree aux1 = binaryTree.class.cast(treeStack.pop().getElement());
                binaryTree aux2 = binaryTree.class.cast(treeStack.pop().getElement());
                
                current.insertNode(aux1.getRoot(), current.getRoot(), "right");
                current.insertNode(aux2.getRoot(), current.getRoot(), "left");
                
                treeStack.push(current);
                
            }else{
                treeStack.push(current);            
            }
            
            
        }
        
        return binaryTree.class.cast(treeStack.pop().getElement());
    
    }
    
}