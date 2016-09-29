import java.awt.*;
import java.awt.event.*; //Import event libraries
import javax.swing.*;
import java.util.*;

class TestNumber extends JFrame implements ActionListener {
	// Window components used by other method must be declared
	// as class variables

	int nrOfGuesses = 8;
	int range = 100;
	int i = 1;
	
	JLabel primeLabel = new JLabel("");
	JLabel textLabel = new JLabel("Guess a number between 1 and " + range);
	JButton guessButton = new JButton("Guess");
	JTextField textBox = new JTextField("", 5);
	Container contentArea = getContentPane();
	JLabel guesses = new JLabel("You have " + nrOfGuesses + " guesses left");
	JLabel HighOrLow = new JLabel("");
	Random number = new Random();
	int rNum = number.nextInt(range);

	public TestNumber() {
		super("Input Example");
		setSize(290, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

		contentArea.setBackground(Color.WHITE);

		FlowLayout flowManager = new FlowLayout();
		contentArea.setLayout(flowManager);

		guessButton.addActionListener(this);
		// Add an event listener to the button

		contentArea.add(textLabel);
		contentArea.add(textBox);
		contentArea.add(guessButton);
		contentArea.add(guesses);
		contentArea.add(HighOrLow);
		contentArea.add(primeLabel);
		setContentPane(contentArea);
		
		getRootPane().setDefaultButton(guessButton);

	}

	public void actionPerformed(ActionEvent event) {
		Random randomColor = new Random();
		int color = randomColor.nextInt(0xffffff);
		if (event.getSource() == guessButton) {

			contentArea.setBackground(new Color(color));
			String numberString = textBox.getText();
			textLabel.setText("Guess a number between 1 and " + range);
			if(numberString.matches("-?[0-9]+")){
				
				if(numberString.length() >= 10){
					textLabel.setText("That number isn't within the given range");
				}else{
				
				int guessedNumber = Integer.parseInt(numberString);
				testNumber(guessedNumber, rNum);
				textBox.setText("");
				
				}
			}else{
				textLabel.setText("That's not a number");
			}
			
		}
	}

	public void testNumber(int gNum, int rNum) {
		primeLabel.setText(testIfPrime(gNum));
		i++;
		if (gNum == rNum) {

			textLabel.setText("Correct, the number is "
					+ rNum);

			contentArea.remove(textBox);
			contentArea.remove(guessButton);
			contentArea.remove(guesses);
			contentArea.remove(HighOrLow);
		} else {
			if (nrOfGuesses == 1) {
				contentArea.remove(textBox);
				contentArea.remove(guessButton);
				contentArea.remove(guesses);
				contentArea.remove(HighOrLow);
				textLabel.setText("You lost, the number was " + rNum);
			}
			if (gNum > range || gNum < (range - (range - 1))) {
				textLabel.setText(gNum
						+ " isn't within the given range. Try again");
				return;
			}
			if (gNum > rNum) {
				HighOrLow.setText("Too high");
				nrOfGuesses--;

			} else if (gNum < rNum) {
				HighOrLow.setText("Too low");
				nrOfGuesses--;

			}
			guesses.setText("You have " + nrOfGuesses + " guesses left");
		}
	}
	
	public String testIfPrime(int number){
		
		for(int i = 2; i < number; i++){
			if(number % i == 0){
				return "This is not a prime number";
			}
		}
		
		return "This is a prime number";
	}

}

public class Screen {
	public static void main(String[] args) {
		TestNumber Win = new TestNumber();

	}
}
