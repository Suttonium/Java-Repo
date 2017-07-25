package SpaceInvaders;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class SImissile extends SIthing {

    public SImissile(int x, int y) {
        super(x, y);
    }

    public void moveDown() {
        y += 5;
    }

    public void moveUp() {
        y -= 5;
    }

    @Override
    public void paintMe(Graphics2D g2) {
        Rectangle2D.Double r = new Rectangle2D.Double(x, y, 2, 10);
        g2.setColor(Color.WHITE);
        g2.fill(r);
    }
}
