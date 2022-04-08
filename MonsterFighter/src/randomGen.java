import java.util.Random;

public class randomGen {
    public static Random numGen = new Random();
	/**
	 * Generates a random number in a range
	 * @param min		The minimum value the number can be
	 * @param max		The maximum value the number can be
	 */
	public int randNumInRange(int min, int max){
	    int rand = Math.abs((min)+numGen.nextInt(max));
	    return rand;
	}
}
