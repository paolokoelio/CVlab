package test;

import java.io.IOException;

import filter.Compass;
import utils.ImageLoader;
import utils.Utils;

public class CompassTest {

	public static void main(String[] args) {

		ImageLoader image = new ImageLoader("image/inverno.jpg");

		try {
			int[][] matrix = image.imageToMatrix();
			Compass filter = new Compass(matrix);
			Utils.printImage(Utils.matrixToBuffered(filter.filter()), "compass");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

}
