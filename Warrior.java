import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is an enemy that automatically moves towards the player.
 * 
 * @Gillian Sanchez, Jonathon Ferguson 
 * @January 18, 2016
 */
public class Warrior extends Enemy
{
    /**
     * Make warrior move towards the player as long as the screen is not covered.
     */
    public void act() 
    {
        if (getWorld().getObjects(Full.class).size() == 0) {
            if (getWorld().getObjects(MC.class).size() != 0) {
                Actor MC = getWorld().getObjects(MC.class).get(0);
                int xMC = MC.getX();
                int yMC = MC.getY();
                moveTo(xMC, yMC);
            }
            if (getWorld() != null) {
                enemyAct(50);
            }
        }
    }
}
