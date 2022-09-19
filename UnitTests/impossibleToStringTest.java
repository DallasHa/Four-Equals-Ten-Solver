import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class impossibleToStringTest {

	@Test
	//test method impossibleToString
    public void shouldConvertFloatArrayToString() {
		float[] f = {1,2,3,4};
		StringMethods sm = new StringMethods();
        Assertions.assertEquals(sm.impossibleToString(f), "1 2 3 4");
    }
	
}
