import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {

	private Player testPlayer;
	private RandomGen num;
	
	private ByteArrayOutputStream outputStreamContent = new ByteArrayOutputStream();
	private InputStream savedStandardInputStream = System.in;
	private PrintStream savedStandardOut = System.out;

	
	@BeforeEach
	public void init() {
		testPlayer = new Player();
		num = new RandomGen();
		testPlayer.setDay(1);
		testPlayer.setDifficulty(1);
		testPlayer.setDay(7);
		testPlayer.setName("tester");
		
	    System.setOut(new PrintStream(outputStreamContent));
    }
	
	@AfterEach
	public void tearDown() {
	    System.setIn(savedStandardInputStream);
	    System.setOut(savedStandardOut);
	}
	
	@Test
	public void playerStartsWithItemsTest() {
		assertEquals(2, testPlayer.getInventory().getSize());
		assertEquals(3, testPlayer.getInventory().getItem(0).getFrequency());
		assertEquals(3, testPlayer.getInventory().getItem(1).getFrequency());
		assertEquals("Basic Heal", testPlayer.getInventory().getItem(0).getName());
		assertEquals("Attack Plus", testPlayer.getInventory().getItem(1).getName());

	}
	
	@Test
	public void playerStartsWithNoMonstersTest() {
		assertEquals(0, testPlayer.getTeam().getSize());
	}
	
	@Test
	public void playerStartsWithMoneyAndNoPointsTest() {
		assertEquals(250, testPlayer.getMoney());
		assertEquals(0, testPlayer.getPoints());
	}
	
	@Test
	public void playerCanGainMonstersTest() {
		testPlayer.getTeam().addFriend(new RandomMonster(testPlayer, num));
		assertEquals(1, testPlayer.getTeam().getSize());
	}
	
	@Test
	public void playerHasAMaxTeamSizeTest() {
		for (int i = 0; i < 10; i++) {
			testPlayer.getTeam().addFriend(new RandomMonster(testPlayer, num));
		}
		assertEquals(4, testPlayer.getTeam().getSize());
	}
	
	@Test
	public void playerCanLoseMonstersTest() {
		Monster friendToAdd = new RandomMonster(testPlayer, num);
		testPlayer.getTeam().addFriend(friendToAdd);
		assertEquals(1, testPlayer.getTeam().getSize());
		testPlayer.getTeam().removeFriend(friendToAdd);
		assertEquals(0, testPlayer.getTeam().getSize());
	}
	
	@Test
	public void playerCantGetNegativeMonstersTest() {
		Monster friendToAdd = new RandomMonster(testPlayer, num);
		testPlayer.getTeam().addFriend(friendToAdd);
		assertEquals(1, testPlayer.getTeam().getSize());
		testPlayer.getTeam().removeFriend(friendToAdd);
		assertEquals(0, testPlayer.getTeam().getSize());
		testPlayer.getTeam().removeFriend(friendToAdd);
		assertEquals(0, testPlayer.getTeam().getSize());
	}
	
	@Test
	public void playerCanGainItemsTest() {
		assertEquals(2, testPlayer.getInventory().getSize());
		testPlayer.getInventory().addtoBag(new TierPlus(), 3);
		assertEquals(3, testPlayer.getInventory().getSize());
	}
	
	@Test
	public void playerCanLooseItemsTest() {
		testPlayer.getInventory().removeBag(0, 3);
		assertEquals(1, testPlayer.getInventory().getSize());
	}
	
	@Test
	public void currentDayIncreasesButFinishDayStaysTheSameTest() {
		assertEquals(1, testPlayer.getCurrentDay());
		assertEquals(6, testPlayer.daysLeft());
		testPlayer.addDay();
		assertEquals(2, testPlayer.getCurrentDay());
		assertEquals(5, testPlayer.daysLeft());
	}
	
	@Test
	public void validNameTest() {
		testPlayer.setName("2");
		assertEquals(false, testPlayer.checkName(testPlayer.getPlayerName()));
		testPlayer.setName("valid");
		assertEquals(true, testPlayer.checkName(testPlayer.getPlayerName()));
		testPlayer.setName("     e");
		assertEquals(false, testPlayer.checkName(testPlayer.getPlayerName()));
		testPlayer.setName("!valid");
		assertEquals(false, testPlayer.checkName(testPlayer.getPlayerName()));
	}

}
