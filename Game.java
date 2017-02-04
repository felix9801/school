import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Game extends JPanel{
		
	public static final int WIDTH = 600, HEIGHT = WIDTH / 12 * 9;
	
	public Ball ball = new Ball(this);
	public Racket racket = new Racket(this);
	public int points = 0;
	public boolean collided = false;
	
	public Game(){
		gameStart();
		addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == e.VK_D){
					racket.moveX = 2 * ball.speed;
					if(collided){
						
					}
				}
				if(e.getKeyCode() == e.VK_A){
					racket.moveX = -2 * ball.speed;
					if(collided){
						
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				racket.moveX = 0;
			}

			@Override
			public void keyTyped(KeyEvent e) {
				
			}
		});
		setFocusable(true);
	}
	
	private void gameStart() {
		
	}

	private void move(){
		ball.moveBall();
		racket.moveRacket();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D) g;
		ball.render(g2d);
		racket.renderRacket(g2d);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		g2d.drawString("Score: " + points, 5, 30);
		
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		g2d.drawString("Use A & D keys to move", 330, 30);
	}
	
	public void gameOver(){
		JOptionPane.showMessageDialog(this, "Game Over! You got " + points + " points!", "Game Over", JOptionPane.OK_OPTION);
		System.exit(ABORT);
	}
	
	public static void main(String args[]){
		JFrame frame = new JFrame();
		Game game = new Game();
		
		
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setTitle("One Man Pong");
		frame.add(game);
		frame.setResizable(false);
		frame.setVisible(true);
		
		while(true){
			game.move();
			game.repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

		
}	
