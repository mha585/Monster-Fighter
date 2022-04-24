
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

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
		testTeam.addFriend(new MedicalMonster("medical test", 50.0, 5.0, 10, 19.0, 1, 150, 250, ""));
		testTeam.addFriend(new GrassMonster());
		testTeam.addFriend(new WaterMonster("Water test", 100.0, 5.0, 5, 20.0, 1, 150, 250, ""));
		testTeam.addFriend(new WaterMonster());
		testEnemy = new MedicalMonster("medical test", 50.0, 5.0, 10, 19.0, 1, 150, 250, "");

	    String input = "1";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		Scanner userInputs = new Scanner(System.in);
		testBattle.attack(testTeam.getFriend(0), testEnemy, testTeam, false);
	    testBattle.heal(testTeam.getFriend(0), testEnemy, testTeam, userInputs);
	    assertEquals(testTeam.getFriend(0).getHealth(), 35);
	}
	
	@Test
	public void invalidHealTest() {
		testTeam.addFriend(new MedicalMonster("medical test", 20.0, 5.0, 10, 19.0, 1, 150, 250, ""));
		testEnemy = new FireMonster("fire test", 50.0, 5.0, 39, 10, 1, 150, 250, "");
		
	    String input = "-1";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		Scanner userInputs = new Scanner(System.in);
		testBattle.attack(testTeam.getFriend(0), testEnemy, testTeam, false);
	    testBattle.heal(testTeam.getFriend(0), testEnemy, testTeam, userInputs);

	    assertEquals(testTeam.getFriend(0).getHealth(), 0.5);
	    userInputs.close();
	}
	
	@Test
	public void cantHealPastMax() {
		testTeam.addFriend(new MedicalMonster("medical test", 20.0, 99999999, 10, 19.0, 1, 150, 250, ""));
		testEnemy = new FireMonster("fire test", 50.0, 5.0, 0, 10, 1, 150, 250, "");
	    String input = "1";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		Scanner userInputs = new Scanner(System.in);
	    testBattle.heal(testTeam.getFriend(0), testEnemy, testTeam, userInputs);
	    assertEquals(testTeam.getFriend(0).getHealth(), 20);
	    userInputs.close();
	}
	
	@Test
	public void cantHealADeadMonster() {
		testTeam.addFriend(new MedicalMonster("medical test", 20.0, 99999999, 10, 19.0, 1, 150, 250, ""));
		testTeam.addFriend(new MedicalMonster("dead test", 0, 5.0, 10, 19.0, 1, 150, 250, ""));
		testEnemy = new FireMonster("fire test", 50.0, 0, 0, 10, 1, 150, 250, "");
	    
		String input = "2";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		Scanner userInputs = new Scanner(System.in);
		testBattle.attack(testTeam.getFriend(0), testEnemy, testTeam, false);
	    testBattle.heal(testTeam.getFriend(0), testEnemy, testTeam, userInputs);
	    assertEquals(testTeam.getFriend(1).getHealth(), 0);
	    userInputs.close();
	}

	@Test
	public void swapTest() {
		testTeam.addFriend(new MedicalMonster("medical test", 50.0, 5.0, 10, 19.0, 1, 150, 250, ""));
		testTeam.addFriend(new GrassMonster());
		testTeam.addFriend(new WaterMonster("Water test", 100.0, 5.0, 5, 20.0, 1, 150, 250, ""));
		testTeam.addFriend(new WaterMonster());
		testEnemy = new MedicalMonster("medical test", 50.0, 5.0, 10, 19.0, 1, 150, 250, "");
		
//		test for switching 1 with 3
		String input = "1\n" + "3";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		Scanner userInputs = new Scanner(System.in);
	    testBattle.swap(testEnemy, testTeam, userInputs);
	    System.out.println(testTeam);

	    assertEquals(testTeam.getFriend(0).getName(), "Water test");
		
//		test for switching back again
	    input = "3\n" + "1\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		userInputs = new Scanner(System.in);
	    testBattle.swap(testEnemy, testTeam, userInputs);
	    assertEquals(testTeam.getFriend(0).getName(), "medical test");
	    userInputs.close();
	}
	
	@Test
	public void invalidSwapTest() {
		testTeam.addFriend(new MedicalMonster("invalid swap test1", 50.0, 5.0, 10, 19.0, 1, 150, 250, ""));
		testTeam.addFriend(new MedicalMonster("invalid swap test2", 50.0, 5.0, 10, 19.0, 1, 150, 250, ""));
		testEnemy = new MedicalMonster("medical test", 50.0, 5.0, 10, 19.0, 1, 150, 250, "");
		
//		test for switching invalid string then still can switch 1 with 2
	    String input = "-70000*999999999999999*999999999\n" + "aaaaaa\n" + "2\n" + "1";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		Scanner userInputs = new Scanner(System.in);
	    testBattle.swap(testEnemy, testTeam, userInputs);
	    assertEquals(testTeam.getFriend(0).getName(), "invalid swap test2");
	    
//		test for switching 1 with invalid integer then can still switch 2
	    input = "1\n" + "99\n" + "bdcsdhf\n" + "1\n" + "2";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		userInputs = new Scanner(System.in);
	    testBattle.swap(testEnemy, testTeam, userInputs);
	    assertEquals(testTeam.getFriend(0).getName(), "invalid swap test1");
	    userInputs.close();
	}
	
	@Test
	public void swapWithDeadMonsterTest() {
		testTeam.addFriend(new MedicalMonster("alive1", 50.0, 5.0, 10, 19.0, 1, 150, 250, ""));
		testTeam.addFriend(new MedicalMonster("alive2", 50.0, 5.0, 10, 19.0, 1, 150, 250, ""));
		testTeam.addFriend(new MedicalMonster("dead", 0, 5.0, 10, 19.0, 1, 150, 250, ""));
		testEnemy = new MedicalMonster("medical test", 50.0, 5.0, 10, 19.0, 1, 150, 250, "");
		
//		test for switching 1 with 3 (dead)
		String input = "1\n" + "3\n" + "try again\n" + "1\n1";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		Scanner userInputs = new Scanner(System.in);
	    testBattle.swap(testEnemy, testTeam, userInputs);
	    assertEquals(testTeam.getFriend(0).getName(), "alive1");
	    userInputs.close();
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
		String input = "1\n" + "1";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		Scanner userInputs = new Scanner(System.in);
		testBattle.useItem(testTeam, testEnemy, testPlayer.playerBag, userInputs);
	    assertEquals(testTeam.getFriend(0).getTier(), 2);
		
	    
//		test the second item is now in the first slot
		input = "1\n" + "1";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		userInputs = new Scanner(System.in);
		testBattle.useItem(testTeam, testEnemy, testPlayer.playerBag, userInputs);
	    assertEquals(testTeam.getFriend(0).getHealth(), (testTeam.getFriend(0).getMaxHealth() - 5));
	    userInputs.close();
	}
	
	@Test
	public void noItemsTest() {
		String finalLineToCheck = "You have no items left to use";
		Scanner userInputs = new Scanner(System.in);
		testBattle.useItem(testTeam, testEnemy, testPlayer.playerBag, userInputs);
		int indexOfStartOfLineToCheck = (outputStreamContent.toString().length() - (finalLineToCheck.length() + 2));
		int indexOfEndOfLineToCheck = (outputStreamContent.toString().length() - 2);
		assertEquals(finalLineToCheck, outputStreamContent.toString().substring(indexOfStartOfLineToCheck, indexOfEndOfLineToCheck));
	    userInputs.close();
	}
	
	@Test
	public void useInvalidItem() {
		String finalLineToCheck = "Sorry that item wasnt recognised";
		testTeam.addFriend(new RandomMonster("random test", 50.0, 5.0, 10, 19.0, 1, 150, 250, ""));
		testEnemy = new MedicalMonster("medical test", 50.0, 5.0, 10, 19.0, 1, 150, 250, "");
		testPlayer.playerBag.addtoBag(new TierPlus(), 1);
		testPlayer.playerBag.addtoBag(new BasicHeal(), 1);
			    
		String input = "99\n" + "3";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		Scanner userInputs = new Scanner(System.in);
		testBattle.useItem(testTeam, testEnemy, testPlayer.playerBag, userInputs);
		int indexOfStartOfLineToCheck = (outputStreamContent.toString().length() - (finalLineToCheck.length() + 2));
		int indexOfEndOfLineToCheck = (outputStreamContent.toString().length() - 2);
		assertEquals(finalLineToCheck, outputStreamContent.toString().substring(indexOfStartOfLineToCheck, indexOfEndOfLineToCheck));
	    userInputs.close();
	}
	
	@Test
	public void useItemOnInvalidMonster() {
		String finalLineToCheck = "Sorry that monster wasnt recognised";
		testTeam.addFriend(new RandomMonster("random test", 50.0, 5.0, 10, 19.0, 1, 150, 250, ""));
		testEnemy = new MedicalMonster("medical test", 50.0, 5.0, 10, 19.0, 1, 150, 250, "");
		testPlayer.playerBag.addtoBag(new TierPlus(), 1);
		testPlayer.playerBag.addtoBag(new BasicHeal(), 1);
			    
		String input = "1\n" + "-7";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		Scanner userInputs = new Scanner(System.in);
		testBattle.useItem(testTeam, testEnemy, testPlayer.playerBag, userInputs);
		int indexOfStartOfLineToCheck = (outputStreamContent.toString().length() - (finalLineToCheck.length() + 2));
		int indexOfEndOfLineToCheck = (outputStreamContent.toString().length() - 2);
		assertEquals(finalLineToCheck, outputStreamContent.toString().substring(indexOfStartOfLineToCheck, indexOfEndOfLineToCheck));
	    userInputs.close();
	}
	
	@Test
	public void inputFightInFightTest() {
		testTeam.addFriend(new WaterMonster("water test", 50.0, 5.0, 40, 20.0, 1, 150, 250, ""));
		testEnemy = new GlassMonster("glass test", 50.0, 5.0, 10, 19.0, 1, 150, 250, "");

		String input = "fight";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		Scanner userInputs = new Scanner(System.in);
		
		testBattle.fight(testTeam, testEnemy, testPlayer.playerBag, userInputs);
		assertEquals(testEnemy.getHealth(), 0);
	    userInputs.close();
	}
	
	@Test
	public void inputSwitchInFightTest() {
		testTeam.addFriend(new WaterMonster("water test1", 50.0, 5.0, 40, 20.0, 1, 150, 250, ""));
		testTeam.addFriend(new WaterMonster("water test2", 50.0, 5.0, 40, 20.0, 1, 150, 250, ""));
		testEnemy = new GlassMonster("glass test", 50.0, 5.0, 10, 19.0, 1, 150, 250, "");

		String simulatedUserInput = "switch\n1\n2\nfight";
		System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
		Scanner input = new Scanner(System.in);
		testBattle.fight(testTeam, testEnemy, testPlayer.playerBag, input);
		assertEquals(testTeam.getFriend(0).getName(), "water test2");
	}
	
	@Test
	public void inputHealInFightTest() {
		testTeam.addFriend(new WaterMonster("water test1", 50.0, 5.0, 40, 20.0, 1, 150, 250, ""));
		testTeam.addFriend(new WaterMonster("water test2", 50.0, 5.0, 40, 20.0, 1, 150, 250, ""));
		testEnemy = new GlassMonster("glass test", 50.0, 5.0, 10, 19.0, 1, 150, 250, "");

		String simulatedUserInput = "heal\n2\nfight";
		System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
		Scanner input = new Scanner(System.in);
		testBattle.fight(testTeam, testEnemy, testPlayer.playerBag, input);
		assertEquals(testTeam.getFriend(1).getHealth(), 50);
	}
	
	@Test
	public void inputItemsInFightTest() {
		testTeam.addFriend(new WaterMonster("water test1", 50.0, 5.0, 40, 20.0, 1, 150, 250, ""));
		testTeam.addFriend(new WaterMonster("water test2", 50.0, 5.0, 40, 20.0, 1, 150, 250, ""));
		testEnemy = new GlassMonster("glass test", 50.0, 5.0, 10, 19.0, 1, 150, 250, "");
		testPlayer.playerBag.addtoBag(new BasicHeal(), 2);

		String simulatedUserInput = "items\n1\n2\nfight";
		System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
		Scanner input = new Scanner(System.in);
		testBattle.fight(testTeam, testEnemy, testPlayer.playerBag, input);
		assertEquals(testTeam.getFriend(1).getHealth(), 50);
	}
	
	@Test
	public void invalidInputInFightTest() {
		String finalLineToCheck = "Sorry your command wasn't understood";
		testTeam.addFriend(new WaterMonster("water test", 50.0, 5.0, 40, 20.0, 1, 150, 250, ""));
		testEnemy = new GlassMonster("glass test", 50.0, 5.0, 10, 19.0, 1, 150, 250, "");

//		First tests invalid input then tests fight as fight is proven to work per the above test
//		this is to avoid being caught in a loop
		String input = "sdfsd\n" + "fight";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		Scanner userInputs = new Scanner(System.in);
		testBattle.fight(testTeam, testEnemy, testPlayer.playerBag, userInputs);
		testTeam.getFriend(0).gainExperience((-1 * testTeam.getFriend(0).getMyExperience()));
		int indexOfStartOfLineToCheck = (outputStreamContent.toString().length() - (finalLineToCheck.length() + 349));
		int indexOfEndOfLineToCheck = (outputStreamContent.toString().length() - 349);  
	    assertEquals(finalLineToCheck, outputStreamContent.toString().substring(indexOfStartOfLineToCheck, indexOfEndOfLineToCheck));
	}
}
