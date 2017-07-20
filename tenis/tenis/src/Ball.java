import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
	private static final int DIAMETER = 30;			
	int x = 0;										//pozitia  mingii, sus
	int y = 0;										//pozitia  mingii, stanga
	int xa = 1;
	int ya = 1;
	private Game game;

	public Ball(Game game) {
		this.game= game;
	}

	void move() {
		
		if (x + xa < 0)
			xa = 1;									//mingea se deplaseaza la dreapta 
		
		if (x + xa > game.getWidth() - DIAMETER)	//cand mingea depaseste marginea din stanga sau dreapta ferestrei, ii schimbam directia
			xa = -1;								//mingea se deplaseaza la stanga 
		
		if (y + ya < 0)
			ya = 1;									//mingea se deplaseaza in jos 
		
		if (y + ya > game.getHeight() - DIAMETER)	//cand mingea depaseste marginea de jos a ferestrei,
			game.gameOver();						//terminam jocul
		
		if (collision()){							//mingea se deplaseaza in sus, daca se intersecteaza cu jucatorul
			ya = -1;								
			y = game.player.getTopY() - DIAMETER;   
		}
		x = x + xa;									
		y = y + ya;									
	}

	private boolean collision() {
		return game.player.getBounds().intersects(getBounds()); 
	}

	public void paint(Graphics2D g) {
		g.fillOval(x, y, DIAMETER, DIAMETER);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
}