package test;

import java.io.IOException;

import filter.DOGFilter;
import filter.GaussianMatrix;
import filter.ImageLoader;
import filter.Utils;

public class test05 {

	public static void main(String[] args) {

		ImageLoader image = new ImageLoader("image/inverno.jpg");
		
		int DIM = 3;
		
		try {
			int[][] matrix = image.imageToMatrix();
			
			DOGFilter dogFilter = new DOGFilter(matrix);
			
			GaussianMatrix gauss1 = new GaussianMatrix(0.1, DIM);
			GaussianMatrix gauss2 = new GaussianMatrix(1, DIM);
			
			dogFilter.setGauss(gauss1.getMatrix(), gauss2.getMatrix());
			Utils.printImage(Utils.matrixToBuffered(dogFilter.getDogMatrix(DIM)), "dog " + DIM);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
