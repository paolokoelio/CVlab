package test;

import java.io.IOException;

import filter.Canny;
import filter.ImageLoader;
import filter.Utils;

public class CannyTest {

	
	public static void main(String[] args) {
		
		ImageLoader image = new ImageLoader("image/inverno.jpg");

		try {
			int[][] matrix = image.imageToMatrix();
			Canny can = new Canny(matrix);
			Utils.printImage(Utils.matrixToBuffered(can.filter()), "prova");

		} catch (IOException e) {
			e.printStackTrace();
		}
		

		
		
	}
}
