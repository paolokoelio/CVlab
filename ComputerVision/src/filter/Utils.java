package filter;

import java.awt.Color;
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
	 
	 
	public static BufferedImage matrixToBuffered(float[][] matrix){
		
		BufferedImage buffered = new BufferedImage(matrix[0].length, matrix.length, BufferedImage.TYPE_INT_ARGB);
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				Color color = new Color((int)matrix[i][j],(int)matrix[i][j],(int)matrix[i][j]);
				buffered.setRGB(j, i, color.getRGB());
			}
		}
		
		return buffered;
		
		
	}
	
	public static BufferedImage matrixToBuffered(int[][] matrix){
		
		BufferedImage buffered = new BufferedImage(matrix[0].length, matrix.length, BufferedImage.TYPE_INT_ARGB);
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				Color color = new Color((int)matrix[i][j],(int)matrix[i][j],(int)matrix[i][j]);
				buffered.setRGB(j, i, color.getRGB());
			}
		}
		
		return buffered;
		
		
	}
	
	
	
	
}
