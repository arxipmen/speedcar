package arx.game.object;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Road extends JPanel implements ActionListener, Runnable {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		carPlayer.move();
		repaint();
		System.out.println(enemies.size());
	}
	
	public Road() {
		mainTimer.start();
		enemiesFactory.start();
		addKeyListener(new MyKeyAdapter());
		setFocusable(true);
	}

	Timer mainTimer			= new Timer(20, this);
	Image bg_road			= new ImageIcon("res/road.png").getImage();
	Player carPlayer		= new Player();
	Thread enemiesFactory	= new Thread(this);
	List<Enemy> enemies		= new ArrayList<Enemy>();
	
	public void run() {
		while(true) {
			Random rand = new Random();
			try {
				Thread.sleep(rand.nextInt(2000));
				enemies.add(new Enemy(1200,
									rand.nextInt(600),
									rand.nextInt(60),
									this));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void paint(Graphics g) {
		g = (Graphics2D) g;
		g.drawImage(bg_road, carPlayer.layerOne, 0, null);
		g.drawImage(bg_road, carPlayer.layerTwo, 0,  null);
		g.drawImage(carPlayer.carImg, carPlayer.x, carPlayer.y, null);
		
		Iterator<Enemy> i = enemies.iterator();
		while(i.hasNext()) {
			Enemy e = i.next();
			if(e.x >= 2400 || e.x <= -2400) {
				i.remove();
			} else {
				e.move();
				g.drawImage(e.carEnemyImg, e.x, e.y, null);
			}
		}
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
