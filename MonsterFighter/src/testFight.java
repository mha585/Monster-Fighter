
//this is just a class to test fights between monsters delete later!!!!
public class testFight {
	public static void main(String[] args) {
		
		Team myTeam = new Team();
		Battles battle = new Battles();
//		I think these two above lines only need to be initialised once in main

		myTeam.addFriend(new WaterMonster());
		myTeam.addFriend(new FireMonster());
		myTeam.addFriend(new RandomMonster());
		
		System.out.println(myTeam.sumTeamHealth());
		
		if (battle.fight(myTeam, new GrassMonster()) == true) {
//			continue the game
			System.out.println("The game continues");
		} else {
//			end the game
			System.out.println("The game ends");
		}
	}
}
