package test;

import java.io.IOException;

import cleanNoise.Nagao;
import noise.INoise;
import noise.MixedNoise;
import utils.ImageLoader;
import utils.Utils;

public class NagaoTest {

	public static void main(String[] args) {

		//noise parameters
		float up = (float) 0.9;
		float down = (float) 0.1;
		int constant = 20;

		ImageLoader image = new ImageLoader("image/inverno.jpg");

		//nagao kernel dim
		int DIM = 7;

		int[][] matrix;
		try {
			matrix = image.imageToMatrix();

			INoise noise = new MixedNoise(constant, up, down);

			Utils.printImage(Utils.matrixToBuffered(matrix), "original");

			Nagao filter = new Nagao(matrix, DIM);

			Utils.printImage(Utils.matrixToBuffered(filter.filter()), "nagao - original");

			int[][] noisedMatrix = new int[matrix.length][matrix[0].length];
			noisedMatrix = noise.addNoise(matrix);

			// dirtening
			Utils.printImage(Utils.matrixToBuffered(noisedMatrix), "dirten");

			Nagao filterN = new Nagao(noisedMatrix, DIM);

			Utils.printImage(Utils.matrixToBuffered(filterN.filter()), "nagao - pulita");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
