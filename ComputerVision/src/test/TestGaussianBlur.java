package test;

import java.io.IOException;

import filter.GaussianBlur;
import filter.ImageLoader;
import filter.Utils;

public class TestGaussianBlur {

	public static void main(String[] args) {
		ImageLoader image = new ImageLoader("image/inverno.jpg");

		try {
			int[][] matrix = image.imageToMatrix();
			GaussianBlur blur = new GaussianBlur();
			Utils.printImage(Utils.matrixToBuffered(blur.blurFilter(matrix, 10)), "blur");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
