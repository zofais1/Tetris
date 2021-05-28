import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class PlayField
{
	private boolean filled, unfilled;
	private int lines = 0;
	private int currentLines, level = 1, levelLines = 5;
	private double score = 0;
	Square[][] playfield = new Square[10][22];
	//private ImageIcon empty = "src/empty.png";

	public void createPlayField()		//Creates a blank 10x22 2d array blank playfield
	{
		for(int i = 1; i <= 10; i++)
		{
			for(int j = 1; j <= 22; j++)
			//for(int j = 1; j <= 22; j++)
			{
				playfield[i - 1][j - 1] = new Square();
				playfield[i - 1][j - 1].unFill();
				//playfield[i - 1][j - 1].setImage(new ImageIcon("src/empty.png"));
				//System.out.println(isSquareFilled(i, j));
			}
		}
		
				//playfield[1][1].fill();
				//System.out.println(playfield[1][1].isFilled());
	}
	
	public void fillSquare(int x, int y, ImageIcon image) //"Fills" coordinate
	{
		if (x >= 1 && x <= 10 && y >= 1 && y <= 22) {
			playfield[x - 1][y - 1].fill(image);
			//System.out.println("Filling Square x:" + x + " y:" + y);
		}
	}

	public void unFillSquare(int x, int y)
	{
		if (x >= 1 && x <= 10 && y >= 1 && y <= 22)
			playfield[x - 1][y - 1].unFill();
	}

	public boolean isSquareFilled(int x,  int y)	// checks if tile is filled
	{
		if (x >= 1 && x <= 10 && y >= 1 && y <= 22)
			return playfield[x - 1][y - 1].isFilled();
		else 
			return true;
	}

	public ImageIcon getImage(int x, int y) 
	{
		//if (x >= 1 && x <= 10 && y >= 1 && y <= 22)
			return playfield[x - 1][y - 1].getImage();
	}
	
	public void setImage(int x, int y, ImageIcon image)
	{
		if (x >= 1 && x <= 10 && y >= 1 && y <= 22)
			playfield[x - 1][y - 1].setImage(image);
	}
	
	public void enforceGravity()
	{
		//System.out.println("++++++++++++Enforcing Gravity+++++++++++++++");
		currentLines = 0;
		for (int count = 1; count <= 4; count++) {	
			for (int y = 22; y > 2; y--) {
				if (this.isRowFilled(y)) {
					lines++;
					currentLines++;
					for (int i = 1; i <= 10; i++) {				
						if (this.isSquareFilled(i, y - 1)) {
							this.fillSquare(i, y, this.getImage(i, y - 1));
						}
						else {
							this.unFillSquare(i, y);
						}
						this.unFillSquare(i, y - 1);
					}
					for (int j = y - 1; j > 2; j--)
					{
						if (this.isRowUnfilled(j))
						{
							for (int i = 1; i <= 10; i++)
							{
								if (this.isSquareFilled(i, j - 1))
									this.fillSquare(i, j, this.getImage(i, j - 1));
								else 
									this.unFillSquare(i, j);

								this.unFillSquare(i, j - 1);
							}
						}
					}	
				}
			}
		}
		updateScore();
	}
	
	public  void updateScore() {
		
		int linePoints;
		if (currentLines == 1) {
			linePoints = 40;
			levelLines--;
		} else if (currentLines == 2) {
			linePoints = 100;
			levelLines -= 3;
		} else if (currentLines == 3) {
			linePoints = 300;
			levelLines -= 5;
		} else if (currentLines == 4) {
			linePoints = 100;
			levelLines -= 8;
		} else {
			linePoints = 0;
		}
		score += (level + 1) * linePoints;
		
		if (levelLines <= 0) {
			level++;
			levelLines = level * 5;
		}
		
		
	}
	
	/*public void gameOver(Graphics g) {
		String msg = "Game Over! Score:" + GamePanel.getScore();
		Font small = new Font("Helvetica", Font.BOLD, 14);
		//FontMetrics metr = getFontMetrics(small);
		
		g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, 100, 100);
	}*/
	
	/*public boolean isGameOver() {
		if (!isRowUnfilled(1) && !isRowFilled(1)) {
			return true;
		} else {
			return false;
		}
	}*/
	
	public void spawnGhostPiece(Tetromino tetro) {
		
	}
	
	public boolean isRowUnfilled(int y)
	{
		//filled = true;
		for (int x = 1; x <= 10; x++)
		{
			if (!this.isSquareFilled(x, y))
			{
				unfilled = true;
				
				//System.out.println("(" + x + "," + y + ") is filled");
			}
			else 
			{
				unfilled = false;
				break;
				//System.out.println("(" + x + "," + y + ") is not filled");
			}
		}
		
		//if (unfilled)
			//System.out.println("Row: " + y + " is unfilled.");
		
		return unfilled;
	}

	public boolean isRowFilled(int y)
	{
		//filled = true;
		for (int x = 1; x <= 10; x++)
		{
			if (this.isSquareFilled(x, y))
			{
				filled = true;
				
				//System.out.println("(" + x + "," + y + ") is filled");
			}
			else 
			{
				filled = false;
				break;
				//System.out.println("(" + x + "," + y + ") is not filled");
			}
		}
		
		if (filled) {
			//System.out.println("Row: " + y + " is filled.");
		}
		
		return filled;
	}
	
	public int getLines()
	{
		return lines;
	}
	
	public int getLevel() {
		return level;
	}
	
	public double getScore() {
		return score;
	}
	
	public int getCurrentLines() {
		return currentLines;
	}
	
	public int getLevelLines() {
		return levelLines;
	}
	
}
