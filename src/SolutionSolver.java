import java.util.ArrayList;

public class SolutionSolver {
	
	static float total;
	
	public  ArrayList<String> combinationTester(float[] a){
		ArithmeticSolvers as = new ArithmeticSolvers();
		StringMethods sm = new StringMethods();
		SolutionList sl = new SolutionList();
		
		//compare all unique numeric combinations(a[]) with all possible arithmetic operators(b[])
		for (int w = 0; w < 4; w++) 
		{
		    for (int x = 0; x < 4; x++) 
		     {
		        for (int y = 0; y <4; y++) 
		        {
		          for (int z = 0; z < 4; z++) 
		          {
		             if (w!=x && w != y && w != z && x != y && x != z && y != z) 
		             {          	            	 
		            	 for (int c = 0; c < 4; c++) 
		            	 {
		            	     for (int d = 0; d < 4; d++) 
		            	      {
		            	         for (int e = 0; e <4; e++) 
		            	         {
		            	        	 int[] b = {c,d,e};
		            	        	 float[] f = {a[w], a[x], a[y], a[z]};
		            	        	            	        	 
		            	        	 float tot = 0;
		            	        	 float tot2 = 0;           	 
		            	        	 
		            	        	 //All arithmetic cases that do not require brackets, ordered by operation sequence where
		            	        	 //X represents multiplication and division and 0 represents addition / subtraction)
		            	        	 
		            	        	 //X X X
		            	        	 if(((c == 2) || (c == 3)) && ((d == 2) || (d == 3)) && ((e == 2) || (e == 3))) {
		            	        		 
		            	        		tot = as.solveThree(a[w], a[x], a[y], c, d);
		            	        		tot = as.solveTwo(tot, a[z], e);
		            	        		 
		            	        	 }
		            	        	 
		            	        	 //X X 0 (same calculation as above -- separated for clarity)
		            	        	 if(((c == 2) || (c == 3)) && ((d == 2) || (d == 3)) && !((e == 2) || (e == 3))) {
		            	        		 
		            	        		 tot = as.solveThree(a[w], a[x], a[y], c, d);
		             	        		 tot = as.solveTwo(tot, a[z], e);
		            	        	
		            	        	 }
		            	        	 
		            	        	 //X 0 X 
		            	        	 if(((c == 2) || (c == 3)) && !((d == 2) || (d == 3)) && ((e == 2) || (e == 3))) {
		            	        		 
		            	        		 tot = as.solveTwo(a[w], a[x], c);
		            	        		 tot2 = as.solveTwo(a[y], a[z], e);
		            	        		 tot = as.solveTwo(tot, tot2, d);          	        
		            	        		 
		            	        	 }
		            	        	 
		            	        	 //X 0 0
		            	        	 if(((c == 2) || (c == 3)) && !((d == 2) || (d == 3)) && !((e == 2) || (e == 3))) {
		            	        		 
		            	        		 tot = as.solveTwo(a[w], a[x], c);
		            	        		 tot = as.solveThree(tot, a[y], a[z], d, e);
		            	        		 
		            	        	 }
		            	        	 
		            	        	 //0 X X
		            	        	 if(!((c == 2) || (c == 3)) && ((d == 2) || (d == 3)) && ((e == 2) || (e == 3))) {
		            	        		 
		            	        		 tot = as.solveThree(a[x], a[y], a[z], d, e);
		            	        		 tot = as.solveTwo(a[w], tot, c);
		            	        		 
		            	        	 }
		            	        	 
		            	        	 //0 X 0    
		            	        	 if(!((c == 2) || (c == 3)) && ((d == 2) || (d == 3)) && !((e == 2) || (e == 3))) {
		            	        		
		            	        		 tot = as.solveTwo(a[x], a[y], d);
		            	        		 tot = as.solveThree(a[w], tot, a[z], c, e);

		            	        	 }
		            	        	 
		            	        	 //0 0 X  
		            	        	 if(!((c == 2) || (c == 3)) && !((d == 2) || (d == 3)) && ((e == 2) || (e == 3))) {

		            	        		 tot = as.solveTwo(a[y], a[z], e);
		            	        		 tot = as.solveThree(a[w], a[x], tot, c, d);
			 
		            	        	 }
		            	        	 
		            	        	 //0 0 0
		            	        	 if(!((c == 2) || (c == 3)) && !((d == 2) || (d == 3)) && !((e == 2) || (e == 3))) {
		            	        		 
		            	        		 tot = as.solveThree(a[w], a[x], a[y], c, d);
		            	        		 tot = as.solveTwo(tot, a[z], e);
		            	        		 
		            	        	 }           	        	 
		            	             
		            	             if(tot == total) {

		            	            	 String aw = Character.toString(String.valueOf(a[w]).charAt(0));
		            	            	 String ax = Character.toString(String.valueOf(a[x]).charAt(0));
		            	            	 String ay = Character.toString(String.valueOf(a[y]).charAt(0));
		            	            	 String az = Character.toString(String.valueOf(a[z]).charAt(0));
		            	            	 
		            	            	 String solution  = sm.solutionToString(aw, ax, ay, az, c, d, e);
		            	            	 sl.addSolution(solution);
		            	            	           	            	 	
		            	             }else {
		            	            	 if(bracketSolver(f, b) != null) {
		            	            		 sl.addSolution(bracketSolver(f,b));
		            	            	 }
		            	             }
		            	         }
		            	      }
		            	   }
		             } 
		          }
		        }
		     }
		  }
		return SolutionList.removeDuplicates(sl.arrli);
	}
	
	
	public static String bracketSolver(float[] a, int[] b) {
		
		String aw, ax, ay, az = "";
		StringMethods sm = new StringMethods();
		ArithmeticSolvers as = new ArithmeticSolvers();
		
		// a[] represents the numbers in the arithmetic expression being solved
		// b[] represents the arithmetic operator (0 = +, 1 = -, 2 = *, 3 = /)
		
		// case 1 : (W X) Y Z 
		float tot1 = 0;
		tot1 = as.solveTwo(a[0], a[1], b[0]);
		tot1 = as.solveThree(tot1, a[2], a[3], b[1], b[2]);
		
		if(tot1 == total) {
			
			aw = "(" +  Character.toString(String.valueOf(a[0]).charAt(0));
       	 	ax = Character.toString(String.valueOf(a[1]).charAt(0)) + ")";
       	 	ay = Character.toString(String.valueOf(a[2]).charAt(0));
       	 	az = Character.toString(String.valueOf(a[3]).charAt(0));
       	 
       	 	return sm.solutionToString(aw, ax, ay, az, b[0], b[1], b[2]);

		}
				
		// case 2: (W X Y) Z
		float tot2 = 0;
		tot2 = as.solveThree(a[0], a[1], a[2], b[0], b[1]);
		tot2 = as.solveTwo(tot2, a[3], b[2]);
		
		if(tot2 == total) {
			
		    aw= "(" + Character.toString(String.valueOf(a[0]).charAt(0));
	   	 	ax = Character.toString(String.valueOf(a[1]).charAt(0));
	   	 	ay = Character.toString(String.valueOf(a[2]).charAt(0)) + ")";
	   	 	az = Character.toString(String.valueOf(a[3]).charAt(0));
	   	 
	   	 	return sm.solutionToString(aw, ax, ay, az, b[0], b[1], b[2]);
					
		}
		
		// case 3: W (X Y) Z		
		float tot3 = 0;	
		tot3 = as.solveTwo(a[1], a[2], b[1]);
		tot3 = as.solveThree(a[0], tot3, a[3], b[0], b[2]);
	
		if(tot3 == total) {
									
			aw = Character.toString(String.valueOf(a[0]).charAt(0));
	   	 	ax = "(" + Character.toString(String.valueOf(a[1]).charAt(0));
	   	 	ay = Character.toString(String.valueOf(a[2]).charAt(0)) + ")";
	   	 	az = Character.toString(String.valueOf(a[3]).charAt(0));
	   	 
	   	 	return sm.solutionToString(aw, ax, ay, az, b[0], b[1], b[2]);
					
		}
				
		//case 4: W (X Y Z)
		float tot4 = 0;
		tot4 = as.solveThree(a[1], a[2], a[3], b[1], b[2]);
		tot4 = as.solveTwo(a[0], tot4, b[0]);
				
		if(tot4 == total) {
			
			aw = Character.toString(String.valueOf(a[0]).charAt(0));
	   	 	ax =  "(" + Character.toString(String.valueOf(a[1]).charAt(0));
	   	 	ay =  Character.toString(String.valueOf(a[2]).charAt(0));
	   	 	az =  Character.toString(String.valueOf(a[3]).charAt(0)) + ")";
	   	 
	   	 	return sm.solutionToString(aw, ax, ay, az, b[0], b[1], b[2]);
	 	
		}
		
		//case 5: W X (Y Z)
		float tot5 = 0; 
		tot5 = as.solveTwo(a[2], a[3], b[2]);
		tot5 = as.solveThree(a[0], a[1], tot5, b[0], b[1]);		
		
		if(tot5 == total) {
			
			aw = Character.toString(String.valueOf(a[0]).charAt(0));
	   	 	ax =  Character.toString(String.valueOf(a[1]).charAt(0));
	   	 	ay =  "(" + Character.toString(String.valueOf(a[2]).charAt(0));
	   	 	az =  Character.toString(String.valueOf(a[3]).charAt(0)) + ")";
	   	 
	   	 	return sm.solutionToString(aw, ax, ay, az, b[0], b[1], b[2]);
			
		}	
		
		return null;
	}
	
}
