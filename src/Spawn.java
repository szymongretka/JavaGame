import java.util.Random;

public class Spawn
{
    private Handler handler;
    private HUD hud;
    private Random random = new Random();
    private int scoreKeep = 0;
    private Main main;

    public Spawn(Handler handler, HUD hud)
    {
        this.handler = handler;
        this.hud = hud;

    }

    public void Update()
    {
        scoreKeep++;


        if(scoreKeep >= 100) {

            scoreKeep = 0;
            //hud.setLevel(hud.getLevel() + 1);


            if (hud.getLevel() == 3) {
                handler.addObject(new BasicEnemy(100, 100, ID.BasicEnemy, 2, handler));

            }
            if (hud.getLevel() == 5) {
                handler.addObject(new BasicEnemy(100, 100, ID.BasicEnemy, 2, handler));

            }

            if (hud.getLevel() == 10) {
                handler.addObject(new Boss1(100, 100, ID.BasicEnemy, 10, handler));

            }

        }
    }
}
