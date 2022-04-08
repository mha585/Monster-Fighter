
public class FireMonster extends Monster{
	
	public FireMonster(String name, double maxHealth, double healAmount, double damage, double speed, int Tier) {
		super(name, maxHealth, healAmount, damage, speed, Tier);
	}
	
	public FireMonster() {
		super();
		super.setType("Fire");
	}
	
	public String toString() {
		return super.toString() + "\nType: " + super.getType();
	}
}
