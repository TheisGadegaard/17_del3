/* This class has the responsibility of handling the player's piece/car.
 * It carries two private variables:
 * 		- An integer with the current board-position of the piece
 * 		- A color for the piece's color.
 */

package diceGame;
import java.awt.Color;


public class Piece {
	private int position;
	private Color color;

	// Constructor - In order to create the piece, you will need to give the vehicle a color using java.awt.Color;
	public Piece(Color color) {
		this.color = color;
		position = 0;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	// Move the piece to a position using an integer
	public void setPosition(int position) {
		this.position = position;
	}
	
	public int getPosition() {
		return this.position;
	}

}

