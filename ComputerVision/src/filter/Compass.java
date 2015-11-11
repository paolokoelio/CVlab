package filter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Compass {

	private List<int[][]> masksList = new LinkedList<int[][]>();

	private int[][] matrix;

	public Compass(int[][] matrix) {
		super();
		this.matrix = matrix;
		int[][] mask1 = { { -1, 1, 1 }, { -1, -2, 1 }, { -1, 1, 1 } };
		int[][] mask2 = { { 1, 1, 1 }, { -1, -2, 1 }, { -1, -1, 1 } };
		int[][] mask3 = { { 1, 1, 1 }, { 1, -2, 1 }, { -1, -1, -1} };
		int[][] mask4 = { { 1, 1, 1 }, { 1, -2, -1 }, { 1, -1, -1 } };
		int[][] mask5 = { { 1, 1, -1 }, { 1, -2, -1 }, { 1, 1, -1 } };
		int[][] mask6 = { { 1, -1, -1 }, { 1, -2, -1 }, { 1, 1, 1 } };
		int[][] mask7 = { { -1, -1, -1 }, { 1, -2, 1 }, { 1, 1, 1 } };
		int[][] mask8 = { { -1, -1, 1 }, { -1, -2, 1 }, { 1, 1, 1} };
		masksList.add(mask1);
		masksList.add(mask2);
		masksList.add(mask3);
		masksList.add(mask4);
		masksList.add(mask5);
		masksList.add(mask6);
		masksList.add(mask7);
		masksList.add(mask8);
	}

	public float[][] filter() {
		float[][] filtered1 = new float[matrix.length][matrix[0].length];

		for (int i = 0; i < filtered1.length; i++) {
			for (int j = 0; j < filtered1[0].length; j++) {
				filtered1[i][j] = matrix[i][j];
			}
		}
		
		int min1 = 2000;
		int max1 = -2000;
		for (int i = 1; i < filtered1.length - 1; i++) {
			for (int j = 1; j < filtered1[0].length - 1; j++) {
				ArrayList<Integer> l = new ArrayList<Integer>(8);
				for (int p = 0; p < 8; p++) {
					int[][] m = masksList.get(p);
					int convolution = 0;
					for (int j2 = 0; j2 < 3; j2++) {
						for (int k = 0; k < 3; k++) {
							convolution += matrix[j2 + i - 1][k + j - 1]
									* m[j2][k];
						}
					}
					l.add(convolution);
				}
				
				int max = Collections.max(l);
				if(max<min1) {
					min1 = max;
				}
				if(max>max1) {
					max1 = max;
				}
				filtered1[i][j] = max;
//				int c1 = 0;
//				for (int j2 = 0; j2 < 3; j2++) {
//					for (int k = 0; k < 3; k++) {
//						c1 += matrix[j2 + i - 1][k + j - 1]
//								* mask39[j2][k];
//					}
//				}
				System.out.println(max1 + " " + min1);
			}
		}
		for (int i = 0; i < filtered1.length; i++) {
			for (int j = 0; j < filtered1[0].length; j++) {
				//System.out.print(filtered1[i][j]+ " ");
				filtered1[i][j] = (filtered1[i][j]-min1)*255/(max1-min1);
			}
			//System.out.println();
		}
		return filtered1;
	}

}
