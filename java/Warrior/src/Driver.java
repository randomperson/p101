import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		Warrior nameless = new Warrior("The Nameless One");
		System.out.println(nameless);
		System.out.println();
		Warrior traveler = new Warrior("The Wanderer");
		System.out.println(traveler);
		
		System.out.println("Press Any Key to start Battle.....");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		
		int namelessWins = 0;
		int travelerWins = 0;
		
		int numBattles = 100;
		while(numBattles > 0){
			//who attacks first?
			int namelessInit = nameless.rollForInitiative();
			int travelerInit = traveler.rollForInitiative();
			while(namelessInit == travelerInit){
				namelessInit = nameless.rollForInitiative();
				travelerInit = traveler.rollForInitiative();
			}
			
			Warrior[] order = new Warrior[2];
			//we have the order of battle
			if(namelessInit > travelerInit){
				order[0] = nameless;
				order[1] = traveler;
			}else{
				order[0] = traveler;
				order[1] = nameless;
			}
			
			int namelessHP = nameless.hp;
			int travelerHP = traveler.hp;
			//lets fight to the death!!
			while(nameless.hp > 0 && traveler.hp > 0){ //battle loop
				order[0].attack(order[1]);
				order[1].attack(order[0]);
			}
			
			//battle has ended
			if(nameless.hp > 0){
//				System.out.println(nameless.name + " wins");
				namelessWins++;
			}else if(traveler.hp > 0){
//				System.out.println(traveler.name + " wins");
				travelerWins++;
			}else{
				System.out.println("Both warriors died an honourable death");
			}
			numBattles--;
			
			//heal our warriors
			nameless.hp = namelessHP;
			traveler.hp = travelerHP;
		}
		System.out.println("nameless wins: " + namelessWins);
		System.out.println("traveler wins: " + travelerWins);
	}
}