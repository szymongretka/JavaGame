import java.awt.image.BufferedImage;

public class SpriteSheet {

    private BufferedImage sprite;

    public SpriteSheet(BufferedImage ss) {
        this.sprite = ss;
    }

    public BufferedImage grabImage(int col, int row, int width, int height)
    {
        BufferedImage img = sprite.getSubimage((col*56) - 56, (row*63) - 63, width, height);
        return img;
    }

}
