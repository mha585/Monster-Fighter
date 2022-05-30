
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BattlesTest {
	private MonsterManager manager;
	private Team testTeam;
	private Battles testBattle;
	private Player testPlayer;
	private Monster testEnemy;
	private RandomGen num;
	
	private ByteArrayOutputStream outputStreamContent = new ByteArrayOutputStream();
	private InputStream savedStandardInputStream = System.in;
	private PrintStream savedStandardOut = System.out;

	
	@BeforeEach
	public void init() {
		testTeam = new Team();
		testBattle = new Battles();
		testPlayer = new Player();
		num = new RandomGen();
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
	public void evenAttackTest() {	
		testTeam.addFriend(new FireMonster("Fire test", 50.0, 5.0, 5.425, 20.0, 1, 150, 250, "fire"));
		testEnemy = new GlassMonster("Glass test", 50.0, 5.0, 24.75, 21.0, 1, 150, 250, "glass");
		
		testBattle.attack(testTeam.getFriend(0), testEnemy, testTeam, true);
		assertEquals(testTeam.getFriend(0).getHealth(), 0.5);
		assertEquals(testEnemy.getHealth(), 39.15);
		testBattle.attack(testTeam.getFriend(0), testEnemy, testTeam, true);
//		tests health cant drop below 0
		assertEquals(testTeam.getFriend(0).getHealth(), 0);
//		tests monster wont attack if its dead
		assertEquals(testEnemy.getHealth(), 39.15);
	}
	
	@Test
	public void unevenAttackTest() {	
		testTeam.addFriend(new GrassMonster("Grass test", 50.0, 5.0, 20.0, 25.0, 1, 150, 250, "grass"));
		testEnemy = new GlassMonster("Glass test", 50.0, 5.0, 24.75, 21.0, 1, 150, 250, "glass");
		
		testBattle.attack(testTeam.getFriend(0), testEnemy, testTeam, false);
		assertEquals(testTeam.getFriend(0).getHealth(), 0.5);
		assertEquals(testEnemy.getHealth(), 50);
		testBattle.attack(testTeam.getFriend(0), testEnemy, testTeam, false);
		assertEquals(testTeam.getFriend(0).getHealth(), 0);
		assertEquals(testEnemy.getHealth(), 50);
	}
	
	@Test
	public void fasterMonsterAttacksFirstTest() {	
		testTeam.addFriend(new WaterMonster("Water test", 50.0, 5.0, 15.0, 99.0, 1, 150, 250, ""));
		testEnemy = new GlassMonster("Glass test", 50.0, 5.0, 15, 1.0, 1, 150, 250, "glass");
		testBattle.attack(testTeam.getFriend(0), testEnemy, testTeam, true);
		assertEquals(testTeam.getFriend(0).getHealth(), 20);
		assertEquals(testEnemy.getHealth(), 20);
		testBattle.attack(testTeam.getFriend(0), testEnemy, testTeam, true);
		assertEquals(testTeam.getFriend(0).getHealth(), 20);
		assertEquals(testEnemy.getHealth(), 0);
	}
	
	@Test
	public void attackEffectivenessTest() {	
		testTeam.addFriend(new WaterMonster("Water test", 50.0, 5.0, 5.0, 99.0, 1, 150, 250, ""));
		testTeam.addFriend(new MedicalMonster("Medical test", 50.0, 5.0, 5, 1.0, 1, 150, 250, ""));
		testEnemy = new HolyMonster("Holy test", 50.0, 5.0, 5, 1.0, 1, 150, 250, "");
		testBattle.attack(testTeam.getFriend(0), testEnemy, testTeam, true);
		assertEquals(testTeam.getFriend(0).getHealth(), 45);
		assertEquals(testEnemy.getHealth(), 47.5);
		testTeam.pushFrontToBack();
		testBattle.attack(testTeam.getFriend(0), testEnemy, testTeam, true);
		assertEquals(testTeam.getFriend(0).getHealth(), 45);
		assertEquals(testEnemy.getHealth(), 45);
	}
	
	@Test
	public void healTest() {	
		testTeam.addFriend(new MedicalMonster("Medical test", 50.0, 5.0, 5, 1.0, 1, 150, 250, ""));
		testEnemy = new DemonMonster("Demon test", 50.0, 5.0, 10, 1.0, 1, 150, 250, "");
		testBattle.attack(testTeam.getFriend(0), testEnemy, testTeam, true);
		assertEquals(testTeam.getFriend(0).getHealth(), 40);
		assertEquals(testEnemy.getHealth(), 47.5);
		testBattle.heal(testTeam.getFriend(0), testEnemy, testTeam);
		assertEquals(testTeam.getFriend(0).getHealth(), 35);
		assertEquals(testEnemy.getHealth(), 47.5);
	}
	
	@Test
	public void cantHealPastMaxTest() {	
		testTeam.addFriend(new MedicalMonster("Medical test", 50.0, 2000.0, 5, 1.0, 1, 150, 250, ""));
		testEnemy = new DemonMonster("Demon test", 50.0, 5.0, 10, 1.0, 1, 150, 250, "");
		testBattle.attack(testTeam.getFriend(0), testEnemy, testTeam, true);
		assertEquals(testTeam.getFriend(0).getHealth(), 40);
		assertEquals(testEnemy.getHealth(), 47.5);
		testBattle.heal(testTeam.getFriend(0), testEnemy, testTeam);
		assertEquals(testTeam.getFriend(0).getHealth(), 40);
		assertEquals(testEnemy.getHealth(), 47.5);
	}
	
	@Test
	public void getBattlesTest() {	
		testTeam.addFriend(new MedicalMonster("Medical test", 50.0, 5.0, 5, 1.0, 1, 150, 250, ""));
		testEnemy = new DemonMonster("Demon test", 50.0, 5.0, 10, 1.0, 1, 150, 250, "");
		for (int i = 0; i < 7; i++) {
			ArrayList<Trainers> battleTest = testBattle.getBattles(i, testPlayer, num);
			assertEquals(battleTest.size(), i);
		}
	}
}
