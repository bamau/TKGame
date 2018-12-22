package movement;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Demo2 extends JFrame {
	private GameLoop2 gameLoop;
	
	public Demo2() {
		this.setSize(600, 600);  
		this.setVisible(true);
		gameLoop = new GameLoop2(true, this);
		new Thread(gameLoop).start();
	}
	
	public static void main(String[] args) {
		Demo2 demo = new Demo2();
	}
	
	
}
