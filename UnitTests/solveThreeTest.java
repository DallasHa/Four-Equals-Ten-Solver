import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class solveThreeTest {

	@Test
	//test solveThree method
	void testSolveThree() {
		ArithmeticSolvers as = new ArithmeticSolvers();
		float a = 2;
		float b = 3;
		float c  = 4;
		
		//test addition and subtraction
		Assertions.assertEquals(as.solveThree(a, b, c, 0, 1), 1);
		
		//test subtraction and multiplication
		Assertions.assertEquals(as.solveThree(a, b, c, 1, 2), -10);
		
		//test multiplication and division
		Assertions.assertEquals(as.solveThree(a, b, c, 2, 3), 1.5);
		
		//test division and addition
		Assertions.assertEquals(as.solveThree(b, a, c, 3, 0), 5.5);

	}

}
