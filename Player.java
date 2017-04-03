/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import greenfoot.*; 
import javax.swing.*;

public class Player extends Actor
{
    // instance variables - replace the example below with your own
    private boolean upKeyWasUp = true;
    InvadersWorld world;

    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        this.setImage("player2.png");
    }

    public void act() {
        if (world == null) {
            world = this.getWorldOfType(InvadersWorld.class);
        }
        if (Greenfoot.isKeyDown("right")) {
            moveHorizontally(2);
            //this.setImage("player1.png");
        } else if (Greenfoot.isKeyDown("left")) {
            moveHorizontally(-2);
            //this.setImage("player1.png");
        } else {
            //this.setImage("player2.png");
        }
        
        if (Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("space")) {
            if(upKeyWasUp) {
                world.addObject(new PlayerBullet(), this.getX(), this.getY() - 65);
                upKeyWasUp = false;
            }
        } else {
            upKeyWasUp = true;
        }
        
        if (this.isTouching(InvaderBullet.class)) {
            world.lives -= 1;
            world.removeObjects(this.getObjectsInRange(500, InvaderBullet.class));
            if(world.score.getScore() >= 20) {
                world.score.increaseScore(-20);
            } else {
                world.score.increaseScore(-world.score.getScore());
            }
            if(world.lives == 0) {
                JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Game Over. You lost");
                System.exit(0);
            }
            world.updateMessages();
        }
        if(world != null) {
        world.updateMessages();
    }
    }
    
    private void moveHorizontally(int dist) {
        this.setLocation(this.getX() + dist, this.getY());
    }
    
}
