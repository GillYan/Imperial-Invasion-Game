import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Displays how long the player has been alive when the screen is not covered.
 * 
 * @Gillian Sanchez, Jonathon Ferguson 
 * @January 18, 2016
 */
public class Timer extends Counter
{
    /**
     * Display the time the player has been alive.
     */
    public void act() 
    {
        if (getWorld().getObjects(Full.class).size() == 0) {
            setPrefix("Time:      ");
            addTime();
            updateImage(value/60);
        }
    }
}
