package test;

import static org.junit.Assert.assertArrayEquals;

import java.io.IOException;

import org.junit.Test;

import cleanNoise.Average;
import filter.IFilter;
import filter.ImageLoader;
import filter.SobelFilter;
import filter.Utils;


public class AverageTest {

//	@Test
//	public void test() {
//		int[][] m = {{1,1,1, 1}, {2, 2 ,2 , 2}, {3, 3, 3, 3},  {1,2,3, 4}};
//		for (int i = 0; i < m.length; i++) {
//			for (int j = 0; j < m.length; j++) {
//				System.out.print(m[i][j]);
//			}
//			System.out.println();
//		}
//		Average avg = new Average(m);
//		int[][] minor = avg.get3by3Minor(1, 1);
//		int[][] minor1 = {{1,1,1}, {2, 2 ,2}, {3, 3, 3}};
//		for (int i = 0; i < minor1.length; i++) {
//			assertArrayEquals(minor[i], minor1[i]);
//		}
//		
//		minor = avg.get3by3Minor(2, 2);
//		int[][] minor2 = {{2, 2 ,2}, {3, 3, 3}, {2,3,4}};
//		for (int i = 0; i < minor1.length; i++) {
//			assertArrayEquals(minor[i], minor2[i]);
//		}
//		
//		avg.filter();
//		
//		int[][] mat = avg.getMatrix();
//		
//		int[][] exp = {{1,1,1,1}, {2, 2, 2, 2}, {3, 2, 2,3}, {1, 2, 3, 4}};
//		for (int i = 0; i < mat.length; i++) {
//			assertArrayEquals(exp[i], mat[i]);
//		}
//		
//			
//	}
	
	public static void main(String[] args) {
		
		ImageLoader image = new ImageLoader("image/inverno.jpg");
		try {
			int[][] matrix = image.imageToMatrix();
			IFilter filter = new Average(matrix);

			Utils.printImage(Utils.matrixToBuffered(filter.addFilter(matrix)), "prova");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
