/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author Sebastián
 */
public class Verifications {
    
    public boolean isOperand(String data){
        
        try{
        
            int aux;
            aux = Integer.parseInt(data);
            return true;
            
        }catch(Exception e){
            return false;
        }
        
    }
    
 
    public boolean isOperator(String data){
    
        if (data.equals("+") || data.equals("-") || data.equals("*") || data.equals("/") || data.equals("^")){
            return true;
            
        }else{
            return false;
        }
        
    }
    
    
}
