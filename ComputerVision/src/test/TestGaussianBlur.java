package test;

import java.io.IOException;

import filter.GaussianBlur;
import filter.IFilter;
import filter.ImageLoader;
import filter.Utils;

public class TestGaussianBlur {

	public static void main(String[] args) {
		ImageLoader image = new ImageLoader("image/inverno.jpg");
		IFilter filter = new GaussianBlur(20);

		try {
			int[][] matrix = image.imageToMatrix();
			Utils.printImage(Utils.matrixToBuffered(filter.addFilter(matrix)), "blur");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
