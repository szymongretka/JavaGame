import java.awt.*;

public class Boss1 extends GameObject
{
    private Handler handler;


    public Boss1(int x, int y, ID id, int hp, Handler handler) {
        super(x, y, id, hp);

        velX = 0;
        velY = 5;

        this.handler = handler;
    }

    @Override
    public void Update() {
        x += velX;
        y += velY;


        if(y <= 16 || y >= Main.HEIGHT )
            velY *= -1;
        if(x <= 16 || x >= Main.WIDTH + 16)
            velX *= -1;

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect((int)x, (int)y,  64, 64);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 64, 64);
    }

}
