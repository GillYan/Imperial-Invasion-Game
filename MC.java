import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the main character that the user controls.
 * 
 * @Gillian Sanchez, Jonathon Ferguson 
 * @January 18, 2016
 */
public class MC extends Actor
{
    private int speed;
    private int boostDelay = 0;             //delay for using dash
    private int shootDelay = 0;             //delay for shooting spades
    private int dmgDelay = 0;               //delay for taking damage
    private int switchDelay = 0;            //delay for switching direction
    private String[] showMC = { "PlayerBack.png", "PlayerFront.png" };
    private int mode = 0;                    //mode refers to direction of MC
    public int health = 25;                  //give player 25 HP
    
    /**
     * Allow the MC to do what it does as long as the screen is not covered.
     */
    public void act() 
    {
        if (getWorld().getObjects(Full.class).size() == 0) {
            setImage();
            setSpeed();
            checkKeys(speed);
            shoot();
            die();
        }
    }
    
    /**
     * Sets the picture of the player, either facing forward or backwards.
     */
    private void setImage()
    {
        if (switchDelay > 0) {
            switchDelay--;
        }
        else {
            if (Greenfoot.isKeyDown("d")) {
                switch (mode) {
                    case 0:
                        mode = 1;
                        break;
                    default:
                        mode = 0;
                        break;
                }
                setImage(showMC[mode]);
                switchDelay = 15;
            }
        }
    }
    
    /**
     * Set the movement speed of the player.
     */
    private int setSpeed()
    {
        speed = 5;
        if (boostDelay > 0) {
            boostDelay = boostDelay - 1;
        }
        else if (Greenfoot.isKeyDown("s")) {
            speed += 300;
            boostDelay = 200; // delay next shot
        }
        return speed;
    }
    
    /**
     * Directs the player's movement if the controls are being pressed.
     */
    private void checkKeys(int speed)
    {
        if (Greenfoot.isKeyDown("up")) {
            setLocation(getX(), getY()-speed);
        }
        if (Greenfoot.isKeyDown("down")) {
            setLocation(getX(), getY()+speed);
        }
        if (Greenfoot.isKeyDown("right")) {
            move(speed);
        }
        if (Greenfoot.isKeyDown("left")) {
            move(-speed);
        }
    }
    
    /**
     * Shoots a spade from the player.
     */
    private void shoot()
    {
        if (shootDelay > 0) {
            shootDelay--;
        }
        else if (Greenfoot.isKeyDown("a")) {
            getWorld().addObject(new Spade(this), getX(), getY());
            shootDelay = 15; // delay the next shot
        }
    }
    
    /**
     * Remove the player from the world and stop the program when the
     * player's health hits 0.
     */
    private void die()
    {
        if (health <= 0) {
            getWorld().addObject(new Full(1), 279, 311);
            getWorld().setPaintOrder(ScoreCounter.class, Timer.class, Full.class);
            getWorld().removeObject(this);
        }
    }
    
    /**
     * Returns the player mode type.
     */
    public int getMode()
    {
        return mode;
    }
    
    /**
     * Return the player's health.
     */
    public int getHP()
    {
        return health;
    }
    
    /**
     * Return the delay timer for using the dash.
     */
    public int getBoost()
    {
        return boostDelay;
    }
}