package test;

import java.io.IOException;

import cleanNoise.Average;
import cleanNoise.Median;
import filter.ImageLoader;
import noise.INoise;
import noise.MixedNoise;
import utils.Utils;

public class test04 {

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

			// sporco l'immagine di prova
			Utils.printImage(Utils.matrixToBuffered(noisedMatrix), "sporcata");

			// pulisco l'immagine col filtro average
			Average avg = new Average(noisedMatrix);
			avg.filter();

			Utils.printImage(Utils.matrixToBuffered(avg.getMatrix()), "pulite");

			// pulisco con filtro median
			Median median = new Median(noisedMatrix);
			median.filter(1);
			Utils.printImage(Utils.matrixToBuffered(median.getMatrix()), "pulwwite");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
