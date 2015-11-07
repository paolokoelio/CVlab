package filter;

public class DOGFilter {

	private int[][] matrix;

	private double[][] gauss1 = { { 0.0751, 0.1238, 0.0751 }, { 0.1238, 0.2042, 0.1238 }, { 0.0751, 0.1238, 0.0751 } };
	private double[][] gauss2 = { { 0.1019, 0.1154, 0.1019 }, { 0.1154, 0.1308, 0.1154 }, { 0.1019, 0.1154, 0.1019 } };
	private double[][] dog3x3 = new double[3][3];

	public DOGFilter(int[][] matrix) {
		super();
		this.matrix = matrix;
	}

	public double[][] getDogMatrix() {
		double[][] filtered = filter(this.dog3x3);
		double[][] tmp = new double[filtered.length][filtered[0].length];

		for (int i = 0; i < filtered.length; i++) {
			for (int j = 0; j < filtered[0].length; j++) {
				tmp[i][j] = filtered[i][j];
				if (tmp[i][j] > 255) {
					tmp[i][j] = 255;
				}
				if (tmp[i][j] < 0) {
					tmp[i][j] = 0;
				}
			}
		}

		return tmp;
	}

	public double[][] filter(double[][] mask) {

		double[][] filtered = new double[matrix.length][matrix[0].length];
		double[][] filtered1 = new double[matrix.length][matrix[0].length];

		subtract(this.gauss1, this.gauss2);

		for (int i = 0; i < filtered.length; i++) {
			for (int j = 0; j < filtered[0].length; j++) {
				filtered[i][j] = matrix[i][j];
				if (filtered[i][j] > 255) {
					System.out.println(filtered[i][j]);
				}
			}
		}
		for (int i = 0; i < filtered.length; i++) {
			for (int j = 0; j < filtered[0].length; j++) {
				filtered1[i][j] = matrix[i][j];
				if (filtered[i][j] > 255) {
					System.out.println(filtered[i][j]);
				}
			}
		}

		for (int i = 1; i < filtered.length - 2; i++) {
			for (int j = 1; j < filtered[0].length - 2; j++) {
				int convolution = 0;

				for (int j2 = 0; j2 < 3; j2++) {
					for (int k = 0; k < 3; k++) {
						convolution += filtered[j2 + i - 1][k + j - 1] * mask[j2][k];
					}
				}
				if (convolution > 255) {
					convolution = 255;
				}
				if (convolution < -255) {
					convolution = -255;
				}
				System.out.println(convolution);

				filtered1[i][j] = convolution;
			}

		}
		System.out.println(filtered.length + " " + filtered[0].length);
		return filtered1;
	}

	public void genGauss() {

	}

	public void subtract(double[][] A, double[][] B) {

		for (int r = 0; r < A.length; r++) {
			for (int c = 0; c < A[0].length; c++) {
				this.dog3x3[r][c] = A[r][c] - B[r][c];
			}
		}
	}

}
