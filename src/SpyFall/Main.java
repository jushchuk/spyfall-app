package SpyFall;

import java.awt.Dimension;

import javax.swing.JFrame;

import Model.Game;
import View.GameView;

public class Main {

	public static void main(String[] args) {
		JFrame main_frame = new JFrame();
		main_frame.setTitle("Spyfall");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Game g = new Game();
		
		GameView v = new GameView(g);
		main_frame.setContentPane(v);
		main_frame.pack();
		main_frame.setVisible(true);	
	}

}
