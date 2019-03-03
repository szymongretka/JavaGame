import java.awt.*;

public abstract class GameObject
{
    protected int x, y;
    protected ID id;
    protected double velX, velY;
    protected int hp;

    public GameObject(int x, int y, ID id, int hp)
    {
        this.x = x;
        this.y = y;
        this.id = id;
        this.hp = hp;
    }


    public abstract void Update();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();

    public void setX(int x)
    {
        this.x = x;
    }
    public void setY(int y)
    {
        this.y = y;
    }
    public void setID(ID id)
    {
        this.id = id;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public ID getID()
    {
        return id;
    }
    public void setVelX(int velX)
    {
        this.velX = velX;
    }
    public void setVelY(int velY)
    {
        this.velY = velY;
    }
    public double getVelX()
    {
        return velX;
    }
    public double getVelY()
    {
        return velY;
    }
    public void setHP(int hp){ this.hp = hp; }
    public int getHP(){return hp;}

}
