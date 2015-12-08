package test;

import java.io.IOException;

import cleanNoise.Average;
import cleanNoise.Median;
import cleanNoise.Nagao;
import noise.INoise;
import noise.SaltAndPepper;
import utils.ImageLoader;
import utils.Utils;

public class CleaningSaltAndPepper {

	public static void main(String[] args) {

		float up = (float) 0.9;
		float down = (float) 0.1;

		int DIM = 7;

		ImageLoader image = new ImageLoader("image/inverno.jpg");
		
		INoise noise = new SaltAndPepper(up, down);

		try {
			int[][] matrix = image.imageToMatrix();
			int[][] noisedMatrix = new int[matrix.length][matrix[0].length];
			noisedMatrix = noise.addNoise(matrix);

			/**
			 * noising the image with Salt and Pepper noise
			 */
			Utils.printImage(Utils.matrixToBuffered(noisedMatrix), "noised");

			/**
			 * de-noising the image with average filter
			 */
			Average avg = new Average(noisedMatrix);
			avg.filter();

			Utils.printImage(Utils.matrixToBuffered(avg.getMatrix()), "clean - avg");

			/**
			 * de-noising the image with median filter
			 */
			Median median = new Median(noisedMatrix);
			median.filter(1);
			Utils.printImage(Utils.matrixToBuffered(median.getMatrix()), "clean - median");
			
			/**
			 * de-noising the image with nagao filter
			 */
			Nagao nagao = new Nagao(noisedMatrix, DIM);
			median.filter(1);
			Utils.printImage(Utils.matrixToBuffered(nagao.filter()), "clean - nagao");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
