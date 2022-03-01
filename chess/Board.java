package chess;


//This class is partially implemented
public class Board {
	private static Square [][] board = new Square[8][8];

	//This method should not be edited
	public static void initialiseBoard(){
		for (int i=0; i<board[0].length; i++){
			for (int j=0; j<board[1].length; j++)
					board[i][j]=new Square();
		}		
	}
    
	//This method requires your input	
	public static void initialisePieces(){
		//Adding All Black pieces to board
		Piece blackRook1 = new Rook(PieceColour.BLACK);
		setPiece(0,0,blackRook1);

		Piece blackRook2 = new Rook(PieceColour.BLACK);
		setPiece(0,7,blackRook2);

		Piece blackKnight1 = new Knight(PieceColour.BLACK);
		setPiece(0,1,blackKnight1);

		Piece blackKnight2 = new Knight(PieceColour.BLACK);
		setPiece(0,6,blackKnight2);

		Piece blackBishop1 = new Bishop(PieceColour.BLACK);
		setPiece(0,2,blackBishop1);

		Piece blackBishop2 = new Bishop(PieceColour.BLACK);
		setPiece(0,5,blackBishop2);

		Piece bQueen = new Queen(PieceColour.BLACK);
		setPiece(0,3,bQueen);

		Piece bKing = new King(PieceColour.BLACK);
		setPiece(0,4,bKing);

		for(int i=0; i<8; i++){
			Piece p = new Pawn(PieceColour.BLACK);
			setPiece(1,i,p);
		}

		//Adding All white pieces to the board

		Piece whiteRook1 = new Rook(PieceColour.WHITE);
		setPiece(7,0,whiteRook1);

		Piece whiteRook2 = new Rook(PieceColour.WHITE);
		setPiece(7,7,whiteRook2);

		Piece whiteKnight1 = new Knight(PieceColour.WHITE);
		setPiece(7,1,whiteKnight1);

		Piece whiteKnight2 = new Knight(PieceColour.WHITE);
		setPiece(7,6,whiteKnight2);

		Piece whiteBishop1 = new Bishop(PieceColour.WHITE);
		setPiece(7,2,whiteBishop1);

		Piece whiteBishop2 = new Bishop(PieceColour.WHITE);
		setPiece(7,5,whiteBishop2);

		Piece wQueen = new Queen(PieceColour.WHITE);
		setPiece(7,3,wQueen);

		Piece wKing = new King(PieceColour.WHITE);
		setPiece(7,4,wKing);

		for(int i=0; i<8; i++){
			Piece p = new Pawn(PieceColour.WHITE);
			setPiece(6,i,p);
		}
	}
	
	//This method requires your input	
	public static void printBoard(){
		System.out.print("\n  a b c d e f g h \n");
		System.out.print("  -----------------\n");		
		for (int i=0; i<board[0].length; i++){
			int row=i+1;
				for (int j=0; j<board[1].length; j++){
					if ((j==0) && Board.hasPiece(i,j))
						System.out.print(row+" "+Board.getPiece(i,j).getSymbol());	
					else if ((j==0) && !Board.hasPiece(i,j))
						System.out.print(row+"  " );
					else if (Board.hasPiece(i,j))					
						System.out.print("|"+Board.getPiece(i,j).getSymbol());					
					else					
						System.out.print("| ");		
				}				
				System.out.print("  "+row+"\n");
		}
		System.out.print("  -----------------");
		System.out.print("\n  a b c d e f g h \n");	
	}
	
	//This method requires your input, need to implement captures here as well
	public static boolean movePiece(int i0, int j0, int i1, int j1, Piece p){
		if(p.isLegitMove(i0, j0, i1, j1)){
			setPiece(i1, j1, p);
			board[i0][j0].removePiece();
			if(kingCaptured(p)){
				return true;
			}
			return false;
		}
		return false;
	}


	public static void setPiece(int iIn, int jIn, Piece p){
		board[iIn][jIn].setPiece(p);
	}
	
	//This method requires your input
	public static Piece getPiece(int iIn, int jIn){
		if(board[iIn][jIn].getPiece() != null){
			return board[iIn][jIn].getPiece();
		}
		return null;
	}
	
	//This method requires your input
	public static boolean hasPiece(int i, int j){
		if(board[i][j].getPiece() != null){
			return true;
		}
		return false;

	}

	public static boolean kingCaptured(Piece p){
		PieceColour colour = p.colour == PieceColour.BLACK ? PieceColour.WHITE : PieceColour.BLACK;
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[i].length; j++){
				Piece currentPiece = board[i][j].getPiece();
				if(currentPiece == null){
					continue;
				}
				if(currentPiece.colour == colour && currentPiece instanceof King){
					return false;
				}
			}
		}
		return true;
	}


}
