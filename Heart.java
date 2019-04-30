import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Heart that increases the player's current health by one.
 * 
 * @Gillian Sanchez, Jonathon Ferguson 
 * @January 18, 2016
 */
public class Heart extends Actor
{
    /**
     * Check if the heart touches the player and increase the player's health
     * if it does.
     */
    public void act() 
    {
        Actor hitMC = getOneIntersectingObject(MC.class);
        if (hitMC != null) {
            ((Hall) getWorld()).player.health++;
            getWorld().removeObject(this);
        }
    }    
}
