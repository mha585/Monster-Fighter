import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrainersTest {

	private Player testPlayer;
	
	private ByteArrayOutputStream outputStreamContent = new ByteArrayOutputStream();
	private InputStream savedStandardInputStream = System.in;
	private PrintStream savedStandardOut = System.out;

	
	@BeforeEach
	public void init() {
		testPlayer = new Player();
		testPlayer.setDay(1);
		testPlayer.setDifficulty(1);
		testPlayer.setName("tester");
		
	    System.setOut(new PrintStream(outputStreamContent));
    }
	
	@AfterEach
	public void tearDown() {
	    System.setIn(savedStandardInputStream);
	    System.setOut(savedStandardOut);
	}
	
	@Test
	public void dayOneTrainerTest() {
	    Trainers newTrainer = new Trainers(testPlayer);
	    assertEquals(1, (newTrainer.getSize()));
	}
	
	@Test
	public void dayTwoToThreeTrainerTest() {
		testPlayer.setDay(2);
		testPlayer.addDay();
	    
	    for (int i = 0; i < 10; i++) {
	    	Trainers newTrainer = new Trainers(testPlayer);
		    if (newTrainer.getSize() != 2 && newTrainer.getSize() != 1) {
		    	fail("incorrect enemy team size");
		    }
	    }
	}
	
	@Test
	public void dayFourToFiveTrainerTest() {
		testPlayer.setDay(4);
		for (int i = 0; i < testPlayer.getPlayerDayCompleted(); i++) {
			testPlayer.addDay();
		}
		
	    for (int i = 0; i < 10; i++) {
	    	Trainers newTrainer = new Trainers(testPlayer);
		    if (newTrainer.getSize() > 3 && newTrainer.getSize() <= 1) {
		    	fail("incorrect enemy team size");
		    }
	    }
	}
	
	@Test
	public void daySixOnwardsTrainerTest() {
		testPlayer.setDay(6);
		for (int i = 0; i < testPlayer.getPlayerDayCompleted(); i++) {
			testPlayer.addDay();
		}
		
	    for (int i = 0; i < 10; i++) {
	    	Trainers newTrainer = new Trainers(testPlayer);
		    if (newTrainer.getSize() > 4 && newTrainer.getSize() <= 1) {
		    	fail("incorrect enemy team size");
		    }
	    }
	}

}
