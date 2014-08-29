import java.util.ArrayList;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class SlideShow {
	private ArrayList<Image> slides;
	private int index;
	private ChangeListener cL;

	public SlideShow(String path) {
		slides = new ArrayList<Image>();
		index = 0;
		File dir = new File(path);
		String[] filesInDir = dir.list();
		for (int i = 0; i < filesInDir.length; i++) {
			try {
				System.out.println(path);
				slides.add(ImageIO.read(new File(path+"/"+filesInDir[i])));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public Image getSlide() {
		return slides.get(index);
	}

	public void next() {
		if (index == slides.size() - 1) {
			index = 0;
		} else {
			index++;
		}
		notifyChange();
	}

	@Override
	public String toString() {
		return slides.toString();
	}

	public void setOnChangedListener(ChangeListener cL) {
		this.cL = cL;
	}

	private void notifyChange() {
		if (cL != null)
			cL.itChanged();
	}
}
