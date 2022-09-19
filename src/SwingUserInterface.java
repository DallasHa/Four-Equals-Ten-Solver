import java.awt.event.*;  
import javax.swing.*;    
public class SwingUserInterface {  
//creates a user interface for solution inputs and outputs
public void solutionInterface() {  
    JFrame f=new JFrame("4=10 Solver");  
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    
    JLabel totalNumberField= new JLabel("Total number to solve for: ");
    totalNumberField.setBounds(74, 30, 250, 30);
    f.add(totalNumberField);
    
    final JTextField totNum =new JTextField("10");  
    totNum.setBounds(245, 30, 50, 30);
    f.add(totNum);
    
    JLabel inputVariablesLabel= new JLabel("Input Variables: ");
    inputVariablesLabel.setBounds(74, 75, 250, 30);
    f.add(inputVariablesLabel);
    
    final JTextField num1 =new JTextField("1");  
    final JTextField num2 =new JTextField("2");  
    final JTextField num3 =new JTextField("3");  
    final JTextField num4 =new JTextField("4");  
 
    num1.setBounds(70, 105, 50, 30);
    num2.setBounds(140,105, 50,30);  
    num3.setBounds(210,105, 50,30);  
    num4.setBounds(280,105, 50,30);  
    f.add(num1); f.add(num2); f.add(num3); f.add(num4);  
      
    JLabel discludeLabel = new JLabel("Select operators to disclude: ");
    discludeLabel.setBounds(74, 160, 250, 30);
    f.add(discludeLabel);
    
    JCheckBox checkbox1 = new JCheckBox("+");    
    checkbox1.setBounds(70,185, 50,30);    
    JCheckBox checkbox2 = new JCheckBox("-");    
    checkbox2.setBounds(140,185, 50,30);    
    JCheckBox checkbox3 = new JCheckBox("×");    
    checkbox3.setBounds(210,185, 50,30);    
    JCheckBox checkbox4 = new JCheckBox("÷");    
    checkbox4.setBounds(280,185, 50,30);    
    f.add(checkbox1); f.add(checkbox2); f.add(checkbox3); f.add(checkbox4);
         
    JButton b=new JButton("Calculate Solutions");  
    b.setBounds(67,235,145,30);  
    b.addActionListener(new ActionListener(){  
    	public void actionPerformed(ActionEvent e){  
    		
    		SolutionList sl = new SolutionList();
    		SolutionSolver ss = new SolutionSolver();
    		ExclusionMethods em = new ExclusionMethods();
    		
    		JPanel panel = new JPanel();

    		float[] a = { Float.valueOf(num1.getText()), Float.valueOf(num2.getText()), Float.valueOf(num3.getText()), Float.valueOf(num4.getText()) }; 
    		
    		boolean incorrectInput = false;	
    		try {
    			SolutionSolver.total = Float.valueOf(totNum.getText());
    		}catch(Exception excep) {
    			incorrectInput = true;    
    		}
    		
    		sl.arrli = ss.combinationTester(a);
    		
    		if(checkbox1.isSelected()) {
    			sl.arrli = em.excludeAddition(sl.arrli);
    		}
    		if(checkbox2.isSelected()) {
    			sl.arrli = em.excludeSubtraction(sl.arrli);
    		}
    		if(checkbox3.isSelected()) {
    			sl.arrli = em.excludeMultiplication(sl.arrli);
    		}
    		if(checkbox4.isSelected()) {
    			sl.arrli = em.excludeDivision(sl.arrli);
    		}
    		
    	    JList list = new JList(sl.arrli.toArray());
    	   
    		boolean numberOutOfBounds = false;	    
    		for(int i = 0; i<a.length; i++) {
    			
    			if(!(a[i] >=0) || !(a[i] <= 9)) {
        	    	numberOutOfBounds = true;	
    			}
    		}
    		
    		
    		//display the panel with the results or error window
    		if(numberOutOfBounds) {
    			JLabel jlabel = new JLabel("Invalid number: Input variables must"
    	    			+ " be between 0 and 9 inclusive");
    	        panel.add(jlabel);
    	    	JOptionPane.showMessageDialog(null, panel, "Invalid number error", JOptionPane.PLAIN_MESSAGE);    	
    		}else if(incorrectInput){
    			JLabel jlabel = new JLabel("Input must be numeric");
    	        panel.add(jlabel);
    	    	JOptionPane.showMessageDialog(null, panel, "No results calculated", JOptionPane.PLAIN_MESSAGE);
    		}else if(sl.arrli.isEmpty()) {
    	    	JLabel jlabel = new JLabel("No solutions present");
    	        panel.add(jlabel);
    	    	JOptionPane.showMessageDialog(null, panel, "No results calculated", JOptionPane.PLAIN_MESSAGE);    	   
    	    }else {
    	    	panel.add(new JScrollPane(list));
    	    	JLabel jlabel = new JLabel(String.valueOf(sl.arrli.size()) + " unique solutions calculated");
    	        panel.add(jlabel);
    	    	JOptionPane.showMessageDialog(null, panel, "Solutions", JOptionPane.PLAIN_MESSAGE );
    	    }  	    
    	    
        }  
    });  f.add(b);
    
     
    JLabel incorrectCombinations = new JLabel("To view all impossible numeric combinations: ");
    incorrectCombinations.setBounds(74, 305, 340, 30);
    f.add(incorrectCombinations);
    
    //make a button which processes impossible combinations once button is clicked
    JButton impossibleSolutionsButton=new JButton("Impossible Solutions");  
    impossibleSolutionsButton.setBounds(67, 340, 160,30);  
    impossibleSolutionsButton.addActionListener(new ActionListener(){  
    	public void actionPerformed(ActionEvent e){  

    		//populate a JList with all impossible solutions for the given total
    		ImpossibleSolver is = new ImpossibleSolver();
    		SolutionSolver.total = Float.valueOf(totNum.getText());  		
    		is.al = is.impossibleSolver();	
			JList list = new JList(is.al.toArray());
    		
    		//display panel with the list of impossible combinations
     	    JPanel panel = new JPanel();
     	    panel.add(new JScrollPane(list));
     	    JLabel jlabel = new JLabel(String.valueOf(is.al.size()) + " unique unique impossible solutions for: " + SolutionSolver.total);
	        panel.add(jlabel);
	    	JOptionPane.showMessageDialog(null, panel, "Impossible Solutions", JOptionPane.PLAIN_MESSAGE );		
    		
        }  
    });  
    f.add(impossibleSolutionsButton);    
 
    f.setSize(405,450);  
    f.setLayout(null);  
    f.setVisible(true);   
}  
}  