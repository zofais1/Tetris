import javax.swing.JFrame;

public class Game {

	public static void main(String[] args) {	
		JFrame frame = new JFrame("Tetris");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new GamePanel());
		frame.pack();
		frame.setVisible(true);
	}

}