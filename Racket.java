import java.awt.*;

public class Racket {
	
	private Game game;
	
	int width = 160;
	int height = 15;
	
	private int x = 210;
	private int y = 403;
	
	public int moveX = 0;
	
	public Racket(Game game){
		this.game = game;
	}
	
	
	public void renderRacket(Graphics2D g2d){
		g2d.setColor(Color.BLACK);
		g2d.fillRect(x, y, width, height);
	}
	
	public void moveRacket(){
		if(x + moveX > 0 && x + moveX < game.getWidth() - width){
			x += moveX;
		}
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, width, height);
	}
	
}
