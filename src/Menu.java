import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends MouseAdapter {

    private Main main;
    private Handler handler;


    public Menu(Main main, Handler handler)
    {
        this.main = main;

        this.handler = handler;
    }

    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        //play button
        if (selectedMenu(mouseX, mouseY, 210, 150, 200, 64))
        {
            main.gameState = Main.STATE.Game;

            if(main.gameState == Main.STATE.Game)
            {
                handler.addObject(new Player(100, 100, ID.Player, 10, handler));
                handler.addObject(new BasicEnemy(100, 100, ID.BasicEnemy, 2, handler));
            }
        }

        //quit button
        if (selectedMenu(mouseX, mouseY, 210, 350, 200, 64))
        {
            System.exit(1);
        }
    }
    /*public void mouseReleased(MouseEvent e)
    {

    }*/

    private boolean selectedMenu(int mouseX, int mouseY, int x, int y, int width, int height)
    {
        if(mouseX > x && mouseX < x + width) {
            if (mouseY > y && mouseY < y + height) {
                return true;
            }else
                return false;
        } else
            return false;

    }

    public void Update()
    {

    }
    public void render(Graphics g)
    {
        Font font = new Font("arial", 1 , 50);
        Font font2 = new Font("arial", 1 , 30);

        g.setFont(font);
        g.setColor(Color.white);
        g.drawString("Menu", 240, 70);

        g.setFont(font2);
        g.drawRect(210, 150, 200, 64);
        g.drawString("Play", 270, 190);

        g.drawRect(210, 250, 200, 64);
        g.drawString("Options", 270, 290);

        g.drawRect(210, 350, 200, 64);
        g.drawString("Exit", 270, 390);



    }

}

