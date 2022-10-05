//Irwin Mok

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

public class MainChar
{
    private int rX;
    private int rY;
    private int rW;
    private int rH;  
    private int vx;
    private int vy;
    private int health;

    
    
    public MainChar()
    {
        rX = 675;
        rY = 350;
        rW = 10;
        rH = 10;
        vx = 3;
        vy = 3;
        health = 100;

    }
    
    public void drawMainChar(Graphics g)
    {
        g.setColor(Color.PINK);                             //add color customization
        g.fillRect(rX,rY,rW,rH);
        
        
        g.setColor(Color.gray);
        g.drawRect(rX-12, rY - 11, health/3, 9);
        g.fill3DRect(rX -12, rY-11, health/3, 9, true);
        
        Font defal = new Font("Arial", Font.BOLD, 10);
        g.setFont(defal);
        g.setColor(Color.BLACK);
        g.drawString(health + "", rX-4  , rY - 3);        //fix
                
    }
    
    public double distance(int x1, int y1, int x2, int y2)
    {
        double distance;
        double totalX = x2 - x1;
        double powOfX = Math.pow(totalX, 2);
        double totalY = y2 - y1;
        double powOfY = Math.pow(totalY, 2);
        distance = powOfX + powOfY;
        distance = Math.sqrt(distance);
        return distance;
    }
    
    public int getrX()
    {
        return rX;
    }
    public int getrY()
    {
        return rY;
    }
    public int getrW()
    {
        return rW;
    }
    public int getrH()
    {
        return rH;
    }
    public int getvX()
    {
        return vx;
    }
    public int getvY()
    {
        return vy;
    }
    public int gethealth()
    {
        return health;
    }
    public int getCenterX()
    {
        int getCenterX = rX + rW/2;
        return getCenterX;
    }
    public int getCenterY()
    {
        int getCenterY = rY + rH/2;
        return getCenterY;
    }
    
    
    
    public void setrX(int x)
    {
        rX = x;
    }
    public void setrY(int y)
    {
        rY = y;
    }
    public void setrW(int w)
    {
        rW = w;
    }
    public void setrH(int h)
    {
        rH = h;
    }
    public void setvX(int vX)
    {
        vx = vX;
    }
    public void setvY(int vY)
    {
        vy = vY;
    }
    public void setHealth(int he)
    {
        health = he;
    }
    
}
        