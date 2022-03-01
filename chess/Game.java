package chess;
import java.util.*;

public class Game {
	private static boolean gameEnd=false;

	//This method requires your input
	public static void play(){
		Map<Character, Integer> charValues = new HashMap<>();
		charValues.put('a', 0);
		charValues.put('b', 1);
		charValues.put('c', 2);
		charValues.put('d', 3);
		charValues.put('e', 4);
		charValues.put('f', 5);
		charValues.put('g', 6);
		charValues.put('h', 7);

		String currentPlayer = "WHITE";

		while (!gameEnd){
			System.out.println();
			System.out.println("--------"+currentPlayer+" MOVES---------");
			Scanner playerInput = new Scanner(System.in);
			System.out.print("Enter origin: ");
			String pieceCoords = playerInput.nextLine();
			if(pieceCoords.equals("END")){
				System.out.println(currentPlayer + " has resigned");
				break;
			}
			if(!new CheckInput().checkCoordinateValidity(pieceCoords)){
				System.out.println("Invalid input");
				continue;
			}
			int j0 = charValues.get(pieceCoords.charAt(1));
			int i0 = Character.getNumericValue(pieceCoords.charAt(0)) - 1;
			Piece p = Board.getPiece(i0, j0);

			if (p == null) {
				System.out.println("You have not selected any piece");
				continue;
			}

			if(p.colour != PieceColour.valueOf(currentPlayer)){
				System.out.println("This is not your piece");
				continue;
			}

			String moveCoords;
			while(true) {
				System.out.print("Enter destination: ");
				moveCoords = new Scanner(System.in).nextLine();
				if (moveCoords.equals("END")) {
					System.out.println(currentPlayer + " has resigned!!");
					gameEnd = true;
					break;
				}
				if (!new CheckInput().checkCoordinateValidity(moveCoords)) {
					System.out.println("Invalid input!");
					continue;
				}
				int j1 = charValues.get(moveCoords.charAt(1));
				int i1 = Character.getNumericValue(moveCoords.charAt(0)) - 1;
				if (p.isLegitMove(i0, j0, i1, j1)){
					if (Board.movePiece(i0, j0, i1, j1, p)) {
						System.out.println(currentPlayer + " WINS");
						Board.printBoard();
						gameEnd = true;
						break;
					}
					break;
				}
				else{
					System.out.println("You cannot move the piece there!!");
				}
			}
			if(gameEnd)break;

			Board.printBoard();
			if(currentPlayer.equals("WHITE")){
				currentPlayer = "BLACK";
			}
			else {
				currentPlayer = "WHITE";
			}

		}
	}
	
	//This method should not be edited
	public static void main (String args[]){
		Board.initialiseBoard();
		Board.initialisePieces();
		Board.printBoard();
		Game.play();
	}
}
