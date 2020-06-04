package simonSays;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * In this class I put the scoring system and the name input.
 * 
 * In the score() method I create the scoreboard mechanics, if the button the player presses is the same as the sequence the score goes up, 
 * If it's not the same the score goes down.
 * The score gets shown in a JLabel.
 * 
 * In the naam() method I create the space where the player can enter his/her name.
 * I do this by creating a JTextField and a JButton.
 * The Player can press the button to enter his name and score into the database.
 *
 */
public class Score {

	Game game;
	int score = 0;
	public JLabel scoreboard = new JLabel("Score: " + score);
	
	public Score(Game game) {
		this.game = game;
	}

	public void score(String result) {
		if (result == "WIN") {
			score++;
		} else {
			score--;
		}
		System.out.println(score);
		scoreboard.setText("Score: " + score);
	}
	
	public void naam(JPanel panel) {
		JLabel naamlabel = new JLabel("          Naam: ");
		JTextField naamveld = new JTextField();
		naamveld.setPreferredSize(new Dimension(100, 30));
		JButton entername = new JButton("Enter name");
		entername.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				game.dc.insertNameIntoDB(naamveld.getText(), score);
			}
		});
		
		panel.add(naamlabel);
		panel.add(naamveld);
		panel.add(entername);
	}
	
}
