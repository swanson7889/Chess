package chess.pieces;

import java.util.ArrayList;

import chess.Board;
import chess.Move;
import chess.Point;

public class King extends Piece
{
	private boolean hasMoved;
	
	public King(Point p)
	{
		super(100, p);
		hasMoved = false;
	}

	//Still to do
	public ArrayList<Move> getMoves(Board board)
	{
		ArrayList<Move> moves = new ArrayList<Move>();
		
		for (int i = 0; i < 8; i++)
		{
			Point to = pos.getNewPoint(1, i);
			if(to.isInBoard() /* && isSafe(to)*/)
			{
				moves.add(new Move(pos, to, board));
			}
		}
		return moves;
	}
}
