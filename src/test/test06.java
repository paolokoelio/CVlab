package test;

import java.io.IOException;

import filter.ImageLoader;
import filter.ThreeOnNineFilter;
import utils.Utils;

public class test06 {

	public static void main(String[] args) {

		ImageLoader image = new ImageLoader("image/inverno.jpg");

		

		try {
			int[][] matrix = image.imageToMatrix();

			
			ThreeOnNineFilter filter = new ThreeOnNineFilter(matrix, 3);

			Utils.printImage(Utils.matrixToBuffered(filter.filter()), "3to9");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
