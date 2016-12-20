import java.util.*; 
import java.io.*;

class Function {  
	int NumberAddition(String str) { 
		  
		 int sum=0;
		  String number="";
		  
		   char[] array = str.toCharArray();
		   
		   for(int i=0;i<str.length();i++)
		   {
			   char c = str.charAt(i);
			   System.out.println("char="+c);
		       if(Character.isDigit(c))
		       {
		           number= number + c;
		           //System.out.print("number="+number);
		  
		        }
		        
		        else
		        {	
		        	 if(number != "")
		             {
		        		 System.out.println("number="+number);
		        		 System.out.println("sum="+sum);
		             sum = sum + Integer.parseInt(number);
		             System.out.println("sum="+sum);
		            
		             number="";
		             System.out.println("number="+number);
		             }
		        	 
		        	 else
		        	 {
		        		 continue;
		        	 }
		        }
		       
		    }
		    
		    
		    
		    
		    
		    
		    
		    
		    return sum;
		    
		  } 
  public static void main (String[] args) {  
    // keep this function call here     
    Scanner  s = new Scanner(System.in);
    Function c = new Function();
    System.out.print(c.NumberAddition(s.nextLine())); 
  }   
  
}