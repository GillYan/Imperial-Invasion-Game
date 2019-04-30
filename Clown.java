import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is an enemy that automatically moves to a corner.
 * 
 * @Gillian Sanchez, Jonathon Ferguson 
 * @January 18, 2016
 */
public class Clown extends Enemy
{
    /**
     * Do as clowns do as long as the screen is not covered.
     */
    public void act(int type) 
    {
        if (getWorld().getObjects(Full.class).size() == 0) {
            moveCorner(type);
            hitSide();
            if (getWorld() != null) {
                enemyAct(50);
            }
        }
    }
}