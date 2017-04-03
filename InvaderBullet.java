/**
 * Write a description of class InvaderBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import greenfoot.*;

public class InvaderBullet  extends Bullet
{

    /**
     * Constructor for objects of class InvaderBullet
     */
    public InvaderBullet()
    {
        GreenfootImage img = new GreenfootImage("laser.png");
        img.scale(8, 20);
        this.setImage(img);
    }

    public void act() {
        Direction dir = Direction.DOWN;
        this.setLocation(this.getX(), this.getY() + dir.getDir());
        if (isAtEdge()) {
            this.getWorld().removeObject(this);
        }
    }
}
