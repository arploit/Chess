package chess.board;

import chess.Piece.Piece;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.Map;


public abstract class Tile { // this is the abstract class which represent  Entity tile
    // this variables stores the tile coordinate
    protected final int tileCoordinate; //making class immutable so that no one can excess  it from outside
    /*
     *  Immutability:
     *   Immutability is a design pattern where something  can't be modified after being instantiated
     *
     *
     *
     * */


    private static final Map<Integer, EmptyTile> Empty_Tiles_Cache = createAllPossibleEmptyTiles(); //function to create

    private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles() {


        final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();

        for (int i = 0; i < BoardUtils.NUM_TILES; i++) {
            emptyTileMap.put(i, new EmptyTile(i));
        }

        return ImmutableMap.copyOf(emptyTileMap);

    }

    public static Tile createTile(final int tileCoordinate, final Piece piece) {
        return piece != null ? new OccupiedTile(tileCoordinate, piece) : Empty_Tiles_Cache.get(tileCoordinate);

    }

    private Tile(final int tileCoordinate) {
        //sets the value for the tile coordinate
        this.tileCoordinate = tileCoordinate;
    }

    //Method which would be defined in other classes
    public abstract boolean istileOccupied();

    public abstract Piece getPiece();


    //class for EmptyTile
    public static final class EmptyTile extends Tile {

        /*There is no such piece on that coordinate that's why no extra variable*/
        private EmptyTile(final int coordinate) {
            super(coordinate);
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
        private final Piece pieceOnTile; /*the difference in this class this fetches piece coordinate*/

        private OccupiedTile(int tileCoordinate, final Piece pieceOnTile) { /*Making subclass Constructor Private*/
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

            return this.pieceOnTile;
        }
    }
}