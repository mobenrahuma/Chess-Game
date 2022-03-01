package chess;

public class Rook extends Piece{
    public Rook(PieceColour p){
        colour = p;
        if(p == PieceColour.BLACK){
            setSymbol("" + blackRook);
        }
        else {
            setSymbol("" + whiteRook);
        }
    }

    public boolean isLegitMove(int currentY, int currentX, int destY, int destX){
        if(currentY == destY && currentX!=destX){
            int xIncrement = destX - currentX > 0 ? 1 : -1;
            int xCount = currentX;

            while(xCount != destX){
                if(xCount != currentX && Board.hasPiece(currentY, xCount)){
                    return false;
                }
                xCount += xIncrement;
            }
            if(!Board.hasPiece(destY, destX)){
                return true;
            }
            if(Board.hasPiece(destY, destX) && Board.getPiece(destY, destX).colour != this.colour){
                return true;
            }
            else {
                return false;
            }
        }
        else if(currentX == destX && currentY!=destY){
            int yIncrement = destY - currentY > 0 ? 1 : -1;
            int yCount = currentY;

            while(yCount != destY){
                if(yCount != currentY && Board.hasPiece(yCount, currentX)){
                    return false;
                }
                yCount += yIncrement;
            }
            if(!Board.hasPiece(destY, destX)){
                return true;
            }
            if(Board.hasPiece(destY, destX) && Board.getPiece(destY, destX).colour != this.colour){
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }
}
