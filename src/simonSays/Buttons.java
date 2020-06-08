package simonSays;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * 
 * In this class I made the buttons and the system that checks if the input is correct.
 * Every button has an unique color.
 * The player needs to press the buttons in the same order as shown in the sequence in order to score points.
 * 
 * In the buttons() method I create all the buttons that you can see on the screen.
 * I do that by creating 4 JButtons.
 * In the actionlistner I put what happens when you press a button.
 * 
 * In the input() method I put the code that gets executed when the player presses a button.
 * 
 * In the controleinput() method I check if the players input is the same as the randomly generated sequence.
 * I do this by making a char for the input and the sequence and then checking if those 2 chars are the same.
 * If the 2 chars are the same the score goes up, if they are not the same the score goes down.
 *
 */
public class Buttons {
	
	public JButton blue, yellow, green, red;
	String input = "";
	int length = 0;
	
	Game gameinstantie;
	Score scoreinstantie;
    public Buttons(Game game, Score score) {
        this.gameinstantie = game;
        this.scoreinstantie = score;
    }
	
	public void buttons(JPanel panel) { //this method creates the buttons
		
		red = new JButton("red");
		red.setBackground(Color.red);
		red.setPreferredSize(new Dimension(200, 100));
		red.addActionListener(new ActionListener() {			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				input("R");	
				controleinput();
				length++;
			}
		});
		
		green = new JButton("green");
		green.setBackground(Color.green);
		green.setPreferredSize(new Dimension(200, 100));
		green.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				input("G");	
				controleinput();
				length++;
			}
		});
		
		yellow = new JButton("yellow");
		yellow.setBackground(Color.yellow);
		yellow.setPreferredSize(new Dimension(200, 100));
		yellow.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				input("Y");
				controleinput();
				length++;
			}
		});
		
		blue = new JButton("blue");
		blue.setBackground(Color.blue);
		blue.setPreferredSize(new Dimension(200, 100));
		blue.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				input("B");
				controleinput();
				length++;
			}
		});
		
		JButton start = new JButton("Start");
		start.setPreferredSize(new Dimension(100,50));
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				controleinput();
				gameinstantie.simon();
				gameinstantie.showSequence();
			}
		});
		
		JButton nextSeq = new JButton("Next Sequence");
		nextSeq.setPreferredSize(new Dimension(150, 50));
		nextSeq.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gameinstantie.sequence = "";
				input = "";
				length = 0;
				gameinstantie.simon(gameinstantie.patternlength);
			}
		});
				
		panel.add(red);
		panel.add(green);
		panel.add(yellow);
		panel.add(blue);
		panel.add(start);
		panel.add(nextSeq);
	}
	
	private void input(String kleur) { //this method is what happens when you press a button
		input = input + kleur;
		System.out.println(input);
	}
	
	private void controleinput() { //this method is work in progress
		if (length > gameinstantie.sequence.length() - 1) {
			//this code is executed if the pattern is finished and the user presses another button
			System.out.println("sequence ended");
			return;
		}
		char inputchar = input.charAt(length);
		char sequencechar = gameinstantie.sequence.charAt(length);
		
		if(inputchar == sequencechar) {
			//System.out.println("WIN");
			scoreinstantie.score("WIN");
		} else {
			//System.out.println("LOSE");
			scoreinstantie.score("LOSE");
		}
	}
	
}