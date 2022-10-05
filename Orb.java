//Irwin Mok
import java.awt.Color;
import java.awt.Graphics;

public class Orb
{
    private int x;
    private int y;
    private int vx;
    private int vy;
    private int diam;
    private int damage;
    
    public Orb()
    {
        x = 1;
        y = 1;
        vx = 1;
        vy = 1;
        diam = 10;
        damage = 1;
    }
    
    public Orb(int rX, int rY, int vX, int vY, int d, int dam)
    {
        x = rX;
        y = rY;
        vx = vX;
        vy = vY;
        diam = d;
        damage = dam;
    }
    
    public void drawOrb(Graphics g)
    {
        g.setColor(Color.black);
        g.drawOval(x, y, diam, diam);
    }
    public void drawRandomOrb(Graphics g)
    {
        g.setColor(Color.black);
        g.drawOval((int)(Math.random()*1348 +1), (int)(Math.random()*698 +1),diam,diam);
        vx = 1;
        vy = 1;
    }
    public void drawOrbPos(Graphics g, int newx, int newy)
    {
        g.setColor(Color.black);
        x = newx;
        y = newy;
        g.drawOval(x, y, diam, diam);
    }
    
    public void drawOrb1(Graphics g)
    {
        g.setColor(Color.BLUE);
        g.drawOval(x, y, diam, diam);
        g.fillOval(x, y, diam, diam);
        g.setColor(Color.YELLOW);
        g.drawOval(getCenterX()-2, getCenterY()-2, diam/2, diam/2);
    }
    
    
    public void drawCOrb(Graphics g)
    {
        g.setColor(Color.red);
        g.drawOval(x, y, diam, diam);
        g.fillOval(x, y, diam, diam);
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
    
    
    public boolean collide(Mob a)                                           
    {                                                                              
        boolean output = false;
        
        for(int i = x;i <= x+diam;i++)
        {
            for(int j = y; j<= y+diam;j++)
            {
                for(int k = a.getX(); k <= a.getX() + a.getW();k++)
                {
                    for(int l = a.getY(); l <= a.getY() + a.getH(); l++)
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
    
    public boolean collide(MainChar a)                                           
    {                                                                              
        boolean output = false;
        
        for(int i = x;i <= x+diam;i++)
        {
            for(int j = y; j<= y+diam;j++)
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
    
    public void target(MainChar elo)                                       //taken from Mob
    {
        if(x + diam< elo.getrX())
        {
            x +=vx;
        }
        if(x > elo.getrX() + elo.getrW())
        {
            x -=vx;
        }
        if(y + diam< elo.getrY())
        {
            y += vy;
        }
        if(y > elo.getrY() + elo.getrH())
        {
            y -= vy;
        }
    }
    
   
    
    public boolean existing(int w, int h)
    {
        boolean exist = false;
        if(x > 0 && x <w)
        {
            if(y > 0 && y < h)
            {
                exist = true;
            }
        }
        return exist;
    }
    
    
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public int getVx()
    {
        return vx;
    }
    public int getVy()
    {
        return vy;
    }
    public int getDiam()
    {
        return diam;
    }
    public int getDamage()
    {
        return damage;
    }

    public int getCenterX()
    {
        int getCenterX = x + diam/2;
        return getCenterX;
    }
    public int getCenterY()
    {
        int getCenterY = y + diam/2;
        return getCenterY;
    }
    
    
    public void setX(int xcor)
    {
        x = xcor;
    }
    public void setY(int ycor)
    {
        y = ycor;
    }
    public void setVx(int xlocit)
    {
        vx = xlocit;
    }
    public void setVy(int ylocit)
    {
        vy = ylocit;
    }
    public void setVx(double xlocit)
    {
        vx = (int)xlocit;
    }
    public void setVy(double ylocit)
    {
        vy = (int)ylocit;
    }
    public void setDamage(int dam)
    {
        damage = dam;
    }

    
    public void act(int w, int h)
    {
        //get the next x and y coordinates
        int nextX,nextY;
        nextX = x + vx;
        nextY = y + vy;
        //if-statements to handle the Bubble bouncing off of the 4 walls
        if(nextX + diam > w)
        {
            vx *= -1;
        }
        if(nextY + diam > h)
        {
            vy *= -1;
        }
        if(nextX < 0)
        {
            vx *= -1;
        }
        if(nextY < 0)
        {
            vy *=-1;
        }
        //updating x and y
        x =  x+vx;
        y =  y+vy;
    }
    
    public void casting(int w, int h)
    {
        int nextX,nextY;
        x =  x+vx;
        y =  y+vy;
    }
    
        
    
    
    
    
}