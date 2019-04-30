import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the bullet shot by the MC.
 * 
 * @Gillian Sanchez, Jonathon Ferguson 
 * @January 18, 2016
 */
public class Spade extends Actor
{
    private static final int maxDistance = 700;
    private static final int bulletSpeed = 20;
    private String[] showSpade = { "SpadeUp.png", "SpadeDown.png" };
    private MC myCharacter;
    private int distance = 0;   //distance travelled
    
    /**
     * Spawn the spade from the player.
     */
    public Spade(MC myCharacter)
    {
        this.myCharacter = myCharacter;
    }
    
    /**
     * Move the spade in the direction the player is facing.
     */
    public void act() 
    {
        int mode = ((Hall) getWorld()).player.getMode();
        setImage(mode);
        direct(mode);
        if (getWorld() != null) {
            hitVertical();
        }
    }
    
    /**
     * Set the spade to be either facing up or down.
     */
    private void setImage(int mode)
    {
        setImage(showSpade[mode]);
    }
    
    /**
     * Move the spade in the direction in accordance to the player's mode.
     */
    private void direct(int mode)
    {
        switch (mode) {
            case 0:
                travel(-bulletSpeed);
                break;
            default:
                travel(bulletSpeed);
                break;
        }
    }
    
    /**
     * Move the spade in a direction.
     */
    private void travel(int Speed)
    {
        setLocation(getX(), getY() + Speed);
        distance += bulletSpeed;
        if (distance >= maxDistance) {
            getWorld().removeObject(this);
        }
    }
    
    /**
     * Remove the spade if it hits either the top or bottom.
     */
    private void hitVertical()
    {
        if (getY() <= 0 || getY() >= getWorld().getHeight() - 1) {
            getWorld().removeObject(this);
        }
    }
}
