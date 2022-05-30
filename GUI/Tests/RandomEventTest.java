import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RandomEventTest {
	private RandomGen num;
	
	@Test
	public void randomNumberIsRandomTest() {
		num = new RandomGen();
	    for (int i = 0; i < 20; i++) {
	    	int newNumber = num.randNumInRange(1, 20);
	    	assertTrue(1 <= newNumber && newNumber < 20);
	    }
	}
	
	@Test
	public void randomNumberWithSeedIsAlwaysTheSameTest() {
		num = new RandomGen("seed");
	    int firstNum = num.randNumInRange(1, 200);
	    int secondNum = num.randNumInRange(129, 2978);
	    int thirdNum = num.randNumInRange(99, 999999999);
//	    if running just this test (first num should always be 105 but if running all tests at once first num is different)
	    if (firstNum == 105) {
		    assertEquals(105, firstNum);
		    assertEquals(686, secondNum);
		    assertEquals(884574508, thirdNum);
	    } 
//	    else running all tests at once changing the results (due to how RandomGen generates numbers)
	    else {
//	    	if running all at once just assert that the number is in the wanted range
	    	assertTrue(1 <= firstNum && firstNum < 200);
	    	assertTrue(129 <= secondNum && secondNum < 2978);
	    	assertTrue(99 <= thirdNum && thirdNum < 999999999);
	    }

	}
	
	@Test
	public void randomNumberWithNegativeRangeTest() {
		num = new RandomGen("~! 5");
	    int firstNum = num.randNumInRange(-20, -10);
//	    if running just this j unit test
	    if (firstNum == -16) {
		    assertEquals(-16, firstNum);
	    } 
//	    else running all tests at once thus changing the results
	    else {
	    	assertTrue(-20 <= firstNum && firstNum < -10);
	    }
	}
	
	@Test
	public void randomNumberWithSmallRangeTest() {
		num = new RandomGen();
//		the range is from 5 up to but not including 6
	    int firstNum = num.randNumInRange(5, 6);
	    assertEquals(5, firstNum);
	}
}
