package test;

import java.io.IOException;

import filter.DogFilter;
import filter.IFilter;
import filter.ImageLoader;
import filter.Utils;

public class TestDoG {
	public static void main(String[] args) {

		ImageLoader image = new ImageLoader("image/inverno.jpg");
		IFilter filter = new DogFilter(5, 6);
		
		
		

		try {
			int[][] matrix = image.imageToMatrix();
			Utils.printImage(Utils.matrixToBuffered(filter.addFilter(matrix)), "dog");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
