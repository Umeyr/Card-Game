
import java.util.Random;

// Cards - Maintains a collection of zero or more playing cards.
//         Provides facilities to create a full pack of 52 cards
//         and to shuffle the cards.
// author:yunus umeyr k�l��
// date:01.03.2015
public class Cards
{
    final int NOOFCARDSINFULLPACK = 52;
    
    // properties
    Card[] cards;
    int    valid;
    
    // constructors
    public Cards( boolean fullPack)
    {
        cards = new Card[ NOOFCARDSINFULLPACK ];
        valid = 0;
        
        if ( fullPack)
            createFullPackOfCards();
    }
    
    // methods
    public Card getTopCard()
    {
        Card tmp;

        if ( valid <= 0)
            return null;
        else
        {
            valid--;
            tmp = cards[valid];
            cards[valid] = null;
            return tmp;
        }
    }
    
    public boolean addTopCard( Card c)
    {
        if ( valid < cards.length)
        {
            cards[valid] = c;   // should this be cloned?
            valid++;
            return true;
        }
        return false;
    }
    
    private void createFullPackOfCards()
    {
        for( int i = 0; i < 52; i++)
        	addTopCard( new Card(i) );
        
    }
    
    public void shuffle()
    {
        Random generator = new Random();
        for( int i = 0; i < 52; i++)
        {
        	int x = generator.nextInt(52);
        	Card instancecard = cards [i];
        	cards[i] = cards[x];
        	cards[x] = instancecard;
        }
    }
} // end class Cards
