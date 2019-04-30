import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Contains the methods used by the enemy actors.
 * 
 * @Gillian Sanchez, Jonathon Ferguson 
 * @January 18, 2016
 */
public class Enemy extends Actor
{
    private int health = 2;
    Actor hitPlayer;
    Actor spade;
    
    /**
     * Act - do whatever the Enemy wants to do.
     */
    public void enemyAct(int points) 
    {
        Actor hitPlayer = getOneIntersectingObject(MC.class);
        Actor spade = getOneIntersectingObject(Spade.class);
        hitMC(hitPlayer);
        hit(spade, points);
    }
    
    /**
     * Move the Warrior towards a location.
     */
    public void moveTo(int locX, int locY)
    {
        if(getX() < locX) {
            setLocation(getX() + 2, getY());
        }
        if(getX() > locX) {
            setLocation(getX() - 2, getY());
        }
        if(getY() < locY) {
            setLocation(getX(), getY() + 2);
        }
        if(getY() > locY) {
            setLocation(getX(), getY() - 2);
        }
    }
    
    /**
     * Subtract health when hit.
     * Delete Warrior when health hits 0.
     */
    public void hit(Actor spade, int score)
    {
        if (spade != null && getWorld() != null) {
            getWorld().removeObject(spade);
            health--;
        }
        if (health == 0) {
            addScore(score);
            die();
        }
    }
    
    /**
     * Change amount of points of the score.
     */
    public void addScore(int score)
    {
        ((Hall) getWorld()).scoreCounter.add(score);
    }
    
    /**
     * Check if the player has been touched by the enemy.
     */
    public void hitMC(Actor hitPlayer)
    {
        if (hitPlayer != null) {
            ((Hall) getWorld()).player.health--;
            getWorld().removeObject(this);
        }
    }
    
    /**
     * Move towards one of the corners.
     */
    public void moveCorner(int algorithm)
    {
        int wWidth = getWorld().getWidth();
        int wHeight = getWorld().getHeight();
        switch (algorithm) {
            case 1:
                moveTo(wWidth, wHeight);
                break;
            case 2:
                moveTo(0, wHeight);
                break;
            case 3:
                moveTo(wWidth, 0);
                break;
            default:
                moveTo(0, 0);
                break;
        }
    }
    
    /**
     * Remove actor if it touches either the left or right side.
     */
    public void hitSide()
    {
        if (this.getX() == 0 || this.getX() == 557) {
            addScore(-100);
            getWorld().removeObject(this);
        }
    }
    
    /**
     * Remove the enemy from the face of the world.
     */
    public void die()
    {
        getWorld().removeObject(this);
    }
}