package models.Pieces;

import models.Board.Cell;
import models.Helpers.Color;

public class Pawn extends Piece implements ChessPiece{

    public Pawn(PieceName pieceName, Color color) {
        super(pieceName,color);
    }


    @Override
    public void makeMove(Cell start, Cell end) {

    }

    @Override
    public boolean canMove(Cell start, Cell end) {
        return false;
    }

    @Override
    public boolean isKilled() {
        return this.getKilled();
    }

    @Override
    public void setKilled(boolean killed) {
        this.setKilled(killed);
    }

    @Override
    public void listPossibleMoves(Cell currentCell) {

    }
}
