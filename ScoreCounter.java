import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Displays the score.
 * 
 * @Gillian Sanchez, Jonathon Ferguson 
 * @January 18, 2016
 */
public class ScoreCounter extends Counter
{
    /**
     * Display the current score.
     */
    public void act() 
    {
        setPrefix("Score:    ");
        updateImage(value);
    }
}
