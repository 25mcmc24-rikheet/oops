import java.util.Random;
class Card
{
    private final String face;
    private final String suit;

    public Card(String f, String s)
    {
	this.face = f;
	this.suit = s;
    }
    public String getFace()
    {
	return this.face;
    }

    public String getSuit()
    {
	return this.suit;
    }
    public String toString()
    {
	return "["+this.face+", "+this.suit+"]";
    }
}

class DeckOfCards
{
    public Card deck[] = new Card[52];
    private int dIndex;

    public DeckOfCards()
    {
	String [] faces = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	String [] suites = {"Hearts", "Diamonds", "Clubs", "Spades"};
	for(int i = 0; i < 52; i++)
	{
	    deck[i] = new Card(faces[i%13], suites[i/13]);
	}
	this.dIndex = 0;
    }

    public void shuffle(int swaps)
    {
	Random rObj = new Random();
	for(int i = 0; i < swaps; i++)
	{
	    int l = rObj.nextInt(52);
	    int r = rObj.nextInt(52);
	    Card temp = this.deck[l];
	    this.deck[l] = this.deck[r];
	    this.deck[r] = temp;
	}
	this.dIndex = 0;
    }
    public Card dealCard()
    {
	if(this.dIndex > 51)
	{
	    return null;
	}
	return this.deck[dIndex++];
    }
    
    public String toString()
    {
	String s = "{\n";
	for(int i = 0; i < 52; i++)
	{
	    s = s + this.deck[i] + "\n";
	}
	s = s + "}";
	return s;
    }
}

public class CardSimulation
{
    public static void main(String [] args)
    {
	DeckOfCards d = new DeckOfCards();
	System.out.println(d);
	d.shuffle(100000);
	System.out.println(d);
    }
}