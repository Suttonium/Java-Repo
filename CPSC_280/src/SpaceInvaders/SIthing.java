package SpaceInvaders;

import java.awt.Graphics2D;

public abstract class SIthing {
    protected int x;
    protected int y;

    public SIthing(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void paintMe(Graphics2D g2);

    public void moveXBy(int delta) {
        x += delta;

    }

    public void moveYBy(int delta) {
        y += delta;

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
