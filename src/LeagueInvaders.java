import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeagueInvaders {
	 JFrame frame = new JFrame();
	 int WIDTH = 500;
	 int HEIGHT = 800;
public static void main(String[] args) {
LeagueInvaders F = new LeagueInvaders();
F.setup();
}
void setup(){
	frame.setSize(WIDTH, HEIGHT);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.add(GamePanel);
}
}
