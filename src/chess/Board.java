package chess;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import chess.pieces.Bishop;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Pawn;
import chess.pieces.Piece;
import chess.pieces.Queen;
import chess.pieces.Rook;

/**
 * Manages the black and white pieces
 */
public class Board {
	/**
	 * Describes a piece on the board
	 */
	HashMap<Point, Piece> whitePieces;
	HashMap<Point, Piece> blackPieces;
	
	public Stack<Move> history;
	
	public boolean turn;
	public boolean topPlayer;

	/**
	 * Initailizes the pieces on the board according to what player is on the top
	 * @param topPlayer
	 */
	public Board(boolean topPlayer) {
		whitePieces  = new HashMap<>();
		blackPieces  = new HashMap<>();
		turn = true;
		this.topPlayer = topPlayer;
		
		history = new Stack<>();

		//Rooks
		for(int x = 0; x < 8; x++){
			whitePieces.put(new Point(x, (topPlayer ? 1 : 6)), new Pawn(true));
			blackPieces.put(new Point(x, (topPlayer ? 6 : 1)), new Pawn(true));
		}

		int whiteY = topPlayer ? 0 : 7;
		int blackY = topPlayer ? 7 : 0;

		whitePieces.put(new Point(0, whiteY), new Rook(true));
		whitePieces.put(new Point(1, whiteY), new Knight(true));
		whitePieces.put(new Point(2, whiteY), new Bishop(true));
		if(topPlayer){
			whitePieces.put(new Point(3, whiteY), new Queen(true));
			whitePieces.put(new Point(4, whiteY), new King(true));
		}
		else{
			whitePieces.put(new Point(3, whiteY), new Bishop(true));
			whitePieces.put(new Point(4, whiteY), new Queen(true));
		}
		whitePieces.put(new Point(5, whiteY), new Bishop(true));
		whitePieces.put(new Point(6, whiteY), new Knight(true));
		whitePieces.put(new Point(7, whiteY), new Rook(true));
		
		blackPieces.put(new Point(0, blackY), new Rook(false));
		blackPieces.put(new Point(1, blackY), new Knight(false));
		blackPieces.put(new Point(2, blackY), new Bishop(false));
		if(topPlayer){
			blackPieces.put(new Point(3, blackY), new Queen(false));
			blackPieces.put(new Point(4, blackY), new Bishop(false));
		}
		else{
			blackPieces.put(new Point(3, blackY), new King(false));
			blackPieces.put(new Point(4, blackY), new Queen(false));
		}
		blackPieces.put(new Point(5, blackY), new Bishop(false));
		blackPieces.put(new Point(6, blackY), new Knight(false));
		blackPieces.put(new Point(7, blackY), new Rook(false));
		
	}
	
	/**
	 * Determines if a move is valid and if so, changes the board accordingly
	 * @param from
	 * The beginning position of the piece
	 * @param to
	 * The ending position of the piece
	 */
	public void move(Move m){
		//TODO move piece on board
		if(whitePieces.containsKey(m.from)){
			whitePieces.put(m.to, whitePieces.remove(m.from));
		}
		else if(blackPieces.containsKey(m.from)){
			blackPieces.put(m.to, blackPieces.remove(m.from));
		}
		turn = !turn;
	}
	
	/**
	 * Returns the piece at a specific location, returns null if there is no piece there
	 * @param p
	 * The point we are looking at
	 */
	public Piece getPiece(Point p)
	{
		if(whitePieces.containsKey(p))
			return whitePieces.get(p);
		else if(blackPieces.containsKey(p))
			return blackPieces.get(p);
		else
			return null;
	}
	
	public boolean playerHasPieceAt(boolean player, Point pos){
		return getPiece(pos).isWhite() == player;
	}
}
