/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author Martin
 */
public class InPreToPostMethods {
    
     public static String prefixToPostFix(String str){
        int length = str.length();
        Stack stack = new Stack();
        for(int i = length-1; i >= 0; i--){
            if(isOperator(str.charAt(i))){
                String s1 = stack.pop().getElement().toString();
                String s2 = stack.pop().getElement().toString();
                String temp = s1+s2+str.charAt(i);
                stack.push(temp);
            }else {
                stack.push(str.charAt(i)+"");
            }
        }
        return stack.pop().getElement().toString();
    }

    public static boolean isOperator(char c) {
        switch (c){
            case '+':
            case '-':
            case '*':
            case '/':
            case '^':
                return true;
        }
        return false;
    }
    
    public static int precedence(char ch) 
   	{ 
       	switch (ch) 
       	{ 
       	case '+': 
       	case '-': 
           	return 1; 
      
       	case '*': 
       	case '/': 
           	return 2; 
       
       	case '^': 
           	return 3; 
       	}//switch() 
       	return -1; 
   	}//precedence() 
       
   	public static String infixToPostfix(String exp) 
   	{ 
   		String result = new String(""); 
          
   		Stack stack = new Stack(); 
          
   		for (int i = 0; i<exp.length(); ++i) 
    	{ 
   			char c = exp.charAt(i); 
              
    		if (Character.isLetterOrDigit(c)) 
   				result += c; 
               
   			else if (c == '(') 
    			stack.push(c); 
             
    		else if (c == ')') 
    		{ 
   				while (!stack.isEmpty() && stack.getPeek().getElement().toString().charAt(0) != '(') 
   					result += stack.pop().getElement().toString(); 
                  
   				if (!stack.isEmpty() && stack.getPeek().getElement().toString().charAt(0) != '(') 
   					return "Invalid Expression";          
   				else
   					stack.pop(); 
   			}//else_if 
            
   			else 
   			{ 
   				while (!stack.isEmpty() && precedence(c) <= precedence(stack.getPeek().getElement().toString().charAt(0))) 
    				result += stack.pop().getElement().toString(); 
   				stack.push(c); 
    		}//else 
       
   		}//for() 
       
    	while (!stack.isEmpty()) 
   			result += stack.pop().getElement().toString();
       
   		return result; 
   	}//infixToPostfix() 
        
   	public static int evaluatePostfix(String exp) 
   	{ 
    	Stack stack = new Stack(); 
              
    	for(int i=0;i<exp.length();i++) 
   		{ 
    		char c=exp.charAt(i); 
    			
    		if(Character.isDigit(c)) 
   				stack.push(c - '0'); 
                  
    		else
            { 
    			int val1 = (Integer)stack.pop().getElement(); 
                int val2 = (Integer)stack.pop().getElement(); 
                    
                switch(c) 
                { 
                	case '+': 
                	  stack.push(val2+val1); 
                	  break; 
                          
                	case '-': 
                      stack.push(val2- val1); 
                      break; 
                         
                    case '/': 
                      stack.push(val2/val1); 
                      break; 
                          
                    case '*': 
                      stack.push(val2*val1); 
                      break; 
                 }//switch 
              }//else
           }//for 
           return (Integer)stack.pop().getElement();     
        }//evalluatePostfix() 

  public boolean isNumber(String token) {
    return Character.isDigit(token.charAt(0));
  }

  public int getPriority(String op) {
    if (op.equals("(")) {
      return 0;
    } else if (op.equals("+") || op.equals("-")) {
      return 1;
    } else {
      return 2;
    }
  }
    
    
}
