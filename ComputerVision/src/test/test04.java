package test;

import java.io.IOException;

import filter.ImageLoader;
import filter.Utils;
import noise.INoise;
import noise.MixedNoise;

public class test04 {
	
	public static void main(String[] args) {
		
		
		float up = (float)0.9;
		float down = (float)0.1;
		int constant = 50;
		
		ImageLoader image = new ImageLoader("image/inverno.jpg");
		
		INoise noise = new MixedNoise(constant, up, down);
		
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
