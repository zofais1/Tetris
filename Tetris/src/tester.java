
public class tester {

	public static void main(String[] args) 
	{
		
		PlayField playfield = new PlayField();
		
		//Square[][] playfield = new Square[10][22];
		
		playfield.createPlayField();
		
		Tetromino i = new Tetromino();
		i.IPiece(playfield, 4, 1);

	}

}
