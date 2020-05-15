package chess.Piece;

import chess.Alliance;
import chess.board.Board;
import chess.board.BoardUtils;
import chess.board.Move;
import chess.board.Tile;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static chess.board.Move.*;

public class Knight extends Piece {
    
    private final static int [] CANDIDATES_MOVE_COORDINATES = {-17,-15,-10,-6,6,10,15,17};/*ALL THE LEGAL MOVES KNIGHT CAN TAKE*/


    Knight(final int piecePosition,final Alliance pieceAlliance) {
        super(piecePosition, pieceAlliance);
    }

    @Override
    public Collection<Move> calculateLegalMoves(final Board board) {

        final List<Move> legalMoves = new ArrayList<>();

        for(final int currentCanditateOffset : CANDIDATES_MOVE_COORDINATES) {

         final  int candidateDestinationCoordinate = this.piecePosition + currentCanditateOffset;
         /*candidateDestinationCoordinate will take more space
         * but will be local so easy to access
         * */
            if (BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {

                /*if any of the edge cases failes loop will not work*/

                if (isFirstColumnExclusion(this.piecePosition, currentCanditateOffset) ||
                        isSeconColumnExclusion(this.piecePosition, currentCanditateOffset) ||
                        isSeventhColumnExclusion(this.piecePosition, currentCanditateOffset) ||
                        isEighthColumnExclusion(this.piecePosition, currentCanditateOffset)) {
                    continue;
                }


                final Tile candidateDestinationTile = board.getTile(candidateDestinationCoordinate);
                if (!candidateDestinationTile.istileOccupied()) {
                    boolean add = legalMoves.add(new MajorMove(board, this, candidateDestinationCoordinate));
                    /*Added move if there is no Piece on the Tile*/
                } else {
                    final Piece pieceAtDestination = candidateDestinationTile.getPiece();
                    final Alliance pieceAlliance = pieceAtDestination.getPieceAlliance();
                    if (this.pieceAlliance != pieceAlliance) {
                        legalMoves.add(new AttackMove(board,this, candidateDestinationCoordinate ,pieceAtDestination));
                        /*Added move if there is a Piece on the Tile*/
                    }
                }
            }
        }
        return ImmutableList.copyOf(legalMoves);
    }

    /*These function will tell if knight is not moving against its edge cases
    * Every offset is the edge case in which knight move would be illegal
    * */

    private static boolean isFirstColumnExclusion(final int currentPosition, final int candidateOffset){
        return BoardUtils.FIRST_COLUMN[currentPosition] && (candidateOffset == -17 || candidateOffset == -10
                || candidateOffset == 6 || candidateOffset == 15);
    }

    private static boolean isSeconColumnExclusion(final int currentPosition, final int candidateOffset){
        return BoardUtils.SECOND_COLUMN[currentPosition] && (candidateOffset == -10 || candidateOffset == 6);
    }

    private static boolean isSeventhColumnExclusion(final int currentPosition, final int candidateOffset){
        return BoardUtils.SEVENTH_COLUMN[currentPosition] && (candidateOffset == -6 || candidateOffset == 10);
    }

    private static boolean isEighthColumnExclusion (final int currentPosition, final int candidateOffset){
        return  BoardUtils.EIGHTH_COLUMN[currentPosition] && (candidateOffset == -15 || candidateOffset == -6
                || candidateOffset == 10 || candidateOffset == 17);
    }
}






















