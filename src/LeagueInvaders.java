 import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeagueInvaders {
	GamePanel gp = new GamePanel();
	 JFrame frame = new JFrame();
	 static int WIDTH = 500;
	 static int HEIGHT = 800;
public static void main(String[] args) {
LeagueInvaders F = new LeagueInvaders();
F.setup();
}
void setup(){
	frame.add(gp);
	frame.addKeyListener(gp);
	frame.setSize(WIDTH, HEIGHT);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}
}
