package filter;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

import model.Normalizer;



public class ThreeOnNineFilter implements IFilter {

	double p;
	double tau;

	public ThreeOnNineFilter(double p, double tau) {
		super();
		this.p = p;
		this.tau = tau;
	}

	@Override
	public int[][] addFilter(int[][] image) {
		return filter(image);
	}
	
	
	public int[][] filter(int[][] original) {
		double[][] matrix = new double[original.length][original[0].length];
		for (int i = 1; i < original.length - 1; i++) {
			for (int j = 1; j < original[0].length- 1; j++) {
				ArrayList<Integer> pCoefficients = new ArrayList<>(8);
	
				pCoefficients.add(original[i-1][j-1]+original[i-1][j]+original[i-1][j+1]);
				pCoefficients.add(original[i-1][j-1]+original[i][j-1]+original[i-1][j]);
				pCoefficients.add(original[i-1][j-1]+original[i][j-1]+original[i+1][j-1]);
				pCoefficients.add(original[i][j-1]+original[i+1][j-1]+original[i+1][j]);
				pCoefficients.add(original[i+1][j-1]+original[i+1][j]+original[i+1][j+1]);
				pCoefficients.add(original[i+1][j]+original[i+1][j+1]+original[i][j+1]);
				pCoefficients.add(original[i+1][j+1]+original[i][j+1]+original[i-1][j+1]);
				pCoefficients.add(original[i][j+1]+original[i-1][j+1]+original[i-1][j]);

				int maxCoefficient = Collections.max(pCoefficients);
				double threshold = ((1 - tau) / (2 * tau - 1));
				double fin = 0;
				if (maxCoefficient > p) {
					double sum = 0;
					sum += original[i-1][j-1];
					sum += original[i-1][j];
					sum += original[i-1][j+1];
					sum += original[i][j-1];
					sum += original[i][j];
					sum += original[i][j+1];
					sum += original[i+1][j-1];
					sum += original[i+1][j];
					sum += original[i+1][j+1];

					fin = (1.5 * ((maxCoefficient / (double) sum) - 0.333));
					if (fin < threshold) {
						matrix[i][j] = fin;
					}
				}

			}

		}
			
		int[][] newMatrix = Normalizer.normalizeImage(matrix);
		
		return newMatrix;
	}

}
