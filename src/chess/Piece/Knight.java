package chess.Piece;

import chess.Alliance;
import chess.board.Board;
import chess.board.Move;
import chess.board.Tile;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {
    
    private final static int [] CANDIDATES_MOVE_COORDINATES = {-17,-15,-10,-6,6,10,15,17};/*ALL THE LEGAL MOVES KNIGHT CAN TAKE*/


    Knight(final int piecePosition,final Alliance pieceAlliance) {
        super(piecePosition, pieceAlliance);
    }

    @Override
    public List<Move> calculateLegalMoves(Board Board) {

        int candidateDestinationCoordinate;
        final List<Move> legalMoves = new ArrayList<>();

        for(final int currentCanditate : CANDIDATES_MOVE_COORDINATES) {

            candidateDestinationCoordinate = this.piecePosition + currentCanditate;
            if (true /*isValidCoordinate*/) {
                final Tile candidateDestinationTile = board.getTile(candidateDestinationCoordinate);
                if (!candidateDestinationTile.istileOccupied()) {
                    legalMoves.add(new Move());
                } else {
                    final Piece pieceAtDestination = candidateDestinationTile.getPiece();
                    final Alliance pieceAlliance = pieceAtDestination.getPieceAlliance();
                    if (this.pieceAlliance != pieceAlliance) {
                        legalMoves.add(new Move());

                    }
                }
            }
        }
        return ImmutableList.copyOf(legalMoves);
    }
}
