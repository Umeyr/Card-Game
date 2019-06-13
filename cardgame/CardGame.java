
import java.util.ArrayList;
// Cardgame
// author:yunus umeyr kýlýç
// date:28.02.2015
public class CardGame
{
    // properties
    Cards             fullPack;
    ArrayList<Player> players;
    ScoreCard         scoreCard;
    Cards[]           cardsOnTable;
    int               roundNo;
    int               turnOfPlayer;
    
    // constructors
    public CardGame( Player p1, Player p2, Player p3, Player p4)
    {
        cardsOnTable = new Cards [13];
        for( int i = 0; i < 13; i++)
        	cardsOnTable [i] = new Cards( false);
        players = new ArrayList <Player>();
        players.add( p1);
        players.add( p2);
        players.add( p3);
        players.add( p4);
        fullPack = new Cards( true);
        fullPack.shuffle();
        int k = 0;
        for( int i = 0; i < 52; i++)
        {
        	if( i % 13 == 0 && i != 0)
        		k++;
        	players.get( k).add( fullPack.getTopCard());
        }  
        scoreCard = new ScoreCard( 4); 
    }
    
    // methods
    int m = 0;
    int count = 0;
    int instance1, instance2, instance3,instance4;
    
    public boolean playTurn( Player p)
    {
        if( isTurnOf ( p))
        {
        	count++; 
        	if( count % 4 == 1 && count != 1)
        		m++;
        	   	
        	cardsOnTable [m].addTopCard(p.playCard());
        
        	if( count % 4 == 0)
        	{
        		instance4 = cardsOnTable [m].getTopCard().getFaceValue();
        		instance3 = cardsOnTable [m].getTopCard().getFaceValue();
        		instance2 = cardsOnTable [m].getTopCard().getFaceValue();
        		instance1 = cardsOnTable [m].getTopCard().getFaceValue();
        		
        		if(instance1 >= instance2 && instance1 >= instance3 && instance1 >= instance4)
        			scoreCard.update(0,1);
        		if(instance2 >= instance1 && instance2 >= instance3 && instance2 >= instance4)
        			scoreCard.update(1,1);
        		if(instance3 >= instance2 && instance3 >= instance1 && instance3 >= instance4)
        			scoreCard.update(2,1);
        		if(instance4 >= instance2 && instance4 >= instance4 && instance4 >= instance1)
        			scoreCard.update(3,1);		
        	}	
        	return true;
        }
        return false;
    }
    
    public boolean isTurnOf( Player p)
    {
        if( p == players.get(0) )
        {
        	if( count % 4 == 0)
        		return true;
        }
        if( p == players.get(1) )
        {
        	if( count % 4 == 1)
        		return true;
        }
        if( p == players.get(2) )
        {
        	if( count % 4 == 2)
        		return true;
        }
        if( p == players.get(3) )
        {
        	if( count % 4 == 3)
        		return true;
        }
        return false;
    }
    
    public boolean isGameOver()
    {
        if( count == 52 )
        	return true;
        return false;
    }
    
    public int getScore( int playerNumber)
    {
        return scoreCard.getScore( playerNumber);
    }
    
    public String getName( int playerNumber)
    {
        return players.get( playerNumber).getName();
    }
    
    public int getRoundNo()
    {
        return m + 1;
    }
    
    public int getTurnOfPlayerNo()
    {
        return (count % 4) + 1;
    }
    
    public int[] getwinners()
    {
        int [] wins = new int [4];          
        wins [0] = scoreCard.getWinners()[0];
       	wins [1] = scoreCard.getWinners()[1];
        wins [2] = scoreCard.getWinners()[2];
       	wins [3] = scoreCard.getWinners()[3];              
        return wins ;
    }
    
    public String showScoreCard()  // added 2014, David!
    {
        return scoreCard.toString();
    }
    
}