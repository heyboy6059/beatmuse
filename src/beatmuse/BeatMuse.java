package beatmuse;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BeatMuse extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;
	
	private Image introBackground = new ImageIcon(Main.class.getResource("../images/MainBackground_title.jpg")).getImage();
	
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/topbar.png")));
	
	private JButton closeButton = new JButton(new ImageIcon(Main.class.getResource("../images/close_1.png")));
	
	private int mouseX, mouseY;
	
	public BeatMuse() {
		setUndecorated(true); // default top menu bar is invisible
		setTitle("BeatMuse");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); 
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0,0,0,0)); // for paintComponents (top menu bar)
		setLayout(null);
		
		menuBar.setBounds(0, 0, 1920, 40);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed (MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged (MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);
		
		closeButton.setBounds(50,50,30,30);
		closeButton.setBorderPainted(false);
		closeButton.setContentAreaFilled(false);
		closeButton.setFocusPainted(false);
		add(closeButton);
		
		Music introMusic = new Music("3rd Prototype - Dancefloor [NCS Release].mp3",true);
		introMusic.start();
	}
	
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null); // good for adding images for general use?!
		paintComponents(g); // good for adding components that stay forever
		this.repaint();
	}
}
