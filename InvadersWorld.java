import greenfoot.*;  // (Actor, World, Greenfoot, GreenfootImage)
import java.awt.*;

public class InvadersWorld extends World
{
    /**
     * Create the crab world (the beach). Our world has a size 
     * of 560x560 cells, where every cell is just 1 pixel.
     */
    
    int rowsOfInvaders = 4;
    int numOfInvaders = 7;
    int size = 560;
    public Score score = new Score();
    public int lives = 5;
    
    public InvadersWorld() 
    {
        super(560, 560, 1);
        setupInvaders();
    }
    
    private void setupInvaders() {
        int invaderRow = 0;
        int invaderColumn = 0;
        int invaderNum = 1;
        int numberOfInvaders = invaderNum * 2 + 1;
        for (int i = 0; i< rowsOfInvaders; i++) {
            invaderRow = i;
            for (int j = 0; j < numOfInvaders; j++) {
                invaderColumn = j;
                Invader tempInvader = new Invader();
                int xPositionStart = size/2 - 20 - numOfInvaders * 12 + 10;
                addObject(tempInvader, xPositionStart + (46*(j-1)), 46 * (i+1));
            }
        }
        addObject(new Player(), size/2, size-65);
        GreenfootImage image = new GreenfootImage(100,100);
        image.setColor(Color.black);
        image.fill();
        this.setBackground(image);
    }
    
    public void updateMessages() {
        removeObjects(getObjects(MessageControl.class));
        addObject(new MessageControl("lives", lives), 50, 20);
        addObject(new MessageControl("score", score.getScore()), 480, 20);
 
    }
    
    public Score getScore() {
        return score;
    }
    
}