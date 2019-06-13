
import java.util.Random;
// ScoreCard - Maintains one integer score per player, for any number of players
//             Caution: invalid playernumbers result in run-time exception!
// author:yunus umeyr kýlýç
// date:
public class ScoreCard
{
    // properties
    int[] scores;
    
    // constructors
    public ScoreCard( int noOfPlayers)
    {
        scores = new int[noOfPlayers];
        
        // init all scores to zero
        for ( int i = 0; i < scores.length; i++)
            scores[i] = 0;
    }
    
    // methods
    public int getScore( int playerNo)
    {
        return scores[ playerNo];
    }
    
    public void update( int playerNo, int amount)
    {
        scores[playerNo] += amount;
    }
    
    public String toString()
    {
        String s;
        s = "\n"
            + "_____________\n"
            + "\nPlayer\tScore\n"
            + "_____________\n";
        
        for ( int playerNo = 0; playerNo < scores.length; playerNo++)
        {
            s = s + playerNo + "\t" + scores[playerNo] + "\n";
        }
        
        s += "_____________\n";
        return s;
    }
    
    
 	int instance1, instance2, instance3,instance4;
    
    public int[] getWinners()
    {
        int [] winners = {0, 1, 2, 3};
        instance1 =  getScore( 0);
        instance2 =  getScore( 1);
        instance3 =  getScore( 2);
        instance4 =  getScore( 3);
        int m ;

        m = 0;
        for( int i = 0; i < 4; i++)
        {
     		m = 0;
	        	do
	        	{
	        		m++;
	        		if( getScore( i) < getScore( m))
	        		{
	        			int instance = winners [m];
	        			winners [m] = winners [i];
	        			winners [i] = instance;
	        		}
	        			
	        	}
	        	while( m < 3);
        	
        }
        
        return winners;	
    }
    
} // end class ScoreCard
