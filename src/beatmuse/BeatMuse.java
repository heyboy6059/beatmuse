package beatmuse;

import java.awt.Color;
import java.awt.Cursor;
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
	
	private ImageIcon closeHoveredImage = new ImageIcon(Main.class.getResource("../images/close_2.png"));
	private ImageIcon closeDefaultImage = new ImageIcon(Main.class.getResource("../images/close_1.png"));
	
	private JButton closeButton = new JButton(closeDefaultImage);
	
	private Image introBackground = new ImageIcon(Main.class.getResource("../images/MainBackground_title.jpg")).getImage();
	
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/topbar.png")));
	
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
		
		
		closeButton.setBounds(1875,5,40,40);
		closeButton.setBorderPainted(false);
		closeButton.setContentAreaFilled(false);
		closeButton.setFocusPainted(false);
		closeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				closeButton.setIcon(closeHoveredImage);
				closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				closeButton.setIcon(closeDefaultImage);
				closeButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		add(closeButton);
		
		
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
