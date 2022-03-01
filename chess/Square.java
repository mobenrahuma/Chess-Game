package chess;

//This class requires your input
public class Square {
	private boolean hasPiece;
	private Piece p;

	public Piece getPiece(){
		return p;
	}

	public void setPiece(Piece p){
		this.p = p;
	}

	public void removePiece(){
		p = null;
	}

	public boolean hasPiece(){
		return hasPiece;
	}	
}
