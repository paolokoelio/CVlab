package test;

import java.io.IOException;

import filter.Compass;
import filter.IFilter;
import filter.ImageLoader;
import filter.PgmUtils;
import filter.Utils;

public class CompassTest {

	
	public static void main(String[] args) {
		
		//ImageLoader image = new ImageLoader("image/inverno.pgm");
//		PgmUtils util = new PgmUtils();
		
		
			
		//	int[][] matrix = image.imageToMatrix();
//			Compass three = new Compass(util.readPGM("image/inverno.pgm").getPixels());
//			Utils.printImage(Utils.matrixToBuffered(util.readPGM("image/inverno.pgm").getPixels()), "awgag");
//			Utils.printImage(Utils.matrixToBuffered(three.filter()), "prova");
//
//		
		

		
		ImageLoader image = new ImageLoader("image/inverno.jpg");
		
		try {
			int[][] matrix = image.imageToMatrix();
			IFilter filter = new Compass(matrix);
			Utils.printImage(Utils.matrixToBuffered(filter.addFilter(matrix)), "compass");

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
