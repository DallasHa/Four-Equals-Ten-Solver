
public class StringMethods {
	public String solutionToString(String num1, String num2, String num3, String num4, int op1, int op2, int op3) {
		
		 	String solution  = "";
		 
		 	solution += num1;	 
		 	
    	 	if(op1 == 0) {
    	 		solution += (" + ");
    	 	}else if(op1 == 1) {
    	 		solution += (" - ");
    	 	}else if(op1 == 2) {
    	 		solution += (" × ");
    	 	}else{
    	 		solution += (" ÷ ");
    	 	}
    	 	         	            	 	
    	 	solution += num2;
    	 	
    	 	if(op2 == 0) {
    	 		solution += (" + ");
    	 	}else if(op2 == 1) {
    	 		solution += (" - ");
    	 	}else if(op2 == 2) {
    	 		solution += (" × ");
    	 	}else{
    	 		solution += (" ÷ ");
    	 	}
    	 	     
    	 	solution += num3;
    	 	
    	 	if(op3 == 0) {
    	 		solution += (" + ");
    	 	}else if(op3 == 1) {
    	 		solution += (" - ");
    	 	}else if(op3 == 2) {
    	 		solution += (" × ");
    	 	}else {
    	 		solution += (" ÷ ");
    	 	}
    	 	
    	 	return solution += num4;
	
	}
	
	public String impossibleToString(float[] f) {
		
		return Character.toString(String.valueOf(f[0]).charAt(0)) + " " + Character.toString(String.valueOf(f[1]).charAt(0)) +
		" " + Character.toString(String.valueOf(f[2]).charAt(0)) + " " + Character.toString(String.valueOf(f[3]).charAt(0));

	}
	
}
