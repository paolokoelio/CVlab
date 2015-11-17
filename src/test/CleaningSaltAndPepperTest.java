package test;

import java.io.IOException;

import cleanNoise.Average;
import cleanNoise.Median;
import noise.INoise;
import noise.MixedNoise;
import utils.ImageLoader;
import utils.Utils;

public class CleaningSaltAndPepperTest {

	public static void main(String[] args) {

		float up = (float) 0.9;
		float down = (float) 0.1;
		int constant = 50;

		ImageLoader image = new ImageLoader("image/inverno.jpg");

		INoise noise = new MixedNoise(constant, up, down);

		try {
			int[][] matrix = image.imageToMatrix();
			int[][] noisedMatrix = new int[matrix.length][matrix[0].length];
			noisedMatrix = noise.addNoise(matrix);

			/**
			 * noising the image with mixed noise
			 */
			Utils.printImage(Utils.matrixToBuffered(noisedMatrix), "noised");

			/**
			 * de-noising the image with average filter
			 */
			Average avg = new Average(noisedMatrix);
			avg.filter();

			Utils.printImage(Utils.matrixToBuffered(avg.getMatrix()), "clean - avg");

			/**
			 * noising the image with median filter
			 */
			Median median = new Median(noisedMatrix);
			median.filter(1);
			Utils.printImage(Utils.matrixToBuffered(median.getMatrix()), "clean - median");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
