import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TeamTest {

	private Team testTeam;
	private Player testPlayer;
	private Monster testEnemy;
	private Shop testShop;
	private RandomGen num;
	
	private ByteArrayOutputStream outputStreamContent = new ByteArrayOutputStream();
	private InputStream savedStandardInputStream = System.in;
	private PrintStream savedStandardOut = System.out;

	
	@BeforeEach
	public void init() {
		testTeam = new Team();
		testPlayer = new Player();
		num = new RandomGen();
		testShop = new Shop(testPlayer, num);
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
	public void addFriendToTeamTest() {
	    System.setOut(savedStandardOut);
	    testTeam.addFriend(new RandomMonster(testPlayer, num));
	    assertEquals(1, (testTeam.getSize()));
	}
	
	@Test
	public void removeFriendFromTeamTest() {
	    System.setOut(savedStandardOut);
	    RandomMonster test = new RandomMonster(testPlayer, num);
	    testTeam.addFriend(test);
	    testTeam.removeFriend(test);
	    assertEquals(0, (testTeam.getSize()));
	}
	
	@Test
	public void CantHaveMoreThanFourTeammatesTest() {
	    FireMonster monster1 = new FireMonster("Fire test1", 50.0, 5.0, 5.425, 20.0, 1, 150, 250, "");
	    FireMonster monster2 = new FireMonster("Fire test2", 50.0, 5.0, 5.425, 20.0, 1, 150, 250, "");
	    FireMonster monster3 = new FireMonster("Fire test3", 50.0, 5.0, 5.425, 20.0, 1, 150, 250, "");
	    FireMonster monster4 = new FireMonster("Fire test4", 50.0, 5.0, 5.425, 20.0, 1, 150, 250, "");
	    FireMonster monster5 = new FireMonster("Fire test5", 50.0, 5.0, 5.425, 20.0, 1, 150, 250, "");
	    testTeam.addFriend(monster1);
	    testTeam.addFriend(monster2);
	    testTeam.addFriend(monster3);
	    testTeam.addFriend(monster4);
	    testTeam.addFriend(monster5);
	    System.out.println(testTeam);
	    assertEquals(testTeam.getFriend(3).getName(), "Fire test4");
	}
	
	@Test
	public void CantRemoveFromEmptyTeamTest() {
	    testTeam.removeFriend(testEnemy);
	    assertEquals(0, testTeam.getSize());
	}
	
	@Test
	public void CantRemoveAMonsterNotInTeamTest() {
	    FireMonster monster1 = new FireMonster("Fire test1", 50.0, 5.0, 5.425, 20.0, 1, 150, 250, "");
	    ArrayList<Object> originalTeam = testTeam.getTeam();
	    testTeam.addFriend(monster1);
	    testTeam.removeFriend(testEnemy);
	    assertEquals(originalTeam, testTeam.getTeam());
	}
	
	@Test
	public void swapTest() {
	    System.setOut(savedStandardOut);
	    FireMonster monster1 = new FireMonster("Monster1", 50.0, 5.0, 5.425, 20.0, 1, 150, 250, "");
	    FireMonster monster2 = new FireMonster("Monster2", 50.0, 5.0, 5.425, 20.0, 1, 150, 250, "");
	    testTeam.addFriend(monster1);
	    testTeam.addFriend(monster2);
	    testTeam.swap(0, 1);
	    assertEquals(monster2, testTeam.getFriend(0));
	}
	
	@Test
	public void invalidSwapTest() {
	    FireMonster monster1 = new FireMonster("Monster1", 50.0, 5.0, 5.425, 20.0, 1, 150, 250, "");
	    FireMonster monster2 = new FireMonster("Monster2", 50.0, 5.0, 5.425, 20.0, 1, 150, 250, "");
	    testTeam.addFriend(monster1);
	    testTeam.addFriend(monster2);
	    testTeam.swap(0, -1);
	    assertEquals(monster2, testTeam.getFriend(1));
	}
	
	@Test
	public void swapWithItselfTest() {
	    FireMonster monster1 = new FireMonster("Monster1", 50.0, 5.0, 5.425, 20.0, 1, 150, 250, "");
	    testTeam.addFriend(monster1);
	    testTeam.swap(1, 1);
	    assertEquals(monster1, testTeam.getFriend(0));
	}
	
	@Test
	public void pushFrontToBackTest() {
	    FireMonster monster1 = new FireMonster("Monster1", 50.0, 5.0, 5.425, 20.0, 1, 150, 250, "");
	    FireMonster monster2 = new FireMonster("Monster2", 50.0, 5.0, 5.425, 20.0, 1, 150, 250, "");
	    FireMonster monster3 = new FireMonster("Monster3", 50.0, 5.0, 5.425, 20.0, 1, 150, 250, "");
	    FireMonster monster4 = new FireMonster("Monster4", 50.0, 5.0, 5.425, 20.0, 1, 150, 250, "");
	    testTeam.addFriend(monster1);
	    testTeam.addFriend(monster2);
	    testTeam.addFriend(monster3);
	    testTeam.addFriend(monster4);	
	    testTeam.pushFrontToBack();
	    assertEquals(monster2, testTeam.getFriend(0));
	    assertEquals(monster3, testTeam.getFriend(1));
	    assertEquals(monster4, testTeam.getFriend(2));
	    assertEquals(monster1, testTeam.getFriend(3));
	}
	
	@Test
	public void sumHealthTest() {
	    FireMonster monster1 = new FireMonster("Monster1", 100.0, 5.0, 5.425, 20.0, 1, 150, 250, "");
	    FireMonster monster2 = new FireMonster("Monster2", -20.0, 5.0, 5.425, 20.0, 1, 150, 250, "");
	    FireMonster monster3 = new FireMonster("Monster3", 5.0, 5.0, 5.425, 20.0, 1, 150, 250, "");
	    FireMonster monster4 = new FireMonster("Monster4", 7.0, 5.0, 5.425, 20.0, 1, 150, 250, "");
	    testTeam.addFriend(monster1);
	    testTeam.addFriend(monster2);
	    testTeam.addFriend(monster3);
	    testTeam.addFriend(monster4);	
	    double health = testTeam.sumTeamHealth();
	    assertEquals(92.0, health);
	}
	
	@Test
	public void negativeSumHealthTest() {
	    FireMonster monster1 = new FireMonster("Monster1", -100.0, 5.0, 5.425, 20.0, 1, 150, 250, "");
	    FireMonster monster2 = new FireMonster("Monster2", -20.0, 5.0, 5.425, 20.0, 1, 150, 250, "");
	    FireMonster monster3 = new FireMonster("Monster3", -10.0, 5.0, 5.425, 20.0, 1, 150, 250, "");
	    FireMonster monster4 = new FireMonster("Monster4", 12.0, 5.0, 5.425, 20.0, 1, 150, 250, "");
	    testTeam.addFriend(monster1);
	    testTeam.addFriend(monster2);
	    testTeam.addFriend(monster3);
	    testTeam.addFriend(monster4);	
	    double health = testTeam.sumTeamHealth();
	    assertEquals(-118.0, health);
	}
	
	@Test
	public void buyMonsterTest() {
	    assertEquals(250, testPlayer.getMoney());
		testTeam.buyMonster(1, testShop, testPlayer);
		assertEquals(1, testPlayer.getTeam().getSize());
		assertEquals(100, testPlayer.getMoney());
	}
	
	@Test
	public void notEnoughMoneyToBuyMonsterTest() {
		testPlayer.deductMoney(250);
	    assertEquals(0, testPlayer.getMoney());
		testTeam.buyMonster(1, testShop, testPlayer);
		assertEquals(0, testPlayer.getTeam().getSize());
		assertEquals(0, testPlayer.getMoney());
	}
	
	@Test
	public void teamAlreadyFullWhenBuyingMonsterTest() {
	    FireMonster monster1 = new FireMonster("Monster1", -100.0, 5.0, 5.425, 20.0, 1, 150, 250, "");
	    FireMonster monster2 = new FireMonster("Monster2", -20.0, 5.0, 5.425, 20.0, 1, 150, 250, "");
	    FireMonster monster3 = new FireMonster("Monster3", -10.0, 5.0, 5.425, 20.0, 1, 150, 250, "");
	    FireMonster monster4 = new FireMonster("Monster4", 12.0, 5.0, 5.425, 20.0, 1, 150, 250, "");
	    testPlayer.playerTeam.addFriend(monster1);
	    testPlayer.playerTeam.addFriend(monster2);
	    testPlayer.playerTeam.addFriend(monster3);
	    testPlayer.playerTeam.addFriend(monster4);
	    
		testTeam.buyMonster(1, testShop, testPlayer);
		assertEquals(4, testPlayer.getTeam().getSize());
		assertEquals(250, testPlayer.getMoney());
	}
	
	@Test
	public void sellMonsterTest() {
	    FireMonster monster1 = new FireMonster("Monster1", 100.0, 5.0, 5.425, 20.0, 2, 150, 250, "");
	    FireMonster monster2 = new FireMonster("Monster2", 20.0, 5.0, 5.425, 20.0, 2, 150, 250, "");

	    testTeam.addFriend(monster1);
	    testTeam.addFriend(monster2);
	    
		assertEquals(250, testPlayer.getMoney());
		assertEquals(2, testTeam.getSize());

	    testTeam.sellMonster(1, 1, testShop, testPlayer);
	    
		assertEquals(300, testPlayer.getMoney());
		assertEquals(1, testTeam.getSize());
	}
	
	@Test
	public void sellMonsterWhenOnlyHaveOneInTeamTest() {
	    FireMonster monster1 = new FireMonster("Monster1", 100.0, 5.0, 5.425, 20.0, 2, 150, 250, "");
	    testTeam.addFriend(monster1);
	    
		assertEquals(1, testTeam.getSize());

	    testTeam.sellMonster(0, 1, testShop, testPlayer);
	    
		assertEquals(250, testPlayer.getMoney());
		assertEquals(1, testTeam.getSize());
	}
	
	@Test
	public void invalidSellInput() {
	    FireMonster monster1 = new FireMonster("Monster1", 100.0, 5.0, 5.425, 20.0, 2, 150, 250, "");
	    testTeam.addFriend(monster1);
	    
		assertEquals(1, testTeam.getSize());

	    testTeam.sellMonster(-300, -7, testShop, testPlayer);
	    
		assertEquals(250, testPlayer.getMoney());
		assertEquals(1, testTeam.getSize());
	}
	
	@Test
	public void correctIndexTest() {
	    FireMonster monster1 = new FireMonster("Monster1", 100.0, 5.0, 5.425, 20.0, 2, 150, 250, "");
	    testTeam.addFriend(monster1);
	    
	    assertEquals(0, testTeam.getIndex(monster1.getName()));
	}
}
