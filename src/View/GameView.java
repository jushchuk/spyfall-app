package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Model.Game;

public class GameView extends JPanel{
	private Game game;
	

	
	public GameView(Game game){
		this.game = game;
		setLayout(new BorderLayout());
		
		PlayerView pv = new PlayerView(game);
		NumberPlayerView npv = new NumberPlayerView(game,pv);
		
		
		add(npv, BorderLayout.NORTH);
		add(pv, BorderLayout.CENTER);
	}
}
