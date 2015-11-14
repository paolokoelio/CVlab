package filter;

import java.util.ArrayList;
import java.util.Collections;

import utils.Normalization;

/**
 * This filter is about weighting the most relevant sum of pixels of 8 pieces of
 * the neighborhood of a give pixel. We use a threshold, obtained combining the
 * parameter tau in the formula, for setting the final given pixel, also through
 * a formula. A more detailed description is given near the single methods.
 */
public class ThreeOnNineFilter {

	private int[][] original;
	private double tau;
	private double P;

	public ThreeOnNineFilter(int[][] origninal, double tau, double P) {
		super();
		this.tau = tau;
		this.original = origninal;
		this.P = P;
	}

	// principal method for filtering
	public int[][] filter() {

		double[][] toFilter = new double[original.length][original[0].length];

		// copying original image into temporary array
		for (int i = 0; i < toFilter.length; i++) {
			for (int j = 0; j < toFilter[0].length; j++) {
				toFilter[i][j] = original[i][j];
			}
		}

		double[][] filtered = new double[original.length][original[0].length];
		int[][] filtered1 = new int[original.length][original[0].length];

		// executing 3on9 by generating an arrayList of values for each piece of
		// the neighbors, getting the max and applying the tau and a threshold;
		// then filling the resulting array filtered with values from the
		// applied formula on finP
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
				double thr = ((1 - tau) / (2 * tau - 1));
				double finP = 0;
				if (maxP > P) {
					double sumP = 0;
					sumP += toFilter[i - 1][j - 1];
					sumP += toFilter[i - 1][j];
					sumP += toFilter[i - 1][j + 1];
					sumP += toFilter[i][j - 1];
					sumP += toFilter[i][j];
					sumP += toFilter[i][j + 1];
					sumP += toFilter[i + 1][j - 1];
					sumP += toFilter[i + 1][j];
					sumP += toFilter[i + 1][j + 1];

					finP = (1.5 * ((maxP / (double) sumP) - 0.333));
					if (finP < thr) {
						filtered[i][j] = finP;
					}
				}

			}
		}

		// normalizing the image in order to get visible results
		filtered1 = Normalization.normalizeImage(filtered);

		// needed to shift the final image to the border of one pixel
		int[][] filtered2 = new int[original.length - 2][original[0].length - 2];

		for (int i = 1; i < filtered1.length - 1; i++) {
			for (int j = 1; j < filtered1[i].length - 1; j++) {

				filtered2[i - 1][j - 1] = filtered1[i][j];
			}
		}

		return filtered2;

	}

}
