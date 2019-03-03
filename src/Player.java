import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject
{
    private Handler handler;
    private GameObject tempObject;

    private BufferedImage player_image;

    public Player(int x, int y, ID id, int hp, Handler handler)
    {
        super(x, y, id, hp);
        this.handler = handler;

        SpriteSheet ss = new SpriteSheet(Main.sprite_sheet);

        player_image = ss.grabImage(1, 1, 63, 56);
    }


    public void Update()
    {
        x += velX;
        y += velY;

        x = Main.Constraint(x, 0, Main.WIDTH - 37);
        y = Main.Constraint(y, 0, Main.HEIGHT - 60);

        collision();
    }


    public void render(Graphics g)
    {
        //g.setColor(Color.white);
        //g.fillRect(x, y, 32, 32);
        g.drawImage(player_image, (int)x, (int)y, null);
    }


    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }

    public void collision()
    {
        for(int i = 0; i < handler.objects.size(); i++)
        {
            tempObject = handler.objects.get(i);


            if(tempObject.getID() != ID.Player && tempObject.getID() != ID.Bullet)
            {
                if(getBounds().intersects(tempObject.getBounds()))
                {
                    HUD.HEALTH -= 1;
                }
            }

        }

    }



}
