import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
Rocketship rocket;
Random random = new Random();
ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
ArrayList<Alien> aliens = new ArrayList<Alien>();
ObjectManager (Rocketship rocket){
	this.rocket = rocket;
}
	void addProjectile(Projectile p) {
		projectiles.add(p);
	}
	void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
	}
	void update() {
		
		for (Alien alien: aliens) {
			alien.update();
			if (alien.y>LeagueInvaders.HEIGHT) {
				alien.isActive = false;
			}
		}
		for (Projectile proj: projectiles) {
			proj.update();
			if (proj.y<0) {
				proj.isActive = false;
			}
		}
	}
	void draw(Graphics g) {
		rocket.draw(g);
		for (Alien alien: aliens) {
			alien.draw(g);
		}
		for (Projectile proj: projectiles) {
			proj.draw(g);
		}
	}
	void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++) {
			if (!aliens.get(i).isActive) {
				aliens.remove(i);
			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			if (!projectiles.get(i).isActive) {
				projectiles.remove(i);
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
	}
	
}