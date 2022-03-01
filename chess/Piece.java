package chess;

//This class requires your input
public abstract class Piece{
	//white pieces
	protected final static char whiteKing = 9812;
	protected final static char whiteQueen = 9813;
	protected final static char whiteRook = 9814;
	protected final static char whiteBishop = 9815;
	protected final static char whiteKnight = 9816;
	protected final static char whitePawn = 9817;


	//black pieces
	protected final static char blackKing = 9818;
	protected final static char blackQueen = 9819;
	protected final static char blackRook = 9820;
	protected final static char blackBishop = 9821;
	protected final static char blackKnight = 9822;
	protected final static char blackPawn = 9823;


	private String symbol;
	protected PieceColour colour;

	public PieceColour getColour(){
		return colour;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol){
		this.symbol = symbol;
	}

	public abstract boolean isLegitMove(int currentX, int currentY, int destX, int destY);
}
