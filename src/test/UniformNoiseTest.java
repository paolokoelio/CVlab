package test;

import java.io.IOException;

import filter.ImageLoader;
import noise.INoise;
import noise.UniformNoise;
import utils.Utils;

public class UniformNoiseTest {
	
	public static void main(String[] args) {
		
		ImageLoader image = new ImageLoader("image/inverno.jpg");
		
		INoise noise = new UniformNoise(50);
		
		try {
			int[][] matrix = image.imageToMatrix();
			int[][] noisedMatrix = new int[matrix.length][matrix[0].length];
			noisedMatrix = noise.addNoise(matrix);
			
			Utils.printImage(Utils.matrixToBuffered(noisedMatrix), "prova");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
