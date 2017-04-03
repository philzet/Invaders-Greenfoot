/**
 * Write a description of class MessageControl here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import greenfoot.*;
import java.awt.*;

public class MessageControl extends Actor
{

    /**
     * Constructor for objects of class MessageControl
     */
    public MessageControl(String type, int number)
    {
        GreenfootImage image = new GreenfootImage(250, 50);
        image.setFont(new Font ("ArcadeClassic", Font.PLAIN, 26));
        image.setColor(Color.white);
        if (type == "lives") {
            image.drawString("Lives: " + number, 90, 30);
        } else if (type == "score") {
            image.drawString("Score: " + number, 90, 30);
        }
        this.setImage(image);
    }
}
