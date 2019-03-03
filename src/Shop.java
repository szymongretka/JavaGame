import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

public class Shop implements MouseListener {

    private Handler handler;
    private Main main;
    private HUD hud;

    private int B1 = 300;
    private int B2 = 500;

    public Shop(Main main, Handler handler, HUD hud){


        this.handler = handler;
        this.main = main;
        this.hud = hud;

    }

    public void render(Graphics g)
    {
        g.setColor(Color.white);
        g.setFont(new Font("arial", 0, 48));
        g.drawString("SHOP", Main.WIDTH/2 - 100, 50);

        //box1
        g.setFont(new Font("arial", 0, 12));
        g.drawString("Upgrade health", 110, 120);
        g.drawString("Cost: " + B1, 110, 140);
        g.drawRect(100, 100, 100, 80);

        //box2
        g.drawString("Upgrade rate of fire!!", 260, 120);
        g.drawString("Cost: " + B2, 260, 140);
        g.drawRect(250, 100, 100, 80);

        //box3
        g.drawString("go back", 410, 120);
        g.drawRect(400, 100, 100, 80);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        //box 1
        if (selected(mouseX, mouseY, 100, 100, 100, 80))
        {
            if(hud.getScore() >= B1)
            {
                hud.setScore(hud.getScore() - B1);
            }
        }
        //box 2
        if (selected(mouseX, mouseY, 250, 100, 100, 80))
        {
            if(hud.getScore() >= B2)
            {
                hud.setScore(hud.getScore() - B2);
                Bullet.rateOfFire += 100;
            }
        }
        //box 3
        if (selected(mouseX, mouseY, 400, 100, 100, 80))
        {
            main.gameState = Main.STATE.Game;
        }


    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    private boolean selected(int mouseX, int mouseY, int x, int y, int width, int height)
    {
        if(mouseX > x && mouseX < x + width) {
            if (mouseY > y && mouseY < y + height) {
                return true;
            }else
                return false;
        } else
            return false;

    }

}
