package models.Pieces;

import models.Helpers.Color;

public abstract class Piece {
    private final PieceName pieceName;
    private final Color color;
    private boolean killed;

    public Piece(PieceName pieceName, Color color) {
        this.killed = false;
        this.pieceName = pieceName;
        this.color = color;
    }
}
