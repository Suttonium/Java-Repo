import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings({ "serial" })
public class SIPanel extends JPanel {
    private boolean left, right = false;
    private boolean isAtRightEdge;
    private boolean isAtLeftEdge;
    private boolean baseIsAlive;
    private SIbase base;
    private SImissile missile;
    private SImissile alienMissile1;
    private SImissile alienMissile2;
    private SImissile alienMissile3;
    private SImystery mystery;
    private static Timer timer;
    private Integer alienMissilePulse;
    private Integer alienMovementPulse;
    private Integer alienSpriteChangePulse;
    private Integer moveDown;
    private int invaderCount;
    private int score;
    private Font f;
    private ArrayList<SItop> topRow;
    private ArrayList<SImiddle> secondRow;
    private ArrayList<SImiddle> thirdRow;
    private ArrayList<SIbottom> fourthRow;
    private ArrayList<SIbottom> fifthRow;

    private void isWithinRange() {
        for (int i = 0; i < topRow.size(); i++) {
            if (topRow.get(i) != null) {
                if (missile.getX() >= topRow.get(i).getX()
                        && missile.getX() <= topRow.get(i).getX() + 30
                        && missile.getY() >= topRow.get(i).getY()
                        && missile.getY() <= topRow.get(i).getY() + 17) {
                    topRow.get(i).playBlastSound();
                    score += topRow.get(i).getScore();
                    topRow.remove(topRow.get(i));
                    invaderCount--;
                    missile = null;
                    return;
                }
            }
        }
        for (int i = 0; i < secondRow.size(); i++) {
            if (secondRow.get(i) != null) {
                if (missile.getX() >= secondRow.get(i).getX()
                        && missile.getX() <= secondRow.get(i).getX() + 30
                        && missile.getY() >= secondRow.get(i).getY()
                        && missile.getY() <= secondRow.get(i).getY() + 17) {
                    secondRow.get(i).playBlastSound();
                    score += secondRow.get(i).getScore();
                    secondRow.remove(secondRow.get(i));
                    invaderCount--;
                    missile = null;
                    return;
                }
            }
        }
        for (int i = 0; i < thirdRow.size(); i++) {
            if (thirdRow.get(i) != null) {
                if (missile.getX() >= thirdRow.get(i).getX()
                        && missile.getX() <= thirdRow.get(i).getX() + 30
                        && missile.getY() >= thirdRow.get(i).getY()
                        && missile.getY() <= thirdRow.get(i).getY() + 17) {
                    thirdRow.get(i).playBlastSound();
                    score += thirdRow.get(i).getScore();
                    thirdRow.remove(thirdRow.get(i));
                    invaderCount--;
                    missile = null;
                    return;
                }
            }
        }
        for (int i = 0; i < fourthRow.size(); i++) {
            if (fourthRow.get(i) != null) {
                if (missile.getX() >= fourthRow.get(i).getX()
                        && missile.getX() <= fourthRow.get(i).getX() + 30
                        && missile.getY() >= fourthRow.get(i).getY()
                        && missile.getY() <= fourthRow.get(i).getY() + 17) {
                    fourthRow.get(i).playBlastSound();
                    score += fourthRow.get(i).getScore();
                    fourthRow.remove(fourthRow.get(i));
                    invaderCount--;
                    missile = null;
                    return;
                }
            }
        }
        for (int i = 0; i < fifthRow.size(); i++) {
            if (fifthRow.get(i) != null) {
                if (missile.getX() >= fifthRow.get(i).getX()
                        && missile.getX() <= fifthRow.get(i).getX() + 30
                        && missile.getY() >= fifthRow.get(i).getY()
                        && missile.getY() <= fifthRow.get(i).getY() + 17) {
                    fifthRow.get(i).setImage(
                            fifthRow.get(i).getImage("SIinvaderBlast.gif"));
                    fifthRow.get(i).playBlastSound();
                    score += fifthRow.get(i).getScore();
                    fifthRow.remove(fifthRow.get(i));
                    invaderCount--;
                    missile = null;
                    return;
                }
            }
        }
        if (mystery != null)
            if (missile.getX() >= mystery.getX()
                    && missile.getX() <= mystery.getX() + 35
                    && missile.getY() >= mystery.getY()
                    && missile.getY() <= mystery.getY() + 8) {
                mystery.playBlastSound();
                score += mystery.getScore();
                mystery = null;
                missile = null;
                return;
            }
    }

    private void makeTopRow() {
        topRow = new ArrayList<SItop>();
        topRow.add(new SItop(95, 95));
        for (int i = 1; i < 10; i++) {
            topRow.add(new SItop(topRow.get(i - 1).getX() + 30,
                    topRow.get(i - 1).getY()));
        }
    }

    private void makeSecondRow() {
        secondRow = new ArrayList<SImiddle>();
        secondRow.add(new SImiddle(95, 120));
        for (int i = 1; i < 10; i++) {
            secondRow.add(new SImiddle(secondRow.get(i - 1).getX() + 30,
                    secondRow.get(i - 1).getY()));
        }
    }

    private void makeThirdRow() {
        thirdRow = new ArrayList<SImiddle>();
        thirdRow.add(new SImiddle(95, 145));
        for (int i = 1; i < 10; i++) {
            thirdRow.add(new SImiddle(thirdRow.get(i - 1).getX() + 30,
                    thirdRow.get(i - 1).getY()));
        }
    }

    private void makeFourthRow() {
        fourthRow = new ArrayList<SIbottom>();
        fourthRow.add(new SIbottom(95, 170));
        for (int i = 1; i < 10; i++) {
            fourthRow.add(new SIbottom(fourthRow.get(i - 1).getX() + 30,
                    fourthRow.get(i - 1).getY()));
        }
    }

    private void makeFifthRow() {
        fifthRow = new ArrayList<SIbottom>();
        fifthRow.add(new SIbottom(95, 195));
        for (int i = 1; i < 10; i++) {
            fifthRow.add(new SIbottom(fifthRow.get(i - 1).getX() + 30,
                    fifthRow.get(i - 1).getY()));
        }
    }

    private SIinvader getRandomAlien() {
        ArrayList<SIinvader> theInvaders = new ArrayList<SIinvader>();
        for (int i = 0; i < topRow.size(); i++) {
            theInvaders.add(topRow.get(i));
        }
        for (int i = 0; i < secondRow.size(); i++) {
            theInvaders.add(secondRow.get(i));
        }
        for (int i = 0; i < thirdRow.size(); i++) {
            theInvaders.add(thirdRow.get(i));
        }
        for (int i = 0; i < fourthRow.size(); i++) {
            theInvaders.add(fourthRow.get(i));
        }
        for (int i = 0; i < fifthRow.size(); i++) {
            theInvaders.add(fifthRow.get(i));
        }
        Random r = new Random();
        if (theInvaders.get(r.nextInt(theInvaders.size())) != null) {
            return theInvaders.get(r.nextInt(theInvaders.size()));
        }
        return getRandomAlien();
    }

    private void isWithinRange(SIbase base, SImissile alienMissile) {
        if (base != null) {
            if (alienMissile.getX() >= base.getX()
                    && alienMissile.getX() <= base.getX() + 25
                    && alienMissile.getY() >= base.getY()
                    && alienMissile.getY() <= base.getY() + 17) {
                base.playBaseBlastSound();
                base = null;
                alienMissile = null;
                baseIsAlive = false;
                return;
            }
        }
    }

    public SIPanel() {
        base = new SIbase(230, 360);
        baseIsAlive = true;
        score = 0;
        invaderCount = 50;
        alienMissilePulse = 0;
        alienMovementPulse = 0;
        alienSpriteChangePulse = 0;
        isAtRightEdge = false;
        isAtLeftEdge = false;
        makeTopRow();
        makeSecondRow();
        makeThirdRow();
        makeFourthRow();
        makeFifthRow();
        setFocusable(true);
        setTimer(new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (left && base.getX() != 10) {
                    base.moveXBy(-5);
                }
                if (right && base.getX() != 465) {
                    base.moveXBy(5);
                }
                if (missile != null) {
                    if (missile.getY() == 0) {
                        missile = null;
                    }
                    else {
                        missile.moveUp();
                        isWithinRange();
                    }
                }
                double x = Math.random();
                SIinvader shooter = getRandomAlien();
                if (alienMissile1 == null) {
                    alienMissile1 = new SImissile(shooter.getX(),
                            shooter.getY());
                }
                SIinvader shooter2 = getRandomAlien();
                if (alienMissile2 == null && shooter != shooter2) {
                    alienMissile2 = new SImissile(shooter2.getX(),
                            shooter2.getY());
                }
                SIinvader shooter3 = getRandomAlien();
                if (alienMissile3 == null && shooter3 != shooter
                        && shooter3 != shooter2) {
                    alienMissile3 = new SImissile(shooter.getX(),
                            shooter.getY());
                }
                if (x > .997) {
                    mystery = new SImystery(10, 10);
                }
                if (alienMissilePulse == 1) {
                    if (alienMissile1 != null) {
                        alienMissile1.moveDown();
                        isWithinRange(base, alienMissile1);
                        if (alienMissile1.getY() == 450) {
                            alienMissile1 = null;
                        }
                    }
                    if (alienMissile2 != null) {
                        alienMissile2.moveDown();
                        isWithinRange(base, alienMissile2);
                        if (alienMissile2.getY() == 450) {
                            alienMissile2 = null;
                        }
                    }
                    if (alienMissile3 != null) {
                        alienMissile3.moveDown();
                        isWithinRange(base, alienMissile3);
                        if (alienMissile3.getY() == 450) {
                            alienMissile3 = null;
                        }
                    }
                    if (mystery != null) {
                        mystery.moveRight(5);
                        if (mystery.getX() == 490) {
                            mystery = null;
                        }
                    }
                    alienMissilePulse = 0;
                }
                else {
                    alienMissilePulse++;
                }
                if (alienMovementPulse == 45) {
                    moveInvaders();
                    alienMovementPulse = 0;
                }
                else {
                    alienMovementPulse++;
                }
                if (alienSpriteChangePulse == 45) {
                    dance1();
                }
                if (alienSpriteChangePulse == 90) {
                    dance0();
                    alienSpriteChangePulse = 0;
                }
                else {
                    alienSpriteChangePulse++;
                }
                repaint();
            }
        }));
        getTimer().start();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_RIGHT:
                        right = true;
                        break;
                    case KeyEvent.VK_LEFT:
                        left = true;
                        break;
                    case KeyEvent.VK_SPACE:
                        if (missile == null) {
                            base.playShootSound();
                            missile = new SImissile(base.getX() + 12,
                                    base.getY());
                        }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_RIGHT:
                        right = false;
                        break;
                    case KeyEvent.VK_LEFT:
                        left = false;
                        break;
                }
            }
        });
    }

    private void dance1() {
        for (int i = 0; i < topRow.size(); i++) {
            if (topRow.get(i) != null) {
                topRow.get(i).setImage(topRow.get(i).getImage("SItop1.gif"));
            }
        }
        for (int i = 0; i < secondRow.size(); i++) {
            if (secondRow.get(i) != null) {
                secondRow.get(i)
                        .setImage(secondRow.get(i).getImage("SImiddle1.gif"));
            }
        }
        for (int i = 0; i < thirdRow.size(); i++) {
            if (thirdRow.get(i) != null) {
                thirdRow.get(i)
                        .setImage(thirdRow.get(i).getImage("SImiddle1.gif"));
            }
        }
        for (int i = 0; i < fourthRow.size(); i++) {
            if (fourthRow.get(i) != null) {
                fourthRow.get(i)
                        .setImage(fourthRow.get(i).getImage("SIbottom1.gif"));
            }
        }
        for (int i = 0; i < fifthRow.size(); i++) {
            if (fifthRow.get(i) != null) {
                fifthRow.get(i)
                        .setImage(fifthRow.get(i).getImage("SIbottom1.gif"));
            }
        }
    }

    private void dance0() {
        for (int i = 0; i < topRow.size(); i++) {
            if (topRow.get(i) != null) {
                topRow.get(i).setImage(topRow.get(i).getImage("SItop0.gif"));
            }
        }
        for (int i = 0; i < secondRow.size(); i++) {
            if (secondRow.get(i) != null) {
                secondRow.get(i)
                        .setImage(secondRow.get(i).getImage("SImiddle0.gif"));
            }
        }
        for (int i = 0; i < thirdRow.size(); i++) {
            if (thirdRow.get(i) != null) {
                thirdRow.get(i)
                        .setImage(thirdRow.get(i).getImage("SImiddle0.gif"));
            }
        }
        for (int i = 0; i < fourthRow.size(); i++) {
            if (fourthRow.get(i) != null) {
                fourthRow.get(i)
                        .setImage(fourthRow.get(i).getImage("SIbottom0.gif"));
            }
        }
        for (int i = 0; i < fifthRow.size(); i++) {
            if (fifthRow.get(i) != null) {
                fifthRow.get(i)
                        .setImage(fifthRow.get(i).getImage("SIbottom0.gif"));
            }
        }
    }

    private void moveInvaders() {
        if (isAtRightEdge == false) {
            moveInvadersRight(topRow, secondRow, thirdRow, fourthRow,
                    fifthRow);
        }
        if (isAtRightEdgeOfScreen() == true) {
            isAtRightEdge = true;
            for (int i = 0; i < topRow.size(); i++) {
                for (moveDown = 0; moveDown < 1; moveDown++) {
                    topRow.get(i).moveYBy(25);
                }
            }
            for (int i = 0; i < secondRow.size(); i++) {
                for (moveDown = 0; moveDown < 1; moveDown++) {
                    secondRow.get(i).moveYBy(25);
                }
            }
            for (int i = 0; i < thirdRow.size(); i++) {
                for (moveDown = 0; moveDown < 1; moveDown++) {
                    thirdRow.get(i).moveYBy(25);
                }
            }
            for (int i = 0; i < fourthRow.size(); i++) {
                for (moveDown = 0; moveDown < 1; moveDown++) {
                    fourthRow.get(i).moveYBy(25);
                }
            }
            for (int i = 0; i < fifthRow.size(); i++) {
                for (moveDown = 0; moveDown < 1; moveDown++) {
                    fifthRow.get(i).moveYBy(25);
                }
            }
        }
        if (isTopRowAt120Y() == true && isAtRightEdge == true
                && isAtLeftEdge == false) {
            moveInvadersLeft(topRow, secondRow, thirdRow, fourthRow, fifthRow);
        }
        if (isAtLeftEdgeOfScreen() == true) {
            isAtLeftEdge = true;
            isAtRightEdge = false;
            for (int i = 0; i < topRow.size(); i++) {
                for (moveDown = 0; moveDown < 1; moveDown++) {
                    topRow.get(i).moveYBy(25);
                }
            }
            for (int i = 0; i < secondRow.size(); i++) {
                for (moveDown = 0; moveDown < 1; moveDown++) {
                    secondRow.get(i).moveYBy(25);
                }
            }
            for (int i = 0; i < thirdRow.size(); i++) {
                for (moveDown = 0; moveDown < 1; moveDown++) {
                    thirdRow.get(i).moveYBy(25);
                }
            }
            for (int i = 0; i < fourthRow.size(); i++) {
                for (moveDown = 0; moveDown < 1; moveDown++) {
                    fourthRow.get(i).moveYBy(25);
                }
            }
            for (int i = 0; i < fifthRow.size(); i++) {
                for (moveDown = 0; moveDown < 1; moveDown++) {
                    fifthRow.get(i).moveYBy(25);
                }
            }
        }
        if (isTopRowAt145Y() && isAtLeftEdge == true
                && isAtRightEdge == false) {
            moveInvadersRight(topRow, secondRow, thirdRow, fourthRow,
                    fifthRow);
        }
        if (isAtRightEdgeOfScreen() == true) {
            isAtRightEdge = true;
            isAtLeftEdge = false;
            for (int i = 0; i < topRow.size(); i++) {
                for (moveDown = 0; moveDown < 1; moveDown++) {
                    topRow.get(i).moveYBy(25);
                }
            }
            for (int i = 0; i < secondRow.size(); i++) {
                for (moveDown = 0; moveDown < 1; moveDown++) {
                    secondRow.get(i).moveYBy(25);
                }
            }
            for (int i = 0; i < thirdRow.size(); i++) {
                for (moveDown = 0; moveDown < 1; moveDown++) {
                    thirdRow.get(i).moveYBy(25);
                }
            }
            for (int i = 0; i < fourthRow.size(); i++) {
                for (moveDown = 0; moveDown < 1; moveDown++) {
                    fourthRow.get(i).moveYBy(25);
                }
            }
            for (int i = 0; i < fifthRow.size(); i++) {
                for (moveDown = 0; moveDown < 1; moveDown++) {
                    fifthRow.get(i).moveYBy(25);
                }
            }
        }
        if (isTopRowAt170Y() == true && isAtRightEdge == true
                && isAtLeftEdge == false) {
            moveInvadersLeft(topRow, secondRow, thirdRow, fourthRow, fifthRow);
        }
        if (isAtLeftEdgeOfScreen() == true) {
            isAtLeftEdge = true;
            isAtRightEdge = false;
            for (int i = 0; i < topRow.size(); i++) {
                for (moveDown = 0; moveDown < 1; moveDown++) {
                    topRow.get(i).moveYBy(25);
                }
            }
            for (int i = 0; i < secondRow.size(); i++) {
                for (moveDown = 0; moveDown < 1; moveDown++) {
                    secondRow.get(i).moveYBy(25);
                }
            }
            for (int i = 0; i < thirdRow.size(); i++) {
                for (moveDown = 0; moveDown < 1; moveDown++) {
                    thirdRow.get(i).moveYBy(25);
                }
            }
            for (int i = 0; i < fourthRow.size(); i++) {
                for (moveDown = 0; moveDown < 1; moveDown++) {
                    fourthRow.get(i).moveYBy(25);
                }
            }
            for (int i = 0; i < fifthRow.size(); i++) {
                for (moveDown = 0; moveDown < 1; moveDown++) {
                    fifthRow.get(i).moveYBy(25);
                }
            }
        }
        if (isTopRowAt195Y() == true && isAtLeftEdge == true
                && isAtRightEdge == false) {
            moveInvadersRight(topRow, secondRow, thirdRow, fourthRow,
                    fifthRow);
        }
        if (isAtRightEdgeOfScreen() == true) {
            isAtRightEdge = true;
            isAtLeftEdge = false;
            for (int i = 0; i < topRow.size(); i++) {
                for (moveDown = 0; moveDown < 1; moveDown++) {
                    topRow.get(i).moveYBy(25);
                }
            }
            for (int i = 0; i < secondRow.size(); i++) {
                for (moveDown = 0; moveDown < 1; moveDown++) {
                    secondRow.get(i).moveYBy(25);
                }
            }
            for (int i = 0; i < thirdRow.size(); i++) {
                for (moveDown = 0; moveDown < 1; moveDown++) {
                    thirdRow.get(i).moveYBy(25);
                }
            }
            for (int i = 0; i < fourthRow.size(); i++) {
                for (moveDown = 0; moveDown < 1; moveDown++) {
                    fourthRow.get(i).moveYBy(25);
                }
            }
            for (int i = 0; i < fifthRow.size(); i++) {
                for (moveDown = 0; moveDown < 1; moveDown++) {
                    fifthRow.get(i).moveYBy(25);
                }
            }
        }
        if (isTopRowAt220Y() == true && isAtRightEdge == true
                && isAtLeftEdge == false) {
            moveInvadersLeft(topRow, secondRow, thirdRow, fourthRow, fifthRow);
        }
    }

    private boolean isAtLeftEdgeOfScreen() {
        for (int i = 0; i < topRow.size(); i++) {
            if (topRow.get(i).getX() == 15) {
                return true;
            }
        }
        for (int i = 0; i < secondRow.size(); i++) {
            if (secondRow.get(i).getX() == 15) {
                return true;
            }
        }
        for (int i = 0; i < thirdRow.size(); i++) {
            if (thirdRow.get(i).getX() == 15) {
                return true;
            }
        }
        for (int i = 0; i < fourthRow.size(); i++) {
            if (fourthRow.get(i).getX() == 15) {
                return true;
            }
        }
        for (int i = 0; i < fifthRow.size(); i++) {
            if (fifthRow.get(i).getX() == 15) {
                return true;
            }
        }
        return false;
    }

    private boolean isAtRightEdgeOfScreen() {
        for (int i = 0; i < topRow.size(); i++) {
            if (topRow.get(i).getX() == 475) {
                return true;
            }
        }
        for (int i = 0; i < secondRow.size(); i++) {
            if (secondRow.get(i).getX() == 475) {
                return true;
            }
        }
        for (int i = 0; i < thirdRow.size(); i++) {
            if (thirdRow.get(i).getX() == 475) {
                return true;
            }
        }
        for (int i = 0; i < fourthRow.size(); i++) {
            if (fourthRow.get(i).getX() == 475) {
                return true;
            }
        }
        for (int i = 0; i < fifthRow.size(); i++) {
            if (fifthRow.get(i).getX() == 475) {
                return true;
            }
        }
        return false;
    }

    private boolean isTopRowAt120Y() {
        for (int i = 0; i < topRow.size(); i++) {
            if (topRow.get(i).getY() == 120) {
                return true;
            }
        }
        return false;
    }

    private boolean isTopRowAt145Y() {
        for (int i = 0; i < topRow.size(); i++) {
            if (topRow.get(i).getY() == 145) {
                return true;
            }
        }
        return false;
    }

    private boolean isTopRowAt170Y() {
        for (int i = 0; i < topRow.size(); i++) {
            if (topRow.get(i).getY() == 170) {
                return true;
            }
        }
        return false;
    }

    private boolean isTopRowAt195Y() {
        for (int i = 0; i < topRow.size(); i++) {
            if (topRow.get(i).getY() == 195) {
                return true;
            }
        }
        return false;
    }

    private boolean isTopRowAt220Y() {
        for (int i = 0; i < topRow.size(); i++) {
            if (topRow.get(i).getY() == 220) {
                return true;
            }
        }
        return false;
    }

    private void moveInvadersRight(ArrayList<SItop> topRow,
            ArrayList<SImiddle> secondRow, ArrayList<SImiddle> thirdRow,
            ArrayList<SIbottom> fourthRow, ArrayList<SIbottom> fifthRow) {
        for (int i = 0; i < topRow.size(); i++) {
            topRow.get(i).moveXBy(5);
        }
        for (int i = 0; i < secondRow.size(); i++) {
            secondRow.get(i).moveXBy(5);
        }
        for (int i = 0; i < thirdRow.size(); i++) {
            thirdRow.get(i).moveXBy(5);
        }
        for (int i = 0; i < fourthRow.size(); i++) {
            fourthRow.get(i).moveXBy(5);
        }
        for (int i = 0; i < fifthRow.size(); i++) {
            fifthRow.get(i).moveXBy(5);
        }
    }

    private void moveInvadersLeft(ArrayList<SItop> topRow,
            ArrayList<SImiddle> secondRow, ArrayList<SImiddle> thirdRow,
            ArrayList<SIbottom> fourthRow, ArrayList<SIbottom> fifthRow) {
        for (int i = 0; i < topRow.size(); i++) {
            topRow.get(i).moveXBy(-5);
        }
        for (int i = 0; i < secondRow.size(); i++) {
            secondRow.get(i).moveXBy(-5);
        }
        for (int i = 0; i < thirdRow.size(); i++) {
            thirdRow.get(i).moveXBy(-5);
        }
        for (int i = 0; i < fourthRow.size(); i++) {
            fourthRow.get(i).moveXBy(-5);
        }
        for (int i = 0; i < fifthRow.size(); i++) {
            fifthRow.get(i).moveXBy(-5);
        }
    }

    private boolean isAlienWithBase() {
        for (int i = 0; i < topRow.size(); i++) {
            if (topRow.get(i).getY() == 345) {
                return true;
            }
        }
        for (int i = 0; i < secondRow.size(); i++) {
            if (secondRow.get(i).getY() == 345) {
                return true;
            }
        }
        for (int i = 0; i < thirdRow.size(); i++) {
            if (thirdRow.get(i).getY() == 345) {
                return true;
            }
        }
        for (int i = 0; i < fourthRow.size(); i++) {
            if (fourthRow.get(i).getY() == 345) {
                return true;
            }
        }
        for (int i = 0; i < fifthRow.size(); i++) {
            if (fifthRow.get(i).getY() == 345) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        base.paintMe(g2);
        if (mystery != null) {
            mystery.paintMe(g2);
        }
        String scoreCount = "Score: " + score;
        g.setColor(Color.GREEN);
        g.drawString(scoreCount, 430, 15);
        for (int i = 0; i < topRow.size(); i++) {
            if (topRow.get(i) != null) {
                topRow.get(i).paintMe(g2);
            }
        }
        for (int i = 0; i < secondRow.size(); i++) {
            if (secondRow.get(i) != null) {
                secondRow.get(i).paintMe(g2);
            }
        }
        for (int i = 0; i < thirdRow.size(); i++) {
            if (thirdRow.get(i) != null) {
                thirdRow.get(i).paintMe(g2);
            }
        }
        for (int i = 0; i < fourthRow.size(); i++) {
            if (fourthRow.get(i) != null) {
                fourthRow.get(i).paintMe(g2);
            }
        }
        for (int i = 0; i < fifthRow.size(); i++) {
            if (fifthRow.get(i) != null) {
                fifthRow.get(i).paintMe(g2);
            }
        }
        if (missile != null) {
            missile.paintMe(g2);
        }
        if (alienMissile1 != null) {
            alienMissile1.paintMe(g2);
        }
        if (alienMissile2 != null) {
            alienMissile2.paintMe(g2);
        }
        if (alienMissile3 != null) {
            alienMissile3.paintMe(g2);
        }
        if (baseIsAlive == false || isAlienWithBase() == true) {
            String endGame = "GAME OVER";
            f = new Font("Times New Roman", Font.BOLD, 50);
            g.setColor(Color.GREEN);
            g.setFont(f);
            getTimer().stop();
            g.drawString(endGame, 90, 175);
        }
        if (invaderCount == 0) {
            makeTopRow();
            makeSecondRow();
            makeThirdRow();
            makeFourthRow();
            makeFifthRow();
        }
    }

    public static Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        SIPanel.timer = timer;
    }
}