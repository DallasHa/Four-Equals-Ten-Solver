import java.util.ArrayList;

//collection of methods which take in a list and return the list without the elements containing a specified arithmetic operator
public class ExclusionMethods {

	public ArrayList<String> excludeAddition(ArrayList<String> al){

		for(int i =0; i<al.size(); i++) {
			if (al.get(i).contains("+")){
				al.remove(i);
				i--;
			}
		}
		
		return al;
	}
	
	public ArrayList<String> excludeSubtraction(ArrayList<String> al){

		for(int i =0; i<al.size(); i++) {
			if (al.get(i).contains("-")){				
				al.remove(i);
				i--;
			}
		}
		
		return al;
	}
	
	public ArrayList<String> excludeMultiplication(ArrayList<String> al){

		for(int i =0; i<al.size(); i++) {
			if (al.get(i).contains("×")){
				al.remove(i);
				i--;
			}
		}
		
		return al;
	}
	
	public ArrayList<String> excludeDivision(ArrayList<String> al){

		for(int i =0; i<al.size(); i++) {
			if (al.get(i).contains("÷")){
				al.remove(i);
				i--;
			}
		}
		
		return al;
	}
	
}
