
public class Shop {
	AtkBoost AB = new AtkBoost();
	AtkPlus AP = new AtkPlus();
	BasicHeal BH = new BasicHeal();
	HPrestore HR = new HPrestore();
	MegaHeal MH = new MegaHeal();
	SpeedBoost SB = new SpeedBoost();
	SpeedPlus SP = new SpeedPlus();
	TierPlus TP = new TierPlus();
	
	public Shop() {}
	
	public String toString() {
		return"(1)"+ AB.getName() + " - " + AB.getDescription() + " ......................$" + AB.getPrice()+ "\n" +
				"(2)"+AP.getName() + " - " + AP.getDescription() + " .......$" + AP.getPrice()+"\n" +
				"(3)"+BH.getName() + " - " + BH.getDescription() + " ...............................$" + BH.getPrice()+"\n" +
				"(4)"+HR.getName() + " - " + HR.getDescription() + " ..............................$" + HR.getPrice()+"\n" +
				"(5)"+MH.getName() + " - " + MH.getDescription() + " ................................$" + MH.getPrice()+"\n" +
				"(6)"+SB.getName() + " - " + SB.getDescription() + " ........................$" + SB.getPrice()+"\n" +
				"(7)"+SP.getName() + " - " + SP.getDescription() + " .........$" + SP.getPrice()+"\n" +
				"(8)"+TP.getName() + " - " + TP.getDescription() + " .......................$" + TP.getPrice() +
				"\n(9)Exit";
	}
	
	
}
