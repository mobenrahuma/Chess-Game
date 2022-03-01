package chess;

public class Bishop extends Piece {
    public Bishop(PieceColour p){
        colour = p;
        if(p == PieceColour.BLACK){
            setSymbol("" + blackBishop);
        }
        else {
            setSymbol("" + whiteBishop);
        }
    }


    public boolean isLegitMove(int currentY, int currentX, int destY, int destX){
        if(currentX==destX && currentY==destY){
            return false;
        }
        if(destX < 0 || destX > 7){
            return false;
        }
        if(destY < 0 || destY > 7){
            return false;
        }
        if(Math.abs(destX-currentX) == Math.abs(destY-currentY)){

            int xIncrement = destX-currentX > 0 ? 1 : -1;
            int yIncrement = destY - currentY > 0 ? 1 : -1;

            int xCount = currentX;
            int yCount = currentY;

            while(xCount!=destX || yCount!=destY){
                if(xCount != currentX && Board.hasPiece(yCount, xCount)){
                    return false;
                }
                xCount += xIncrement;
                yCount += yIncrement;
            }
            if(!Board.hasPiece(destY, destX)){
                return true;
            }
            if(Board.hasPiece(destY, destX) && Board.getPiece(destY, destX).colour != this.colour){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }

}
