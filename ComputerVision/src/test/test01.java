package test;

import java.io.IOException;

import filter.ImageLoader;

public class test01 {

	public static void main(String[] args) {

		ImageLoader loader = new ImageLoader("albert.gif");

		int[][] matrix = null;
		try {
			matrix = loader.imageToMatrix();
		} catch (IOException e) {
			// TODO Auto-generated catch block9
			System.out.println("error found");
			e.printStackTrace();
		}
		
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length ; j++) {
				System.out.println(matrix[i][j]);
			}
		}	
		

	}

}
