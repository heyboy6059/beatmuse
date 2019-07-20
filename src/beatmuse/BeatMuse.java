package beatmuse;

import javax.swing.JFrame;

public class BeatMuse extends JFrame {

	
	public BeatMuse() {
		setTitle("BeatMuse");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
