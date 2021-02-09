import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

// TieWindow class is displayed when the game ends in a tie
public class TieWindow extends RestartWindow {
	private JButton restartButton;
	private GameWindow gameWindow;
	private TieButton reset;

	// Constructor that calls the window() function that creates all the components
	// for
	// this window
	public TieWindow(int width, int height, String windowTitle, GameWindow gameWindow) {
		super(width, height, windowTitle);
		this.gameWindow = gameWindow;
		window();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

	// window method creates all the necessary components displayed on the JFrame
	@Override
	public void window() {
		// TODO Auto-generated method stub
		reset = new TieButton();
		this.setLayout(new GridLayout(2, 0));
		JLabel tieText = new JLabel("The game ended in a tie");
		restartButton = new JButton("Restart");
		restartButton.addActionListener(reset);
		tieText.setHorizontalAlignment(JLabel.CENTER);
		this.add(tieText);
		this.add(restartButton);
	}

	// ButtonPressed is the action listener class used to restart the game when the
	// restart button is pressed
	// Closes the old GameWindow and TieWindow, creates a brand new GameWindow
	private class TieButton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == restartButton) {
				gameWindow.getFrame().dispose();
				gameWindow = new GameWindow();
				gameWindow.GameStart();
				dispose();
			}
		}
	}
}
