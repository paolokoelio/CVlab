package filter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ThreeOverNineFilter {

	private float[][] mask39 = { { 3, 2, 1 }, { 4, 8, 0 }, { 5, 6, 7 } };
	private List<int[][]> masksList = new LinkedList<int[][]>();

	private int[][] matrix;

	public ThreeOverNineFilter(int[][] matrix) {
		super();
		this.matrix = matrix;
		int[][] mask1 = { { 1, 1, 1 }, { 0, 0, 0 }, { 0, 0, 0 } };
		int[][] mask2 = { { 1, 1, 0 }, { 1, 0, 0 }, { 0, 0, 0 } };
		int[][] mask3 = { { 1, 0, 0 }, { 1, 0, 0 }, { 1, 0, 0 } };
		int[][] mask4 = { { 0, 0, 0 }, { 1, 0, 0 }, { 1, 1, 0 } };
		int[][] mask5 = { { 0, 0, 0 }, { 0, 0, 0 }, { 1, 1, 1 } };
		int[][] mask6 = { { 0, 0, 0 }, { 0, 0, 1 }, { 0, 1, 1 } };
		int[][] mask7 = { { 0, 0, 1 }, { 0, 0, 1 }, { 0, 0, 1 } };
		int[][] mask8 = { { 0, 1, 1 }, { 0, 0, 1 }, { 0, 0, 0 } };
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

		for (int i = 1; i < filtered1.length - 2; i++) {
			for (int j = 1; j < filtered1[0].length - 2; j++) {
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
				int sum = 0;
				for (Integer integer : l) {
					sum += integer;
				}
//				int c1 = 0;
//				for (int j2 = 0; j2 < 3; j2++) {
//					for (int k = 0; k < 3; k++) {
//						c1 += matrix[j2 + i - 1][k + j - 1]
//								* mask39[j2][k];
//					}
//				}
				filtered1[i][j] = 1.5f*((float)max/sum +0.333f)*9;
				System.out.println((float)max/sum);
			}
		}
		return filtered1;
	}

}
