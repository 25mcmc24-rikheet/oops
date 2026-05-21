import java.util.Random;
class Dice
{
    private int face;

    public Dice()
    {
	this.face = 0;
    }

    public int getFace()
    {
	return this.face;
    }

    public void rollDice()
    {
	Random rObj = new Random();
	this.face = 1 + rObj.nextInt(6);
    }

    public String toString()
    {
	String s = "[";
	s += this.face+"]";
	return s;
    }
}

public class DiceGame
{
    public static void main(String [] args)
    {
	Dice d1 = new Dice();
	Dice d2 = new Dice();
	d1.rollDice();
	d2.rollDice();
	int sum = d1.getFace() + d2.getFace();
	if(sum == 7 || sum == 11)
	{
	    System.out.println("USER WINS");
	    return;
	}
	if(sum == 2 || sum == 3 || sum == 12)
	{
	    System.out.println("USER LOSE");
	    return;
	}
	int target = sum;
	do
	{
	    d1.rollDice();
	    d2.rollDice();
	    sum = d1.getFace() + d2.getFace();
	    if(sum == 7)
	    {
		System.out.println("USER LOSE");
	    }
	    if(sum == target)
	    {
		System.out.println("USER WINS");
	    }
	}while(sum != 7 && sum != target);
    }
}