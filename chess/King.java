package chess;

public class King extends Piece{

    public King(PieceColour p){
        colour = p;
        if(p == PieceColour.BLACK){
            setSymbol("" + blackKing);
        }
        else {
            setSymbol("" + whiteKing);
        }
    }

    public boolean isLegitMove(int currentY, int currentX, int destY, int destX){
        if(currentX==destX && currentY==destY){
            return false;
        }
        if(Math.abs(destX-currentX) == 1 || Math.abs(destY-currentY) == 1){
            if(!Board.hasPiece(destY, destX)){
                return true;
            }
            else if(Board.getPiece(destY, destX).colour != this.colour){
                return true;
            }
            return false;
        }
        return false;
    }
}
