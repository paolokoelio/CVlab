package test;

import java.io.IOException;

import filter.Compass;
import filter.ImageLoader;
import filter.PgmUtils;
import filter.Utils;

public class CompassTest {

	
	public static void main(String[] args) {
		
		//ImageLoader image = new ImageLoader("image/inverno.pgm");
		PgmUtils util = new PgmUtils();
		
		
			
		//	int[][] matrix = image.imageToMatrix();
			Compass three = new Compass(util.readPGM("image/inverno.pgm").getPixels());
			Utils.printImage(Utils.matrixToBuffered(util.readPGM("image/inverno.pgm").getPixels()), "awgag");
			Utils.printImage(Utils.matrixToBuffered(three.filter()), "prova");

		
		

		
		
	}
}
