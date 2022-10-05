//Irwin Mok
import java.awt.Color;
import java.awt.Graphics;

public class Mob
{
    private int x;
    private int y;
    private int w;
    private int h;
    private int vx;
    private int vy;
    private int health;
    
    
    public Mob()
    {
        x = 900;
        y = 400;
        w = 10;
        h = 10;
        vx = 1;
        vy = 1;
    }
    
    public Mob(int rx, int ry, int rw, int rh, int VX, int VY)
    {
        x = rx;
        y = ry;
        w = rw;
        h = rh;
        vx = VX;
        vy = VY;
    }
    
    public void tracking(MainChar elo)
    {
        double xcor = elo.getCenterX() - getCenterX();
        double ycor = elo.getCenterY() - getCenterY();
        vx = (int)xcor;
        vy = (int)ycor;
    }
    
    public void walking(MainChar elo)
    {
        if(x + w< elo.getrX())
        {
            x += vx;
        }
        if(x > elo.getrX() + elo.getrW())
        {
            x -= vx;
        }
        if(y + h< elo.getrY())
        {
            y += vy;
        }
        if(y > elo.getrY() + elo.getrH())
        {
            y -= vy;
        }
    }
    
    public void drawMob(Graphics g)
    {
        g.setColor(Color.RED);
        /*
        int tempx,tempy;
        int flip = (int)Math.random()*2;
        int flip2 = (int)Math.random()*2;
        if(flip == 0)
        {
            tempx = (int)Math.random()*(-50) - 5;
        }
        else
        {
            tempx = (int)Math.random()*(50) + 1350;
        }
        if(flip2 == 0)
        {
            tempy = (int)Math.random()*(-50) - 5;
        }
        else
        {
            tempy = (int)Math.random()*(50) + 700;
        }
        */
        g.fillRect(x, y, w, h);
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
    
    
    public boolean altAttack(MainChar a)                                            //I FINALLY PULLED IT OFF
    {                                                                               //ATTACK METHOD
        boolean output = false;
        
        for(int i = x;i <= x+w;i++)
        {
            for(int j = y; j<= y+h;j++)
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
    
        
    
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public int getW()
    {
        return w;
    }
    public int getH()
    {
        return h;
    }
    public int getCenterX()
    {
        int getCenterX = x + w/2;
        return getCenterX;
    }
    public int getCenterY()
    {
        int getCenterY = y + h/2;
        return getCenterY;
    }
    
    
    public void setX(int X)
    {
        x = X;
    }
    public void setY(int Y)
    {
        y = Y;
    }
    public void setW(int W)
    {
        w = W;
    }
    public void setH(int H)
    {
        h = H;
    }
    public void setVx(int VX)
    {
        vx = VX;
    }
    public void setVy(int VY)
    {
        vy = VY;
    }

    
}