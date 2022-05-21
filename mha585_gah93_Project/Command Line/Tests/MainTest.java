import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//As every method in main is static need to be careful with the tests
//e.g if the first test sets the player name to be "test" then the playername will be "test" for all future tests in this file
//Although you can manually change the name (or any other static variable) for the duration of a test it will reset to the first value once that specific test is over
class MainTest {

	private Team testTeam;
	private Player testPlayer;
	private Monster testEnemy;
	private Shop testShop;
	
	private ByteArrayOutputStream outputStreamContent = new ByteArrayOutputStream();
	private InputStream savedStandardInputStream = System.in;
	private PrintStream savedStandardOut = System.out;

	@BeforeEach
	public void init() {
		testTeam = new Team();
		testPlayer = new Player();
		testShop = new Shop();
		testPlayer.setDay(1);
//		testPlayer.setDifficulty(1);
		testPlayer.setName("tester");
	    System.setOut(new PrintStream(outputStreamContent));
    }
	
	@AfterEach
	public void tearDown() {
	    System.setIn(savedStandardInputStream);
	    System.setOut(savedStandardOut);
	}
	
	@Test
	public void setPlayerNameTest() {	    
	    String input = "tester";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		Scanner userInputs = new Scanner(System.in);
		MAIN.setPlayerName(userInputs, testPlayer);
		assertEquals("tester", testPlayer.getPlayerName());
	    userInputs.close();
	}
	
	@Test
	public void invalidPlayerNameTest() {
		String finalLineToCheck = "Invalid input";
	    String input = "72\n" + "\n\r\n\n" + "     hi\n" + "!!~@#%><}\n" + "finalName";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		Scanner userInputs = new Scanner(System.in);
		MAIN.setPlayerName(userInputs, testPlayer);
		int indexOfStartOfLineToCheck = (outputStreamContent.toString().length() - (finalLineToCheck.length() + 116));
		int indexOfEndOfLineToCheck = (outputStreamContent.toString().length() - 116);		
		assertEquals(finalLineToCheck, outputStreamContent.toString().substring(indexOfStartOfLineToCheck, indexOfEndOfLineToCheck));		
		assertEquals("finalName", testPlayer.getPlayerName());
	    userInputs.close();
	}
	
	@Test
	public void setPlayerDaysTest() {	 
	    String input = "5";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		Scanner userInputs = new Scanner(System.in);
		MAIN.setDays(userInputs, testPlayer);
		assertEquals(5, testPlayer.getPlayerDayCompleted());
	    userInputs.close();
	}
	
	@Test
	public void invalidPlayerDaysTest() {
		String finalLineToCheck = "Input must be a number from 5 - 15";
	    String input = "4\n" + "16\n" + "-2\n" + "!!~@#%><}\n" + "test\n" + "15";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		Scanner userInputs = new Scanner(System.in);
		MAIN.setDays(userInputs, testPlayer);

		int indexOfStartOfLineToCheck = (outputStreamContent.toString().length() - (finalLineToCheck.length() + 85));
		int indexOfEndOfLineToCheck = (outputStreamContent.toString().length() - 85);
		assertEquals(finalLineToCheck, outputStreamContent.toString().substring(indexOfStartOfLineToCheck, indexOfEndOfLineToCheck));		
	    userInputs.close();
	}
	
	@Test
	public void setPlayerDifficultyTest() {	    
	    String input = "2";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		Scanner userInputs = new Scanner(System.in);
		MAIN.setDifficulty(userInputs, testPlayer);
		assertEquals("normal", testPlayer.getDifficulty());
	    userInputs.close();
	}
	
	@Test
	public void invalidPlayerDifficultyTest() {
		String finalLineToCheck = "Input must be a number from 1 - 3";
	    String input = "0\n" + "-29\n" + "eek\n" + "4\n" + "3";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		Scanner userInputs = new Scanner(System.in);
		MAIN.setDifficulty(userInputs, testPlayer);
		int indexOfStartOfLineToCheck = (outputStreamContent.toString().length() - (finalLineToCheck.length() + 133));
		int indexOfEndOfLineToCheck = (outputStreamContent.toString().length() - 133);
		assertEquals(finalLineToCheck, outputStreamContent.toString().substring(indexOfStartOfLineToCheck, indexOfEndOfLineToCheck));		
		assertEquals("hard", testPlayer.getDifficulty());
	    userInputs.close();
	}
}
