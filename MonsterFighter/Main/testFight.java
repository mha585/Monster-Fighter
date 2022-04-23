
//this is just a class to test fights between monsters delete later!!!!
public class testFight {
	public static void main(String[] args) {
		
		Team myTeam = new Team();
		Battles battle = new Battles();
		Player test = new Player();
		test.setDay(6);
		test.setDifficulty(1);
		test.setName("tester");
		System.out.println(test.getPlayerDayCompleted());
//		these above lines only need to be initialised once in main not in here

		myTeam.addFriend(new RandomMonster(test));
		myTeam.addFriend(new RandomMonster(test));
		myTeam.addFriend(new RandomMonster(test));
		
		test.playerBag.addtoBag(new TierPlus(), 1);
		test.playerBag.addtoBag(new BasicHeal(), 3);
		
		if (battle.fight(myTeam, new DemonMonster("Demon test", 50.0, 5.0, 5, 20.0, 1, 150, 250, "fire"), test.playerBag) == true) {
//			continue the game
			System.out.println("The game continues");
		} else {
//			end the game
			System.out.println("The game ends");
		}
	}
}
