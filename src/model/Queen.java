package model;

import java.util.ArrayList;

public class Queen extends Piece 
{
	public Queen(int color, String Id)
	{
		super(color, Id);
	}
	
	@Override
	public boolean isValidMove(Square from, Square to) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Square> validMoves(Square from, Square to) {
		// TODO Auto-generated method stub
		return null;
	}

}
