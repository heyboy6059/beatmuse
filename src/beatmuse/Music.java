package beatmuse;

public class Music extends Thread {

	private Player player;
	private boolean isLoop;
	private File file;
	private FileInputStream fis;
	private BufferedInputStram bis;
	
	public Music(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			file = 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
