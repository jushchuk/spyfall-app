package View;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Model.Game;

public class PossibleLocationsView extends JPanel{
	private Game game;
	private JScrollPane sp; 
	private JTextArea textArea;
	

	public PossibleLocationsView(Game game){
		setLayout(new GridLayout(0,3));
		String[] locations=game.getLocation();
		add(new JLabel("Possible Locations:"));
		for (int i=0;i<locations.length;i++){
			add(new JLabel(locations[i]));
		}
		/*
		textArea = new JTextArea();
		String text = "Possible Locations: \n";
		for (int i=0;i<locations.length;i++){
			if(i==locations.length-1){
				text = text + locations[i];
			} else {
				text = text + locations[i] + "\n";	
			}
		}
		textArea.setText(text);
		sp = new JScrollPane(textArea);
		sp.setPreferredSize(new Dimension(300, 200));
		
		add(sp);
		*/
		repaint();
	}
}
