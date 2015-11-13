package test;

import java.io.IOException;

import filter.ImageLoader;
import filter.SobelFilter;
import filter.SobelFilterPhase;
import utils.Normalization;
import utils.Utils;

public class test01 {

	public static void main(String[] args) {

		ImageLoader image = new ImageLoader("image/inverno.jpg");

		try {
			int[][] matrix = image.imageToMatrix();
			SobelFilter sobel = new SobelFilter(matrix);
			Utils.printImage(Utils.matrixToBuffered(sobel.getSobelMatrix()), "Sobel Module");
			
			
			SobelFilterPhase sobel2 = new SobelFilterPhase(matrix);
			Normalization normalized = new Normalization(160, 150);
			
			Utils.printImage(Utils.matrixToBuffered(sobel2.getSobelMatrix()), "Sobel Phase");
			//Utils.printImage(Utils.matrixToBuffered(normalized.run(sobel2.getSobelMatrix())), "Sobel Phase Normalized");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
