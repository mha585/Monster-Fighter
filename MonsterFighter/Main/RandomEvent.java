import java.util.*;

public class RandomEvent {
	
	private randomGen randNum = new randomGen();
	
	public RandomEvent() {
	}
	
	public boolean shouldLevelUp(Monster monster) {
		Set<Integer> num = new HashSet<Integer>();
		if (monster.getTier() == 1) {
			while (num.size() < 20 ) {
				int number = randNum.randNumInRange(0, 100);
				num.add(number);	
			}
		}
		else if (monster.getTier() == 2) {
			while (num.size() < 10 ) {
				int number = randNum.randNumInRange(0, 100);
				num.add(number);
			}
		}
		else if (monster.getTier() == 3) {
			num.add(101);
			}
		int getNumber = randNum.randNumInRange(0, 100);
		if (num.contains(getNumber)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean shouldLeave(Team team, double faints) {
		Set<Integer> num = new HashSet<Integer>();
		if (team.getSize() > 0) {
			if(faints == 0) {
				while (num.size() < 5) {
					int number = randNum.randNumInRange(0, 100);
					num.add(number);
				}
			}
			else if (faints == 1) {
				while(num.size() < 46) {
					int number = randNum.randNumInRange(0, 100);
					num.add(number);
				}
			}
			else if (faints == 2) {
				while(num.size() < 99) {
					int number = randNum.randNumInRange(0, 100);
					num.add(number);
				}
			}
		}
		else {
			num.add(101);
		}
		int getNumber = randNum.randNumInRange(0, 100);
		if (num.contains(getNumber)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean shouldJoin(Team team) {
		Set<Integer> num = new HashSet<Integer>();
		if (team.getSize() == 3) {
			while (num.size() < 5) {
				int number = randNum.randNumInRange(0, 100);
				num.add(number);
			}
		}
		else if (team.getSize() == 2) {
			while (num.size() < 10) {
				int number = randNum.randNumInRange(0, 100);
				num.add(number);
			}
		}
		else if (team.getSize() == 1) {
			while (num.size() < 15) {
				int number = randNum.randNumInRange(0, 100);
				num.add(number);
			}
		}
		else {
			num.add(101);
		}
		int getNumber = randNum.randNumInRange(0, 100);
		if (num.contains(getNumber)) {
			return true;
		}
		else {
			return false;
		}
	}
}
