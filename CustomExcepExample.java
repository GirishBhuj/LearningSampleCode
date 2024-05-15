package GBSoft.Learning;

import org.apache.logging.log4j.*;

public class CustomExcepExample {
	
	
	public static void main(String[] args) throws UserDefinedException {
		
		System.setProperty("log4j.configurationFile","log4j2.xml");
		Logger logger = LogManager.getLogger(CustomExcepExample.class);
		
		/* if (true)
		{
            throw new UserDefinedException("An error occurred because of some condition");
		}
		*/
		
		try { // Code that may throw an exception
		}
		finally { // Code that will always execute, regardless of whether an exception is thrown or not
		}
	
		  try {
	            int[] arr = new int[5];
	            arr[5] = 10; // This will throw an ArrayIndexOutOfBoundsException
	      } 
		  catch (ArrayIndexOutOfBoundsException e)
		  		{System.out.println("Array index out of bounds!"+ e);
		  		logger.error(e);
		  		}
		  catch (ArithmeticException e) 
		  		{System.out.println("Arithmetic exception occurred!");
		  		logger.error(e);
		  		}
		  catch (Exception e)
		  		{System.out.println("Some other exception occurred!");}
        
	      try {
	            int result = 10/0; // This will throw an ArithmeticException
	        } catch (ArithmeticException e) {
	            System.out.println("Cannot divide by zero!");
	        }
	}
	
	@Override
    protected void finalize() {
        System.out.println("Finalize method called.");
    }
}