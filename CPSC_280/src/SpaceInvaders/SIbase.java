package SpaceInvaders;

import java.awt.Graphics2D;

public class SIbase extends SIship {

    public SIbase(int x, int y) {
        super(x, y);
        setX(x);
        setY(y);
        setImage(getImage("SIbase.gif"));
        setSound(getSound("SIbaseShoot.wav"));
        explosionImage = getImage("SIbaseBlast.gif");
        explosionSound = getSound("SIshipHit.wav");
    }

    @Override
    public void paintMe(Graphics2D g2) {
        g2.drawImage(shipImage, x, y, null);
    }

    public void moveXBy(int delta) {
        x += delta;
    }

    public void playShootSound() {
        getSound("SIbaseShoot.wav").play();
    }

    public void playBaseBlastSound() {
        getSound("SIshipHit.wav").play();
    }
}
