package arx.game.object;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Enemy {

	int x;
	int y;
	int speedEnemy;
	Image carEnemyImg = new ImageIcon("res/car_enemy.png").getImage();
	Road road;
	
	public Enemy(int x, int y, int speed, Road road) {
		this.x			= x;
		this.y			= y;
		this.speedEnemy	= speed;
		this.road		= road;
		
	}
	public void move() {
		x = x - road.carPlayer.speed + speedEnemy;
	}
}
