package SpaceInvaders;

import java.awt.Graphics2D;
import java.awt.Image;

public abstract class SIinvader extends SIship {
    private Image invaderBlast;

    public SIinvader(int x, int y) {
        super(x, y);
        invaderBlast = getImage("SIinvaderBlast.gif");
    }

    public void playBlastSound() {
        getSound("SIshipHit.wav").play();
    }

    public void playInvaderShootSound() {
        getSound("SIbaseShoot.wav").play();
    }

    public void paintInvaderBlast(Graphics2D g2) {
        g2.drawImage(invaderBlast, x, y, null);
    }

    public abstract int getScore();

}
