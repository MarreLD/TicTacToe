// Rules Class checks the win conditon for a player to win
public class Rules {
	private boolean win = false;
	private boolean tie = false;
	private int tieCount;

	public void winCondition(GameWindow windowObj) {
		// increments the tie count for each button click
		tieCount++;
		
		// Horizontal win conditions, checks if the buttons have the same value
		// horizontally
		if (windowObj.buttons.get(0).getValue() == windowObj.buttons.get(1).getValue()
				&& windowObj.buttons.get(1).getValue() == windowObj.buttons.get(2).getValue()
				&& windowObj.buttons.get(0).getValue() != 0) {
			win = true;

		}
		if (windowObj.buttons.get(3).getValue() == windowObj.buttons.get(4).getValue()
				&& windowObj.buttons.get(4).getValue() == windowObj.buttons.get(5).getValue()
				&& windowObj.buttons.get(3).getValue() != 0) {
			win = true;
		}
		if (windowObj.buttons.get(6).getValue() == windowObj.buttons.get(7).getValue()
				&& windowObj.buttons.get(7).getValue() == windowObj.buttons.get(8).getValue()
				&& windowObj.buttons.get(6).getValue() != 0) {
			win = true;
		}

		// Vertical win conditions, checks if the buttons have the same value vertically
		if (windowObj.buttons.get(0).getValue() == windowObj.buttons.get(3).getValue()
				&& windowObj.buttons.get(3).getValue() == windowObj.buttons.get(6).getValue()
				&& windowObj.buttons.get(0).getValue() != 0) {
			win = true;
		}
		if (windowObj.buttons.get(1).getValue() == windowObj.buttons.get(4).getValue()
				&& windowObj.buttons.get(4).getValue() == windowObj.buttons.get(7).getValue()
				&& windowObj.buttons.get(1).getValue() != 0) {
			win = true;
		}
		if (windowObj.buttons.get(2).getValue() == windowObj.buttons.get(5).getValue()
				&& windowObj.buttons.get(5).getValue() == windowObj.buttons.get(8).getValue()
				&& windowObj.buttons.get(2).getValue() != 0) {
			win = true;
		}

		// Diagonal win conditions, checks if the buttons have the same value diagonally
		if (windowObj.buttons.get(0).getValue() == windowObj.buttons.get(4).getValue()
				&& windowObj.buttons.get(4).getValue() == windowObj.buttons.get(8).getValue()
				&& windowObj.buttons.get(0).getValue() != 0) {
			win = true;
		}
		if (windowObj.buttons.get(2).getValue() == windowObj.buttons.get(4).getValue()
				&& windowObj.buttons.get(4).getValue() == windowObj.buttons.get(6).getValue()
				&& windowObj.buttons.get(2).getValue() != 0) {
			win = true;

		}

		// If win is true disable all buttons
		if (win) {
			for (int i = 0; i < windowObj.buttons.size(); i++) {
				windowObj.buttons.get(i).setEnabled(false);
			}
		// if the tie counter reaches 9 and nobody has won, set tie to true
		} else if (tieCount == 9 && win == false) {
			tie = true;
		}

	}
	
	// All the getters and the setters below
	public boolean isTie() {
		return tie;
	}

	public boolean isWin() {
		return win;
	}


}
