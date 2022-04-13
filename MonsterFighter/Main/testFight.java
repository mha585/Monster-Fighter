

//this is just a class to test fights between monsters delete later!!!!
public class testFight {
	public static void main(String[] args) {

		Team myTeam = new Team();
		Battles battle = new Battles();
		Player test = new Player("tester", 6, 1);
//		these above lines only need to be initialised once in main not in here

		myTeam.addFriend(new MedicalMonster());
		myTeam.addFriend(new RandomMonster());
		myTeam.addFriend(new RandomMonster());

		test.playerBag.addtoBag(new TierPlus(), 1);
		test.playerBag.addtoBag(new BasicHeal(), 3);

		if (battle.fight(myTeam, new RandomMonster(), test.playerBag) == true) {
//			continue the game
			System.out.println("The game continues");
		} else {
//			end the game
			System.out.println("The game ends");
		}
		System.out.println(test);
		System.out.println(myTeam);
	}
}
