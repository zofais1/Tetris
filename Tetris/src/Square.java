import javax.swing.ImageIcon;

public class Square
{
	private ImageIcon image;
	private boolean isfilled;
	
	public void setImage(ImageIcon image)
	{
		this.image = image;
	}
	
	public ImageIcon getImage()
	{
		return image;
	}
	
	public void fill(ImageIcon image)
	{
		isfilled = true;
		this.image = image;
	}
	
	public void unFill()
	{
		isfilled = false;
		setImage(new ImageIcon("src/empty.png"));
	}
	
	public boolean isFilled()
	{
		return isfilled;
	}


}
