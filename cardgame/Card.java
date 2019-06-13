

/**
 * Card - a single playing card
 * @author yunus umeyr kýlýç
 * @version
 */
public class Card
{
    final String[] SUITS = { "Hearts", "Diamonds", "Spades", "Clubs"};
    final String[] FACES = { "A", "2", "3", "4", "5",
                             "6", "7", "8", "9", "10",
                             "J", "Q", "K"};
    // properties
    int  cardNo;
    
    // constructors
    public Card( int faceValue, int suit )
    {
        cardNo = faceValue + suit * 13;
    }
    
    public Card( int cardNumber)
    {
        cardNo = cardNumber;
    }
    
    public int getFaceValue()
    {
        return cardNo % 13;
    }
    
    public int getSuit()
    {
        return cardNo / 13;
    }
    
    public String toString()
    {
        return FACES[ getFaceValue() ] + " of " + SUITS[ getSuit() ];
    }
    
    public boolean equals( Card c)
    {
        if( getFaceValue() == c.getFaceValue() &&  getSuit() == c.getSuit() )
        	return true;
        return false;
    }
    
    public int compareTo( Card c)
    {
        if( getFaceValue() > c.getFaceValue())
        	return 1;
        if( getFaceValue() < c.getFaceValue())
        	return -1;
       return 0;
    }
}