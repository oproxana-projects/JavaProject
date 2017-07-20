import static java.awt.Color.pink;
import java.awt.Graphics;    /* proces care se porneste cand                                
cream un obiect JFrame; acest proces primeste informatii de la tastatura si mouse*/                 
import java.awt.Color;
import java.awt.Graphics2D;						
//import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel {					

	Ball ball = new Ball(this);						
	Player player = new Player(this);				

	public Game() {
		addKeyListener(new KeyListener() { 			//verifica daca o tasta e apasata
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				player.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {		//se apleleaza de fiecare data cand e o tasta apasata
				player.keyPressed(e);
			}
		});
		setFocusable(true);																	
	}
	
	private void move() {										
		ball.move();											
		player.move();										
	}

	@Override
	public void paint(Graphics g) {       					
		super.paint(g);													
		Graphics2D g2d = (Graphics2D) g;						
		
		g.setColor(Color.CYAN);									
		ball.paint(g2d);
		g.setColor(Color.BLACK);									
		player.paint(g2d);
		setBackground(pink);
		 
	}
	
	public void gameOver() {														
		JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION); 
		System.exit(ABORT);
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Tenis");  					//desenam fereastra in care are loc jocul
		Game game = new Game();
		frame.add(game);
		frame.setSize(300, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		while (true) {											 
			game.move();										
			game.repaint();										
			Thread.sleep(5);								
		}
	}
}