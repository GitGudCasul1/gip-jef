package simonSays;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Score {

	int score = 0;
	public JLabel scoreboard = new JLabel("Score: " + score);
	
	public void score(String result) {
		if (result == "WIN") {
			score++;
		} else {
			score--;
		}
		System.out.println(score);
		scoreboard.setText("Score: " + score);
	}
	
}
