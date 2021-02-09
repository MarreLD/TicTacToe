import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

// Buttons class to get and set the buttons value
public class Button extends JButton implements ActionListener {
	private int value;
	private GameWindow window;
	private Rules ruleCheck;

	public Button(GameWindow window, Rules ruleCheck) {
		// TODO Auto-generated constructor stub
		this.window = window;
		this.ruleCheck = ruleCheck;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (window.isPlayerTurn()) {
			this.setText("X");
			this.setValue(1);
			this.setEnabled(false);
			window.setWinner("X");
			window.setPlayerTurn(false);
		} else if (window.isPlayerTurn() == false) {
			this.setText("O");
			this.setValue(2);
			this.setEnabled(false);
			window.setWinner("O");
			window.setPlayerTurn(true);
		}
		// checks after every click if there is a winner or if the game ended in a tie
		ruleCheck.winCondition(window);
		window.winTie();
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
