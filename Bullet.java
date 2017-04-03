/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*; 

public class Bullet extends Actor 
{
    // instance variables - replace the example below with your own

    enum Direction { 
        UP { 
            public int getDir() { return -4; } 
        }, 
        DOWN { 
            public int getDir() { return 4; } 
        }; 
        
        public abstract int getDir(); 
 
    } 
    
    /**
     * Constructor for objects of class Bullet
     */
    public Bullet()
    {
        
    }
    
}
