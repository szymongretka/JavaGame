import java.awt.*;

public class BasicEnemy extends GameObject
{
    private Handler handler;
    //public static int BASICENEMY_HEALTH = 2;
    private GameObject tempObject;



    public BasicEnemy(int x, int y, ID id, int hp, Handler handler) {
        super(x, y, id, hp);

        velX = 3;
        velY = 3;

        this.handler = handler;
    }

    @Override
    public void Update() {
        x += velX;
        y += velY;

        collision();

        if(y <= 16 || y >= Main.HEIGHT )
            velY *= -1;
        if(x <= 16 || x >= Main.WIDTH + 16)
            velX *= -1;

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y,  16, 16);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 16, 16);
    }


    public void collision() {
        for (int i = 0; i < handler.objects.size(); i++) {
            tempObject = handler.objects.get(i);

            if(tempObject.getID() == ID.Bullet){
                if(getBounds().intersects(tempObject.getBounds())){
                    handler.removeObject(tempObject);
                }
            }

        }
    }

}
