import java.util.Random;

public class Dice {
	private int numDice;
	private int sides;
	private Random rand;
	
	public Dice(int count, int sides)
	{
		this.numDice = count;
		this.sides = sides;
		rand = new Random();
	}
	
	public int roll()
	{
		int total = 0;
		for(int roll = 0; roll < numDice; roll++){
			total += rand.nextInt(sides)+1;
		}
		return total;
	}
}
