package SpaceInvaders;

import java.awt.Graphics2D;
import java.awt.Image;

@SuppressWarnings("unused")
public class SImiddle extends SIinvader {
    private Image image1;
    private int score;

    public SImiddle(int x, int y) {
        super(x, y);
        score = 20;
        setImage(getImage("SImiddle0.gif"));
        image1 = getImage("SImiddle1.gif");
    }

    @Override
    public void paintMe(Graphics2D g2) {
        g2.drawImage(shipImage, x, y, null);
    }

    public int getScore() {
        return score;
    }

    public void moveXRightBy(int delta) {
        x += delta;
    }

    public void moveXLeftBy(int delta) {
        x -= delta;
    }
}
