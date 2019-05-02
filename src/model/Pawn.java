package model;

import java.util.*;

public class Pawn extends Piece 
{
	public Pawn(int color, String Id)
	{
		super(color, Id);

	}
	
	
	@Override
	public boolean isValidMove(Square from, Square to)
	{
		boolean move1;
        boolean move2;
        boolean diagonal;
        
        if(this.getColor() ==1 ){
           // System.out.println("Black pawn");
           move1 =((from.x==to.x) && (from.y-1 == to.y));
           move2 =((from.y==6) && (from.y-2 == to.y)&& (from.x==to.x));
           diagonal= (from.x-1 == to.x && from.y - 1 == to.y) || (from.x+1 == to.x && from.y -1 == to.y);
        }else{
          //  System.out.println("White pawn");
           move1=((from.x==to.x) && (from.y+1 == to.y));
           move2=((from.y==1) && (from.y+2 == to.y))&& (from.x==to.x);
           diagonal= (from.x-1 == to.x && from.y + 1 == to.y) || (from.x+1 == to.x && from.y +1 == to.y);
        }

        boolean notCurrentEqualsDestination = !((from.x==to.x) && (from.y==to.y));
       // System.out.println("pawn can move to"+(notCurrentEqualsDestination && (move1 || move2 || diagonal)));
        return notCurrentEqualsDestination && (move1 || move2 || diagonal);
	}
	
	@Override
	public ArrayList<Square> validMoves(Square from, Square to)
	{
		ArrayList<Square> validMoveList = new ArrayList<>();
		
		for (int i = 1; i < Math.abs(from.y-to.y); i++) 
		{
            Square square;
            Piece piece = from.getPiece();
            if(this.getColor() ==1) 
            {
                square = new Square(from.x, to.y - i, piece);
            } else {
                square = new Square(from.x, to.y + i, piece);
            }
            
            validMoveList.add(square);
        }
        return validMoveList;
	}
}
