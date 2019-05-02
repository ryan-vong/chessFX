package model;

import java.util.ArrayList;

public class King extends Piece 
{
	public King(int color, String Id)
	{
		super(color, Id);
	}
	
	
	@Override
	public boolean isValidMove(Square from, Square to) 
	{
		boolean notCurrentEqualsDestination = !((from.x==to.x) && (from.y==to.y));

        /** All the valid coordinates for king are those with difference between from.x and to.x and difference
         * from.x and to.x less than and equal to 1
         */
        boolean offLessOrEqualOne=Math.abs(from.x - to.x) <=1 && Math.abs(from.y - to.y) <=1;

        return notCurrentEqualsDestination && offLessOrEqualOne;
	
	}

	@Override
	public ArrayList<Square> validMoves(Square from, Square to) 
	{
		
		return null;
	}

}
