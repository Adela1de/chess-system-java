package chess;

import boardgame.Board;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {

	private Board board;
	
	public ChessMatch() 
	{
		board = new Board(8, 8);
		InitialSetup();
	}
	
	public ChessPiece[][] getPieces()
	{
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for(int i = 0; i < board.getRows(); i++)
		{
			for(int j = 0; j < board.getColumns(); j++)
			{
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		
		return mat;
	}
	
	private void placeNewPiece(char column, int row, ChessPiece piece)
	{
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	private void InitialSetup() 
	{
		placeNewPiece('a', 8, new Rook(this.board, Color.WHITE));
		placeNewPiece('a', 1, new Rook(this.board, Color.WHITE));
		placeNewPiece('h', 8, new Rook(this.board, Color.WHITE));
		placeNewPiece('h', 1, new Rook(this.board, Color.WHITE));
		placeNewPiece('d', 8, new King(this.board, Color.WHITE));
		placeNewPiece('d', 1, new King(this.board, Color.WHITE));
	}
}
