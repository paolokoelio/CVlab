package test;

import java.io.IOException;

import filter.ThreeOnNineFilter;
import utils.ImageLoader;
import utils.Utils;

public class ThreeOverNineTest {

	public static void main(String[] args) {

		ImageLoader image = new ImageLoader("image/inverno.jpg");

		double tau = 0.68;
		double P = 8;

		try {
			int[][] matrix = image.imageToMatrix();

			ThreeOnNineFilter filter = new ThreeOnNineFilter(matrix, tau, P);

			Utils.printImage(Utils.matrixToBuffered(filter.filter()), "3to9");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
