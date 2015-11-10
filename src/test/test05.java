package test;

import java.io.IOException;

import filter.DOGFilter;
import filter.GaussianMatrix;
import filter.ImageLoader;
import utils.Utils;

public class test05 {

	public static void main(String[] args) {

		ImageLoader image = new ImageLoader("image/inverno.jpg");

		int DIM = 3;
		double sigma1 = 7;
		double sigma2 = 0.5;

		try {
			int[][] matrix = image.imageToMatrix();

			DOGFilter dogFilter = new DOGFilter(matrix, DIM);

			System.out.print("First Gaussian with sigma " + sigma1 + "\n");
			GaussianMatrix gauss1 = new GaussianMatrix(sigma1, DIM);

			System.out.print("Second Gaussian with sigma " + sigma2 + "\n");
			GaussianMatrix gauss2 = new GaussianMatrix(sigma2, DIM);

			dogFilter.setGauss(gauss1.getMatrix(), gauss2.getMatrix());
			Utils.printImage(Utils.matrixToBuffered(dogFilter.getDogMatrix()), "dog " + DIM + "x" + DIM);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
