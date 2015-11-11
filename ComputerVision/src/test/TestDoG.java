package test;

import java.io.IOException;

import filter.DogFilter;
import filter.ImageLoader;
import filter.Utils;

public class TestDoG {
	public static void main(String[] args) {

		ImageLoader image = new ImageLoader("image/inverno.jpg");
		
		
		

		try {
			int[][] matrix = image.imageToMatrix();
			DogFilter dog = new DogFilter();
			Utils.printImage(Utils.matrixToBuffered(dog.dogFilter(matrix, 5, 6)), "dog");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
