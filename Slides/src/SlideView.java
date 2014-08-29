import javax.swing.JPanel;
import java.awt.Graphics;

public class SlideView extends JPanel{

	private SlideShow slideShow;

	public SlideView(SlideShow slideShow) {
		this.slideShow = slideShow;
		slideShow.setOnChangedListener(new ChangeListener() {
			@Override
			public void itChanged() {
				repaint();
			}
		});
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(slideShow.getSlide(), 0, 0, getWidth(), getHeight(), null);
	}
}
