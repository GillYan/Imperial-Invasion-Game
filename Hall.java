import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * World of Palace Hallway.
 * 
 * @Gillian Sanchez, Jonathon Ferguson 
 * @January 18, 2016
 */
public class Hall extends World
{
    public ScoreCounter scoreCounter = new ScoreCounter();
    public MC player = new MC();
    private GifImage gifImage = new GifImage("Background.gif");
    private int heartDelay = 1000;            //delay for hearts being spawned
    private int rTime;
    private int rAlgorithm;
    private int rX;
    private int rY;
    
    /**
     * Constructor for objects of class Hall.
     */
    public Hall()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(558, 623, 1);
        Greenfoot.start();
        prepare();
        setBackground(gifImage.getCurrentImage());
    }
    
    /**
     * Run animated background.
     */
    public void act() 
    {
        rAlgorithm = Greenfoot.getRandomNumber(4)+1;
        if (getObjects(Full.class).size() == 0) {
            setBackground(gifImage.getCurrentImage());
            randomWarrior();
            randomClown();
            spawnHeart();
        }
        reset();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject(player,279,311);
        addObject(scoreCounter,490,45);
        Timer timer = new Timer();
        addObject(timer,490,82);
        HealthBar hp = new HealthBar();
        addObject(hp,80,45);
        DashCounter dc = new DashCounter();
        addObject(dc,80,82);
        Full full = new Full(0);
        addObject(full,279,311);
    }
    
    /**
     * Roll a random number.
     */
    private int rNumber(int number)
    {
        return rTime = Greenfoot.getRandomNumber(number);
    }
    
    /**
     * Spawn a warrior in random intervals.
     */
    private void randomWarrior()
    {
        rNumber(300);
        if (rTime <= 5) {
            rX = rNumber(558);
            if (rAlgorithm <= 2) {
                rY = rNumber(85);
            }
            else {
                rY = rNumber(103) + 520;
            }
            addObject(new Warrior(), rX, rY);
        }
    }
    
    /**
     * Spawn a clown in random intervals.
     */
    private void randomClown()
    {
        rNumber(1000);
        if (rTime <= 5) {
            switch (rAlgorithm) {
                case 1:
                    addObject(new Clown1(), 0, 0);
                    break;
                case 2:
                    addObject(new Clown2(), getWidth(), 0);
                    break;
                case 3:
                    addObject(new Clown3(), 0, getHeight());
                    break;
                default:
                    addObject(new Clown4(), getWidth(), getHeight());
                    break;
            }
        }
    }
    
    /**
     * Spawn a heart in random intervals. 
     */
    private void spawnHeart()
    {
        if (heartDelay > 0) {
            heartDelay--;
        }
        else {
            addObject(new Heart(), rNumber(558), rNumber(623));
            heartDelay = 1000;
        }
    }
    
    /**
     * Reset or end the game.
     */
    private void reset()
    {
        if (player.health <= 0) {
            if (Greenfoot.isKeyDown("enter")) {
                Greenfoot.setWorld(new Hall());
            }
            if (Greenfoot.isKeyDown("backspace")) {
                Greenfoot.stop();
            }
        }
    }
}
