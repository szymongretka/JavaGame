import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Main extends Canvas implements Runnable
{
    public enum STATE
    {
        Menu,
        Shop,
        Game;
    }

    public STATE gameState = STATE.Menu;
    public static BufferedImage sprite_sheet;

    private Thread thread;
    private boolean running = false;
    public static boolean paused = false;

    private Handler handler;
    private HUD hud;
    private Spawn spawner;
    private Menu menu;
    private Shop shop;

    public static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int WIDTH = (int) screenSize.getWidth();
    public static final int HEIGHT = (int) screenSize.getHeight();

    public Main()
    {
        handler = new Handler();
        hud = new HUD(handler);
        spawner = new Spawn(handler, hud);

        menu = new Menu(this, handler);
        shop = new Shop(this, handler, hud);


        AudioPlayer.load();
        //AudioPlayer.getMusic("music").loop();

        new Window(WIDTH, HEIGHT, "Let's roll", this);

        BufferedImageLoader loader = new BufferedImageLoader();
        sprite_sheet = loader.loadImage("res/spaceship.png");

        this.addKeyListener(new KeyHandler(handler, this));
        this.addMouseListener(shop);
        this.addMouseListener(menu);
        this.setFocusable(true);


    }
    public synchronized void Start()
    {
        Thread thread = new Thread(this);
        thread.start();
        running = true;
    }
    public synchronized void Stop()
    {
        try
        {
            thread.join();
            running = false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
    private void Update()
    {

        if(gameState == STATE.Game)
        {
            if(!paused)
            {
                handler.Up();
                hud.Update();
                spawner.Update();
            }

        } else {
            //new Menu();
        }
    }

    public void run()
    {

        long lastTime = System.nanoTime();
        double amountOfTics = 60.0;
        double ns = 1000000000 / amountOfTics;
        double delta = 0;

        while(running)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1)
            {
                Update();
                delta--;
            }
            if(running)
            {
                render();
            }
        }
        Stop();

    }

    private void render()
    {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null)
        {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        //handler.render(g);

        if(paused)
        {
            g.drawString("Paused", 100, 100);
        }

        if(gameState == STATE.Game)
        {
            handler.render(g);
            hud.render(g);
        } else if(gameState == STATE.Menu) {
            handler.render(g);
            menu.render(g);
        } else if(gameState == STATE.Shop)
        {
            shop.render(g);
        }

        g.dispose();
        bs.show();
    }


    public static int Constraint(int var, int min, int max)
    {
        if(var >= max) {
            var = max;
            return var;
        }
        else if(var <= min) {
            var = min;
            return var;
        }
        else
            return var;

    }


    public static void main(String[] args)
    {
        new Main();
    }



}