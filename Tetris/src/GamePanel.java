import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class GamePanel extends JPanel
{
	private final int WIDTH = 500, HEIGHT = 600;
	private final int IMAGE_SIZE = 25;
	private int level = 0, totallines = 0;
	private ImageIcon image,  image2, image3, image4, ghostImage;
	private Timer timer;
	private Tetromino tetro, ghost;
	private PlayField playfield = new PlayField();
	private double delay = 725 * Math.pow(.85,  playfield.getLevel()) + playfield.getLevel();

	private int x, x2, x3, x4, y, y2, y3, y4, ghostx, ghostx2, ghostx3, ghostx4, ghosty, ghosty2, ghosty3, ghosty4;

	public GamePanel() {
		addKeyListener(new GameListener());
		delay = 725 * Math.pow(.85,  playfield.getLevel()) + playfield.getLevel();
		timer = new Timer( (int) (725 * Math.pow(.85,  playfield.getLevel()) + playfield.getLevel()), new GameListener());
		playfield.createPlayField();
		tetro = new Tetromino(); 
		tetro.spawnRandom(playfield);
		image = tetro.getImage();

		x = (tetro.getX() - 1) * 25;	x2 = (tetro.getX2() - 1) * 25;	x3 = (tetro.getX3() - 1) * 25;	x4 = (tetro.getX4() - 1) * 25;
		y = (tetro.getY() - 1) * 25;	y2 = (tetro.getY2() - 1) * 25;	x3 = (tetro.getY3() - 1) * 25;	y4 = (tetro.getY4() - 1) * 25;

		//ghostx = (tetro.getX() - 1) * 25;	ghostx2 = (tetro.getGhostX() - 1) * 25;		ghostx3 = (tetro.getGhostX3() - 1) * 25;	ghostx4 = (tetro.getGhostX4() - 1) * 25;
		//ghosty = (tetro.getY() - 1) * 25;	ghosty2 = (tetro.getGhostY2() - 1) * 25;	ghostx3 = (tetro.getGhostY3() - 1) * 25;	ghosty4 = (tetro.getGhostY4() - 1) * 25;

		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.black);
		timer.setDelay((int) (725 * Math.pow(.85,  playfield.getLevel()) + playfield.getLevel()));
		timer.start();
		setFocusable(true);
	}

	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		page.setColor(Color.white);		
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 22; j++) {
				playfield.getImage(i, j).paintIcon(this, page, (i) * 25, (j) * 25);
			}
		}
		page.drawString("SCORE: " + playfield.getScore(), 325, 50);
		page.drawString("Level: " + playfield.getLevel(), 325, 150);
		page.drawString("Delay: " + delay, 325, 250);
		page.drawString("Lines Cleared: " + playfield.getLines(), 325, 350);
		page.drawString("Current Lines: " + playfield.getCurrentLines(), 325, 450);
		page.drawString("Level Lines: " + playfield.getLevelLines(), 325, 550);
	}


	class GameListener implements ActionListener, KeyListener {
		public void actionPerformed(ActionEvent event) {
			x = (tetro.getX()) * 25;	x2 = (tetro.getX2() - 1) * 25;	x3 = (tetro.getX3() - 1) * 25;	x4 = (tetro.getX4() - 1) * 25;
			y = (tetro.getY() - 1) * 25;	y2 = (tetro.getY2() - 1) * 25;	x3 = (tetro.getY3() - 1) * 25;	y4 = (tetro.getY4() - 1) * 25;

			//ghostx = x; 	ghostx2 = x2; 	ghostx3 = x3;	ghostx4 = x4;
			//ghosty = y; 	ghosty2 = y2; 	ghosty3 = y3; 	ghosty4 = y4;

			if  (tetro.canShiftDown(playfield)) {
				tetro.shiftDown(playfield);
			} else {
				playfield.enforceGravity();
				tetro.spawnRandom(playfield);
			}
			timer.setDelay((int) (725 * Math.pow(.85,  playfield.getLevel()) + playfield.getLevel()));
			repaint();
		}

		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode())	{
			case KeyEvent.VK_RIGHT: {
				if (tetro.canShiftRight(playfield)) {
					tetro.shiftRight(playfield);
				}
				break;
			}
			case KeyEvent.VK_LEFT: {
				if (tetro.canShiftLeft(playfield)) {
					tetro.shiftLeft(playfield);
				}
				break;
			}
			case KeyEvent.VK_DOWN: {
				if (tetro.canShiftDown(playfield)) {
					tetro.shiftDown(playfield);
				}
				break;
			}
			case KeyEvent.VK_UP: {
				tetro.rotate(playfield);
				break;
			}				
			case KeyEvent.VK_SPACE: {
				while (tetro.canShiftDown(playfield)) {
					tetro.shiftDown(playfield);
				}
			}
			case KeyEvent.VK_ESCAPE: {
				
			}
			}
			repaint();
		}
		public void keyReleased(KeyEvent e) {}
		public void keyTyped(KeyEvent e) {}
	}

}
