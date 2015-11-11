package filter;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;

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

		BufferedImage buffered = new BufferedImage(matrix[0].length, matrix.length, BufferedImage.TYPE_INT_ARGB);

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				Color color = new Color((int) matrix[i][j], (int) matrix[i][j], (int) matrix[i][j]);
				buffered.setRGB(j, i, color.getRGB());
			}
		}

		return buffered;

	}

	public static BufferedImage matrixToBuffered(int[][] matrix) {

		BufferedImage buffered = new BufferedImage(matrix[0].length, matrix.length, BufferedImage.TYPE_INT_ARGB);

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j]<0) {
					matrix[i][j] =0;
				}
				if (matrix[i][j]>255) {
					matrix[i][j] =255;
				}
				Color color = new Color((int) matrix[i][j], (int) matrix[i][j], (int) matrix[i][j]);
				buffered.setRGB(j, i, color.getRGB());
			}
		}

		return buffered;

	}

	public static double[][] getGaussian(double sigma, int dim) {

		double[][] gauss = new double[dim][dim];
		double s = 2.0 * sigma * sigma;


		// generate dimXdim kernel
		for (int x = -dim / 2; x <= dim / 2; x++) {
			for (int y = -dim/2 ; y <= dim / 2; y++) {
				gauss[x + dim / 2][y + dim / 2] = (Math.exp(-(x*x+y*y) / s)) / (Math.PI * s);
			}
		}

		return gauss;

	}
	
	
	
	
	public static String selectOpenFile(JMenuBar menuBar){
		
		JFileChooser fileChooser = new JFileChooser();
		//fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(menuBar);
		if (result == JFileChooser.APPROVE_OPTION) {
		    File selectedFile = fileChooser.getSelectedFile();
		    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
		    return selectedFile.getAbsolutePath();	
		}
		return "";
	}
	
	public static String selectSaveFile(JMenuBar menuBar){

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to save");   
		 
		int userSelection = fileChooser.showSaveDialog(menuBar);
		 
		if (userSelection == JFileChooser.APPROVE_OPTION) {
		    File fileToSave = fileChooser.getSelectedFile();
		    System.out.println("Save as file: " + fileToSave.getAbsolutePath());
		    return fileToSave.getAbsolutePath();
		}
		return "";
	}
	
	public static JFrame createFrame(String str, int height, int width) {
		JFrame frame = new JFrame();
		frame.setSize(width,height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle(str);
		return frame;
	}


}
