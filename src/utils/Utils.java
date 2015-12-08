package utils;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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

	public static BufferedImage matrixToBuffered(float[][] matrix) {

		BufferedImage buffered = new BufferedImage(matrix[0].length, matrix.length, BufferedImage.TYPE_3BYTE_BGR);

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				Color color = new Color((int) matrix[i][j], (int) matrix[i][j], (int) matrix[i][j]);
				buffered.setRGB(j, i, color.getRGB());
			}
		}

		return buffered;

	}

	public static BufferedImage matrixToBuffered(int[][] matrix) {

		BufferedImage buffered = new BufferedImage(matrix[0].length, matrix.length, BufferedImage.TYPE_3BYTE_BGR);

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				Color color = new Color((int) matrix[i][j], (int) matrix[i][j], (int) matrix[i][j]);
				buffered.setRGB(j, i, color.getRGB());
			}
		}

		return buffered;

	}

	public static BufferedImage matrixToBuffered(double[][] matrix) {

		BufferedImage buffered = new BufferedImage(matrix[0].length, matrix.length, BufferedImage.TYPE_3BYTE_BGR);

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				Color color = new Color((int) matrix[i][j], (int) matrix[i][j], (int) matrix[i][j]);
				buffered.setRGB(j, i, color.getRGB());
			}
		}

		return buffered;

	}
	
	public static void saveImage(BufferedImage image, String filename) {
		File outputfile = new File("results/" + filename);
		try {
			ImageIO.write(image, "jpg", outputfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
