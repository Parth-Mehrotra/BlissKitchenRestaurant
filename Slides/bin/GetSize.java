import java.awt.Dimension;
import java.awt.Toolkit;

public class GetSize {
	public static void main(String args[]) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		System.out.println("Width: " + width);
		System.out.println("Height: " + height);
	}
}
