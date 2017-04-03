/**
 * Write a description of class PlayerBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;

public class PlayerBullet  extends Bullet
{

    /**
     * Constructor for objects of class InvaderBullet
     */
    public PlayerBullet()
    {
        GreenfootImage img = new GreenfootImage("playerLaser.png");
        this.setImage(img);
    }

    public void act() {
        Direction dir = Direction.UP;
        this.setLocation(this.getX(), this.getY() + dir.getDir());
        if (isAtEdge()) {
            this.getWorld().removeObject(this);
        }
    }
}

