package test;

import java.io.IOException;

import cleanNoise.Nagao;
import filter.ImageLoader;
import filter.Utils;
import noise.INoise;
import noise.SaltAndPepper;

public class test03 {

	public static void main(String[] args) {
		
		
		float up = (float)0.99;
		float down = (float)0.01;
		
		ImageLoader image = new ImageLoader("image/inverno.jpg");

		INoise noise = new SaltAndPepper(up, down);
		
		
		try {
			int[][] matrix = image.imageToMatrix();
			int[][] noisedMatrix = new int[matrix.length][matrix[0].length];
			noisedMatrix = noise.addNoise(matrix);
			Nagao nag = new Nagao(noisedMatrix);
			Utils.printImage(Utils.matrixToBuffered(nag.filter()), "pulwwite");
			Utils.printImage(Utils.matrixToBuffered(noisedMatrix), "sporca");
			Utils.printImage(Utils.matrixToBuffered(matrix), "prova");

			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
