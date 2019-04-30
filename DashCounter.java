import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//import java.awt.Color;

/**
 * Displays how long until a dash can be used.
 * 
 * @Gillian Sanchez, Jonathon Ferguson 
 * @January 18, 2016
 */
public class DashCounter extends Counter
{
    /**
     * Display the delay of using a dash.
     */
    public void act() 
    {
        setPrefix("Dash:     ");
        dashDelay();
        setColour(new Color(0,255,0));
        updateImage(value);
    }
}
