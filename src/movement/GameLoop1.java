package movement;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class GameLoop1 implements Runnable{
	private boolean isRunning;
	private Demo1 demo;
	private List<Character> characters;
	private List<KinematicWandering> kinematicWanderings;
        private List<KinematicFlee> kinematicFlees;
	public GameLoop1(boolean isRunning, Demo1 demo) {
		super();
		this.isRunning = isRunning;
		this.demo = demo;
		
		Character c1 = new Character(new Vector2D(300,300), 0, new Vector2D(0, 0), 0, Color.RED);
		Character c2 = new Character(new Vector2D(600, 600), 0, new Vector2D(0, 0), 0, Color.GREEN);
		
                this.characters = new ArrayList<Character>();
		this.kinematicWanderings = new ArrayList<KinematicWandering>();
		this.kinematicFlees = new ArrayList<KinematicFlee>();
		this.characters.add(c1);
		this.characters.add(c2);
                this.kinematicWanderings.add(new KinematicWandering(c2, 3, 2));
                this.kinematicFlees.add(new KinematicFlee(c2, c1,3));
		
                
	}

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	public Demo1 getDemo() {
		return demo;
	}

	public void setDemo(Demo1 demo) {
		this.demo = demo;
	}

	@Override
	public void run() {
		/*for (int i=0; i<20; i++) {
			demo.getGraphics().clearRect(0,  0,  demo.getWidth(), demo.getHeight());
			int x, y;
			x = 100 + i*10;
			y = 100 + i*10;
			demo.getGraphics().drawOval(x, y, 50, 50);
			demo.getGraphics().drawLine(x, y, x + 25, y + 25);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		while (true) {
			demo.getGraphics().clearRect(0,  0,  demo.getWidth(), demo.getHeight());
			this.characters.get(0).update(kinematicWanderings.get(0).generateKinematicOutput(), 1);
                        this.characters.get(0).render(this.demo.getGraphics());
                        this.characters.get(1).update(kinematicFlees.get(0).generateKinematicOutput(), 1);
                        this.characters.get(1).applyNewOrientation();
                        this.characters.get(1).render(this.demo.getGraphics());
                       
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
