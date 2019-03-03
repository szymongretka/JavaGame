import java.awt.*;

public class HUD
{
    private Handler handler;
    public static int HEALTH = 100;

    private int score = 0;
    private int level = 1;
    private int n = 1;

    public HUD(Handler handler)
    {
        this.handler = handler;
    }


    public void Update()
    {
        HEALTH = Main.Constraint(HEALTH, 0, 100);
        score++;

        if(score >= n*100)
        {
            //setScore(0);
            setLevel(getLevel() + 1);
            n++;
        }
    }

    public void render(Graphics g)
    {
        g.setColor(Color.gray);
        g.fillRect(15, 15, 200, 32);
        g.setColor(Color.green);
        g.fillRect(15, 15, HEALTH*2, 32);
        g.setColor(Color.white);
        g.drawRect(15, 15, 200, 32);

        g.drawString("Score: " + score, 10, 64);
        g.drawString("Level: " + level, 10, 80);
        g.drawString("Press C for shop: ", 15, 94);
    }

    public void setScore(int score)
    {
        this.score = score;
    }
    public int getScore()
    {
        return score;
    }
    public void setLevel(int level)
    {
        this.level = level;
    }
    public int getLevel()
    {
        return level;
    }

}
