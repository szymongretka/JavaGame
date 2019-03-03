import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import javax.swing.JFrame;


public class Window extends Canvas
{

    public Window(int width, int height, String title, Main game)
    {
        JFrame frame = new JFrame(title);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setResizable(false);

        frame.add(game);
        frame.setVisible(true);
        game.Start();

    }

}
