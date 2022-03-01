package chess;

public class Pawn extends Piece{

    public Pawn(PieceColour p){
        colour = p;
        if(p == PieceColour.BLACK){
            setSymbol("" + blackPawn);
        }
        else {
            setSymbol("" + whitePawn);
        }
    }
    //general legit movement exlcuding start of game 2 space allowance
    public boolean isLegitMove(int currentY, int currentX, int destY, int destX){
        if(this.colour == PieceColour.BLACK){
            if(destY-currentY == 1 && Math.abs(destX-currentX) == 1 && Board.hasPiece(destY, destX)){
                if(Board.getPiece(destY, destX).colour == PieceColour.WHITE){
                    return true;
                }
            }
            if(currentX == destX && destY == currentY+1 && !Board.hasPiece(destY, destX)){
                return true;
            }

            if(currentY == 1){
                if(currentX == destX && destY == currentY+2 && !Board.hasPiece(currentY+1, currentX)){
                    return true;
                }
            }

        }
        else {
            if(destY-currentY == -1 && Math.abs(destX-currentX) == 1 && Board.hasPiece(destY, destX)){
                if(Board.getPiece(destY, destX).colour == PieceColour.BLACK){
                    return true;
                }
            }
            if(currentX==destX && destY==currentY-1 && !Board.hasPiece(destY, destX)){
                return true;
            }

            if(currentY == 6){
                if(currentX==destX && destY==currentY-2 && !Board.hasPiece(currentY-1, currentX)){
                    return true;
                }
            }

        }
        return false;
    }
	
}
