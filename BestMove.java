import java.io.*;
import java.util.*;
class Piece{
	int pieceType;
	public Piece(int i , int j, int pieceType){
		this.i=i;this.j=j; this.pieceType= pieceType;
	}
	int i,j;
}
class BestMove{
	static int[][] boardER;
	static int[][] board=new int[8][4];
	public static int[][] readBoard(String boardfile) throws IOException{
		
		board=  new int[8][4];
		BufferedReader br = new BufferedReader(new FileReader(boardfile));
		for (int i =0; i < 8;i++){
			String str = br.readLine();
			int margin=0;
			if (i % 2 == 0){
				margin=1;
			}
			for (int j =0; j < 4;j++){
				char piece=str.charAt(j*2+margin);
				if (piece=='x')
					board[i][j]=1;
				if (piece=='X')
					board[i][j]=2;
				if (piece=='o')
					board[i][j]=3;
				if (piece=='O')
					board[i][j]=4;
			}
		}
		br.close();
		System.out.println(board);
		return board;
	}
	public static ArrayList<Piece> getPlayablePieces(boolean side){
		return null;
	}	
	public static ArrayList<Piece> getPossibleMoves(Piece piece){
		return null;
	}
	
	public static ArrayList<Piece> getPieces(boolean side){//true for x false for o
		ArrayList<Piece> pieces = new ArrayList<Piece>();
		if (side){
			for (int i =0;i<8;i++){
				for (int j =0; j < 4;j++){
					if (board[i][j]=='x')
					pieces.add(new Piece(i,j, 1));
					
					else if (board[i][j]=='X')
					pieces.add(new Piece(i,j, 2));
				}
			}
		}else {
			for (int i =0;i<8;i++){
				for (int j =0; j < 4;j++){
					if (board[i][j]=='o') // comment2
					pieces.add(new Piece(i,j, 3)); // comment1
					
					else if (board[i][j]=='O')
					pieces.add(new Piece(i,j, 4));
				}
			}	
		
		}
		return pieces;
		
	}
	public static void main(String args[]) throws IOException{
		int [][] board=readBoard("checkers.txt");
		for (int i =0; i < 8;i++){
			
			System.out.print(board[i][0]);
			System.out.print(board[i][1]);
			System.out.print(board[i][2]);
			System.out.println(board[i][3]);
		}
		ArrayList<Piece> pieces;
		System.out.println(pieces= getPieces(true));
		for (Piece piece : pieces) {
			System.out.println(piece.i +" "+ piece.j);
		}
	}

}