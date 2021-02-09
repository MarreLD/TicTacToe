import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

//WinWindow class is displayed when there is a winner 
public class WinWindow extends RestartWindow {
	private JButton restartButton;
	private WinButton reset;
	private String winner;
	private GameWindow gameWindow;

	// Constructor that calls the window() function that creates all the components
	// for
	// this window
	public WinWindow(int width, int height, String windowTitle, String winner, GameWindow gameWindow) {
		super(width, height, windowTitle);
		this.winner = winner;
		this.gameWindow = gameWindow;
		window();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

	// window method creates all the necessary components displayed on the JFrame
	@Override
	public void window() {
		// TODO Auto-generated method stub
		reset = new WinButton();
		this.setLayout(new GridLayout(2, 0));
		JLabel winText = new JLabel("Player " + winner + " won");
		restartButton = new JButton("Restart");
		restartButton.addActionListener(reset);
		winText.setHorizontalAlignment(JLabel.CENTER);
		this.add(winText);
		this.add(restartButton);
	}

	// ButtonPressed is the action listener class used to restart the game when the
	// restart button is pressed
	// Closes the old GameWindow and TieWindow, creates a brand new GameWindow
	private class WinButton implements ActionListener {
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
