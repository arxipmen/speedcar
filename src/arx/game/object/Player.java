package arx.game.object;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Player {
	
	int speed			= 30;
	int acceleration	= 0;
	int distance		= 0;
	int layerOne		= 0;
	int layerTwo		= 1200;
	int x				= 30;
	int y				= 280;
	
	
	Image carImg = new ImageIcon("res/car.png").getImage();
	
	public void move() {
		distance += speed;
		
		// Create loop road
		if(layerTwo - speed <= 0) {
			layerOne = 0;
			layerTwo = 1200;
		} else {
			layerOne -= speed;
			layerTwo -= speed;
		}	
	}
}
