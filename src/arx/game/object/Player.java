package arx.game.object;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Player {
	public static final int MAX_SPEED	= 100;
	public static final int MARGIN_TOP	= 100;
	public static final int MARGIN_DOWN	= 450;
	
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
		if(speed <= 0) speed = 0;
		if(speed >= MAX_SPEED) speed = MAX_SPEED;
		y			-= changeY;
		if(y <= MARGIN_TOP) y = MARGIN_TOP;
		if(y >= MARGIN_DOWN) y = MARGIN_DOWN;
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
			acceleration = 3;
		}
		if(key == KeyEvent.VK_LEFT) {
			acceleration = -3;
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
