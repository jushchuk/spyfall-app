package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.Game;

public class PlayerView extends JPanel implements ActionListener{
	private Game game;
	private int numPlayers;
	private int currentPlayer;
	private boolean onPlayer;

	private JPanel buttonView;
	private JButton next;
	private JLabel text;

	private JPanel locationView;
	private JLabel locationText;
	private JLabel roleText;

	public PlayerView(Game game){
		this.game = game;
		currentPlayer = 0;
		onPlayer = true;
		setLayout(new GridLayout(0,1));

		buttonView = new JPanel(new BorderLayout());
		buttonView.setPreferredSize(new Dimension(350, 25));
		text = new JLabel("Select Number of players to continue");
		buttonView.add(text, BorderLayout.WEST);
		add(buttonView);

		locationView = new JPanel(new GridLayout(0,1));
		locationText = new JLabel("");
		roleText = new JLabel("");
		locationView.add(locationText);
		locationView.add(roleText);
		add(locationView);

	}

	public void setNumPlayers(int numPlayers){
		this.numPlayers = numPlayers;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String type = e.getActionCommand();
		if(type.equals("start")){
			next = new JButton("Next");
			next.setActionCommand("next");
			next.addActionListener(this);
			text.setText("Press next to see your location and role");
			buttonView.add(next, BorderLayout.EAST);

			//locationText.setText("Location: Unknown");
			//roleText.setText("Role: Unknown");
		}

		if(type.equals("next")){
			if(onPlayer){
				if(currentPlayer<numPlayers){
					text.setText("Once you know your location and role press next");

					//other jpanel that displays location and role is updated here
					roleText.setText("Role: "+game.getCurrentRoles()[currentPlayer]);
					if(game.getCurrentRoles()[currentPlayer].equals("You are the SPY")){
						locationText.setText("Location: HIDDEN");
					} else {
						locationText.setText("Location: "+game.getCurrentLocation());
					}
					if(currentPlayer==numPlayers-1){
						onPlayer = true;
					} else {
						onPlayer = false;
					}
					currentPlayer++;
				} else {
					removeAll();
					setLayout(new BorderLayout());
					text.setText("The game may begin!");
					add(text,BorderLayout.CENTER);
				}
			} else {
				text.setText("Pass to next player and they press next");

				//other jpanel that displays location and role is hidden here
				locationText.setText("");
				roleText.setText("");
				
				onPlayer = true;
			}
		}


		repaint();
		validate();

		//When this is pressed, playerView should move on to next role, 
		//but if all roles are exhausted then new message should appear
		//(Maybe "The game may begin!" and possible locations?)
	}

}
