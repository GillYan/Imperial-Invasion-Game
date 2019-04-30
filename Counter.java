import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//import java.awt.Color;

/**
 * A Counter class that allows you to display a numerical value on screen.
 * 
 * @author Neil Brown and Michael Kölling 
 * @version 1.0
 */
public class Counter extends Actor
{
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;
    private String prefix;
    private Color colour;
    public int value;
    
    public Counter()
    {
        this(new String());
    }

    /**
     * Create a new counter, initialised to 0.
     */
    public Counter(String prefix)
    {
        background = getImage();  // get image from class
        this.prefix = prefix;
        updateImage(value);
    }
    
    /**
     * Display the current value.
     */
    public void act() 
    {
        updateImage(value);
    }

    /**
     * Add a new score to the current counter value.  This will animate
     * the counter over consecutive frames until it reaches the new value.
     */
    public void add(int score)
    {
        value += score;
    }
    
    /**
     * Return the value.
     */
    public int getValue()
    {
        return value;
    }
    
    /**
     * Sets the colour of the text.
     */
    public void setColour(Color newColour)
    {
        colour = newColour;
    }
    
    /**
     * Sets a text prefix that should be displayed before the counter value.
     */
    public void setPrefix(String prefix)
    {
        this.prefix = prefix;
        updateImage(value);
    }
    
    /**
     * Sets the value to the health of the player.
     */
    public void playerHP()
    {
        value = ((Hall) getWorld()).player.getHP();
    }

    /**
     * Sets the value to the delay of using another dash.
     */
    public void dashDelay()
    {
        value = ((Hall) getWorld()).player.getBoost();
    }
    
    /**
     * Add one to the time every frame.
     * 50 - 60 FPS, divide value by 50 - 60 to get time in seconds.
     */
    public void addTime()
    {
        value++;
    }
    
    /**
     * Update the image on screen to show the current value.
     */
    public void updateImage(int value)
    {
        GreenfootImage image = new GreenfootImage(background);
        GreenfootImage text = new GreenfootImage(prefix + value, 22, colour, transparent);
        
        if (text.getWidth() > image.getWidth() - 20)
        {
            image.scale(text.getWidth() + 20, image.getHeight());
        }
        
        image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
                        (image.getHeight()-text.getHeight())/2);
        setImage(image);
    }
}