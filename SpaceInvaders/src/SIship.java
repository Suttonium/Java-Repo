import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics2D;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public abstract class SIship extends SIthing {
    protected AudioClip explosionSound;
    protected AudioClip shootSound;
    protected Image explosionImage;
    protected Image shipImage;

    public SIship(int x, int y) {
        super(x, y);
        explosionSound = getSound("SIshipHit.wav");
    }

    public void paintMe(Graphics2D g2) {
        g2.drawImage(shipImage, getX(), getY(), null);
    }

    public AudioClip getSound(String name) {
        URL file = getClass().getResource(name);
        return Applet.newAudioClip(file);
    }

    public Image getImage(String image) {
        URL file = getClass().getResource(image);
        ImageIcon icon = new ImageIcon(file);
        return icon.getImage();
    }

    public void setImage(Image image) {
        this.shipImage = image;
    }

    public void setSound(AudioClip sound) {
        this.explosionSound = sound;
    }
}