package filter;
import java.util.ArrayList;

import model.Normalizer;

public class KirshFilter implements IFilter {

	ArrayList<int[][]> masks = new ArrayList<>(8);
	int[][] mask1 = {{-3, -3, 5}, {-3, 0, 5}, {-3, -3, 5}};
	int[][] mask2 = {{-3, 5, 5}, {-3, 0, 5}, {-3, -3, -3}};
	int[][] mask3 = {{5, 5, 5}, {-3, 0, -3}, {-3, -3, -3}};
	int[][] mask4 = {{5, 5, -3}, {5, 0, -3}, {-3, -3, -3}};
	int[][] mask5 = {{5, -3, -3}, {5, 0, -3}, {5, -3, -3}};
	int[][] mask6 = {{-3, -3, -3}, {5, 0, -3}, {5, 5, -3}};
	int[][] mask7 = {{-3, -3, -3}, {-3, 0, -3}, {5, 5, 5}};
	int[][] mask8 = {{-3, -3, -3}, {-3, 0, 5}, {-3, 5, 5}};
	
	public int[][] filter(int[][] original) {
		masks.add(mask1);
		masks.add(mask2);
		masks.add(mask3);
		masks.add(mask4);
		masks.add(mask5);
		masks.add(mask6);
		masks.add(mask7);
		masks.add(mask8);
		double[][] matrix = new double[original.length - 1][original[0].length - 1];
		for (int i = 1; i < original.length - 1; i++) {
			for (int j = 1; j < original[0].length - 1; j++) {
				int max = Integer.MIN_VALUE;
				for (int j2 = 0; j2 < masks.size(); j2++) {
					int[][] currentMask = masks.get(j2);
					int sum = 0;
					for (int k = 0; k < currentMask.length; k++) {
						for (int k2 = 0; k2 < currentMask.length; k2++) {
							sum += original[i-1+k][j-1+k2]*currentMask[k][k2];
						}
					}
					if(sum > max) max = sum;
				}
				matrix[i][j] = max;
			}
		}
		
		int[][] newMatrix = Normalizer.normalizeImage(matrix);
		
		return newMatrix;
	}

	@Override
	public int[][] addFilter(int[][] image) {
		return filter(image);
	}

}
