import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//import java.awt.Color;

/**
 * Displays the player's health.
 * 
 * @Gillian Sanchez, Jonathon Ferguson 
 * @January 18, 2016
 */
public class HealthBar extends Counter
{
    /**
     * Display the health of the player.
     */
    public void act() 
    {
        setPrefix("Health:   ");
        playerHP();
        setColour(new Color(255,0,0));
        updateImage(value);
    }
}
