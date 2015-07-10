package arx.game.object;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Road extends JPanel implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		carPlayer.move();
		repaint();
	}
	
	public Road() {
		mainTimer.start();
		addKeyListener(new MyKeyAdapter());
		setFocusable(true);
	}

	Timer mainTimer		= new Timer(20, this);
	Image bg_road		= new ImageIcon("res/road.png").getImage();
	Player carPlayer	= new Player();
	
	public void paint(Graphics g) {
		g = (Graphics2D) g;
		g.drawImage(bg_road, carPlayer.layerOne, 0, null);
		g.drawImage(bg_road, carPlayer.layerTwo, 0,  null);
		g.drawImage(carPlayer.carImg, carPlayer.x, carPlayer.y, null);
	}
	
	private class MyKeyAdapter extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			carPlayer.keyPressed(e);
		}
		public void keyReleased(KeyEvent e) {
			carPlayer.keyReleased(e);
		}
	}
}
