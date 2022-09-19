import java.util.ArrayList;

public class ImpossibleSolver {
	
	SolutionSolver ss = new SolutionSolver();
	StringMethods sm = new StringMethods();
	ArrayList<String> al = new ArrayList<String>();
	
	//function which returns an ArrayList of all possible combinations of 4 numbers which cannot be manipulated to produce a given total
	public ArrayList<String> impossibleSolver(){
		
			for(float i = 0; i<=9; i++){
			    for(float j = i; j<=9; j++){
			        for(float k = j; k<=9; k++){
			            for(float m = k; m<=9; m++){
			            	
			                float[] f = {i, j, k, m};
			                
			                if (ss.combinationTester(f).size() == 0) {
			                	al.add(sm.impossibleToString(f));
			                }
		
			            }
			        }
			    }
			}
			
		return al;
		
	}
}
