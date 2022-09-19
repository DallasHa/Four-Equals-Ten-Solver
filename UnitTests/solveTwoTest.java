import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class solveTwoTest {

	@Test
	//test solveTwo method
	void testSolveTwo() {
		ArithmeticSolvers as = new ArithmeticSolvers();
		float a = 2;
		float b = 3;
		
		//test addition
		Assertions.assertEquals(as.solveTwo(a, b, 0), 5);
		
		//test subtraction
		Assertions.assertEquals(as.solveTwo(a, b, 1), -1);
		
		//test multiplication
		Assertions.assertEquals(as.solveTwo(a, b, 2), 6);
		
		//test division
		Assertions.assertEquals(as.solveTwo(b, a, 3), 1.5);
	}


}
