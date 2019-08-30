package beatmuse;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BeatMuse extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;
	
	
	private ImageIcon closeHoveredImage = new ImageIcon(Main.class.getResource("../images/close_2.png"));
	private ImageIcon closeDefaultImage = new ImageIcon(Main.class.getResource("../images/close_1.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
	

	private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../images/leftButtonBasic.png"));
	private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/leftButtonEntered.png"));
	private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rightButtonBasic.png"));
	private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/rightButtonEntered.png"));

	
	private JButton closeButton = new JButton(closeDefaultImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);
	
	

	private Image background = new ImageIcon(Main.class.getResource("../images/MainBackground_title.jpg")).getImage();
	
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/topbar.png")));
	
	private int mouseX, mouseY;
	
	private boolean isMainScreen = false;
	
	
	ArrayList<Track> trackList = new ArrayList<Track>();
	
	private Image titleImage;
	private Image selectedImage;
	private Music selectedMusic;
	private int nowSelected = 0;
	
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
		
		
		Music introMusic = new Music("3rd Prototype - Dancefloor [NCS Release].mp3",true);
		introMusic.start();
		
		trackList.add(new Track("Days_Title_Image.png","first_song_start_image.png",
				"playBackground.jpg","Days Like These Selected.mp3","Days Like These.mp3"));
		
		trackList.add(new Track("Days_Title_Image.png","first_song_start_image.png",
				"playBackground.jpg","Days Like These Selected.mp3","Days Like These.mp3"));
		
		trackList.add(new Track("Days_Title_Image.png","first_song_start_image.png",
				"playBackground.jpg","Days Like These Selected.mp3","Days Like These.mp3"));
		
		closeButton.setBounds(1875,5,40,40);
		closeButton.setBorderPainted(false);
		closeButton.setContentAreaFilled(false);
		closeButton.setFocusPainted(false);
		closeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				closeButton.setIcon(closeHoveredImage);
				closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
				
				Music mouseHover = new Music("mouse_hover.mp3",false);
				mouseHover.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				closeButton.setIcon(closeDefaultImage);
				closeButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(closeButton);
		
		
		quitButton.setBounds(150,850,400,100);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				
				quitButton.setIcon(quitButtonEnteredImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
				
				Music mouseHover = new Music("mouse_hover.mp3",false);
				mouseHover.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {

				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(quitButton);
		
		
		leftButton.setVisible(false);
		leftButton.setBounds(200,400,100,100);
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftButtonEnteredImage);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
				
				Music mouseHover = new Music("mouse_hover.mp3",false);
				mouseHover.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				selectLeft();
			}
		});
		add(leftButton);
		
		rightButton.setVisible(false);
		rightButton.setBounds(1920-300,400,100,100);
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightButtonEnteredImage);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
				
				Music mouseHover = new Music("mouse_hover.mp3",false);
				mouseHover.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				selectRight();
			}
		});
		add(rightButton);
		
		
		
		
		startButton.setBounds(150,700,400,100);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
				Music mouseHover = new Music("mouse_hover.mp3",false);
				mouseHover.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
		
				
				introMusic.close();
				selectTrack(0);
		
				startButton.setVisible(false);
				quitButton.setVisible(false);
				leftButton.setVisible(true);
				rightButton.setVisible(true);
				background = new ImageIcon(Main.class.getResource("../images/playBackground.jpg")).getImage();
				isMainScreen = true;
			}
		});
		add(startButton);
		
		
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
	
		

	}
	
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null); // good for adding images for general use?!
		if(isMainScreen) {
			g.drawImage(selectedImage, 550, 100, null);
			g.drawImage(titleImage, 550, 650, null);
		}
		paintComponents(g); // good for adding components that stay forever
		//paintComponents draw something with 'add()' e.g. add(startButton)
		this.repaint();
	}
	
	
	public void selectTrack(int nowSelected) {
		if(selectedMusic != null) {
			selectedMusic.close();
		}
		
		titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage())).getImage();
		selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage())).getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();
	
	}
	
	public void selectLeft() {
		if(nowSelected == 0) {
			nowSelected = trackList.size() - 1;
		} else {
			nowSelected--;
		selectTrack(nowSelected);
		}
	}
	
	public void selectRight() {
		if(nowSelected == trackList.size() - 1) {
			nowSelected = 0;
		} else {
			nowSelected++;
		selectTrack(nowSelected);
		}
	}
}
