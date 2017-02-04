import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.util.Random;

public class Ball {
	
	public static int D = 50;
	
	private int moveX = 1;
	
	private int moveY = 1;
	
	public int speed = 1;
	
	public int newRacketSpeed = 2;
	
	public static Random r = new Random();
	
	public static Color ballColor = new Color(r.nextInt(0x99ff99));
	
	public static int x = r.nextInt(Game.WIDTH - D);

	public static int y = r.nextInt(Game.HEIGHT / 2);
	
	Game game;
	
	public Ball(Game game){
	this.game = game;
	}
	
	public void moveBall(){
		if(x + moveX > game.getWidth() - D){
			moveX = -1;
		}
		
		if(x + moveX <= 0){
			moveX = 1;
		}
		
		if(y + moveY <= 0){
			moveY = 1;
		}
		if(y + moveY > game.getHeight() - D){
			game.gameOver();
		}
		if(collision()){
			moveY = -1;
			speed++;
			game.points++;
		}
		
		x += moveX * speed;
		y += moveY * speed;
		
	}
	
	public void render(Graphics2D g2d){
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(ballColor);
		g2d.fillOval(x, y, D, D);
	}
	
	private Rectangle getBounds(){
		
		return new Rectangle(x, y, D, D);
	}
	
	private boolean collision(){
		
		return game.racket.getBounds().intersects(getBounds());
	}
	
}
