import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class solutionToStringTest {

	@Test
	//test solutionToString method
	void solutionToStringTest() {
		StringMethods sm = new StringMethods();
		Assertions.assertEquals(sm.solutionToString("1", "2", "3", "4", 0, 1, 2), "1 + 2 - 3 × 4");
		Assertions.assertEquals(sm.solutionToString("1", "2", "3", "4", 1, 2, 3), "1 - 2 × 3 ÷ 4");
	}

}
