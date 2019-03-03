import java.awt.*;

public class OtherEnemy extends GameObject
{
    private Handler handler;
    private GameObject player;

    public OtherEnemy(int x, int y, ID id, int hp, Handler handler) {
        super(x, y, id, hp);

        this.handler = handler;

        for(int i = 0; i < handler.objects.size(); i++)
            if(handler.objects.get(i).getID() == ID.Player){player = handler.objects.get(i);}

    }

    @Override
    public void Update() {

        float diffX = (x - player.getX() - 8);
        float diffY = (y - player.getY() - 8);
        float distance = (float) Math.sqrt((x - player.getX())*(x - player.getX()) + (y - player.getY())*(y - player.getY()));

        velX = (int) ((-1/distance)*diffX);
        velY = (int) ((-1/distance)*diffY);

        x += velX;
        y += velY;

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillRect((int)x, (int)y,  16, 16);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 16, 16);
    }

}

