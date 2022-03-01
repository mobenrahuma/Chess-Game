package chess;

public class Knight extends Piece {
    public Knight(PieceColour p){
        colour = p;
        if(p == PieceColour.BLACK){
            setSymbol("" + blackKnight);
        }
        else {
            setSymbol("" + whiteKnight);
        }
    }

    public boolean isLegitMove(int currentY, int currentX, int destY, int destX){
        if(currentX==destX && currentY==destY){
            return false;
        }
        if(Math.abs(destX-currentX) == 2 && Math.abs(destY-currentY) == 1){
            if(!Board.hasPiece(destY, destX)){
                return true;
            }
            else {
                if(Board.getPiece(destY, destX).colour != this.colour){
                    return true;
                }
                return false;
            }

        }
        if(Math.abs(destY-currentY) == 2 && Math.abs(destX-currentX) == 1){
            if(!Board.hasPiece(destY, destX)){
                return true;
            }
            else {
                if(Board.getPiece(destY, destX).colour != this.colour){
                    return true;
                }
                return false;
            }
        }
        return false ;

    }
}
