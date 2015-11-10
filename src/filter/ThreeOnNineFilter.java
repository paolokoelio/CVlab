package filter;

import java.util.ArrayList;
import java.util.Collections;

public class ThreeOnNineFilter {

	private int[][] original;
	private double tau;

	public ThreeOnNineFilter(int[][] origninal, double tau) {
		super();
		this.tau = tau;
		this.original = origninal;
	}

	public double[][] filter() {

		double[][] toFilter = new double[original.length][original[0].length];

		for (int i = 0; i < toFilter.length; i++) {
			for (int j = 0; j < toFilter[0].length; j++) {
				toFilter[i][j] = original[i][j];
				if (toFilter[i][j] > 255) {
					// System.out.println("filtered[i][j]);
				}
			}
		}

		double[][] filtered = new double[original.length][original[0].length];

		for (int i = 0; i < filtered.length; i++) {
			for (int j = 0; j < filtered[0].length; j++) {
				filtered[i][j] = original[i][j];
				if (filtered[i][j] > 255) {
					// System.out.println(filtered[i][j]);
				}
			}
		}

		for (int i = 1; i < toFilter.length - 1; i++) {
			for (int j = 1; j < toFilter[0].length - 1; j++) {
				ArrayList<Double> Ps = new ArrayList<Double>(8);
				Ps.add(toFilter[i - 1][j - 1] + toFilter[i - 1][j] + toFilter[i - 1][j + 1]); // P1
				Ps.add(toFilter[i][j - 1] + toFilter[i - 1][j - 1] + toFilter[i - 1][j]); // P2
				Ps.add(toFilter[i - 1][j - 1] + toFilter[i][j - 1] + toFilter[i + 1][j - 1]); // P3
				Ps.add(toFilter[i][j - 1] + toFilter[i + 1][j - 1] + toFilter[i + 1][j - 1]); // P4
				Ps.add(toFilter[i + 1][j - 1] + toFilter[i + 1][j] + toFilter[i + 1][j + 1]); // P5
				Ps.add(toFilter[i + 1][j] + toFilter[i + 1][j + 1] + toFilter[i][j + 1]); // P6
				Ps.add(toFilter[i + 1][j + 1] + toFilter[i][j + 1] + toFilter[i - 1][j + 1]); // P7
				Ps.add(toFilter[i][j + 1] + toFilter[i - 1][j + 1] + toFilter[i - 1][j]); // P8

				double maxP = Collections.max(Ps);

				double sumP = 0;

				for (Double I : Ps) {
					if (I > 255)
						I = (double) 255;
					sumP += I;
				}

				double P = (3 / 2) * (maxP / sumP * 0.333);
				if (P > 255)
					P = 255;
				else if (P < 0)
					P = 0;

				filtered[i][j] = P;

			}
		}

		return filtered;

	}

	public float[][] getNewMatrix() {
		// TODO Auto-generated method stub
		return null;
	}

}
