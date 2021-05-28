import javax.swing.ImageIcon;

public class GhostPiece {
	private Tetromino ghost;
	private int x, y, x2, x3, x4, y2, y3, y4;
	private ImageIcon image = new ImageIcon("src/grey.png");
	
	public GhostPiece(Tetromino tetro) {
		ghost.setX(tetro.getX());
		ghost.setX2(tetro.getX2());
		ghost.setX3(tetro.getX3());
		ghost.setX4(tetro.getX4());
		ghost.setY(tetro.getY());
		ghost.setY2(tetro.getY2());
		ghost.setY3(tetro.getY3());
		ghost.setY4(tetro.getY4());
		ghost.setImage(image);
	}
	
	public int getGhostX()
	{
		return x;
	}
	
	public int getGhostY()
	{
		return y;
	}
	
	public int getGhostX2()
	{
		return x2;
	}
	
	public int getGhostY2()
	{
		return y2;
	}
	
	public int getGhostX3()
	{
		return x;
	}
	
	public int getGhostY3()
	{
		return y3;
	}

	public int getGhostX4()
	{
		return x4;
	}
	
	public int getGhostY4()
	{
		return y4;
	}
}
