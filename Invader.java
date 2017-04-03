/**
 * Write a description of class Invader here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import greenfoot.*; 
import java.util.Random;
import javax.swing.*;

public class Invader extends Actor
{
    
    int invaderSpeed = 1;
    boolean canFire = false;
    static int invaderCount = 0;
    InvadersWorld world;
    private int timer = 0;
    private GreenfootImage[] sprites = new GreenfootImage[2];
    private int state = 0;
    
    public Invader() {
        Random random = new Random();
       /* if (random.nextInt(4) <= 2) {
            canFire = true;
        }*/
        invaderCount++;
        sprites[0] = new GreenfootImage("invader1.png");
        sprites[1] = new GreenfootImage("invader2.png");
        this.setImage(sprites[state]);
    }
    
    public void act() {
        timer++;
        if(timer % 35 == 0) {
            timer = 0;
            toggleImage();
        }
        if (world == null) {
            world = this.getWorldOfType(InvadersWorld.class);
        }
        boolean changeDirection = false;
        this.setLocation(this.getX() - invaderSpeed, this.getY());
        if(this.isAtEdge()){
             changeDirection = true;
        }
        if (changeDirection == true){
            invaderSpeed *= -1;
            this.setLocation(this.getX(), this.getY() + 50);
            changeDirection = false;
        }
        //if(canFire) {
            Random random = new Random();
            if (random.nextInt(1000) <= 250 / (invaderCount * 6 + 1)) {
                this.getWorld().addObject(new InvaderBullet(), this.getX(), this.getY());
            }
        //}
        if (this.isTouching(PlayerBullet.class)) {
            world.removeObjects(this.getObjectsInRange(500, PlayerBullet.class));
            //world.removeObjects(this.getIntersectingObjects(PlayerBullet.class));
            world.removeObject(this);
            invaderCount--;
            world.getScore().increaseScore(5);
            if(invaderCount == 0) {
                JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "You Won!");
                System.exit(0);
            }
        }
    }
    
    private void toggleImage() {
        if(state == 0) {
            state = 1;
        } else {
            state = 0;
        }
        this.setImage(sprites[state]);
    }

}