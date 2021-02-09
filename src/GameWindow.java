import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameWindow {
	// an arraylist which contains the class Buttons
	public ArrayList<Button> buttons;
	private JFrame frame;

	// boolean that is either true or false to keep track of which players turn it is
	private boolean playerTurn = true;
	//creates a new object of the class Rules
	private Rules rules;
	//creates a new object of the class Button
	private Button boxButton;
	// this String holds the winner variable
	private String winner;

	// this method starts the main game window with all the components
	public void GameStart() {
		rules = new Rules();
		buttons = new ArrayList<>();
		frame = new JFrame("Tic Tac Toe");
		frame.setSize(400, 400);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 3));
		frame.add(panel);

		// creates the game board with 9 buttons
		for (int i = 0; i < 9; i++) {
			boxButton = new Button(this, rules);
			// adds actionlistener to every button
			boxButton.addActionListener(boxButton);
			// adds the buttons created to the arraylist
			buttons.add(boxButton);
			panel.add(boxButton);
		}

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
	// pops out a new window if a player has won or the game ended in a tie
	public void winTie() {
		if (rules.isWin()) {
			new WinWindow(300, 200, "Win Window", getWinner(), this);
		} else if (rules.isTie() && rules.isWin() == false) {
			new TieWindow(300, 200, "Tie Window", this);
		}
	}

	// getters and setters below
	public boolean isPlayerTurn() {
		return playerTurn;
	}

	public void setPlayerTurn(boolean playerTurn) {
		this.playerTurn = playerTurn;
	}
	
	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}
	
	public JFrame getFrame() {
		return frame;
	}
}
