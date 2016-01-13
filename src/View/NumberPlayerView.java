package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.Game;

public class NumberPlayerView extends JPanel implements ActionListener{
	private Game game;
	private JComboBox players;
	private JButton start;
	private PlayerView pv;
	
	public NumberPlayerView(Game game, PlayerView pv){
		this.pv=pv;
		this.game = game;
		String[] playerOptions = {"3","4","5","6","7","8"};
		players = new JComboBox(playerOptions);
		
		start = new JButton("Start");
		start.setActionCommand("start");
		start.addActionListener(this);
		start.addActionListener(pv);
		add(players);
		add(start);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		int numPlayers = (players.getSelectedIndex()+3); 
		pv.setNumPlayers(numPlayers);
		game.createNewGame(numPlayers);
		add(new JLabel("Number of players: "+numPlayers));
		remove(players);
		remove(start);
		repaint();
		validate();
	}
}
