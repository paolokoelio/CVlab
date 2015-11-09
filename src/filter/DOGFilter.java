package filter;

import java.text.DecimalFormat;

public class DOGFilter {

	private int[][] matrix;
	private int kernelDim;
	private double[][] gauss1;
	private double[][] gauss2;
	private double[][] dog;
	DecimalFormat numberFormat = new DecimalFormat("#.0000");

	public DOGFilter(int[][] matrix, int kernelDim) {
		super();
		this.kernelDim = kernelDim;
		//System.out.println("KERNEL DIM: " + this.kernelDim + "\n");
		this.matrix = matrix;
		this.dog = new double[matrix.length][matrix[0].length];
	}

	public double[][] getDogMatrix() {

		double[][] filtered = filter(gauss1);
		double[][] filtered1 = filter(gauss2);
		double[][] tmp = new double[filtered.length][filtered[0].length];

		subtract(filtered, filtered1);

		for (int i = 0; i < dog.length; i++) {
			for (int j = 0; j < dog[0].length; j++) {
				tmp[i][j] = dog[i][j];
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

		for (int i = 0; i < filtered.length; i++) {
			for (int j = 0; j < filtered[0].length; j++) {
				filtered[i][j] = matrix[i][j];
				if (filtered[i][j] > 255) {
					// System.out.println(filtered[i][j]);
				}
			}
		}
		for (int i = 0; i < filtered.length; i++) {
			for (int j = 0; j < filtered[0].length; j++) {
				filtered1[i][j] = matrix[i][j];
				if (filtered[i][j] > 255) {
					// System.out.println(filtered[i][j]);
				}
			}
		}
		
		for (int i = 1; i < filtered.length - (this.kernelDim-1); i++) {
			for (int j = 1; j < filtered[0].length - (this.kernelDim-1); j++) {
				int convolution = 0;

				
				for (int j2 = 0; j2 < this.kernelDim; j2++) {
					for (int k = 0; k < this.kernelDim; k++) {
						convolution += filtered[j2 + i - 1][k + j - 1] * mask[j2][k];
					}
				}
				if (convolution > 255) {
					convolution = 255;
				}
				if (convolution < -255) {
					convolution = -255;
				}
				// System.out.println(convolution);

				filtered1[i][j] = convolution;
			}

		}
		System.out.println(filtered.length + " " + filtered[0].length);
		return filtered1;
	}

	public void setGauss(double[][] g1, double[][] g2) {
		this.gauss1 = g1;
		this.gauss2 = g2;

	}

	public void subtract(double[][] A, double[][] B) {

		for (int r = 0; r < A.length; r++) {
			for (int c = 0; c < A[0].length; c++) {
				this.dog[r][c] = A[r][c] - B[r][c];
			}
		}
		
		System.out.println(this.dog.length + " " + this.dog[0].length);
	}

}
