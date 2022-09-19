import java.util.ArrayList;

public class SolutionList {
    ArrayList<String> arrli = new ArrayList<String>(); 
    ArrayList<String> impli = new ArrayList<String>(); 
    
    void addSolution(String s) {
    	arrli.add(s);
    }
    
    void addImpossible(String s) {
    	impli.add(s);
    }
    
    //function which removes all duplicate elements from an ArrayList
    public static ArrayList<String> removeDuplicates(ArrayList<String> list)
    {
  
        ArrayList<String> newList = new ArrayList<String>();
  
        for (String element : list) { 
            if (!newList.contains(element)) {  
                newList.add(element);
            }           
        }
  
        return newList;
    }
       
}
