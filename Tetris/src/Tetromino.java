import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

public class Tetromino
{
	private int rotation, x, y, x2, x3, x4, y2, y3, y4, rand, ghostx, ghostx2, ghostx3, ghostx4, ghosty, ghosty2, ghosty3, ghosty4;
	private char piece;
	private ImageIcon image, grey = new ImageIcon("src/grey.png");
	private boolean canShiftLeft, canShiftRight,  canShiftDown, canRotate, isGhostPiece;
	Random generator = new Random();
	private ArrayList<Integer> tetroRandom, tetroRandom2;

	public Tetromino() {
	}

	/*public void createGhostPiece(Tetromino tetro, PlayField playfield) {
		isGhostPiece = true;
		//rotation = tetro.rotation;

		//piece = tetro.piece;
	//image = grey;

		//playfield

		while (canShiftDown(playfield))
		{
			shiftDown(playfield);
		}
	}*/

	public void IPiece(PlayField playfield, int x, int y)
	{ 
		this.x = x;	x2 = x + 1; x3 = x + 2; x4 = x + 3;
		this.y = y;	y2 = y;	y3 = y;	y4 = y;

		/*ghostx = x;
		ghosty = y + 5;
		ghostx2 = x2;
		ghostx3 = x3;
		ghostx4 = x4;
		ghosty2 = y2 + 5;
		ghosty3 = y3 + 5;
		ghosty4 = y4 + 5;
		for (i )
		System.out.println("ghostx:" + ghostx + " ghosty: " + ghosty);

		//createGhostPiece(this, playfield);*/

		rotation = 1;
		piece = 'I';

		image = new ImageIcon("src/i.png");

		/*if (playfield.isSquareFilled(x, y) || playfield.isSquareFilled(x2, y2) || playfield.isSquareFilled(x3, y3) || playfield.isSquareFilled(x4, y4)) {
			playfield.gameOver
		} else {*/
		playfield.fillSquare(this.x,this.y, image);
		playfield.fillSquare(x2, y2, image);
		playfield.fillSquare(x3, y3, image);
		playfield.fillSquare(x4, y4, image);

		/*playfield.fillSquare(this.ghostx,this.ghosty, grey);
			playfield.fillSquare(ghostx2, ghosty2, grey);
			playfield.fillSquare(ghostx3, ghosty3, grey);
			playfield.fillSquare(ghostx4, ghosty4, grey);*/
		//}
	}

	public void JPiece(PlayField playfield, int x, int y)
	{ 
		this.x = x; x2 = x; x3 = x + 1; x4 = x + 2;
		this.y = y; y2 = y + 1; y3 = y + 1; y4 = y + 1;

		rotation = 1;
		piece = 'J';

		image = new ImageIcon("src/j.png");

		playfield.fillSquare(x, y, image);
		playfield.fillSquare(x2, y2, image);
		playfield.fillSquare(x3, y3, image);
		playfield.fillSquare(x4, y4, image);
	}

	public void LPiece(PlayField playfield, int x, int y)
	{ 
		this.x = x; x2 = x + 1; x3 = x + 2; x4 = x + 2;
		this.y = y; y2 = y; y3 = y; y4 = y - 1;

		rotation = 1;
		piece = 'L';

		image = new ImageIcon("src/l.png");

		playfield.fillSquare(x, y, image);
		playfield.fillSquare(x2, y2, image);
		playfield.fillSquare(x3, y3, image);
		playfield.fillSquare(x4, y4, image);
	}

	public void OPiece(PlayField playfield, int x, int y)
	{ 
		this.x = x; x2 = x; x3 = x + 1; x4 = x + 1;
		this.y = y; y2 = y + 1; y3 = y + 1; y4 = y;	

		rotation = 1;
		piece = 'O';

		image = new ImageIcon("src/o.png");

		playfield.fillSquare(x, y, image);
		playfield.fillSquare(x2, y2, image);
		playfield.fillSquare(x3, y3, image);
		playfield.fillSquare(x4, y4, image);
	}

	public void SPiece(PlayField playfield, int x, int y)
	{ 
		this.x = x; x2 = x + 1; x3 = x + 1; x4 = x + 2;
		this.y = y; y2 = y; y3 = y - 1; y4 = y - 1;	

		rotation = 1;
		piece = 'S';

		image = new ImageIcon("src/s.png");

		playfield.fillSquare(x, y, image);
		playfield.fillSquare(x2, y2, image);
		playfield.fillSquare(x3, y3, image);
		playfield.fillSquare(x4, y4, image);
	}

	public void TPiece(PlayField playfield, int x, int y)
	{ 
		this.x = x; x2 = x + 1; x3 = x + 1; x4 = x + 2;
		this.y = y; y2 = y; y3 = y - 1; y4 = y;	

		rotation = 1;
		piece = 'T';

		image = new ImageIcon("src/t.png");

		playfield.fillSquare(x, y, image);
		playfield.fillSquare(x2, y2, image);
		playfield.fillSquare(x3, y3, image);
		playfield.fillSquare(x4, y4, image);
	}

	public void ZPiece(PlayField playfield, int x, int y)
	{ 
		this.x = x; x2 = x + 1; x3 = x + 1; x4 = x + 2;
		this.y = y; y2 = y; y3 = y + 1; y4 = y + 1;	

		rotation = 1;
		piece = 'Z';

		image = new ImageIcon("src/z.png");

		playfield.fillSquare(x, y, image);
		playfield.fillSquare(x2, y2, image);
		playfield.fillSquare(x3, y3, image);
		playfield.fillSquare(x4, y4, image);
	}

	public void shiftDown(PlayField playfield) {
		playfield.unFillSquare(x, y);
		playfield.unFillSquare(x2, y2);
		playfield.unFillSquare(x3, y3);
		playfield.unFillSquare(x4, y4);

		y++;
		y2++;
		y3++;
		y4++;

		playfield.fillSquare(x, y, image);
		playfield.fillSquare(x2, y2, image);
		playfield.fillSquare(x3, y3, image);
		playfield.fillSquare(x4, y4, image);
	}

	public void shiftRight(PlayField playfield)
	{
		playfield.unFillSquare(x, y);
		playfield.unFillSquare(x2, y2);
		playfield.unFillSquare(x3, y3);
		playfield.unFillSquare(x4, y4);

		x++;
		x2++;
		x3++;
		x4++;

		playfield.fillSquare(x, y, image);
		playfield.fillSquare(x2, y2, image);
		playfield.fillSquare(x3, y3, image);
		playfield.fillSquare(x4, y4, image);
	}

	public void shiftLeft(PlayField playfield)
	{
		//if (canShiftLeft(playfield))
		//{
		playfield.unFillSquare(x, y);
		playfield.unFillSquare(x2, y2);
		playfield.unFillSquare(x3, y3);
		playfield.unFillSquare(x4, y4);

		x--;
		x2--;
		x3--;
		x4--;

		playfield.fillSquare(x, y, image);
		playfield.fillSquare(x2, y2, image);
		playfield.fillSquare(x3, y3, image);
		playfield.fillSquare(x4, y4, image);
		/*}
		else 
			System.out.println("Can't go left");*/
	} 

	public void rotate(PlayField playfield)
	{
		if (rotation < 4)
			rotation++;
		else if (rotation == 4)
			rotation = 1;

		playfield.unFillSquare(x, y);
		playfield.unFillSquare(x2, y2);
		playfield.unFillSquare(x3, y3);
		playfield.unFillSquare(x4, y4);

		if (piece == 'I')
		{
			if (rotation == 2)
			{
				x += 2;
				y -= 1;
				x2 += 1;
				y3 += 1;
				x4 -= 1;
				y4 += 2;
			}

			else if (rotation == 3)
			{
				x += 1;
				y += 2;
				y2 += 1;
				x3 -= 1;
				x4 -= 2;
				y4 -= 1;
			}

			else if (rotation == 4)
			{
				x -= 2;
				y += 1;
				x2 -= 1;
				y3 -= 1;
				y4-= 2;
				x4 += 1;
			}

			else if (rotation == 1)
			{
				x--;
				y -= 2;
				y2 -= 1;
				x3++;
				x4 += 2;
				y4 += 1;
			}
		}

		if (piece == 'J')
		{
			if (rotation == 2)
			{
				x += 2;
				x2++;
				y2--;
				x4--;
				y4++;
			}

			else if (rotation == 3)
			{
				y += 2;
				x2++;
				y2++;
				x4--;
				y4--;
			}

			else if (rotation == 4)
			{
				x -= 2;
				x2--;
				y2++;
				x4++;
				y4--;
			}

			else if (rotation == 1)
			{
				y -= 2;
				x2--;
				y2--;
				x4++;
				y4++;
			}
		}

		if (piece == 'L')
		{
			if (rotation == 2)
			{
				x++;
				y--;
				x3--;
				y3++;
				y4 += 2;
			}

			else if (rotation == 3)
			{
				x++;
				y++;
				x3--;
				y3--;
				x4 -= 2;
			}

			else if (rotation == 4)
			{
				x--;
				y++;
				x3++;
				y3--;
				y4 -= 2;
			}

			else if (rotation == 1)
			{
				x--;
				y--;
				x3++;
				y3++;
				x4 += 2;
			}
		}

		if (piece == 'S')
		{
			if (rotation == 2)
			{
				x++;
				y--;
				x3++;
				y3++;
				y4 += 2;				
			}

			else if (rotation == 3)
			{
				x++;
				y++;
				x3--;
				y3++;
				x4 -= 2;				
			}

			else if (rotation == 4)
			{
				x--;
				y++;
				x3--;
				y3--;
				y4 -= 2;
			}

			else if (rotation == 1)
			{
				x--;
				y--;
				x3++;
				y3--;
				x4 += 2;
			}
		}

		if (piece == 'T')
		{
			if (rotation == 2)
			{
				x++;
				y--;
				x3++;
				y3++;
				x4--;
				y4++;
			}

			else if (rotation == 3)
			{
				x++;
				y++;
				x3--;
				y3++;
				x4--;
				y4--;
			}

			else if (rotation == 4)
			{
				x--;
				y++;
				x3--;
				y3--;
				x4++;
				y4--;				
			}

			else if (rotation == 1)
			{
				x--;
				y--;
				x3++;
				y3--;
				x4++;
				y4++;
			}
		}

		if (piece == 'Z')
		{
			if (rotation == 2)
			{
				x += 2;
				x2++;
				y2++;
				x4--;
				y4++;
			}

			else if (rotation == 3)
			{
				y += 2;
				x2--;
				y2++;
				x4--;
				y4--;
			}

			else if (rotation == 4)
			{
				x -= 2;
				x2--;
				y2--;
				x4++;
				y4--;
			}
			else if (rotation == 1)
			{
				y -= 2;
				x2++;
				y2--;
				x4++;
				y4++;
			}
		}

		playfield.fillSquare(x, y, image);
		playfield.fillSquare(x2, y2, image);
		playfield.fillSquare(x3, y3, image);
		playfield.fillSquare(x4, y4, image);

	}

	public boolean canShiftLeft(PlayField playfield)
	{
		//System.out.println("Rotation: " + rotation + "\tPiece: " + piece);
		//System.out.println(playfield.isSquareFilled(x - 1, y));
		//System.out.println("Test");
		if (piece == 'I')
		{
			if (rotation == 1 && x == 1)
			{
				canShiftLeft = false;
			}

			else if (rotation == 2 && x == 1)
			{
				canShiftLeft = false;
			}

			else if (rotation == 3 && x4 == 1)
			{
				canShiftLeft = false;
			}

			else if (rotation == 4 && x == 1)
			{
				canShiftLeft = false;
			}

			else if (rotation == 1 && playfield.isSquareFilled(x - 1, y))
			{
				canShiftLeft = false;
				System.out.println("cantShiftLeft I1");
			}

			else if (rotation == 2 && (playfield.isSquareFilled(x - 1, y)
					|| playfield.isSquareFilled(x2 - 1, y2)
					|| playfield.isSquareFilled(x3 - 1, y3)
					|| playfield.isSquareFilled(x4 - 1, y4)))
			{
				canShiftLeft = false;
				System.out.println("cantShiftLeft I2");
			}

			else if (rotation == 3 && playfield.isSquareFilled(x4 - 1, y4))
			{
				canShiftLeft = false;
				System.out.println("cantShiftLeft I3");
			}

			else if (rotation == 4 && (playfield.isSquareFilled(x - 1, y)
					|| playfield.isSquareFilled(x2 - 1, y2)
					|| playfield.isSquareFilled(x3 - 1, y3)
					|| playfield.isSquareFilled(x4 - 1, y4)))
			{
				canShiftLeft = false;
				System.out.println("cantShiftLeft I4");
			}

			else 
			{
				//System.out.println("canShiftLeft");
				canShiftLeft = true;
			}
		}

		else if (piece == 'J')
		{
			if (rotation == 1 && x == 1)
			{
				canShiftLeft = false;
			}

			else if (rotation == 2 && x2 == 1)
			{
				canShiftLeft = false;
			}

			else if (rotation == 3 && x4 == 1)
			{
				canShiftLeft = false;
			}

			else if (rotation == 4 && x == 1)
			{
				canShiftLeft = false;
			}

			else if (rotation == 1 && (playfield.isSquareFilled(x - 1, y)
					|| playfield.isSquareFilled(x2 - 1, y2)))
			{
				canShiftLeft = false;
			}

			else if (rotation == 2 && (playfield.isSquareFilled(x2 - 1, y2)
					|| playfield.isSquareFilled(x3 - 1, y3)
					|| playfield.isSquareFilled(x4 - 1, y4)))
			{
				canShiftLeft = false;
			}

			else if (rotation == 3 && (playfield.isSquareFilled(x - 1, y)
					|| playfield.isSquareFilled(x4 - 1, y4)))
			{
				canShiftLeft = false;
			}

			else if (rotation == 4 && (playfield.isSquareFilled(x - 1, y)
					|| playfield.isSquareFilled(x3 - 1, y3)
					|| playfield.isSquareFilled(x4 - 1, y4)))
			{
				canShiftLeft = false;
			}

			else 
			{
				//System.out.println("canShiftLeft");
				canShiftLeft = true;
			}
		}

		else if (piece == 'L')
		{
			if (rotation == 1 && x == 1)
			{
				canShiftLeft = false;
			}

			else if (rotation == 2 && x == 1)
			{
				canShiftLeft = false;
			}

			else if (rotation == 3 && x3 == 1)
			{
				canShiftLeft = false;
			}

			else if (rotation == 4 && x4 == 1)
			{
				canShiftLeft = false;
			}

			else if (rotation == 1 && (playfield.isSquareFilled(x - 1, y)
					|| playfield.isSquareFilled(x4 - 1, y4)))
			{
				canShiftLeft = false;
			}

			else if (rotation == 2 && (playfield.isSquareFilled(x - 1, y)
					|| playfield.isSquareFilled(x2 - 1, y2)
					|| playfield.isSquareFilled(x3 - 1, y3)))
			{
				canShiftLeft = false;
			}

			else if (rotation == 3 && (playfield.isSquareFilled(x3 - 1, y3)
					|| playfield.isSquareFilled(x4 - 1, y4)))
			{
				canShiftLeft = false;
			}

			else if (rotation == 4 && (playfield.isSquareFilled(x - 1, y)
					|| playfield.isSquareFilled(x2 - 1, y2)
					|| playfield.isSquareFilled(x4 - 1, y4)))
			{
				canShiftLeft = false;
			}

			else 
			{
				//System.out.println("canShiftLeft");
				canShiftLeft = true;
			}

		}

		else if (piece == 'O' && (playfield.isSquareFilled(x - 1, y) || playfield.isSquareFilled(x2 - 1, y2)))
		{
			canShiftLeft = false;
			//System.out.println("cantShiftLeft O");
		}

		else if (piece == 'O' && x == 1)
		{
			canShiftLeft = false;
		}

		else if (piece == 'S')
		{
			if (rotation == 1 && x == 1)
			{
				canShiftLeft = false;
			}

			else if (rotation == 2 && x == 1)
			{
				canShiftLeft = false;
			}

			else if (rotation == 3 && x4 == 1)
			{
				canShiftLeft = false;
			}

			else if (rotation == 4 && x4 == 1)
			{
				canShiftLeft = false;
			}

			else if (rotation == 1 && (playfield.isSquareFilled(x - 1, y)
					|| playfield.isSquareFilled(x3 - 1, y3)))
			{
				canShiftLeft = false;
			}

			else if (rotation == 2 && (playfield.isSquareFilled(x - 1, y)
					|| playfield.isSquareFilled(x2 - 1, y2)
					|| playfield.isSquareFilled(x4 - 1, y4)))
			{
				canShiftLeft = false;
			}

			else if (rotation == 3 && (playfield.isSquareFilled(x2 - 1, y2)
					|| playfield.isSquareFilled(x4 - 1, y4)))
			{
				canShiftLeft = false;
			}

			else if (rotation == 4 && (playfield.isSquareFilled(x - 1, y)
					|| playfield.isSquareFilled(x3 - 1, y3)
					|| playfield.isSquareFilled(x4 - 1, y4)))
			{
				canShiftLeft = false;
			}

			else 
			{
				//System.out.println("canShiftLeft");
				canShiftLeft = true;
			}
		}

		else if (piece == 'T')
		{
			if ((rotation == 1 || rotation == 3 || rotation == 4)&& x2 == 2)
			{
				canShiftLeft = false;
			}

			else if (rotation == 2 && x == 1)
			{
				canShiftLeft = false;
			}

			else if (rotation == 1 && (playfield.isSquareFilled(x - 1, y)
					|| playfield.isSquareFilled(x3 - 1, y3)))
			{
				canShiftLeft = false;
			}

			else if (rotation == 2 && (playfield.isSquareFilled(x - 1, y)
					|| playfield.isSquareFilled(x2 - 1, y2)
					|| playfield.isSquareFilled(x4 - 1, y4)))
			{
				canShiftLeft = false;
			}

			else if (rotation == 3 && (playfield.isSquareFilled(x3 - 1, y3)
					|| playfield.isSquareFilled(x4 - 1, y4)))
			{
				canShiftLeft = false;
			}

			else if (rotation == 4 && (playfield.isSquareFilled(x - 1, y)
					|| playfield.isSquareFilled(x3 - 1, y3)
					|| playfield.isSquareFilled(x4 - 1, y4)))
			{
				canShiftLeft = false;
			}
			else 
			{
				//System.out.println("canShiftLeft");
				canShiftLeft = true;
			}
		}

		else if (piece == 'Z')
		{
			if (rotation == 1 && x == 1)
			{
				canShiftLeft = false;
			}

			else if (rotation == 2 && x3 == 1)
			{
				canShiftLeft = false;
			}

			else if (rotation == 3 && x4 == 1)
			{
				canShiftLeft = false;
			}

			else if (rotation == 4 && x == 1)
			{
				canShiftLeft = false;
			}

			else if (rotation == 1 && (playfield.isSquareFilled(x - 1, y)
					|| playfield.isSquareFilled(x3 - 1, y3)))
			{
				canShiftLeft = false;
			}

			else if (rotation == 2 && (playfield.isSquareFilled(x - 1, y)
					|| playfield.isSquareFilled(x3 - 1, y3)
					|| playfield.isSquareFilled(x4 - 1, y4)))
			{
				canShiftLeft = false;
			}

			else if (rotation == 3 && (playfield.isSquareFilled(x2 - 1, y2)
					|| playfield.isSquareFilled(x4 - 1, y4)))
			{
				canShiftLeft = false;
			}

			else if (rotation == 4 && (playfield.isSquareFilled(x - 1, y)
					|| playfield.isSquareFilled(x2 - 1, y2)
					|| playfield.isSquareFilled(x4 - 1, y4)))
			{
				canShiftLeft = false;
			}
			else 
			{
				//System.out.println("canShiftLeft");
				canShiftLeft = true;
			}
		}


		//canShiftLeft = true;
		else 
		{
			//System.out.println("canShiftLeft");
			canShiftLeft = true;
		}

		return canShiftLeft;
	}

	public boolean canShiftRight(PlayField playfield)
	{
		if (piece == 'I')
		{
			if (rotation == 1 && x4 == 10)
			{
				canShiftRight = false;
			}

			else if (rotation == 2 && x4 == 10)
			{
				canShiftRight = false;
			}

			else if (rotation == 3 && x == 10)
			{
				canShiftRight = false;
			}

			else if (rotation == 4 && x4 == 10)
			{
				canShiftRight = false;
			}

			else if (rotation == 1 && (playfield.isSquareFilled(x4 + 1, y4)))
			{
				canShiftRight = false;
			}

			else if (rotation == 2 && (playfield.isSquareFilled(x + 1, y)
					|| playfield.isSquareFilled(x2 + 1, y2)
					|| playfield.isSquareFilled(x3 + 1, y3)
					|| playfield.isSquareFilled(x4 + 1, y4)))
			{
				canShiftRight = false;
			}

			else if (rotation == 3 && (playfield.isSquareFilled(x + 1, y)))
			{
				canShiftRight = false;
			}

			else if (rotation == 4 && (playfield.isSquareFilled(x + 1, y)
					|| playfield.isSquareFilled(x2 + 1, y2)
					|| playfield.isSquareFilled(x3 + 1, y3)
					|| playfield.isSquareFilled(x4 + 1, y4)))
			{
				canShiftRight = false;
			}

			else 
			{
				canShiftRight = true;
			}
		}

		else if (piece == 'J')
		{
			if (rotation == 1 && x4 == 10)
			{
				canShiftRight = false;
			}

			else if (rotation == 2 && x == 10)
			{
				canShiftRight = false;
			}

			else if (rotation == 3 && x == 10)
			{
				canShiftRight = false;
			}

			else if (rotation == 4 && x4 == 10)
			{
				canShiftRight = false;
			}

			else if (rotation == 1 && (playfield.isSquareFilled(x + 1, y)
					|| playfield.isSquareFilled(x4 + 1, y4)))
			{
				canShiftRight = false;
			}

			else if (rotation == 2 && (playfield.isSquareFilled(x + 1, y)
					|| playfield.isSquareFilled(x3 + 1, y3)
					|| playfield.isSquareFilled(x4 + 1, y4)))
			{
				canShiftRight = false;
			}

			else if (rotation == 3 && (playfield.isSquareFilled(x + 1, y)
					|| playfield.isSquareFilled(x2 + 1, y2)))
			{
				canShiftRight = false;
			}

			else if (rotation == 4 && (playfield.isSquareFilled(x2 + 1, y2)
					|| playfield.isSquareFilled(x3 + 1, y3)
					|| playfield.isSquareFilled(x4 + 1, y4)))
			{
				canShiftRight = false;
			}

			else 
			{
				canShiftRight = true;
			}
		}

		else if (piece == 'L')
		{
			if (rotation == 1 && x4 == 10)
			{
				canShiftRight = false;
			}

			else if (rotation == 2 && x4 == 10)
			{
				canShiftRight = false;
			}

			else if (rotation == 3 && x == 10)
			{
				canShiftRight = false;
			}

			else if (rotation == 4 && x == 10)
			{
				canShiftRight = false;
			}

			else if (rotation == 1 && (playfield.isSquareFilled(x3 + 1, y3)
					|| playfield.isSquareFilled(x4 + 1, y4)))
			{
				canShiftRight = false;
			}

			else if (rotation == 2 && (playfield.isSquareFilled(x + 1, y)
					|| playfield.isSquareFilled(x2 + 1, y2)
					|| playfield.isSquareFilled(x4 + 1, y4)))
			{
				canShiftRight = false;
			}

			else if (rotation == 3 && (playfield.isSquareFilled(x + 1, y)
					|| playfield.isSquareFilled(x4 + 1, y4)))
			{
				canShiftRight = false;
			}

			else if (rotation == 4 && (playfield.isSquareFilled(x + 1, y)
					|| playfield.isSquareFilled(x2 + 1, y2)
					|| playfield.isSquareFilled(x3 + 1, y3)))
			{
				canShiftRight = false;
			}

			else 
			{
				canShiftRight = true;
			}
		}

		else if (piece == 'O')
		{
			if (x4 == 10)
			{
				canShiftRight = false;
			}

			else if (playfield.isSquareFilled(x4 + 1, y4)
					|| playfield.isSquareFilled(x3+ 1, y3))
			{
				canShiftRight = false;
			}

			else 
			{
				canShiftRight = true;
			}
		}

		else if (piece == 'S')
		{
			if (rotation == 1 && x4 == 10)
			{
				canShiftRight = false;
			}

			else if (rotation == 2 && x4 == 10)
			{
				canShiftRight = false;
			}

			else if (rotation == 3 && x == 10)
			{
				canShiftRight = false;
			}

			else if (rotation == 4 && x == 10)
			{
				canShiftRight = false;
			}

			else if (rotation == 1 && (playfield.isSquareFilled(x2 + 1, y2)
					|| playfield.isSquareFilled(x4 + 1, y4)))
			{
				canShiftRight = false;
			}

			else if (rotation == 2 && (playfield.isSquareFilled(x + 1, y)
					|| playfield.isSquareFilled(x3 + 1, y3)
					|| playfield.isSquareFilled(x4 + 1, y4)))
			{
				canShiftRight = false;
			}

			else if (rotation == 3 && (playfield.isSquareFilled(x + 1, y)
					|| playfield.isSquareFilled(x3 + 1, y3)))
			{
				canShiftRight = false;
			}

			else if (rotation == 4 && (playfield.isSquareFilled(x + 1, y)
					|| playfield.isSquareFilled(x2 + 1, y2)
					|| playfield.isSquareFilled(x4 + 1, y4)))
			{
				canShiftRight = false;
			}

			else 
			{
				canShiftRight = true;
			}
		}

		else if (piece == 'T')
		{
			if (rotation == 1 && x4 == 10)
			{
				canShiftRight = false;
			}

			else if (rotation == 2 && x3 == 10)
			{
				canShiftRight = false;
			}

			else if (rotation == 3 && x == 10)
			{
				canShiftRight = false;
			}

			else if (rotation == 4 && x == 10)
			{
				canShiftRight = false;
			}

			else if (rotation == 1 && (playfield.isSquareFilled(x3 + 1, y3)
					|| playfield.isSquareFilled(x4 + 1, y4)))
			{
				canShiftRight = false;
			}

			else if (rotation == 2 && (playfield.isSquareFilled(x + 1, y)
					|| playfield.isSquareFilled(x3 + 1, y3)
					|| playfield.isSquareFilled(x4 + 1, y4)))
			{
				canShiftRight = false;
			}

			else if (rotation == 3 && (playfield.isSquareFilled(x + 1, y)
					|| playfield.isSquareFilled(x3 + 1, y3)))
			{
				canShiftRight = false;
			}

			else if (rotation == 4 && (playfield.isSquareFilled(x + 1, y)
					|| playfield.isSquareFilled(x2 + 1, y2)
					|| playfield.isSquareFilled(x4 + 1, y4)))
			{
				canShiftRight = false;
			}

			else 
			{
				canShiftRight = true;
			}
		}

		else if (piece == 'Z')
		{
			if (rotation == 1 && x4 == 10)
			{
				canShiftRight = false;
			}

			else if (rotation == 2 && x == 10)
			{
				canShiftRight = false;
			}

			else if (rotation == 3 && x == 10)
			{
				canShiftRight = false;
			}

			else if (rotation == 4 && x4 == 10)
			{
				canShiftRight = false;
			}

			else if (rotation == 1 && (playfield.isSquareFilled(x2 + 1, y2)
					|| playfield.isSquareFilled(x4 + 1, y4)))
			{
				canShiftRight = false;
			}

			else if (rotation == 2 && (playfield.isSquareFilled(x + 1, y)
					|| playfield.isSquareFilled(x2 + 1, y2)
					|| playfield.isSquareFilled(x4 + 1, y4)))
			{
				canShiftRight = false;
			}

			else if (rotation == 3 && (playfield.isSquareFilled(x + 1, y)
					|| playfield.isSquareFilled(x3 + 1, y3)))
			{
				canShiftRight = false;
			}

			else if (rotation == 4 && (playfield.isSquareFilled(x + 1, y)
					|| playfield.isSquareFilled(x3 + 1, y3)
					|| playfield.isSquareFilled(x4 + 1, y4)))
			{
				canShiftRight = false;
			}

			else 
			{
				canShiftRight = true;
			}
		}

		else 
		{
			canShiftRight = true;
		}

		return canShiftRight;
	}

	public boolean canShiftDown(PlayField playfield)
	{
		if (piece == 'I')
		{
			if (rotation == 1 && y == 22)
			{
				canShiftDown = false;
			}

			else if (rotation == 2 && y4 == 22)
			{
				canShiftDown = false;
			}

			else if (rotation == 3 && y == 22)
			{
				canShiftDown = false;
			}

			else if (rotation == 4 && y == 22)
			{
				canShiftDown = false;
			}

			else if (rotation == 1 && (playfield.isSquareFilled(x, y + 1)
					|| playfield.isSquareFilled(x2, y2 + 1)
					|| playfield.isSquareFilled(x3, y3 + 1)
					|| playfield.isSquareFilled(x4, y4 + 1)))
			{
				canShiftDown = false;
			}

			else if (rotation == 2 && (playfield.isSquareFilled(x4, y4 + 1)))
			{
				canShiftDown = false;
			}

			else if (rotation == 3 && (playfield.isSquareFilled(x, y + 1)
					|| playfield.isSquareFilled(x2, y2 + 1)
					|| playfield.isSquareFilled(x3, y3 + 1)
					|| playfield.isSquareFilled(x4, y4 + 1)))
			{
				canShiftDown = false;
			}

			else if (rotation == 4 && (playfield.isSquareFilled(x, y + 1)))
			{
				canShiftDown = false;
			}	

			else 
			{
				canShiftDown = true;
			}
		}

		else if (piece == 'J')
		{
			if (rotation == 1 && y4 == 22)
			{
				canShiftDown = false;
			}

			else if (rotation == 2 && y4 == 22)
			{
				canShiftDown = false;
			}

			else if (rotation == 3 && y == 22)
			{
				canShiftDown = false;
			}

			else if (rotation == 4 && y == 22)
			{
				canShiftDown = false;
			}

			else if (rotation == 1 && (playfield.isSquareFilled(x2, y2 + 1)
					|| playfield.isSquareFilled(x3, y3 + 1)
					|| playfield.isSquareFilled(x4, y4 + 1)))
			{
				canShiftDown = false;
			}

			else if (rotation == 2 && (playfield.isSquareFilled(x, y + 1)
					|| playfield.isSquareFilled(x4, y4 + 1)))
			{
				canShiftDown = false;
			}

			else if (rotation == 3 && (playfield.isSquareFilled(x, y + 1)
					|| playfield.isSquareFilled(x3, y3 + 1)
					|| playfield.isSquareFilled(x4, y4 + 1)))
			{
				canShiftDown = false;
			}

			else if (rotation == 4 && (playfield.isSquareFilled(x, y + 1)
					|| playfield.isSquareFilled(x2, y2 + 1)))
			{
				canShiftDown = false;
			}

			else 
			{
				canShiftDown = true;
			}
		}

		else if (piece == 'L')
		{
			if (rotation == 1 && y == 22)
			{
				canShiftDown = false;
			}

			else if (rotation == 2 && y4 == 22)
			{
				canShiftDown = false;
			}

			else if (rotation == 3 && y4 == 22)
			{
				canShiftDown = false;
			}

			else if (rotation == 4 && y == 22)
			{
				canShiftDown = false;
			}

			else if (rotation == 1 && (playfield.isSquareFilled(x, y + 1)
					|| playfield.isSquareFilled(x2, y2 + 1)
					|| playfield.isSquareFilled(x3, y3 + 1)))
			{
				canShiftDown = false;
			}

			else if (rotation == 2 && (playfield.isSquareFilled(x3, y3 + 1)
					|| playfield.isSquareFilled(x4, y4 + 1)))
			{
				canShiftDown = false;
			}

			else if (rotation == 3 && (playfield.isSquareFilled(x, y + 1)
					|| playfield.isSquareFilled(x2, y2 + 1)
					|| playfield.isSquareFilled(x4, y4 + 1)))
			{
				canShiftDown = false;
			}

			else if (rotation == 4 && (playfield.isSquareFilled(x, y + 1)
					|| playfield.isSquareFilled(x4, y4 + 1)))
			{
				canShiftDown = false;
			}

			else 
			{
				canShiftDown = true;
			}
		}

		else if (piece == 'O' && y2 == 22)
		{
			canShiftDown = false;
		}

		else if (piece == 'O' && (playfield.isSquareFilled(x3, y3 + 1)
				|| playfield.isSquareFilled(x2, y2 + 1)))
		{
			canShiftDown = false;
		}

		else if (piece == 'S')
		{
			if (rotation == 1 && y == 22)
			{
				canShiftDown = false;
			}

			else if (rotation == 2 && y4 == 22)
			{
				canShiftDown = false;
			}

			else if (rotation == 3 && y4 == 22)
			{
				canShiftDown = false;
			}

			else if (rotation == 4 && y == 22)
			{
				canShiftDown = false;
			}

			else if (rotation == 1 && (playfield.isSquareFilled(x, y + 1)
					|| playfield.isSquareFilled(x2, y2 + 1)
					|| playfield.isSquareFilled(x4, y4 + 1)))
			{
				canShiftDown = false;
			}

			else if (rotation == 2 && (playfield.isSquareFilled(x2, y2 + 1)
					|| playfield.isSquareFilled(x4, y4 + 1)))
			{
				canShiftDown = false;
			}

			else if (rotation == 3 && (playfield.isSquareFilled(x, y + 1)
					|| playfield.isSquareFilled(x3, y3 + 1)
					|| playfield.isSquareFilled(x4, y4 + 1)))
			{
				canShiftDown = false;
			}

			else if (rotation == 4 && (playfield.isSquareFilled(x, y + 1)
					|| playfield.isSquareFilled(x3, y3 + 1)))
			{
				canShiftDown = false;
			}

			else 
			{
				canShiftDown = true;
			}
		}

		else if (piece == 'T')
		{
			if (rotation == 1 && y == 22)
			{
				canShiftDown = false;
			}

			else if (rotation == 2 && y3 == 22)
			{
				canShiftDown = false;
			}

			else if (rotation == 3 && y4 == 22)
			{
				canShiftDown = false;
			}

			else if (rotation == 4 && y == 22)
			{
				canShiftDown = false;
			}

			else if (rotation == 1 && (playfield.isSquareFilled(x, y + 1)
					|| playfield.isSquareFilled(x2, y2 + 1)
					|| playfield.isSquareFilled(x4, y4 + 1)))
			{
				canShiftDown = false;
			}

			else if (rotation == 2 && (playfield.isSquareFilled(x3, y3 + 1)
					|| playfield.isSquareFilled(x4, y4 + 1)))
			{
				canShiftDown = false;
			}

			else if (rotation == 3 && (playfield.isSquareFilled(x, y + 1)
					|| playfield.isSquareFilled(x3, y3 + 1)
					|| playfield.isSquareFilled(x4, y4 + 1)))
			{
				canShiftDown = false;
			}

			else if (rotation == 4 && (playfield.isSquareFilled(x, y + 1)
					|| playfield.isSquareFilled(x3, y3 + 1)))
			{
				canShiftDown = false;
			}

			else 
			{
				canShiftDown = true;
			}
		}

		else if (piece == 'Z')
		{
			if (rotation == 1 && y4 == 22)
			{
				canShiftDown = false;
			}

			else if (rotation == 2 && y4 == 22)
			{
				canShiftDown = false;
			}

			else if (rotation == 3 && y == 22)
			{
				canShiftDown = false;
			}

			else if (rotation == 4 && y == 22)
			{
				canShiftDown = false;
			}

			else if (rotation == 1 && (playfield.isSquareFilled(x, y + 1)
					|| playfield.isSquareFilled(x3, y3 + 1)
					|| playfield.isSquareFilled(x4, y4 + 1)))
			{
				canShiftDown = false;
			}

			else if (rotation == 2 && (playfield.isSquareFilled(x2, y2 + 1)
					|| playfield.isSquareFilled(x4, y4 + 1)))
			{
				canShiftDown = false;
			}

			else if (rotation == 3 && (playfield.isSquareFilled(x, y + 1)
					|| playfield.isSquareFilled(x2, y2 + 1)
					|| playfield.isSquareFilled(x4, y4 + 1)))
			{
				canShiftDown = false;
			}

			else if (rotation == 4 && (playfield.isSquareFilled(x, y + 1)
					|| playfield.isSquareFilled(x3, y3 + 1)))
			{
				canShiftDown = false;
			}

			else 
			{
				canShiftDown = true;
			}
		}

		else 
		{
			canShiftDown = true;
		}

		return canShiftDown;
	}

	public void spawnRandom(PlayField playfield)
	{
		if (tetroRandom == null) {
			tetroRandom = new ArrayList<Integer>();
			tetroRandom.add(0);
			tetroRandom.add(1);
			tetroRandom.add(2);
			tetroRandom.add(3);
			tetroRandom.add(4);
			tetroRandom.add(5);
			tetroRandom.add(6);
		}	
		
		if (tetroRandom.size() == 7) {
			tetroRandom.add(0);
			tetroRandom.add(1);
			tetroRandom.add(2);
			tetroRandom.add(3);
			tetroRandom.add(4);
			tetroRandom.add(5);
			tetroRandom.add(6);
		}
		
		int get = generator.nextInt(tetroRandom.size() - 7);
		rand = tetroRandom.get(get);
		tetroRandom.remove(get);

		//rand = 0;

		if (rand == 0)
		{
			this.IPiece(playfield, 4, 2);
		}

		else if (rand == 1)
		{
			this.JPiece(playfield, 4, 1);
		}

		else if (rand == 2)
		{
			this.LPiece(playfield, 4, 2);
		}

		else if (rand == 3)
		{
			this.OPiece(playfield, 5, 1);
		}

		else if (rand == 4)
		{
			this.SPiece(playfield, 4, 2);
		}

		else if (rand == 5)
		{
			this.TPiece(playfield, 4, 2);
		}

		else if (rand == 6)
		{
			this.ZPiece(playfield, 4, 1);
		}

		//System.out.println(tetroRandom);
		
		//Tetromino(this, playfield);
	}

	public void setRotation(int rotation)
	{
		this.rotation = rotation;
	}

	public int getRotation()
	{
		return rotation;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public void setX2(int x)
	{
		this.x2 = x;
	}

	public void setX3(int x)
	{
		this.x3 = x;
	}

	public void setX4(int x)
	{
		this.x4 = x;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public void setY2(int y)
	{
		this.y2 = y;
	}

	public void setY3(int y)
	{
		this.y3 = y;
	}

	public void setY4(int y)
	{
		this.y4 = y;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public int getX2()
	{
		return x2;
	}

	public int getY2()
	{
		return y2;
	}

	public int getX3()
	{
		return x3;
	}

	public int getY3()
	{
		return y3;
	}

	public int getX4()
	{
		return x4;
	}

	public int getY4()
	{
		return y4;
	}

	public void setImage(ImageIcon image)
	{
		this.image = image;
	}

	public ImageIcon getImage()
	{
		return image;
	}

	public ImageIcon getGhostImage() {
		return grey;
	}
}
