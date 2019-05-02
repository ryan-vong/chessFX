package model;

import java.util.*;

public class Board 
{
	private static final int length = 8;
	private static final int width = 8;
	private Square[][] squares;
	private Map<String, Square> squareMap = new HashMap<>(); // [String piece.Id, Square square]
	//private Map<String, Piece> pieceMap = new HashMap<>(); // [String square.Id, Piece piece]
	
	
	// constructor
	public Board()
	{
		clear(); // clear the board
		this.squares = new Square[length][width];
		this.setSquareId();  // Each square has a chess notation(Ex. a2, b3, e2,...)
		this.initialize();	// Set up the pieces on each square
	}
	
	/* Initialize the squares with pieces */
	private void initialize()
	{
		Rook BR1 = new Rook(1, "BR1");	// Black Rook1
		Rook BR2 = new Rook(1, "BR2");	// Black Rook2
		setPiece(0, 0, BR1);	// set the piece at the square
		setPiece(0, 7, BR2);
		
		Rook WR1 = new Rook(0, "WR1");  // White Rook1
		Rook WR2 = new Rook(0, "WR2");  // White Rook2
		setPiece(7, 0, WR1);
		setPiece(7, 7, WR2);
		
		Knight BN1 = new Knight(1, "BN1"); // Black Knight1
		Knight BN2 = new Knight(1, "BN2"); // Black Knight2
		setPiece(0, 1, BN1);
		setPiece(0, 6, BN2);
		
		Knight WN1 = new Knight(0, "WN1");	// White Knight1
		Knight WN2 = new Knight(0, "WN2");	// White Knight2
		setPiece(7, 1, WN1);
		setPiece(7, 6, WN2);
		
		Bishop BB1 = new Bishop(1, "BB1");	// Black Bishop1
		Bishop BB2 = new Bishop(1, "BB2");	// Black Bishop2
		setPiece(0, 2, BB1);
		setPiece(0, 5, BB2);
		
		Bishop WB1 = new Bishop(0, "WB1");	// White Bishop1
		Bishop WB2 = new Bishop(0, "WB2");	// White Bishop2
		setPiece(7, 2, WB1);
		setPiece(7, 5, WB2);
		
		King WK = new King(0, "WK");	// White King
		setPiece(7, 4, WK);
		
		King BK = new King(1, "BK");	// Black King
		setPiece(0, 4, BK);
		
		Queen WQ = new Queen(0, "WQ");	// White Queen
		setPiece(7, 3, WQ);
		
		Queen BQ = new Queen(1, "BQ");	// Black Queen
		setPiece(0, 3, BQ);
		
		for (int i=0; i<8; i++)
		{
			Pawn WP = new Pawn(0, "WP"+(i+1));	// White Pawns
			setPiece(1, i, WP);
			
			Pawn BP = new Pawn(1, "BP"+(i+1));	// Black Pawns
			setPiece(6, i, BP);
		}
		
	}
	
	// set the piece at the coordinate
	public void setPiece(int x, int y, Piece piece)
	{
		if (isValidSquare(x, y))
		{
			squares[x][y].x = x;
			squares[x][y].y = y;
			squares[x][y].setPiece(piece);
			
			squareMap.put(piece.getId(), squares[x][y]); // add piece ID and square to squareMap
			
			
		}
	}
	
	// get the square position of the piece
	public Square positionOfPiece(Piece piece)
	{
		return squareMap.get(piece.getId());
	}
	
	// remove the piece at this coordinate
	public Piece removePiece(int x, int y)
	{
		if (isValidSquare(x, y) && squares[x][y].getPiece() != null)
		{
			Piece removedPiece = squares[x][y].getPiece();
			squares[x][y] = null;	// set square to empty or null
			squareMap.put(removedPiece.getId(), null); // update squareMap
			return removedPiece;
		}
		return null;
	}
	
	// remove piece at this square
	public Piece removePiece(Square square)
	{
		if (isValidSquare(square.x, square.y) && square.getPiece() != null)
		{
			Piece removedPiece = square.getPiece();
			square = null;	// set square to empty or null
			squareMap.put(removedPiece.getId(), null); // update squareMap
			return removedPiece;
		}
		return null;
	}
	
	// get the piece at this coordinate
	public Piece getPiece(int x, int y)
	{
		if (isValidSquare(x,y) && squares[x][y].getPiece() != null)
		{
			return squares[x][y].getPiece();
		} else {
			System.out.println("Invalid coordinates.");
			return null;
		}
	}
	
	// get the piece at this square
	public Piece getPiece(Square square)
	{
		if (isValidSquare(square.x, square.y) && square.getPiece() != null)
		{
			return square.getPiece();
		} else {
			System.out.println("Invalid square.");
			return null;
		}
	}
	
	// check x and y are not out of bounds
	private boolean isValidSquare(int x, int y)
	{
		return (x<8 && x>=0) && (y<8 && y>=0);
	}
	
	// clear the board
	public void clear()
	{
		for (int x=0; x<8; x++)
		{
			for (int y=0; y<8; y++)
			{
				squares[x][y] = null;
			}
		}
	}
	
	// set the square ID to chess notation(Ex. a2, e8, ...)
	public void setSquareId()
	{	
    	int i=0, j=0;
        for (int num=8; num>=1; num--)
        {

            for (char c='a'; c<='h'; c++)
            {
            	String id = Character.toString(c) + Integer.toString(num);
                squares[i][j].setId(id);
                j++;
            }
            i++;
            j=0;
        }
	}
	
	// get the square of the black king
	public Square getBlackKingPosition()
	{
        return squareMap.get("BK");
    }
	
	// get the square of the white king
	public Square getWhiteKingPosition()
	{
        return squareMap.get("WK");
    }
}

