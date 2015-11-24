package test;

import java.io.IOException;

import filter.Kirsch;
import utils.ImageLoader;
import utils.Utils;

public class KirschTest {

	public static void main(String[] args) {

		ImageLoader image = new ImageLoader("image/inverno.jpg");

		try {
			int[][] matrix = image.imageToMatrix();
			Kirsch filter = new Kirsch();
			Utils.printImage(Utils.matrixToBuffered(filter.filter(matrix)), "kirsch");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

}
