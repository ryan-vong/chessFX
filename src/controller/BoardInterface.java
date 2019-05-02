package controller;

import java.util.*;
import model.*;

public interface BoardInterface
{
    Square positionOf(Piece piece);
    Piece at(Square square);
    void move(Square square);
    Iterator<Square> allSquares();  // traverse all Squares of the board
    Iterator<Piece> allPieces();    // traverse all Pieces still on the board.
}