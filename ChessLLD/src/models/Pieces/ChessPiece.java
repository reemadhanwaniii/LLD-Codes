package models.Pieces;

import models.Board.Cell;

public interface ChessPiece {
    void makeMove(Cell start,Cell end);
    boolean canMove(Cell start,Cell end);
    boolean isKilled();
    void setKilled(boolean isKilled);
    void listPossibleMoves(Cell currentCell);
}
