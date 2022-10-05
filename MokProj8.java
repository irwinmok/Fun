//Irwin Mok

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Font;

public class MokProj8 extends JComponent implements KeyListener, MouseListener, MouseMotionListener
{
    //instance variables
    private int WIDTH;
    private int HEIGHT;
    int rX,rY,rW,rH;
    private long startTime, currentTime;
    int score;
    
    private MainChar mainChar1;
    private MainChar secretChar;
    
    
    private Orb[] orbs;
    private Orb[] orbs1;
    private Orb[] orbs11;
    private Orb[] orbs2;
    private Orb[] orbs22;

    private Mob[] mobs;
    private Mob[] mobs2;
    
    boolean up;
    boolean down;
    boolean left;
    boolean right;
    
    boolean upm;
    boolean downm;
    boolean leftm;
    boolean rightm;
    
    boolean upms;
    boolean downms;
    boolean leftms;
    boolean rightms;
    
    boolean inStartScreen;
    boolean inTutorial;
    boolean inMenu;
    boolean gameOver;
    
    boolean fortut;
    
    boolean inLevel1;
    boolean inLevel2;
    
    
    //Default Constructor
    public MokProj8()
    {
        //initializing instance variables
        WIDTH = 1350;
        HEIGHT = 700;
        rX = 300;
        rY = 300;
        rW = 50;
        rH = 100;
        
        score = 0;
        
        startTime = System.currentTimeMillis();
        currentTime = 0;
        mainChar1 = new MainChar();
        secretChar = new MainChar();
        
        
        orbs = new Orb[50];
        orbs1 = new Orb[50];
        orbs11 = new Orb[50];
        orbs2 = new Orb[50];
        orbs22 = new Orb[50];
        mobs = new Mob[50];
        mobs2 = new Mob[50];
        
        for(int i = 0;i<orbs.length;i++)
        {
            orbs[i] = new Orb();
        }
        
        int helper = 0;
        for(int k = 0;k<orbs1.length;k++)
        {
            orbs1[k] = new Orb(helper, 10, 2, 8, 20, 5);
            helper = helper + 70;
        }
        
        int helping = 0;
        for(int l = 0;l<orbs11.length;l++)
        {
            orbs11[l] = new Orb(10, helping, 10, 1, 20, 5);
            helping += 70;
        }
        
        int helper2 = 0;
        for(int i2 = 0;i2<orbs2.length;i2++)
        {
            orbs2[i2] = new Orb(helper2, 10, 2, 8 , 10, 5);
            helper2 += 60;
        }
        
        int helping2 = 0;
        for(int i22 = 0; i22<orbs22.length;i22++)
        {
            orbs22[i22] = new Orb(10, helping2, 10, 0, 10, 5);
            helping2 += 50;
        }
        
        
        for(int j = 0;j<mobs.length;j++)
        {
            mobs[j] = new Mob();
        }
        
        for(int k = 0;k<mobs2.length;k++)
        {
            mobs2[k] = new Mob(10,10,10,10,4,4);
        }

        inStartScreen = true;
        inTutorial = false;
        inMenu = false;
        gameOver = false;
        fortut = false;
        inLevel1 = false;
 

        //Setting up the GUI
        JFrame gui = new JFrame(); //This makes the gui box
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Makes sure program can close
        gui.setTitle("MokProj8"); //This is the title of the game, you can change it
        gui.setPreferredSize(new Dimension(WIDTH + 5, HEIGHT + 30)); //Setting the size for gui
        gui.setResizable(false); //Makes it so the gui can't be resized
        gui.getContentPane().add(this); //Adding this class to the gui

        /*If after you finish everything, you can declare your buttons or other things
        *at this spot. AFTER gui.getContentPane().add(this) and BEFORE gui.pack();
        */

        gui.pack(); //Packs everything together
        gui.setLocationRelativeTo(null); //Makes so the gui opens in the center of screen
        gui.setVisible(true); //Makes the gui visible
        gui.addKeyListener(this); //stating that this object will listen to the Keyboard
        gui.addMouseListener(this); //stating that this object will listen to the Mouse
        gui.addMouseMotionListener(this); //stating that this object will ackknowledge when the Mouse moves
    }
    //This method will acknowledge user input
    public void keyPressed(KeyEvent e)
    {
        //getting the key pressed
        int key = e.getKeyCode();
        System.out.println(key);
        //moving the rectangle
        if(key == 87)                                               //Smooth movement :D
        {
            upm = true;
        }
        if(key ==83)
        {
            downm = true;
        }
        if(key == 65)
        {
            leftm = true;
        }
        if(key == 68)
        {
            rightm = true;
        }
        
        
        if(key == 38)
        {
            upms = true;
        }
        if(key == 40)
        {
            downms = true;
        }
        if(key == 37)
        {
            leftms = true;
        }
        if(key == 39)
        {
            rightms = true;
        }
        
        
        
        /*
        if(key == 38)
        {                      //if a orb exists, move on in the array   //**FAILED
                
                up = true;
                mainChar1.orbs[onOrbNum].setX(mainChar1.getrX());
                mainChar1.orbs[onOrbNum].setY(mainChar1.getrY());
                mainChar1.orbs[onOrbNum].setVy(-5);
                mainChar1.orbs[onOrbNum].setVx(0);
                if(mainChar1.orbs[onOrbNum].getCenterY() < 0)
                {
                    up = false;
                }               
        }
        if(key == 40)
        {
                down = true;
                mainChar1.orbs[onOrbNum].setX(mainChar1.getrX());
                mainChar1.orbs[onOrbNum].setY(mainChar1.getrY());
                mainChar1.orbs[onOrbNum].setVy(5);
                mainChar1.orbs[onOrbNum].setVx(0);
                if(mainChar1.orbs[onOrbNum].getCenterY() > HEIGHT)
                {
                    down = false;
                }
        }
        if(key == 37)
        {
                left = true;
                mainChar1.orbs[onOrbNum].setX(mainChar1.getrX());
                mainChar1.orbs[onOrbNum].setY(mainChar1.getrY());
                mainChar1.orbs[onOrbNum].setVy(0);
                mainChar1.orbs[onOrbNum].setVx(-5);
                if(mainChar1.orbs[onOrbNum].getCenterX() < 0)
                {
                    left = false;
                }
        }
        if(key == 39)
        {
                right = true;
                mainChar1.orbs[onOrbNum].setX(mainChar1.getrX());
                mainChar1.orbs[onOrbNum].setY(mainChar1.getrY());
                mainChar1.orbs[onOrbNum].setVy(0);
                mainChar1.orbs[onOrbNum].setVx(5);
                if(mainChar1.orbs[onOrbNum].getCenterX() > WIDTH)
                {
                    right = false;
                }
        }
        */
    }
    //All your UI drawing goes in here
    public void paintComponent(Graphics g)                                  //beginning of text!
    {
        Font defal = new Font("Arial", Font.BOLD, 50);
        Font menus = new Font("Aria", Font.PLAIN, 20);
        Font lol = new Font("Arial", Font.PLAIN, 10);
        long countdown = currentTime/1000;
        if(inStartScreen)
        {
            g.setFont(defal);
            g.setColor(Color.BLUE);
            g.drawString("The Multitasker", (5*WIDTH)/13, (HEIGHT/2)-100);
            g.drawRect((5*WIDTH)/14, (HEIGHT/2), 100, 100);
            g.drawRect((8*WIDTH)/14, (HEIGHT/2), 100, 100);
            g.setFont(menus);
            g.drawString("\"Tutorial\"",(5*WIDTH)/14 + 15 , ((HEIGHT/5)*3)-30);
            g.drawString("For Noobs", (5*WIDTH)/14 + 5 , ((HEIGHT/5)*3)-5);
            g.drawString("Menu", ((8*WIDTH)/14)+27, ((HEIGHT/5)*3)-15);

            g.setFont(lol);
            g.setColor(Color.gray);
            g.drawString("", 0, HEIGHT - 10);  
        }                 
        if(gameOver)
        {
            Font gameOver = new Font("Arial",Font.BOLD,50);
            g.setColor(Color.gray);
            g.drawRect(400, 200, 600, 400);
            g.setColor(Color.white);
            g.fillRect(400, 200, 600, 400);
            
            g.setColor(Color.black);
            g.drawString("Retry", 535, 430);
            g.drawString("Menu", 685, 430);
            g.drawString("hint", 835, 430);
            
            if(fortut = true)
            {
                g.setFont(gameOver);
                g.setColor(Color.GREEN);
                g.drawString("LOL YOU SUCK", (WIDTH/2) - 200, 500);
            }
            g.setFont(gameOver);
            g.drawString("Game Over", 550, 300);
            
            g.setColor(Color.black);
            g.drawRect(500, 400, 100, 50);
            g.drawRect(650, 400, 100, 50);
            g.drawRect(800, 400, 100, 50);
        }
        
        if(inTutorial)                                                                                      //tutorial
        {
            fortut = true;
            g.setColor(Color.WHITE);
            g.drawRect(0, 0, 1350, 700);
            g.fillRect(0, 0, 1350, 700);
            countdown = currentTime/1000;
            int i = 0;
            
            Font tutorial = new Font("Arial", Font.ITALIC, 50);
            
            if(countdown <= 3)
            {
                Font defaulti = new Font("Arial", Font.BOLD, 100);                             
                g.setFont(defaulti);
                g.setColor(Color.black);
                g.drawString("TUTORIAL", WIDTH/3 + 50, HEIGHT/2);
                
            }
            if(countdown> 3)
            {
                if(countdown >3 && countdown < 42)
                {
                    mainChar1.drawMainChar(g);
                }            
                //g.setColor(Color.BLACK);
                //g.drawString("Time: " + currentTime/1000, 100, 100);            //add a minus 4     //this is tesintg clock change pos
                
                if(countdown>3 && countdown<8)
                {
                    g.setFont(tutorial);
                    g.setColor(Color.black);
                    g.drawString("Hi, and welcome to the tutorial", 400, 50);
                }
            }
                if(countdown >= 8 && countdown <11)
                {
                    g.setFont(tutorial);
                    g.drawString("Let's get started shall we?", 400, 50);
                }

                if(countdown >=10)
                {
                    orbs[i].drawOrb(g);
                    orbs[i].act(WIDTH, HEIGHT);
                    i++;
                    if(countdown >= 12 && countdown <14)
                    {
                        g.setFont(tutorial);
                        g.drawString("WOW! Isn't that cool!", 400, 50);
                    }
                    if(countdown>13 && countdown <=15)
                    {
                        g.setFont(tutorial);
                        g.drawString("no?", 1000, 50);
                    }
                    if(countdown > 16)
                    {
                        if(countdown <19)
                        {
                            g.setFont(tutorial);
                            g.drawString("Ok here's some more", 450, 50);               
                        }
                        
                        if(countdown >18)
                        {
                            orbs[i].drawOrb(g);
                            orbs[i].act(WIDTH, HEIGHT);
                            i++;
                            if(countdown > 19)
                            {
                                orbs[i].drawOrb(g);
                                orbs[i].act(WIDTH, HEIGHT);
                                i++; 
                                if(countdown > 20)
                                {
                                    orbs[i].drawOrb(g);
                                    orbs[i].act(WIDTH, HEIGHT);
                                    i++;
                                    if(countdown > 21)
                                    {
                                        orbs[i].drawOrb(g);
                                        orbs[i].act(WIDTH, HEIGHT);
                                        i++;
                                        
                                        
                                        if(countdown > 25 && countdown < 30)
                                        {
                                            g.setFont(tutorial);
                                            g.drawString("Now wasn't that cool?", 450, 50);
                                        }
                                        if(countdown == 30)
                                        {
                                            g.setFont(tutorial);
                                            g.drawString(".", WIDTH/2, 50);
                                        }
                                        if(countdown == 31)
                                        {
                                            g.setFont(tutorial);
                                            g.drawString("..", WIDTH/2, 50);
                                        }
                                        if(countdown == 32)
                                        {
                                            g.setFont(tutorial);
                                            g.drawString("...", WIDTH/2, 50);
                                        }
                                        
                                        if(countdown >38)
                                        {
                                            g.setFont(tutorial);
                                            g.drawString("Fine. I don't need you here", 400, 50);
                                            
                                            if(countdown >40)
                                            {
                                                mobs[0].setVx(7);
                                                mobs[0].setVy(7);
                                                
                                                mobs[0].drawMob(g);
                                                mobs[0].walking(mainChar1);
                                            }
                                            if(countdown == 42)
                                            {
                                                inLevel1 = false;
                                                inMenu = true;
                                                inStartScreen = false;
                                                inTutorial = false;
                                                mainChar1.setHealth(100);
                                            }
                                        } 
                                    }
                                }
                            }   
                        }   
                    }
                }
                //mobs[0].drawMob(g);                                        //walking mobs
                //mobs[0].walking(mainChar1);
        }                                                                                              //End of tutorial
        if(inMenu)
        {
            countdown = (System.currentTimeMillis()-startTime)/1000;
            
            fortut = false;
            g.setColor(Color.white);
            g.drawRect(0, 0, 1350, 700);
            g.fillRect(0, 0, 1350, 700);
            g.setColor(Color.black);
            
            g.setColor(Color.WHITE);
        
            g.setColor(Color.black);
            g.drawRect(0, 0, 100, 100);
            g.setFont(menus);
            g.drawString("Level 1", 20, 50);
            
            g.drawRect(200, 0, 100, 100);
            g.setFont(menus);
            g.drawString("Level 2", 220, 50);
        }
    
    
        if(inLevel1)                                                                            //level 1
        {
            countdown = (System.currentTimeMillis()-startTime)/1000;
            g.setColor(Color.WHITE);
            g.drawRect(0, 0, 1350, 700);
            g.fillRect(0, 0, 1350, 700);
            Font level1 = new Font("Arial",Font.ITALIC,50);

            g.drawString("Time: " + currentTime/1000, 100, 100);

            int helping = 0;
            int helpingtoo = 10;
            int i = 0;
            int j = 0;
            
            while(i<orbs.length)
            {
                orbs[i].setVx(2);
                orbs[i].setVy(4);
                i++;
            }
            i = 0;
            
            if(countdown >= 0 && countdown <3)
            {
                Font defaulti = new Font("Arial", Font.BOLD, 100);                             
                g.setFont(defaulti);
                g.setColor(Color.black);
                g.drawString("Level 1", WIDTH/3 + 50, HEIGHT/2); 

            }
            if(countdown> 3)
            {
                g.setFont(level1);
                g.setColor(Color.black);
                g.drawString("Time: " + currentTime/1000, 100, 100);
                if(countdown >5 && countdown <8)
                {
                    g.setFont(level1);
                    g.setColor(Color.BLACK);
                    g.drawString("Welcome to level 1 :)", 400, 50);
                }
                if(countdown > 9)
                {
                    mainChar1.drawMainChar(g);
                    if(countdown >10 && countdown <=13)
                    {
                        g.setFont(level1);
                        g.drawString("I hope this will be easy...",370, 50);
                    }
                    if(countdown >13 && countdown<=46)
                    {
                        orbs1[i].drawOrb(g);
                        orbs1[i].act(WIDTH, HEIGHT);
                        i++;
                    }
                    if(countdown > 14 && countdown<=46)
                    {
                        orbs1[i].drawOrb(g);
                        orbs1[i].act(WIDTH, HEIGHT);
                        i++;
                    }
                    if(countdown > 15 && countdown<=46)
                    {
                        orbs1[i].drawOrb(g);
                        orbs1[i].act(WIDTH, HEIGHT);
                        i++;
                    }
                    if(countdown > 16 && countdown<=46)
                    {
                        orbs1[i].drawOrb(g);
                        orbs1[i].act(WIDTH, HEIGHT);
                        i++;
                    }
                    if(countdown > 17 && countdown<=46)
                    {
                        orbs1[i].drawOrb(g);
                        orbs1[i].act(WIDTH, HEIGHT);
                        i++;
                    }
                    if(countdown > 18 && countdown<=46)
                    {
                        orbs1[i].drawOrb(g);
                        orbs1[i].act(WIDTH, HEIGHT);
                        i++;
                    }
                    if(countdown > 19 && countdown<=46)
                    {
                        orbs1[i].drawOrb(g);
                        orbs1[i].act(WIDTH, HEIGHT);
                        i++;
                    }
                    if(countdown > 19 && countdown <=20)
                    {
                        g.setFont(level1);
                        g.drawString("Is this enough?",400, 50);
                    }
                    if(countdown > 20 && countdown<=46)
                    {
                        orbs1[i].drawOrb(g);
                        orbs1[i].act(WIDTH, HEIGHT);
                        i++;
                    }
                    if(countdown > 21 && countdown<=46)
                    {
                        orbs1[i].drawOrb(g);
                        orbs1[i].act(WIDTH, HEIGHT);
                        i++;
                    }
                    if(countdown > 21 && countdown <23)
                    {
                        g.setFont(level1);
                        g.drawString("..no?",900, 50);
                    }
                    if(countdown > 22 && countdown<=46)
                    {
                        orbs1[i].drawOrb(g);
                        orbs1[i].act(WIDTH, HEIGHT);
                        i++;
                    }
                    if(countdown > 23 && countdown<=46)
                    {
                        orbs1[i].drawOrb(g);
                        orbs1[i].act(WIDTH, HEIGHT);
                        i++;
                    }
                    if(countdown > 24 && countdown<=46)
                    {
                        orbs1[i].drawOrb(g);
                        orbs1[i].act(WIDTH, HEIGHT);
                        i++;
                    }
                    if(countdown > 25 && countdown<=46)
                    {
                        orbs1[i].drawOrb(g);
                        orbs1[i].act(WIDTH, HEIGHT);
                        i++;
                    }
                    if(countdown >26 && countdown <=28)
                    {
                        g.setFont(level1);
                        g.drawString("Here's some variety", 400, 50);
                    }
                    if(countdown > 27 && countdown<=46)
                    {
                        orbs11[j].drawOrb(g);
                        orbs11[j].act(WIDTH, HEIGHT);
                        j++;
                    }
                    if(countdown > 28 && countdown<=46)
                    {
                        orbs11[j].drawOrb(g);
                        orbs11[j].act(WIDTH, HEIGHT);
                        j++;
                    }
                    if(countdown > 29 && countdown<=46)
                    {
                        orbs11[j].drawOrb(g);
                        orbs11[j].act(WIDTH, HEIGHT);
                        j++;
                    }
                    if(countdown > 30 && countdown<=46)
                    {
                        orbs11[j].drawOrb(g);
                        orbs11[j].act(WIDTH, HEIGHT);
                        j++;
                    }
                    if(countdown > 31 && countdown<=46)
                    {
                        orbs11[j].drawOrb(g);
                        orbs11[j].act(WIDTH, HEIGHT);
                        j++;
                    }
                    if(countdown > 32 && countdown<=46)
                    {
                        orbs11[j].drawOrb(g);
                        orbs11[j].act(WIDTH, HEIGHT);
                        j++;
                    }
                    if(countdown > 33 && countdown<=46)
                    {
                        orbs11[j].drawOrb(g);
                        orbs11[j].act(WIDTH, HEIGHT);
                        j++;
                    }
                    if(countdown > 34 && countdown<=46)
                    {
                        orbs11[j].drawOrb(g);
                        orbs11[j].act(WIDTH, HEIGHT);
                        j++;
                    }
                    if(countdown > 35 && countdown<=46)
                    {
                        orbs11[j].drawOrb(g);
                        orbs11[j].act(WIDTH, HEIGHT);
                        j++;
                    }
                    if(countdown > 36 && countdown<=46)
                    {
                        orbs11[j].drawOrb(g);
                        orbs11[j].act(WIDTH, HEIGHT);
                        j++;
                    }
                    if(countdown > 37 && countdown<=46)
                    {
                        orbs11[j].drawOrb(g);
                        orbs11[j].act(WIDTH, HEIGHT);
                        j++;
                    }
                    if(countdown > 38 && countdown <= 40)
                    {
                        g.setFont(level1);
                        g.drawString("Now a few more seconds", 400, 50);
                    }
                    if(countdown > 46)
                    {
                        g.setFont(level1);
                        g.drawString("That was boring", 500, 50);
                    }
                    if(countdown == 50)
                    {
                        inLevel1 = false;
                        inMenu = true;
                        mainChar1.setHealth(100);
                    }
                }
            }
        }
        if(inLevel2)                                                                                                //level 2
        {
            countdown = (System.currentTimeMillis()-startTime)/100;
            g.setColor(Color.WHITE);
            g.drawRect(0, 0, 1350, 700);
            g.fillRect(0, 0, 1350, 700);
            Font level2 = new Font("Arial", Font.BOLD, 50);
            Font default2 = new Font("Arial", Font.BOLD, 50); 
            int i = 0;
            int j = 0;
            int k = 0;
            
            if(countdown <30)
            {
                Font defaulti = new Font("Arial", Font.BOLD, 100);                             
                g.setFont(defaulti);
                g.setColor(Color.black);
                g.drawString("Level 2", WIDTH/3 + 50, HEIGHT/2); 
            }
            if(countdown>30 && countdown <=50)
            {
                g.setFont(level2);
                g.setColor(Color.black);
                g.drawString("Ok let's get striaght to the point", 300, 50);
            }
            if(countdown>50)
            {
                mainChar1.drawMainChar(g);
                secretChar.drawMainChar(g);
            }
            if(countdown >70)
            {
                orbs2[i].drawOrb1(g);
                orbs2[i].act(WIDTH, HEIGHT);
                i++;
            }
            if(countdown >75)
            {
                orbs2[i].drawOrb1(g);
                orbs2[i].act(WIDTH, HEIGHT);
                i++;
            }
            if(countdown >80)
            {
                orbs2[i].drawOrb1(g);
                orbs2[i].act(WIDTH, HEIGHT);
                i++;
            }
            if(countdown >85)
            {
                orbs2[i].drawOrb1(g);
                orbs2[i].act(WIDTH, HEIGHT);
                i++;
            }
            if(countdown >90)
            {
                orbs2[i].drawOrb1(g);
                orbs2[i].act(WIDTH, HEIGHT);
                i++;
            }
            if(countdown >95)
            {
                orbs2[i].drawOrb1(g);
                orbs2[i].act(WIDTH, HEIGHT);
                i++;
            }
            if(countdown >100)
            {
                orbs2[i].drawOrb1(g);
                orbs2[i].act(WIDTH, HEIGHT);
                i++;
            }
            if(countdown >105)
            {
                orbs2[i].drawOrb1(g);
                orbs2[i].act(WIDTH, HEIGHT);
                i++;
            }
            if(countdown >110)
            {
                orbs2[i].drawOrb1(g);
                orbs2[i].act(WIDTH, HEIGHT);
                i++;
            }
            if(countdown >115)
            {
                orbs2[i].drawOrb1(g);
                orbs2[i].act(WIDTH, HEIGHT);
                i++;
            }
            if(countdown >120)
            {
                orbs2[i].drawOrb1(g);
                orbs2[i].act(WIDTH, HEIGHT);
                i++;
            }
            if(countdown >125)
            {
                orbs2[i].drawOrb1(g);
                orbs2[i].act(WIDTH, HEIGHT);
                i++;
            }
            if(countdown >130)
            {
                orbs2[i].drawOrb1(g);
                orbs2[i].act(WIDTH, HEIGHT);
                i++;
            }
            if(countdown >135)
            {
                orbs2[i].drawOrb1(g);
                orbs2[i].act(WIDTH, HEIGHT);
                i++;
            }
            if(countdown >140)
            {
                orbs2[i].drawOrb1(g);
                orbs2[i].act(WIDTH, HEIGHT);
                i++;
            }
            if(countdown >145)
            {
                orbs2[i].drawOrb1(g);
                orbs2[i].act(WIDTH, HEIGHT);
                i++;
            }
            if(countdown >150)
            {
                orbs2[i].drawOrb1(g);
                orbs2[i].act(WIDTH, HEIGHT);
                i++;
            }
            if(countdown >155)
            {
                orbs2[i].drawOrb1(g);
                orbs2[i].act(WIDTH, HEIGHT);
                i++;
            }
            if(countdown >160)
            {
                orbs2[i].drawOrb1(g);
                orbs2[i].act(WIDTH, HEIGHT);
                i++;
            }
            if(countdown >165)
            {
                orbs2[i].drawOrb1(g);
                orbs2[i].act(WIDTH, HEIGHT);
                i++;
            }
            if(countdown >170)
            {
                orbs2[i].drawOrb1(g);
                orbs2[i].act(WIDTH, HEIGHT);
                i++;
            }
            if(countdown >175)
            {
                orbs2[i].drawOrb1(g);
                orbs2[i].act(WIDTH, HEIGHT);
                i++;
            }
            if(countdown >180)
            {
                orbs2[i].drawOrb1(g);
                orbs2[i].act(WIDTH, HEIGHT);
                i++;
            }
            if(countdown >185)
            {
                orbs2[i].drawOrb1(g);
                orbs2[i].act(WIDTH, HEIGHT);
                i++;
            }
            if(countdown >190)
            {
                orbs2[i].drawOrb1(g);
                orbs2[i].act(WIDTH, HEIGHT);
                i++;
            }
            if(countdown >195)
            {
                orbs2[i].drawOrb1(g);
                orbs2[i].act(WIDTH, HEIGHT);
                i++;
            }
            if(countdown >200)
            {
                orbs2[i].drawOrb1(g);
                orbs2[i].act(WIDTH, HEIGHT);
                i++;
            }
            if(countdown >205 && countdown <= 230)
            {
                g.setFont(default2);
                g.setColor(Color.red);
                g.drawString("Good Luck :)", 500, 50);
            }
            if(countdown >240)
            {
                orbs22[j].drawOrb1(g);
                orbs22[j].act(WIDTH, HEIGHT);
                j++;
            }
            if(countdown >245)
            {
                orbs22[j].drawOrb1(g);
                orbs22[j].act(WIDTH, HEIGHT);
                j++;
            }
            if(countdown >250)
            {
                orbs22[j].drawOrb1(g);
                orbs22[j].act(WIDTH, HEIGHT);
                j++;
            }
            if(countdown >255)
            {
                orbs22[j].drawOrb1(g);
                orbs22[j].act(WIDTH, HEIGHT);
                j++;
            }
            if(countdown >260)
            {
                orbs22[j].drawOrb1(g);
                orbs22[j].act(WIDTH, HEIGHT);
                j++;
            }
            if(countdown >265)
            {
                orbs22[j].drawOrb1(g);
                orbs22[j].act(WIDTH, HEIGHT);
                j++;
            }
            if(countdown >270)
            {
                orbs22[j].drawOrb1(g);
                orbs22[j].act(WIDTH, HEIGHT);
                j++;
            }
            if(countdown >275)
            {
                orbs22[j].drawOrb1(g);
                orbs22[j].act(WIDTH, HEIGHT);
                j++;
            }
            if(countdown >280)
            {
                orbs22[j].drawOrb1(g);
                orbs22[j].act(WIDTH, HEIGHT);
                j++;
            }
            if(countdown >285)
            {
                orbs22[j].drawOrb1(g);
                orbs22[j].act(WIDTH, HEIGHT);
                j++;
            }
            if(countdown >290)
            {
                orbs22[j].drawOrb1(g);
                orbs22[j].act(WIDTH, HEIGHT);
                j++;
            }
            if(countdown >295)
            {
                orbs22[j].drawOrb1(g);
                orbs22[j].act(WIDTH, HEIGHT);
                j++;
            }
            if(countdown >300)
            {
                orbs22[j].drawOrb1(g);
                orbs22[j].act(WIDTH, HEIGHT);
                j++;
            }
            if(countdown >305)
            {
                orbs22[j].drawOrb1(g);
                orbs22[j].act(WIDTH, HEIGHT);
                j++;
            }
            if(countdown > 310 && countdown < 330)
            {
                g.setFont(default2);
                g.setColor(Color.red);
                g.drawString("HERE'S THE KITCHEN SINK", 400, 50);
            }
            if(countdown > 330)
            {
                mobs2[k].drawMob(g);
                mobs2[k].walking(mainChar1);
                k++;
            }
            if(countdown > 340)
            {
                mobs2[k].drawMob(g);
                mobs2[k].walking(secretChar);
                k++;
            }
            if(countdown > 350)
            {
                mobs2[k].drawMob(g);
                mobs2[k].walking(mainChar1);
                k++;
            }
            if(countdown > 360)
            {
                mobs2[k].drawMob(g);
                mobs2[k].walking(secretChar);
                k++;
            }
            if(countdown > 370)
            {
                mobs2[k].drawMob(g);
                mobs2[k].walking(mainChar1);
                k++;
            }
            if(countdown > 380)
            {
                mobs2[k].drawMob(g);
                mobs2[k].walking(secretChar);
                k++;
            }
            if(countdown > 390 && countdown <= 410)
            {
                g.setFont(default2);
                g.setColor(Color.RED);
                g.drawString("You'll never win. This is infinite :)", 250, 50);
            }
            
            
        }
    

    }
    public void loop()
    {
        currentTime = System.currentTimeMillis()-startTime;
        if(inTutorial)
        {
            int i = 0;                                                          //colliding balls
            while(i<orbs.length)                                                //important in loop
            {
                if(orbs[i].collide(mainChar1) == true)
                {
                    mainChar1.setHealth(mainChar1.gethealth()-orbs[i].getDamage());
                }            
                i++;
            }           
           
            
            //attempting movement again
            //and it works C:                                                   //Smooth movement :D
            if(upm)
            {
                mainChar1.setrY(mainChar1.getrY()-mainChar1.getvY()) ;
            }
            if(downm)
            {
                mainChar1.setrY(mainChar1.getrY()+mainChar1.getvY());
            }
            if(leftm)
            {
                mainChar1.setrX(mainChar1.getrX()-mainChar1.getvX());
            }
            if(rightm)
            {
                mainChar1.setrX(mainChar1.getrX()+mainChar1.getvX());
            }
            
            
            
            if(mainChar1.gethealth() <= 0)
            {
                gameOver= true;
                inTutorial = false;
                inMenu = false;
            }
            
            
        }
        if(inLevel1)
        {                               //O*O   Time
            /*
            //mainChar1.orbs[onOrbNum].setX(mainChar1.getCenterX());
            //mainChar1.orbs[onOrbNum].setY(mainChar1.getCenterY());
            /*
            mainChar1.orbs[onOrbNum].casting();
            if(mainChar1.orbs[onOrbNum].existing(WIDTH, HEIGHT) == true);
            {
                onOrbNum++;
            }
            */
            
            int i = 0;                                                          //colliding balls
            while(i<orbs.length)                                                //important in loop
            {
                if(orbs[i].collide(mainChar1) == true)
                {
                    mainChar1.setHealth(mainChar1.gethealth()-1);
                }            
                i++;
            }    
            
            i = 0;                                                          //colliding balls
            while(i<orbs1.length)                                                //important in loop
            {
                if(orbs1[i].collide(mainChar1) == true)
                {
                    mainChar1.setHealth(mainChar1.gethealth()-orbs1[i].getDamage());
                }            
                i++;
            }           
            
            i = 0;                                                          //colliding balls
            while(i<orbs11.length)                                                //important in loop
            {
                if(orbs11[i].collide(mainChar1) == true)
                {
                    mainChar1.setHealth(mainChar1.gethealth()-orbs11[i].getDamage());
                }            
                i++;
            }    
            
            if(mobs[0].altAttack(mainChar1) == true)                                   //mob attack
            {
                mainChar1.setHealth(mainChar1.gethealth()-1);
            }
                        
            
            //attempting movement again
            //and it works C:                                                   //Smooth movement :D
            if(upm)
            {
                mainChar1.setrY(mainChar1.getrY()-mainChar1.getvY()) ;
            }
            if(downm)
            {
                mainChar1.setrY(mainChar1.getrY()+mainChar1.getvY());
            }
            if(leftm)
            {
                mainChar1.setrX(mainChar1.getrX()-mainChar1.getvX());
            }
            if(rightm)
            {
                mainChar1.setrX(mainChar1.getrX()+mainChar1.getvX());
            }
            
            if(mainChar1.gethealth() <= 0)
            {
                gameOver= true;
                inLevel1 = false;
                inMenu = false;
            }
        }
        if(inLevel2)
        {
            int i = 0;                                                          //colliding balls
            while(i<orbs2.length)                                                //important in loop
            {
                if(orbs2[i].collide(mainChar1) == true)
                {
                    mainChar1.setHealth(mainChar1.gethealth()-orbs2[i].getDamage());
                }            
                i++;
            }      
            i = 0;                                                          //colliding balls
            while(i<orbs.length)                                                //important in loop
            {
                if(orbs2[i].collide(secretChar) == true)
                {
                    secretChar.setHealth(secretChar.gethealth()-orbs2[i].getDamage());
                }            
                i++;
            }      
            
            i = 0;                                                          //colliding balls
            while(i<orbs22.length)                                                //important in loop
            {
                if(orbs22[i].collide(mainChar1) == true)
                {
                    mainChar1.setHealth(mainChar1.gethealth()-orbs22[i].getDamage());
                }            
                i++;
            }    
            
            i = 0;                                                          //colliding balls
            while(i<orbs22.length)                                                //important in loop
            {
                if(orbs22[i].collide(secretChar) == true)
                {
                    secretChar.setHealth(secretChar.gethealth()-orbs22[i].getDamage());
                }            
                i++;
            }      

            i = 0;
            while(i<mobs2.length)
            {
                if(mobs2[i].altAttack(mainChar1) == true)                                   //mob attack
                {
                    mainChar1.setHealth(mainChar1.gethealth()-1);
                }
                i++;
            }
            
            
            i = 0;
            while(i<mobs2.length)
            {
                if(mobs2[i].altAttack(secretChar) == true)                                   //mob attack
                {
                    secretChar.setHealth(secretChar.gethealth()-1);
                }
                i++;
            }


            //attempting movement again
            //and it works C:                                                   //Smooth movement :D
            if(upm)
            {
                mainChar1.setrY(mainChar1.getrY()-mainChar1.getvY()) ;
            }
            if(downm)
            {
                mainChar1.setrY(mainChar1.getrY()+mainChar1.getvY());
            }
            if(leftm)
            {
                mainChar1.setrX(mainChar1.getrX()-mainChar1.getvX());
            }
            if(rightm)
            {
                mainChar1.setrX(mainChar1.getrX()+mainChar1.getvX());
            }
            
            
            if(upms)
            {
                secretChar.setrY(secretChar.getrY()-secretChar.getvY()) ;
            }
            if(downms)
            {
                secretChar.setrY(secretChar.getrY()+secretChar.getvY());
            }
            if(leftms)
            {
                secretChar.setrX(secretChar.getrX()-secretChar.getvX());
            }
            if(rightms)
            {
                secretChar.setrX(secretChar.getrX()+secretChar.getvX());
            }
            
            if(mainChar1.gethealth() <= 0)
            {
                
            }
            
            if(mainChar1.gethealth() <= 0 && secretChar.gethealth() <= 0)
            {
                inLevel2 = false;
                gameOver= true;
                inLevel1 = false;
                inMenu = false;
            }
            
        }
        

        //Do not write below this
        repaint();
    }
    
        public void keyTyped(KeyEvent e)
        {
        }
        public void keyReleased(KeyEvent e)                                            //Smooth movement :D
        {
            int key = e.getKeyCode();
            if(key == 87)
            {
                upm = false;
            }
            if(key == 83)
            {
                downm = false;
            }
            if(key == 65)
            {
                leftm = false;
            }
            if(key == 68)
            {
                rightm = false;
            }
            
            
            if(key == 38)
            {
                upms = false;
            }
            if(key == 40)
            {
                downms = false;
            }
            if(key == 37)
            {
                leftms = false;
            }
            if(key == 39)
            {
                rightms = false;
            }
            
        }
        
        //useless tried to do wasted too much time e.e
        public void mousePressed(MouseEvent e)
        {
            if(inLevel1)
            {
                /*
                double path = slope(mainChar1.getCenterX(),mainChar1.getCenterY(),e.getX(),e.getY());       //attempting to make the orb
                double testing = 0;
                double testing1 = 0;
                if(mainChar1.getCenterX^()-e.getX() > 10 || mainChar1.getCenterX()-e.getX() < -1 )            //move towards the mouse
                {
                    testing = mainChar1.getCenterX()-e.getX();               //trying to make it a plausible speed
                    if(testing>0)
                    {
                        while(testing < 1 || testing > 10)
                        {
                            testing /= 10;
                        }
                    }
                    if(testing < 0)
                    {
                        while(testing > -1 || testing < -10)
                        {
                            testing /= 10;
                        }
                    }
                }
                if(mainChar1.getCenterY()-e.getY() > 10 || mainChar1.getCenterY()-e.getY() < -1)
                {
                    testing1 = mainChar1.getCenterY()-e.getY();
                    if(testing1 > 0)
                    {
                        while(testing1 < 1 || testing1 > 10)
                        {
                            testing1 /= 10;
                        }
                    }
                    if(testing1 < 0)
                    {
                        while(testing1 > -1 || testing1 < -10)
                        {
                            testing1 /= 10;
                        }
                    }
                }
                int anotherone = (int)testing;
                mainChar1.orbs.setX(mainChar1.getrX());
                mainChar1.orbs.setY(mainChar1.getrY());
                
                mainChar1.orbs.setVx(testing);
                mainChar1.orbs.setVy(testing1);
                
                //coding for movement of orbs
                while(mainChar1.orbs.getX() < WIDTH && mainChar1.orbs.getX() > 0 )
                {
                    mainChar1.orbs.setX(mainChar1.orbs.getX() - mainChar1.orbs.getVx());
                }
                while(mainChar1.orbs.getY() < HEIGHT && mainChar1.orbs.getY() > 0)
                {
                    mainChar1.orbs.setY(mainChar1.orbs.getY() - mainChar1.orbs.getVy());
                }
                mainChar1.orbs.act(WIDTH,HEIGHT);
                        */
                
                //double path = slope(mainChar1.getCenterX(),mainChar1.getCenterY(),e.getX(),e.getY()); 
                //double pythag = pythag(mainChar1.getCenterX(), mainChar1.getCenterY());
                //int temp = euclidean(pythag,path);
                //System.out.println(temp);
                
            }
        }
        public void mouseReleased(MouseEvent e)
        {
        }
        public void mouseClicked(MouseEvent e)
        {
            
            if(inStartScreen)
            {                                                  
                if(e.getX()>= ((5*WIDTH)/14) && e.getX()<= ((5*WIDTH)/14) + 100)
                {
                    if(e.getY()>=(HEIGHT/2) && e.getY()<= (HEIGHT/2) + 100)
                    {
                            inTutorial = true;
                            inMenu = false;
                            inStartScreen = false;
                            startTime = System.currentTimeMillis();                                             //O*O   Time
                    }
                }
                
                if(e.getX() >= ((8*WIDTH)/14) && e.getX() <= ((8*WIDTH)/14)+100)             //(8*WIDTH)/14, (HEIGHT/2), 100, 100);
                {
                    if(e.getY() >= (HEIGHT/2) && e.getY()<= (HEIGHT/2)+ 100)
                    {
                        inStartScreen = false;
                        inTutorial = false;
                        inMenu = true;
                    }
                }
                
            }
            if(inTutorial)
            {
                inMenu = false;
                inStartScreen = false;
                inLevel1 = false;
            }
            if(inMenu)
            {
                inStartScreen = false;
                inMenu = true;
                inTutorial = false;
                inLevel1 = false;
                if(e.getX() >=0 && e.getX() <=100)
                {
                    if(e.getY() >= 0 && e.getY() <=100)
                    {
                        inLevel1 = true;
                        inMenu = false;
                        startTime = System.currentTimeMillis();   
                    }
                }
                if(e.getX() >= 200 && e.getX() <= 300)                          //200, 0, 100, 100
                {
                    if(e.getY() >= 0 && e.getY() <= 100)
                    {
                        inLevel2 = true;
                        inMenu = false;
                        inLevel1 = false;
                        startTime = System.currentTimeMillis();  
                    }
                }
            }
            
            if(inLevel1)
            {
                inMenu = false;
                inStartScreen = false;
                inTutorial = false;
            }
            if(inLevel2)
            {
                inLevel2 = true;
                inLevel1 = false;
                inMenu = false;
                inStartScreen = false;
                inTutorial = false;
            }
            if(gameOver)
            {
                if(e.getX() >=500 && e.getX() <=600 )                   ////g.drawRect(500, 400, 100, 50);
                {
                    if(e.getY() >= 400 && e.getY() <= 450)
                    {
                        inTutorial = true;
                        inMenu = false;
                        gameOver = false;
                    }
                }
                if(e.getX() >=650 && e.getX() <=750 )  
                {
                    if(e.getY() >= 400 && e.getY() <= 450)
                    {
                        inMenu = true;
                        gameOver = false;
                        inTutorial = false;
                    }
                }
                if(e.getX() >=800 && e.getX() <=900 )  
                {
                    if(e.getY() >= 400 && e.getY() <= 450)
                    {  
                        System.exit(0);
                    }
                }
            }
        }
        public void mouseEntered(MouseEvent e)
        {
        }
        public void mouseExited(MouseEvent e)
        {
        }
        public void mouseMoved(MouseEvent e)
        {
        }
        public void mouseDragged(MouseEvent e)
        {
        }
        public void start(final int ticks){
        Thread gameThread = new Thread(){
        public void run(){
            while(true){
                loop();
                    try{
                        Thread.sleep(1000 / ticks);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        };
        gameThread.start();
    }

    public double distance(int x1, int y1, int x2, int y2)
    {
        double distance = 0;
        double xdist = Math.pow(x2-x1, 2);
        double ydist = Math.pow(y2-y1, 2);
        distance = Math.sqrt(ydist+xdist);
        return distance;
    }
    
    public double slope(int x1, int y1, int x2, int y2)
    {
        double slope = 0;
        double xcom = x2-x1;
        double ycom = y2-y1;
        slope = ycom/xcom;
        return slope;
    }

    public boolean collisions(MainChar a)                                          
    {                                                                               
        boolean output = false;
        
        for(int i = rX;i <= rX+rW;i++)
        {
            for(int j = rY; j<= rY+rH;j++)
            {
                for(int k = a.getrX(); k <= a.getrX() + a.getrW();k++)
                {
                    for(int l = a.getrY(); l <= a.getrY() + a.getrH(); l++)
                    {
                        if(i == k && j == l)
                        {
                            output = true;
                        }
                    }
                }
            }
        }
        return output;
    }
    
    public static void main(String[] args)
    {
    MokProj8 g = new MokProj8();
    g.start(60);
    }
    
    
    //useless but might add *unlikely*
    public int euclidean(double x, double y)                                //Factoring method
    {
        int first = (int)x;
        int second = (int)y;
        
        int firsttemp = Math.abs(first);
        int secondtemp = Math.abs(second);
        
        while(firsttemp != secondtemp)
        {
            if(firsttemp > secondtemp)
            {
                firsttemp -= secondtemp;
            }
            else
            {
                secondtemp -= firsttemp;
            }
        }
        if(first <0 && second > 0)
        {
            firsttemp *= -1;
            return firsttemp;
        }
        else if(first > 0 && second < 0)
        {
            secondtemp *= -1;
            return secondtemp;
        }
        else
        {
            return firsttemp;
        }
    }
    
    
        
    public double pythag(int x, int y)
    {
        double prod = Math.pow(x, 2) + Math.pow(y, 2);
        prod = Math.sqrt(prod);
        return prod;
    }

}

