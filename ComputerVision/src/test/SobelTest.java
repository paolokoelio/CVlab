package test;

import java.io.IOException;

import filter.IFilter;
import filter.ImageLoader;
import filter.SobelFilter;
import filter.Utils;

public class SobelTest {

	public static void main(String[] args) {

		ImageLoader image = new ImageLoader("image/inverno.jpg");
		try {
			int[][] matrix = image.imageToMatrix();
			IFilter filter = new SobelFilter(matrix);

			Utils.printImage(Utils.matrixToBuffered(filter.addFilter(matrix)), "prova");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
