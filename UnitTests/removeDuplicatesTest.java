import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class removeDuplicatesTest {

	@Test
	//test removeDuplicates method
	void removeDuplicatesTestCase() {
		
		ArrayList<String> al = new ArrayList<String>();
		ArrayList<String> al2  = new ArrayList<String>();
		al.add("one");
		al.add("one");
		al.add("two");
		al.add("two");
		
		al2.add("one");
		al2.add("two");
		
		al = SolutionList.removeDuplicates(al);
		
		Assertions.assertEquals(al, al2);
	}

}
