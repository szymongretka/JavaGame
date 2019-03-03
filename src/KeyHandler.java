import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyHandler extends KeyAdapter
{
    private  boolean keyPressed[] = new boolean[4];

    private Handler handler;
    private GameObject tempObject;
    private Main main;
    private Player player;

    public KeyHandler(Handler handler, Main main)
    {
        keyPressed[0] = false;
        keyPressed[1] = false;
        keyPressed[2] = false;
        keyPressed[3] = false;

        this.handler = handler;
        this.main = main;
    }


    public void keyPressed(KeyEvent evt)
    {
        int keyCode = evt.getKeyCode();

        for(int i = 0; i < handler.objects.size(); i++)
        {
            tempObject = handler.objects.get(i);

            if(tempObject.getID() == ID.Player)
            {
                if(keyCode == KeyEvent.VK_D) {tempObject.setVelX(5);  keyPressed[0] = true;}
                if(keyCode == KeyEvent.VK_A) {tempObject.setVelX(-5);  keyPressed[1] = true;}
                if(keyCode == KeyEvent.VK_W) {tempObject.setVelY(-5);  keyPressed[2] = true;}
                if(keyCode == KeyEvent.VK_S) {tempObject.setVelY(5);  keyPressed[3] = true;}
                if(keyCode == KeyEvent.VK_SPACE && !main.paused) {
                    handler.addObject(new Bullet(tempObject.getX() + 25, tempObject.getY(), ID.Bullet, 1, handler));
                    AudioPlayer.getSound("sound").play();
                }
            }

        }

        if(keyCode == KeyEvent.VK_P) {
            if(Main.paused)
                Main.paused = false;
            else
                Main.paused = true;
        }
        if(keyCode == KeyEvent.VK_C)
        {
            if(main.gameState == Main.STATE.Game)
                main.gameState = Main.STATE.Shop;
            else if(main.gameState == Main.STATE.Shop)
                main.gameState = Main.STATE.Game;
        }

    }

    public void keyReleased(KeyEvent evt)
    {
        int keyCode = evt.getKeyCode();

        for(int i = 0; i < handler.objects.size(); i++)
        {
            tempObject = handler.objects.get(i);

            if(tempObject.getID() == ID.Player)
            {
                if(keyCode == KeyEvent.VK_D) keyPressed[0] = false;
                if(keyCode == KeyEvent.VK_A) keyPressed[1] = false;
                if(keyCode == KeyEvent.VK_W) keyPressed[2] = false;
                if(keyCode == KeyEvent.VK_S) keyPressed[3] = false;
                if(!keyPressed[0] && !keyPressed[1])
                    tempObject.setVelX(0);
                if(!keyPressed[2] && !keyPressed[3])
                    tempObject.setVelY(0);
            }

        }
    }


}
