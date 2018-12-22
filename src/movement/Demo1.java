package movement;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Demo1 extends JFrame {
	private GameLoop1 gameLoop;
	
	public Demo1() {
		this.setSize(600, 600);  
	   	this.setVisible(true);
		gameLoop = new GameLoop1(true, this);
		new Thread(gameLoop).start();
	}
	
	public static void main(String[] args) {
		Demo1 demo = new Demo1();
	}
	
	
}
