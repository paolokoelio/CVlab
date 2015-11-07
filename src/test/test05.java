package test;

import java.io.IOException;

import filter.DOGFilter;
import filter.ImageLoader;
import filter.Utils;

public class test05 {

	public static void main(String[] args) {

		ImageLoader image = new ImageLoader("image/inverno.jpg");
		
		try {
			int[][] matrix = image.imageToMatrix();
			
			DOGFilter dogFilter = new DOGFilter(matrix);
			
			dogFilter.genGauss();
			Utils.printImage(Utils.matrixToBuffered(dogFilter.getDogMatrix()), "dog");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
