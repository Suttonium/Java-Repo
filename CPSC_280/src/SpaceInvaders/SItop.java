package SpaceInvaders;

import java.awt.Graphics2D;

public class SItop extends SIinvader {
    private int score;

    public SItop(int x, int y) {
        super(x, y);
        score = 30;
        setImage(getImage("SItop0.gif"));
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
