package simonSays;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

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
				gameinstantie.showSequence();
			}

		});
				
		panel.add(red);
		panel.add(green);
		panel.add(yellow);
		panel.add(blue);
		panel.add(start);
	}
	
	private void input(String kleur) { //this method is what happens when you press a button
		input = input + kleur;
		System.out.println(input);
	}
	
	private void controleinput() { //this method is work in progress
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