import java.awt.Graphics2D;
import java.util.Random;

public class SImystery extends SIinvader {
    private int score;

    public SImystery(int x, int y) {
        super(x, y);
        int[] values = { 50, 100, 150, 300 };
        setImage(getImage("SImystery.gif"));
        Random random = new Random();
        if (random.nextInt(values.length) == 1) {
            score = 50;
        }
        else if (random.nextInt(values.length) == 2) {
            score = 100;
        }
        else if (random.nextInt(values.length) == 3) {
            score = 150;
        }
        else {
            score = 300;
        }
    }

    @Override
    public void paintMe(Graphics2D g2) {
        g2.drawImage(shipImage, x, y, null);
    }

    public void playMysterySound() {
        getSound("SImystery.wav").play();
    }

    public int getScore() {
        return score;
    }

    public void moveRight(int delta) {
        x += delta;
    }

    public void moveLeft(int delta) {
        x -= delta;
    }
}