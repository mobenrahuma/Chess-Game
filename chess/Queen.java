package chess;

public class Queen extends Piece{
    public Queen(PieceColour p){
        colour = p;
        if(p == PieceColour.BLACK){
            setSymbol("" + blackQueen);
        }
        else {
            setSymbol("" + whiteQueen);
        }
    }

    public boolean isLegitMove(int currentY, int currentX, int destY, int destX){
        if(new Rook(colour).isLegitMove(currentY, currentX, destY, destX) ||
                new Bishop(colour).isLegitMove(currentY, currentX, destY, destX)||
                new Pawn(colour).isLegitMove(currentY, currentX, destY, destX)){
            return true;
        }
        return false;

    }
}
