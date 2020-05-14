package chess.Piece;


import chess.Alliance;
import chess.board.Board;
import chess.board.Move;

import java.util.Collection;

public abstract class Piece {

    protected final int piecePosition; //Every Piece has a position
    protected final Alliance pieceAlliance ; /*Black or White enum class Alliance*/

    Piece (final int piecePosition, final Alliance pieceAlliance){
        this.pieceAlliance = pieceAlliance; /*assigning piece Alliance*/
        this.piecePosition = piecePosition; /*assigning Piece Position on the Chess board*/
    }

    public Alliance getPieceAlliance(){
        return this.pieceAlliance;

    }
    /*A Collection is a group of individual objects represented as a single unit.
    *Java provides Collection Framework which defines several classes and interfaces to represent a group of objects as a single unit
    *
    * *Before Collection Framework (or before JDK 1.2) was introduced,
    *the standard methods for grouping Java objects (or collections) were Arrays or Vectors or Hashtables.
    *All of these collections had no common interface.
    *Accessing elements of these Data Structures was a hassle
    * as each had a different method (and syntax) for accessing its members*/

    public abstract Collection<Move> calculateLegalMoves(final Board board); /*abstract class to declare the List of legal Moves*/
}
