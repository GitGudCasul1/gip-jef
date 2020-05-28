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
 * in this class I put the scoring system and the name input
 *
 */
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
	
	public void naam(JPanel panel) {
		JLabel naamlabel = new JLabel("          Naam: ");
		JTextField naamveld = new JTextField();
		naamveld.setPreferredSize(new Dimension(100, 30));
		JButton entername = new JButton("Enter name");
		entername.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		panel.add(naamlabel);
		panel.add(naamveld);
		panel.add(entername);
	}
	
}
