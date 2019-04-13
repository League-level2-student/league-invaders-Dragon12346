import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
	Font titleFont = new Font("Arial", Font.PLAIN, 48);
	final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}
	 void updateMenuState() {  }
	 void updateGameState() {  }
	 void updateEndState()  {  }
	 void drawMenuState(Graphics g) {
		 g.setColor(Color.BLUE);
		 g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		 g.setFont(titleFont);
		 g.setColor(Color.CYAN);
		 g.drawString("text", LeagueInvaders.WIDTH/3, LeagueInvaders.HEIGHT/2);
		 }
	 
	 
	 void drawGameState(Graphics g) {
		 g.setColor(Color.BLACK);
		 g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);  }
	 
	 
	 void drawEndState(Graphics g)  {
		 g.setColor(Color.RED);
		 g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);  }

	
}
