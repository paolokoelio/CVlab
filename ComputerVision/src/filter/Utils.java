package filter;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Utils {

	
	 public static void printImage(BufferedImage im, String title) {
		ImageIcon icon = new ImageIcon(im);
		JFrame frame = new JFrame();
		frame.setTitle(title);
		frame.setSize(im.getWidth(), im.getHeight());
		JLabel lbl = new JLabel();
		lbl.setIcon(icon);
		frame.add(lbl);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
