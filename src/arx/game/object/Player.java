package arx.game.object;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Player {
	
	int speed			= 10;
	int acceleration	= 0;
	int distance		= 0;
	int layerOne		= 0;
	int x				= 30;
	int y				= 280;
	
	
	Image carImg = new ImageIcon("res/car.png").getImage();
	
	public void move() {
		distance += speed;
		layerOne -= speed;
	}
}
