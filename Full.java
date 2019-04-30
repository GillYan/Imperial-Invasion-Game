import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An image that fully covers the screen.
 * 
 * @Gillian Sanchez, Jonathon Ferguson 
 * @January 18, 2016
 */
public class Full extends Actor
{
    private String[] show = { "Controls.png", "Game Over.png" };
    
    /**
     * Initialize image that fully covers the screen.
     */
    public Full(int newMode)
    {
        setImage(show[newMode]);
    }
    
    /**
     * Show an image that covers the whole screen.
     */
    public void act() 
    {
        if (Greenfoot.isKeyDown("enter")) {
            getWorld().removeObject(this);
        }
    }
}