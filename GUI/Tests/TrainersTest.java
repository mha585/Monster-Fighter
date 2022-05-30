import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrainersTest {

	private Player testPlayer;
	private RandomGen num;
	
	private ByteArrayOutputStream outputStreamContent = new ByteArrayOutputStream();
	private InputStream savedStandardInputStream = System.in;
	private PrintStream savedStandardOut = System.out;

	
	@BeforeEach
	public void init() {
		testPlayer = new Player();
		num = new RandomGen();
		
	    System.setOut(new PrintStream(outputStreamContent));
    }
	
	@AfterEach
	public void tearDown() {
	    System.setIn(savedStandardInputStream);
	    System.setOut(savedStandardOut);
	}
	
	@Test
	public void trainerAlwaysHasOneMonsterInitialyTest() {
		testPlayer.setDay(4);
		for (int i = 0; i < testPlayer.getPlayerDay(); i++) {
			testPlayer.addDay();
		}
		
	    for (int i = 0; i < 20; i++) {
	    	Trainers newTrainer = new Trainers(testPlayer, num);
		    if (newTrainer.getSize() != 1) {
		    	fail("incorrect enemy team size");
		    }
	    }
	}
	
	@Test
	public void canAddAMonsterToTheTrainerTest() {
		Trainers newTrainer = new Trainers(testPlayer, num);
		newTrainer.addMonster(new RandomMonster(testPlayer, num));
		assertEquals(2, newTrainer.getSize());
	}
	
	@Test
	public void firstMonsterRemainsTheSameAfterAddingMonsterTest() {
		Trainers newTrainer = new Trainers(testPlayer, num);
		Monster originalMonster = newTrainer.getFirstEnemy();
		newTrainer.addMonster(new RandomMonster(testPlayer, num));
		assertEquals(originalMonster, newTrainer.getEnemies().get(0));
	}
	
	@Test
	public void removeEnemyTest() {
		Trainers newTrainer = new Trainers(testPlayer, num);
		newTrainer.addMonster(new RandomMonster(testPlayer, num));
		newTrainer.removeEnemy();
		assertEquals(1, newTrainer.getSize());
	}
	
	@Test
	public void emptyConstructorTest() {
		Trainers emptyTrainer = new Trainers();
		assertEquals(0, emptyTrainer.getSize());
	}

}
