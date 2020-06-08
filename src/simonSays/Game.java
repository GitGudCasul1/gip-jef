package simonSays;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * 
 * in this class i made the system that makes the pattern and shows it to the user.
 * 
 * in the veranderkleur() method I put the code that changes the color of the buttons when the sequence gets shown.
 * I did this by using a timer and an actionlistner.
 * The code in the actionlistner gets executed when the timer expires.
 * 
 * in the makesequenceActionListener() method i put the code that shows the player the sequence.
 * I did this by putting this method in a timer and the code gets executed every time the timer expires.
 * Every time that the code gets executed the next character in the sequence string gets checked.
 * When the color is red, the red button changes color to white for a short moment.
 * 
 * in the showsequence() method I make the program show the randomly generated sequence to the player.
 * I do this with a timer, in the timer I run antother method which shows the sequence in the game.
 * 
 * in the simon() method I create a randomly generated sequence.
 * I did this by creating an array with all the button colors inside it and then getting a random color.
 * After i get a random color I put it inside of the sequence.
 *
 */
public class Game {
	public String sequence = "";
	public int patternlength = 0;
	int gameScore = 0;
	Buttons buttons;
	Score score;
	int sequenceCounter = 0;
	public Timer t = new Timer(2000, makesequenceActionListener());
	public DatabaseConnectie dc = new DatabaseConnectie();
	
	public static void main(String[] args) { //this is the main method, this is where you run other methods
		Game game = new Game();
		game.score = new Score(game);
		game.buttons = new Buttons(game, game.score);
		JFrame frame = new JFrame();
		frame.setSize(900,600);
		JPanel panel = new JPanel();
		
		game.buttons.buttons(panel);
		game.simon(game.patternlength);
		panel.add(game.score.scoreboard);
		game.score.naam(panel);
		game.score.difficulty(panel);
		
		frame.add(panel);
		frame.setVisible(true);
	}
	
	
	
	private void veranderkleur(JButton kleurknop) {
		Color orignelekleur = kleurknop.getBackground();
		kleurknop.setBackground(Color.WHITE);
		Timer t = new Timer(1800, new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	kleurknop.setBackground(orignelekleur);
		    }
		});
		t.start();
	}
	
	public ActionListener makesequenceActionListener() {
		return new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	if (sequenceCounter > sequence.length() - 1) {
		    		sequenceCounter = 0;
		    		t.stop();
		    		return;
		    	}
		    	
		    	char c = sequence.charAt(sequenceCounter);
		    	sequenceCounter++;
		    	if (c == 'Y') {
		    		veranderkleur(buttons.yellow);		    		
		    	}
		    	if (c == 'R') {
		    		veranderkleur(buttons.red);		    		
		    	}
		    	if (c == 'G') {
		    		veranderkleur(buttons.green);		    		
		    	}
		    	if (c == 'B') {
		    		veranderkleur(buttons.blue);		    		
		    	}
		    }
		};
	}
	
public void showSequence() {
		
		t.setRepeats(true);
		t.setInitialDelay(0);
		t.start();
	}

	
	
	
	public void simon(int length) { //this method creates a random pattern of letters
		String[] array = {"R", "G", "Y","B"};
		Random r = new Random();
		
		for (int i = 0; i < length; i++) {
			int randomNumber = r.nextInt(array.length);
			sequence = sequence + array[randomNumber];			
		}
		
		System.out.println(sequence);		//test
	}
	
	
	

}