package filter;

import model.Normalizer;

public class SobelPhaseFilter implements IFilter {

	int[][] horizontalMask = { { -1, 0, 1 }, { -2, 0, 2 }, { -1, 0, 1 } };
	int[][] verticalMask = { { 1, 2, 1 }, { 0, 0, 0 }, { -1, -2, -1 } };

	public int[][] filter(int[][] original) {
		int[][] newImg = new int[original.length][ original[0].length];

		double[][] matrix = new double[original.length - 1][original[0].length - 1];

		for (int i = 1; i < original.length - 1; i++) {
			for (int j = 1; j < original[0].length - 1; j++) {
				
				int x = 0;
				for (int k = 0; k < horizontalMask.length; k++) {
					for (int k2 = 0; k2 < horizontalMask.length; k2++) {
						x += original[i - 1 + k][ j - 1 + k2]* horizontalMask[k][k2];
					}
				}

				int y = 0;
				for (int k = 0; k < verticalMask.length; k++) {
					for (int k2 = 0; k2 < verticalMask.length; k2++) {
						y += original[i - 1 + k][ j - 1 + k2]* verticalMask[k][k2];
					}
				}

				if (x == 0)
					matrix[i][j] = 0;
				else
					matrix[i][j] = 180* Math.atan2(y,x) / Math.PI;

			}

		}

		int[][] newMatrix = Normalizer.normalizeImage(matrix);

		for (int i = 1; i < newMatrix.length; i++) {
			for (int j = 1; j < newMatrix[i].length; j++) {
				newImg[i][j] = newMatrix[i][j];
			}
		}
		return newImg;

	}

	@Override
	public int[][] addFilter(int[][] image) {
		return filter(image);
	}

}