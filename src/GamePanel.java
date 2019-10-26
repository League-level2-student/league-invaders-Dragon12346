import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	Timer frameDraw;
	Timer alienSpawn;
	Font titleFont = new Font("Arial", Font.PLAIN, 48);
	Font titleFont2 = new Font("Arial", Font.PLAIN, 25);
	Rocketship rs = new Rocketship(225, 700, 50, 50);
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	ObjectManager h = new ObjectManager(rs);

	void startGame() {
		alienSpawn = new Timer(1000, this);
		alienSpawn.start();
	}

	public GamePanel() {
		if (needImage) {
			loadImage("space.png");
		}
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
		startGame();
	}

	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}
	}

	void updateMenuState() {
	}

	void updateGameState() {
		h.update();
		if (h.rocket.isActive == false) {
			currentState = END;
		}
	}

	void updateEndState() {
	}

	void drawMenuState(Graphics g) {

		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", LeagueInvaders.WIDTH / 17, LeagueInvaders.HEIGHT - 600);
		g.setFont(titleFont2);
		g.drawString("Press ENTER to start", LeagueInvaders.WIDTH / 4, LeagueInvaders.HEIGHT - 460);
		g.drawString("Press SPACE for instructions", LeagueInvaders.WIDTH / 6, LeagueInvaders.HEIGHT - 300);
	}

	void drawGameState(Graphics g) {
		if (gotImage) {
			g.drawImage(image, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
		} else {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		}
		h.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setColor(Color.YELLOW);
		g.setFont(titleFont);
		g.drawString("Game Over", LeagueInvaders.WIDTH - 350, LeagueInvaders.HEIGHT - 500);
		g.setFont(titleFont2);
		g.drawString("Score = " + h.getScore(), LeagueInvaders.WIDTH - 300, LeagueInvaders.HEIGHT - 400);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == GAME) {
			updateGameState();
		} else if (currentState == END) {
			updateEndState();
		}
		System.out.println("action");
		repaint();
		if (e.getSource() == alienSpawn) {
			h.addAlien();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END) {
				rs = new Rocketship(225, 700, 50, 50);
				h = new ObjectManager(rs);
				currentState = MENU;
			} else {
				currentState++;
			}

		}
		if (currentState == GAME) {

			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				h.addProjectile(rs.getProjectile());
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			System.out.println("LEFT");
			if (rs.x > 0) {
				rs.left();
			} else {
				rs.x = 0;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			System.out.println("RIGHT");
			if (rs.x + 50 < LeagueInvaders.WIDTH) {
				rs.right();
			} else {
				rs.x = LeagueInvaders.WIDTH - 50;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			System.out.println("DOWN");

			if (rs.y < LeagueInvaders.HEIGHT - 70) {
				rs.down();
			} else {
				rs.y = 730;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			System.out.println("UP");
			if (rs.y > 0) {
				rs.up();
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
