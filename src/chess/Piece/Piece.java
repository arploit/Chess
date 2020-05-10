package chess.Piece;


import chess.Alliance;
import chess.board.Board;
import chess.board.Move;

import java.util.List;

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

    public abstract List<Move> calculateLegalMoves(final Board Board); /*abstract class to declare the List of legal Moves*/
}
