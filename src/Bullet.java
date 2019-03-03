import java.awt.*;

public class Bullet extends GameObject {

    public static int rateOfFire = 100;
    private Handler handler;
    GameObject tempObject;


    public Bullet(int x, int y, ID id, int hp, Handler handler) {
        super(x, y, id, hp);
        velY = -8;
        this.handler = handler;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }

    @Override
    public void Update() {

        y += velY;

        collision();

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(x, y,  10, 10);
    }

    public void collision(){
        for(int i = 0; i < handler.objects.size(); i++)
        {
            tempObject = handler.objects.get(i);

            if(tempObject.getID() == ID.Bullet) {
                if(tempObject.getY() <= 0 || tempObject.getY() >= Main.HEIGHT) {
                    handler.removeObject(tempObject);
                }

            }
            if(tempObject.getID() != ID.Player && tempObject.getID() != ID.Bullet) {
                if(getBounds().intersects(tempObject.getBounds())) {
                    tempObject.setHP(getHP() - 1);
                }
                if(tempObject.getHP() == 0){
                    handler.removeObject(tempObject);
                }
            }
        }
    }
}
