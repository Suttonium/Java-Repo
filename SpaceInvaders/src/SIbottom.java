import java.awt.Graphics2D;
import java.awt.Image;

@SuppressWarnings("unused")
public class SIbottom extends SIinvader {
    private Image image1;
    private int score;

    public SIbottom(int x, int y) {
        super(x, y);
        score = 10;
        setImage(getImage("SIbottom0.gif"));
        image1 = getImage("SIbottom1.gif");
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

    public void moveYBy(int delta) {
        y += delta;
    }
}