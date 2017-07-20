import java.awt.Graphics2D;
import java.awt.Rectangle;									//clasa care are o metoda de intersectie care returneaza true cand 2 dreptunghiuri ocupa acelasi spatiu
import java.awt.event.KeyEvent;

public class Player {
	private static final int Y = 330;					//distanta jucatorului fata de marginea de sus														
	private static final int WIDTH = 60;				
	private static final int HEIGHT = 10;				
	int x = 0;											//jucatorul este in partea stanga a ferestrei 
	int xa = 0;											//jucatorul este static la inceputul jocului
	private Game game;

	public Player(Game game) {
		this.game = game;
	}

	public void move() {
		if (x + xa > 0 && x + xa < game.getWidth() - WIDTH)
			x = x + xa;
	}

	public void paint(Graphics2D g) {
		g.fillRect(x, Y, WIDTH, HEIGHT);
	}

	public void keyReleased(KeyEvent e) {				
		xa = 0;											
	}

	public void keyPressed(KeyEvent e) {				
														
		if (e.getKeyCode() == KeyEvent.VK_LEFT)			//cand e apasata tasta stanga			
			xa = -2;									//jucatorul se deplaseaza la stanga 
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)		//cand e apasata tasta dreapta
			xa = 2;										//jucatorul se deplaseaza la dreapta 
	
	}

	public Rectangle getBounds() {		//aceasta metoda va fi utilizata de catre minge, 
		return new Rectangle(x, Y, WIDTH, HEIGHT);					//sa cunoasca pozitia jucatorului 
	}															

	public int getTopY() {			//plasam mingea deasupra jucatorului, 
		return Y;
	}
}