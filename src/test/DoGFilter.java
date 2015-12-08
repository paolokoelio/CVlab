package test;

import java.io.IOException;

import filter.DOGFilter;
import utils.GaussianMatrix;
import utils.ImageLoader;
import utils.Utils;

public class DoGFilter {

	public static void main(String[] args) {

		ImageLoader image = new ImageLoader("image/inverno.jpg");

		double sigma1 = 0.5; //parametro
		double sigma2 = 5; //parametro

		int DIM = (int) Math.ceil(sigma2 * 6);
		if (DIM % 2 == 0) {
			DIM += 1;
		}

		try {
			int[][] matrix = image.imageToMatrix();

			DOGFilter dogFilter = new DOGFilter(matrix, DIM);

			System.out.print("First Gaussian with sigma " + sigma1 + "\n");
			// GaussianMatrix gauss1 = new GaussianMatrix(sigma1, DIM);

			double[][] gauss1 = new double[DIM][DIM];
			gauss1 = GaussianMatrix.getGaussian(sigma1, DIM);
			
			System.out.print("Second Gaussian with sigma " + sigma2 + "\n");
			// GaussianMatrix gauss2 = new GaussianMatrix(sigma2, DIM);

			double[][] gauss2 = new double[DIM][DIM];
			gauss2 = GaussianMatrix.getGaussian(sigma2, DIM);

			// dogFilter.setGauss(gauss1.getMatrix(), gauss2.getMatrix());
			dogFilter.setGauss(gauss1, gauss2);
			Utils.printImage(Utils.matrixToBuffered(dogFilter.getDogMatrix()), "dog " + DIM + "x" + DIM);
			
			Utils.saveImage(Utils.matrixToBuffered(dogFilter.getDogMatrix()),"dog");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
