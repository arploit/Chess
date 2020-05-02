package chess.board;

import chess.Piece.Piece;
import org.w3c.dom.ls.LSOutput;


public abstract class Tile { // this is the abstract class which represent  Entity tile
    // this variables stores the tile coordinate
    int tileCoordinate;

    Tile(int tileCoordinate) {
        //sets the value for the tile coordinate
        this.tileCoordinate = tileCoordinate;
    }

    //Method which would be defined in other classes
    public abstract boolean istileOccupied();

    public abstract Piece getPiece();

}

//class for EmptyTile
public static  final class EmptyTile extends Tile {

    /*There is no such piece on that coordinate that's why no extra variable*/
    EmptyTile(int Coordinate) {
        super(Coordinate);
    }

    @Override
    public boolean istileOccupied() {
        return false;
    }

    @Override
    public Piece getPiece() {
        return null;
    }
}

public static final class OccupiedTile extends Tile {
    Piece pieceOnTile; /*the difference in this class this fetches piece coordinate*/

    OccupiedTile(int tileCoordinate, Piece pieceOnTile) {
         /* super keyword is used to refer the immediate parent class object, variable */
        super(tileCoordinate);
        this.pieceOnTile = pieceOnTile;

    }

    @Override
    public boolean istileOccupied() {
        return true;
    }

    @Override
    public Piece getPiece() {
        return this.pieceonTile;
    }
}
