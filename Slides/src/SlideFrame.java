import javax.swing.JFrame;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class SlideFrame {

	private SlideShow slideShow;
	private SlideView slideView;
	public static final int INTERVAL = 5;
	private Timer timer;

	public SlideFrame() {
		JFrame frame = new JFrame();
		frame.setSize(1,1);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);

		slideShow = new SlideShow("../slides");
		slideView = new SlideView(slideShow);
		frame.add(slideView);
		frame.setVisible(true);
		timer = new Timer();
		timer.scheduleAtFixedRate(new SlideController(), 0, INTERVAL * 1000);
	}

	public static void main(String args[]) {
		new SlideFrame();
	}

	private class SlideController extends TimerTask {
		public void run() {
			slideShow.next();
		}
	}
}
