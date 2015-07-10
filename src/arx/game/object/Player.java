package arx.game.object;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Player {
	
	int speed			= 0;
	int acceleration	= 0;
	int distance		= 0;
	int layerOne		= 0;
	int layerTwo		= 1200;
	int x				= 30;
	int y				= 280;
	int changeY			= 0;
	int changeX			= 0;
	
	
	Image carImg = new ImageIcon("res/car.png").getImage();
	
	public void move() {
		distance	+= speed;
		speed 		+= acceleration;
		y			-= changeY;
		
		// Create loop road
		if(layerTwo - speed <= 0) {
			layerOne = 0;
			layerTwo = 1200;
		} else {
			layerOne -= speed;
			layerTwo -= speed;
		}	
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_RIGHT) {
			acceleration = 1;
		}
		if(key == KeyEvent.VK_LEFT) {
			acceleration = -1;
		}
		if(key == KeyEvent.VK_UP) {
			changeY = 5;
		}
		if(key == KeyEvent.VK_DOWN) {
			changeY = -5;
		}
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_LEFT) {
			acceleration = 0;
		}
		if(key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
			changeY = 0;
		}
	}
}
