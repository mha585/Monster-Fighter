
import java.security.SecureRandom;

public final class RandomGen {
	/**
	* The provided seed
	*/
	private String mySeed;
	/**
	* java.util.SecureRandom used to generate secure random numbers 
	*/
    private SecureRandom numGen;
    /**
    * Constructs the random number when no key is provided
    */
	RandomGen() {
		numGen = new SecureRandom();
	}
    /**
    * Constructs the random number when a key is provided
    */
	RandomGen(String seed) {
		mySeed = seed;
		numGen = new SecureRandom(mySeed.getBytes());
	}

	/**
	 * Generates a random number in a range
	 * @param min		The minimum value the number can be
	 * @param max		The maximum value the number can be
	 * @return int		a randomly generated number in a given range
	 */
	public int randNumInRange(int min, int max){
    	int offset = max - min;
    	int randomInt = numGen.nextInt(offset);
    	int includeMin = randomInt + min;
	    return includeMin;
	}
}