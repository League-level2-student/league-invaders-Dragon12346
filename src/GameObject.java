import java.awt.Rectangle;

public class GameObject {

	boolean isActive = true;
	int x;
	int y;
	int width;
	int height;
	Rectangle collisionBox;
	int speed = 20;
	int aSpeed = 1;
	int pSpeed = 10;

	GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		collisionBox = new Rectangle();
		collisionBox.setBounds(x, y, width, height);
	}

	public void update() {
		collisionBox.setBounds(x, y, width, height);
	}

}
