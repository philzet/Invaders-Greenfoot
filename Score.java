/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score
{
    // instance variables - replace the example below with your own
    private int score;

    /**
     * Constructor for objects of class Score
     */
    public Score()
    {
        score = 0;
    }

    public int getScore() {
        return score;
    }
    
    public void increaseScore(int x) {
        score += x;
    }
}
