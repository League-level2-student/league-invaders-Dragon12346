import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
Rocketship rocket;
Random random = new Random();
ArrayList<Projectile> projectiles;
ArrayList<Alien> aliens;
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
		
	}
	
}