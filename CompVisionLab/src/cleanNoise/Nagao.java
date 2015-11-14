package cleanNoise;

/**
 * Il filtro di Nagao si ottiene calcolando media e varianza di 9 sottofinestre
 * (a petali) circostanti il pixel corrente. Di queste sottofinestre si
 * seleziona quella con varianza minore. La media di quest'ultima diventa il
 * valore del pixel corrente.
 * 
 * @author nicola
 */
public class Nagao {

	int dimKernel;
	int limInf;
	int limMed;
	int limSup;
	int[][] matrix;

	public Nagao(int[][] matrix, int dimKernel) {
		super();

		if (dimKernel % 2 == 0)
			dimKernel = dimKernel - 1;

		this.dimKernel = dimKernel;
		this.matrix = matrix;

		limInf = 0;
		limMed = dimKernel / 2;
		limSup = dimKernel - 1;
	}

	public int[][] filter() {
		int[][] filtered = new int[matrix.length - dimKernel + 1][matrix[0].length - dimKernel + 1];

		for (int a = dimKernel / 2; a < matrix.length - dimKernel / 2; a++) {
			for (int b = dimKernel / 2; b < matrix[0].length - dimKernel / 2; b++) {

				// i get the sum of each nagao window and count the elements
				int[] sums = new int[9];
				for (int i = 0; i < sums.length; i++) {
					sums[i] = 0;
				}
				int[] counts = new int[9];
				for (int i = 0; i < counts.length; i++) {
					counts[i] = 0;
				}

				for (int i = 0; i < dimKernel; i++) {
					for (int j = 0; j < dimKernel; j++) {

						int pix = matrix[a - dimKernel / 2 + i][b - dimKernel / 2 + j];

						if (i != limInf && i != limSup && j != limInf && j != limSup) {
							sums[0] += pix;
							counts[0]++;
						}
						if (i <= j && i + j < dimKernel
								&& !((i == limInf && j == limInf) || (i == limInf && j == limSup))) {
							sums[1] += pix;
							counts[1]++;
						}

						if (i <= j && i + j >= limSup
								&& !((i == limInf && j == limSup) || (i == limSup && j == limSup))) {
							sums[2] += pix;
							counts[2]++;
						}

						if (i >= j && i + j >= limSup
								&& !((i == limSup && j == limSup) || (i == limSup && j == limInf))) {
							sums[3] += pix;
							counts[3]++;
						}

						if (i >= j && i + j < dimKernel
								&& !((i == limSup && j == limInf) || (i == limInf && j == limInf))) {
							sums[4] += pix;
							counts[4]++;
						}

						if (i <= limMed && j <= limMed
								&& !((i == limInf && j == limMed) || (i == limMed && j == limInf))) {
							sums[5] += pix;
							counts[5]++;
						}

						if (i <= limMed && j >= limMed
								&& !((i == limInf && j == limMed) || (i == limMed && j == limSup))) {
							sums[6] += pix;
							counts[6]++;
						}

						if (i >= limMed && j >= limMed
								&& !((i == limSup && j == limMed) || (i == limMed && j == limSup))) {
							sums[7] += pix;
							counts[7]++;
						}

						if (i >= limMed && j <= limMed
								&& !((i == limSup && j == limMed) || (i == limMed && j == limInf))) {
							sums[8] += pix;
							counts[8]++;
						}

					}
				}

				// i compute the avarages
				int[] averages = new int[9];
				for (int i = 0; i < averages.length; i++) {
					averages[i] = sums[i] / counts[i];
				}

				// i calculate the variances of each nagao window
				int[] diff = new int[9];
				for (int i = 0; i < diff.length; i++) {
					diff[i] = 0;
				}
				for (int i = 0; i < dimKernel; i++) {
					for (int j = 0; j < dimKernel; j++) {

						int pix = matrix[a - dimKernel / 2 + i][b - dimKernel / 2 + j];

						if (i != limInf && i != limSup && j != limInf && j != limSup) {
							diff[0] += Math.pow(averages[0] - pix, 2);
						}
						if (i <= j && i + j < dimKernel
								&& !((i == limInf && j == limInf) || (i == limInf && j == limSup))) {
							diff[1] += Math.pow(averages[1] - pix, 2);
						}

						if (i <= j && i + j >= limSup
								&& !((i == limInf && j == limSup) || (i == limSup && j == limSup))) {
							diff[2] += Math.pow(averages[2] - pix, 2);
						}

						if (i >= j && i + j >= limSup
								&& !((i == limSup && j == limSup) || (i == limSup && j == limInf))) {
							diff[3] += Math.pow(averages[3] - pix, 2);
						}

						if (i >= j && i + j < dimKernel
								&& !((i == limSup && j == limInf) || (i == limInf && j == limInf))) {
							diff[4] += Math.pow(averages[4] - pix, 2);
						}

						if (i <= limMed && j <= limMed
								&& !((i == limInf && j == limMed) || (i == limMed && j == limInf))) {
							diff[5] += Math.pow(averages[5] - pix, 2);
						}

						if (i <= limMed && j >= limMed
								&& !((i == limInf && j == limMed) || (i == limMed && j == limSup))) {
							diff[6] += Math.pow(averages[6] - pix, 2);
						}

						if (i >= limMed && j >= limMed
								&& !((i == limSup && j == limMed) || (i == limMed && j == limSup))) {
							diff[7] += Math.pow(averages[7] - pix, 2);
						}

						if (i >= limMed && j <= limMed
								&& !((i == limSup && j == limMed) || (i == limMed && j == limInf))) {
							diff[8] += Math.pow(averages[8] - pix, 2);
						}

					}
				}
				int[] variances = new int[9];
				for (int i = 0; i < diff.length; i++) {
					variances[i] = diff[i] / counts[i];
				}

				// i find the minimum variance
				int min = 1000000000;
				int indexMin = 0;
				for (int i = 0; i < variances.length; i++) {
					if (variances[i] < min) {
						min = variances[i];
						indexMin = i;
					}
				}

				// i assign to the pixel the value of the avarage of the window
				// with the minimum variance
				filtered[a - dimKernel / 2][b - dimKernel / 2] = averages[indexMin];
			}
		}

		return filtered;
	}

}