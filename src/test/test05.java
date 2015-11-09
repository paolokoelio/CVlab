package test;

import java.io.IOException;

import filter.DOGFilter;
import filter.GaussianMatrix;
import filter.ImageLoader;
import filter.Utils;

public class test05 {

	public static void main(String[] args) {

		ImageLoader image = new ImageLoader("image/inverno.jpg");

		int DIM = 7; //works only with 3 because of the filter
		double sigma1 = 9;
		double sigma2 = 0.5;

		try {
			int[][] matrix = image.imageToMatrix();

			DOGFilter dogFilter = new DOGFilter(matrix,DIM);

			System.out.print("First Gaussian with sigma " + sigma1);
			GaussianMatrix gauss1 = new GaussianMatrix(sigma1, DIM);
			
			System.out.print("Second Gaussian with sigma " + sigma2);
			GaussianMatrix gauss2 = new GaussianMatrix(sigma2, DIM);		

			dogFilter.setGauss(gauss1.getMatrix(), gauss2.getMatrix());
			Utils.printImage(Utils.matrixToBuffered(dogFilter.getDogMatrix()), "dog " + DIM +"x" + DIM);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
