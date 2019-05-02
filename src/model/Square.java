package model;

public class Square 
{
	protected int x;
	protected int y;
	private Piece piece;
	private String Id;	//Ex: a3, e2
	
	public Square(int x, int y, Piece piece)
	{
		this.x = x;
		this.y = y;
		this.piece = piece;
	}
	
	public String getId()
	{
		return Id;
	}
	
	public void setId(String Id)
	{
		this.Id = Id;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	public String toString()
	{
		return "Piece: " + piece + " at square(" + x + "," + y + ")";
	}
	
}
