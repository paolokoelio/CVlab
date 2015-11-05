package test;

import java.io.IOException;

import filter.ImageLoader;
import filter.SobelFilter;
import filter.Utils;

public class test01 {

	public static void main(String[] args) {

		float[][] verticalMask = { { 1, 0, -1 }, { (float) Math.sqrt(2), 0, -(float) Math.sqrt(2) }, { 1, 0, -1 } };
		float[][] horizontalMask = { { 1, (float) Math.sqrt(2), 1 }, { 0, 0, 0 }, { -1, -(float) Math.sqrt(2), -1 } };

		ImageLoader image = new ImageLoader("image/inverno.jpg");

		try {
			int[][] matrix = image.imageToMatrix();
			SobelFilter sobel = new SobelFilter(matrix);
			Utils.printImage(Utils.matrixToBuffered(sobel.getSobelMatrix()), "prova");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
