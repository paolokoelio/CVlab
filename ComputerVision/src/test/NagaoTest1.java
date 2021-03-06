package test;

import java.io.IOException;

import cleanNoise.Average;
import cleanNoise.Median;
import filter.IFilter;
import filter.ImageLoader;
import filter.Utils;
import noise.INoise;
import noise.MixedNoise;

public class NagaoTest1 {
	
	public static void main(String[] args) {
		
		
		double up = (double)0.9;
		double down = (double)0.1;
		int constant = 50;
		
		ImageLoader image = new ImageLoader("image/inverno.jpg");
		
		INoise noise = new MixedNoise(down, up, constant);
		
		try {
			int[][] matrix = image.imageToMatrix();
			int[][] noisedMatrix = new int[matrix.length][matrix[0].length];
			noisedMatrix = noise.addNoise(matrix);
			
			Utils.printImage(Utils.matrixToBuffered(noisedMatrix), "prova");
			Average avg = new Average(noisedMatrix);
			avg.filter();
			Utils.printImage(Utils.matrixToBuffered(avg.getMatrix()), "pulite");
			
			IFilter filter = new Median(1);
			Utils.printImage(Utils.matrixToBuffered(filter.addFilter(noisedMatrix)), "pulwwite");

			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
