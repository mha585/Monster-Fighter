
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BattlesTest {
	private Team testTeam;
	private Battles testBattle;
	private Player testPlayer;
	private Monster testEnemy;
	
	private ByteArrayOutputStream outputStreamContent = new ByteArrayOutputStream();
	private InputStream savedStandardInputStream = System.in;
	private PrintStream savedStandardOut = System.out;

	
	@BeforeEach
	public void init() {
		testTeam = new Team();
		testBattle = new Battles();
		testPlayer = new Player();
		testPlayer.setDay(6);
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
	public void attackTest() {
		testTeam.addFriend(new FireMonster("Fire test", 50.0, 5.0, 5.425, 20.0, 1, 150, 250, "fire"));
		testTeam.addFriend(new GrassMonster("Grass test", 100.0, 5.0, 20.0, 25.0, 1, 150, 250, "grass"));
		testTeam.addFriend(new FireMonster());
		testTeam.addFriend(new MedicalMonster());
		testEnemy = new GlassMonster("Glass test", 50.0, 5.0, 24.75, 21.0, 1, 150, 250, "glass");
		
		testBattle.attack(testTeam.getFriend(0), testEnemy, testTeam, true);
		assertEquals(testTeam.getFriend(0).getHealth(), 0.5);
		assertEquals(testEnemy.getHealth(), 39.15);
		testBattle.attack(testTeam.getFriend(0), testEnemy, testTeam, true);
		assertEquals(testTeam.getFriend(3).getHealth(), 0);
		assertEquals(testEnemy.getHealth(), 39.15);
		testBattle.attack(testTeam.getFriend(0), testEnemy, testTeam, false);
		assertEquals(testTeam.getFriend(0).getHealth(), 50.5);
		assertEquals(testEnemy.getHealth(), 39.15);
		testBattle.attack(testTeam.getFriend(0), testEnemy, testTeam, true);
		assertEquals(testTeam.getFriend(0).getHealth(), 50.5);
		assertEquals(testEnemy.getHealth(), 0);
	}
	
	@Test
	public void holyDemonTest() {
		testTeam.addFriend(new HolyMonster("Holy test", 100.0, 5.0, 5, 20.0, 1, 150, 250, "holy"));
		testTeam.addFriend(new DemonMonster());
		testTeam.addFriend(new HolyMonster());
		testEnemy = new DemonMonster("demon test", 50.0, 5.0, 10, 19.0, 1, 150, 250, "demon");
		testBattle.attack(testTeam.getFriend(0), testEnemy, testTeam, true);
		assertEquals(testTeam.getFriend(0).getHealth(), 80);
		assertEquals(testEnemy.getHealth(), 40);
		testBattle.attack(testTeam.getFriend(0), testEnemy, testTeam, false);
		assertEquals(testTeam.getFriend(0).getHealth(), 60);
		assertEquals(testEnemy.getHealth(), 40);
		testBattle.attack(testEnemy, testTeam.getFriend(0), testTeam, false);
		testBattle.attack(testEnemy, testTeam.getFriend(0), testTeam, false);
		testBattle.attack(testEnemy, testTeam.getFriend(0), testTeam, false);
		testBattle.attack(testTeam.getFriend(0), testEnemy, testTeam, true);
		assertEquals(testTeam.getFriend(0).getHealth(), 60);
		assertEquals(testEnemy.getHealth(), 0);
	}
	
	@Test
	public void healTest() {
		InputStream savedStandardInputStream = System.in;
		testTeam.addFriend(new MedicalMonster("medical test", 50.0, 5.0, 10, 19.0, 1, 150, 250, ""));
		testTeam.addFriend(new GrassMonster());
		testTeam.addFriend(new WaterMonster("Water test", 100.0, 5.0, 5, 20.0, 1, 150, 250, ""));
		testTeam.addFriend(new WaterMonster());
		testEnemy = new MedicalMonster("medical test", 50.0, 5.0, 10, 19.0, 1, 150, 250, "");

	    String input = "1";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
		testBattle.attack(testTeam.getFriend(0), testEnemy, testTeam, false);
	    testBattle.heal(testTeam.getFriend(0), testEnemy, testTeam);
	    assertEquals(testTeam.getFriend(0).getHealth(), 35);
	    
		System.setIn(savedStandardInputStream);
	    String input2 = "-1";
	    InputStream in2 = new ByteArrayInputStream(input2.getBytes());
	    System.setIn(in2);
	    testBattle.heal(testTeam.getFriend(0), testEnemy, testTeam);
	    assertEquals(testTeam.getFriend(0).getHealth(), 35);
	}
	
	@Test
	public void swapTest() {
	    System.setOut(savedStandardOut);

		testTeam.addFriend(new MedicalMonster("medical test", 50.0, 5.0, 10, 19.0, 1, 150, 250, ""));
		testTeam.addFriend(new GrassMonster());
		testTeam.addFriend(new WaterMonster("Water test", 100.0, 5.0, 5, 20.0, 1, 150, 250, ""));
		testTeam.addFriend(new WaterMonster());
		testEnemy = new MedicalMonster("medical test", 50.0, 5.0, 10, 19.0, 1, 150, 250, "");
		
//		test for switching 1 with 3
		String simulatedUserInput1 = "1" + System.getProperty("line.separator")
		+ "3" + System.getProperty("line.separator");
		System.setIn(new ByteArrayInputStream(simulatedUserInput1.getBytes()));
	    testBattle.swap(testEnemy, testTeam);
	    assertEquals(testTeam.getFriend(0).getName(), "Water test");
		
//		test for switching 1 with 1
		String simulatedUserInput2 = "1" + System.getProperty("line.separator")
		+ "1" + System.getProperty("line.separator");
		System.setIn(new ByteArrayInputStream(simulatedUserInput2.getBytes()));
	    testBattle.swap(testEnemy, testTeam);
	    assertEquals(testTeam.getFriend(0).getName(), "Water test");
	    
//		test for switching invalid string with 1
		String simulatedUserInput3 = "0" + System.getProperty("line.separator")
		+ "1" + System.getProperty("line.separator") + "3";
		System.setIn(new ByteArrayInputStream(simulatedUserInput3.getBytes()));
		testBattle.swap(testEnemy, testTeam);
	    assertEquals(testTeam.getFriend(0).getName(), "medical test");

//		test for switching 1 with invalid integer
		String simulatedUserInput4 = "1" + System.getProperty("line.separator")
		+ "-100" + System.getProperty("line.separator") + "3" + System.getProperty("line.separator") + 1;
		System.setIn(new ByteArrayInputStream(simulatedUserInput4.getBytes()));
		testBattle.swap(testEnemy, testTeam);
	    assertEquals(testTeam.getFriend(0).getName(), "Water test");
	}
	
	@Test
	public void itemTest() {
		testTeam.addFriend(new WaterMonster("Water test", 100.0, 5.0, 5, 20.0, 1, 150, 250, ""));
		testTeam.addFriend(new RandomMonster(testPlayer));
		testTeam.addFriend(new RandomMonster("random test", 50.0, 5.0, 10, 19.0, 1, 150, 250, ""));
		testTeam.addFriend(new GlassMonster());
		testEnemy = new MedicalMonster("medical test", 50.0, 5.0, 10, 19.0, 1, 150, 250, "");
		testPlayer.playerBag.addtoBag(new TierPlus(), 1);
		testPlayer.playerBag.addtoBag(new BasicHeal(), 2);
		
//		test the first item
		String simulatedUserInput = "1" + System.getProperty("line.separator")
		+ "1" + System.getProperty("line.separator");
		
		System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
		testBattle.useItem(testTeam, testEnemy, testPlayer.playerBag);
	    assertEquals(testTeam.getFriend(0).getTier(), 2);
	    
//		test the second item is now in the first slot
		System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
		testBattle.useItem(testTeam, testEnemy, testPlayer.playerBag);
	    assertEquals(testTeam.getFriend(0).getHealth(), (testTeam.getFriend(0).getMaxHealth() - 5));

	}
	
	@Test
	public void noItemsTest() {
		String finalLineToCheck = "You have no items left to use";
		testBattle.useItem(testTeam, testEnemy, testPlayer.playerBag);
		int indexOfStartOfLineToCheck = (outputStreamContent.toString().length() - (finalLineToCheck.length() + 2));
		int indexOfEndOfLineToCheck = (outputStreamContent.toString().length() - 2);
		assertEquals(finalLineToCheck, outputStreamContent.toString().substring(indexOfStartOfLineToCheck, indexOfEndOfLineToCheck));
	}
	
	@Test
	public void useInvalidItem() {
		String finalLineToCheck = "Sorry that item wasnt recognised";
		testTeam.addFriend(new RandomMonster("random test", 50.0, 5.0, 10, 19.0, 1, 150, 250, ""));
		testEnemy = new MedicalMonster("medical test", 50.0, 5.0, 10, 19.0, 1, 150, 250, "");
		testPlayer.playerBag.addtoBag(new TierPlus(), 1);
		testPlayer.playerBag.addtoBag(new BasicHeal(), 1);
			    
		String simulatedUserInput = "99" + System.getProperty("line.separator") + "3";
		System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
		testBattle.useItem(testTeam, testEnemy, testPlayer.playerBag);
		int indexOfStartOfLineToCheck = (outputStreamContent.toString().length() - (finalLineToCheck.length() + 2));
		int indexOfEndOfLineToCheck = (outputStreamContent.toString().length() - 2);
		assertEquals(finalLineToCheck, outputStreamContent.toString().substring(indexOfStartOfLineToCheck, indexOfEndOfLineToCheck));
	}
	
	@Test
	public void useItemOnInvalidMonster() {
		String finalLineToCheck = "Sorry that monster wasnt recognised";
		testTeam.addFriend(new RandomMonster("random test", 50.0, 5.0, 10, 19.0, 1, 150, 250, ""));
		testEnemy = new MedicalMonster("medical test", 50.0, 5.0, 10, 19.0, 1, 150, 250, "");
		testPlayer.playerBag.addtoBag(new TierPlus(), 1);
		testPlayer.playerBag.addtoBag(new BasicHeal(), 1);
			    
		String simulatedUserInput = "1" + System.getProperty("line.separator") + "-7";
		System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
		testBattle.useItem(testTeam, testEnemy, testPlayer.playerBag);
		int indexOfStartOfLineToCheck = (outputStreamContent.toString().length() - (finalLineToCheck.length() + 2));
		int indexOfEndOfLineToCheck = (outputStreamContent.toString().length() - 2);
		assertEquals(finalLineToCheck, outputStreamContent.toString().substring(indexOfStartOfLineToCheck, indexOfEndOfLineToCheck));
	}
	
	@Test
	public void inputFightInFightTest() {
		testTeam.addFriend(new WaterMonster("water test", 50.0, 5.0, 40, 20.0, 1, 150, 250, ""));
		testEnemy = new GlassMonster("glass test", 50.0, 5.0, 10, 19.0, 1, 150, 250, "");

		String simulatedUserInput = "fight" + System.getProperty("line.separator");
		System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
		
		testBattle.fight(testTeam, testEnemy, testPlayer.playerBag);
		assertEquals(testEnemy.getHealth(), 0);
	}
	
	@Test
	public void invalidInputInFightTest() {

		String finalLineToCheck = "Sorry your command wasn't understood";
		testTeam.addFriend(new WaterMonster("water test", 50.0, 5.0, 40, 20.0, 1, 150, 250, ""));
		testEnemy = new GlassMonster("glass test", 50.0, 5.0, 10, 19.0, 1, 150, 250, "");

//		First tests invalid input then tests fight as fight is proven to work per the above test
//		this is to avoid being caught in a loop
		String simulatedUserInput = "sdfsd" + System.getProperty("line.separator") + "fight";
		System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
		
		testBattle.fight(testTeam, testEnemy, testPlayer.playerBag);
		int indexOfStartOfLineToCheck = (outputStreamContent.toString().length() - (finalLineToCheck.length() + 349));
		int indexOfEndOfLineToCheck = (outputStreamContent.toString().length() - 349);    
	    if ((outputStreamContent.toString().length()) == 882) {
	    	assertEquals(finalLineToCheck, outputStreamContent.toString().substring(indexOfStartOfLineToCheck + 1, indexOfEndOfLineToCheck + 1));
	    } else {
	    	assertEquals(finalLineToCheck, outputStreamContent.toString().substring(indexOfStartOfLineToCheck, indexOfEndOfLineToCheck));
	    }	
	}
	
	@Test
	public void inputSwitchInFightTest() {
//	    System.setOut(savedStandardOut);

		testTeam.addFriend(new WaterMonster("water test1", 50.0, 5.0, 40, 20.0, 1, 150, 250, ""));
		testTeam.addFriend(new WaterMonster("water test2", 50.0, 5.0, 40, 20.0, 1, 150, 250, ""));
		testEnemy = new GlassMonster("glass test", 50.0, 5.0, 10, 19.0, 1, 150, 250, "");

		String simulatedUserInput = "switch" + "1" 
		+ System.getProperty("line.separator") + "2\n"
		+ "fight";
		System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
		System.out.print(simulatedUserInput);
		testBattle.fight(testTeam, testEnemy, testPlayer.playerBag);
		assertEquals(testEnemy.getHealth(), 0);
	}
}
