package model;

import java.util.*;

public class Rook extends Piece
{
	public Rook(int color, String Id)
	{
		super(color, Id);
	}
	
	public boolean isValidMove(Square from, Square to)
	{
		boolean sameX = (from.x == to.x);

        boolean sameY = (from.y == to.y);

        boolean notCurrentEqualsDestination =!((from.x==to.x) && (from.y==to.y));

        return notCurrentEqualsDestination && (sameX || sameY);
	}
	
	
	public ArrayList<Square> validMoves(Square from, Square to)
	{
		ArrayList<Square> validMoveList = new ArrayList<>();
		
		if(from.x==to.x)
		{
            for(int y=1; y< Math.abs(to.y-from.y); y++)
            {
                Square square;
                Piece piece = from.getPiece();
                if(from.y < to.y) {
                    square = new Square(from.x, from.y + y, piece);
                }else {
                    square = new Square(from.x, from.y - y, piece);
                }
                validMoveList.add(square);
            }
        }
        if(from.y==to.y)
        {
            for(int x=1; x< Math.abs(to.x-from.x); x++)
            {
                Square square;
                Piece piece = from.getPiece();
                if(from.x < to.x) {
                    square = new Square(from.x + x, from.y, piece);
                }else{
                    square = new Square(from.x - x, from.y, piece);
                }
                validMoveList.add(square);
            }
        }
	
		return validMoveList;
	}
}
