
 class ArithmeticSolvers {

	//function which solves the total for two numbers and an operator in an arithmetic expression
		public float solveTwo(float a1, float a2, int b) {
			// a1, a2 represent the two numbers in the arithmetic term being solved
			// b1 represents the arithmetic operator (0 = +, 1 = -, 2 = *, 3 = /)
			
			if(b == 0) {
				return a1 + a2;
			}else if (b == 1) {
				return a1 - a2;
			}else if (b == 2) {
				return a1 * a2;
			}else {
				return a1 / a2;
			}
			
		}
		
		//function which solves the total for three numbers and two operators in an arithmetic expression
		public float solveThree(float a1, float a2, float a3, int b1, int b2) {
			// a1, a2 and a3 represent the three numbers in the arithmetic term being solved
			// b1 and b2 represent the arithmetic operator (0 = +, 1 = -, 2 = *, 3 = /)
			
			float total = 0;
			
			//solve if the first arithmetic sign is either division or multiplication 
			if((b1 == 2) || (b1 == 3)) {
				
				if (b1 == 2) {
					total = a1 * a2;
				}else {
					total = a1 / a2;
				}
			
				return solveTwo(total, a3, b2);
				
			}else {
				//solve if the second arithmetic sign is either division or multiplication
				if((b2 == 2) || (b2 == 3)) {
					if(b2 == 2) {
						total = a2 * a3;
					}else {
						total = a2 / a3;
					}
					return solveTwo(a1, total, b1);
				}else {
					//solve if neither sign is multiplication or division
					total = solveTwo(a1, a2, b1);
					return solveTwo(total, a3, b2);
				}		
		
			}
		}
	
}
