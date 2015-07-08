package arx.game.object;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Road extends JPanel{
	
	Image bg_road = new ImageIcon("res/road.png").getImage();
	
	public void paint(Graphics g) {
		g = (Graphics2D) g;
		g.drawImage(bg_road, 0, 0, null);
	}
}
