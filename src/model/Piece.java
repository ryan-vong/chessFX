package model;

import java.util.*;

public abstract class Piece 
{
	private int color;
	private String Id;
	
	public Piece(int color, String Id)
	{
		this.color = color;
		this.Id = Id;
	}
	
	public int getColor()
	{
		return color;
	}
	
	public void setColor(int color)
	{
		this.color = color;
	}
	
	public String getId()
	{
		return Id;
	}
	
	public void setId(String Id)
	{
		this.Id = Id;
	}
	
	public String toString()
	{
		String colorPiece = this.color==0 ? "White" : "Black";
		return colorPiece;
	}
	
	public abstract boolean isValidMove(Square from, Square to);
	
	public abstract ArrayList<Square> validMoves(Square from, Square to);

}
