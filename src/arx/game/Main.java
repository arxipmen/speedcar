package arx.game;

import javax.swing.JFrame;

import arx.game.object.Road;

public class Main {
 public static void main(String[] args) {
	 
	 JFrame f = new  JFrame("Speed Car");
	 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 f.setSize(1000, 635);
	 f.setLocationRelativeTo(null);
	 f.add(new Road());
	 f.setVisible(true);
 }
}