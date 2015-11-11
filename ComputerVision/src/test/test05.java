package test;

import java.io.IOException;

import filter.ImageLoader;
import filter.SobelFilter;
import filter.ThreeOverNineFilter;
import filter.Utils;

public class test05 {

	
	public static void main(String[] args) {
		
		ImageLoader image = new ImageLoader("image/inverno.jpg");

		try {
			int[][] matrix = image.imageToMatrix();
			ThreeOverNineFilter three = new ThreeOverNineFilter(matrix);
			Utils.printImage(Utils.matrixToBuffered(three.filter()), "prova");

		} catch (IOException e) {
			e.printStackTrace();
		}
		

		
		
	}
}
