package filter;

/**
 * The Difference of Gaussians filter consists in subtracting two gaussian
 * kernels with different sigmas and the convolving the result with the image.
 * The gaussians' dimention is set according to the sigmas (lets say it has to
 * be six times the biggest variance). After this point it's useful to
 * "remove smoothness" in order to enhance borders by setting pixels that differ
 * from black (0) to white (255). Then we perform an edge detection function of
 * a 3x3 kernel (edgeDetector) analyzing the neighbors a setting the pixel white
 * if no neighbors differs.
 * 
 * @author koelio
 *
 */
public class DOGFilter {

	private int[][] matrix;
	private int kernelDim;
	private double[][] gauss1;
	private double[][] gauss2;
	private double[][] dog;

	public DOGFilter(int[][] matrix, int kernelDim) {
		super();
		this.kernelDim = kernelDim;
		this.matrix = matrix;
		System.out.println("Image dim: " + matrix.length + " " + matrix[0].length);
		this.dog = new double[matrix.length][matrix[0].length];
	}

	public int[][] getDogMatrix() {

		double[][] gaussSub = subtract(gauss1, gauss2);

		dog = filter(gaussSub);

		return edgeDetector(dog);

	}

	public double[][] filter(double[][] mask) {

		double[][] filtered = new double[matrix.length - this.kernelDim / 2][matrix[0].length - this.kernelDim / 2];

		double[][] filtered1 = new double[matrix.length][matrix[0].length];

		// for (int i = 0; i < filtered.length; i++) {
		// for (int j = 0; j < filtered[0].length; j++) {
		// filtered[i][j] = matrix[i][j];
		// }
		// }

		for (int i = 0; i < filtered1.length; i++) {
			for (int j = 0; j < filtered1[0].length; j++) {
				filtered1[i][j] = matrix[i][j];
			}
		}

		for (int i = this.kernelDim / 2; i < filtered1.length - this.kernelDim / 2; i++) {
			for (int j = this.kernelDim / 2; j < filtered1[0].length - this.kernelDim / 2; j++) {
				double convolution = 0;

				for (int j2 = 0; j2 < this.kernelDim; j2++) {
					for (int k = 0; k < this.kernelDim; k++) {
						convolution += filtered1[j2 + i - this.kernelDim / 2][k + j - this.kernelDim / 2] * mask[j2][k];

					}
				}

				if (convolution < 0) {
					filtered[i - this.kernelDim / 2][j - this.kernelDim / 2] = 0;
				} else {
					filtered[i - this.kernelDim / 2][j - this.kernelDim / 2] = 255;
				}

				// System.out.println(convolution);
			}

		}
		// System.out.println(filtered.length + " " + filtered[0].length);
		return filtered;
	}

	private int[][] edgeDetector(double[][] tmp) {

		int[][] matr = new int[tmp.length][tmp[0].length];

		for (int i = 1; i < tmp.length - 1; i++) {
			for (int j = 1; j < tmp[0].length - 1; j++) {
				for (int j2 = -1; j2 <= 1; j2++) {
					for (int k = -1; k <= 1; k++) {
						if (tmp[i][j] != tmp[i + j2][j + k]) {
							matr[i][j] = 0;
							k = 2;
							j2 = 2;
						} else {
							matr[i][j] = 255;
						}
					}

				}
			}
		}

		return matr;

	}

	public void setGauss(double[][] g1, double[][] g2) {
		this.gauss1 = g1;
		this.gauss2 = g2;

	}

	public double[][] subtract(double[][] A, double[][] B) {

		double[][] C = new double[A.length][A[0].length];

		for (int r = 0; r < A.length; r++) {
			for (int c = 0; c < A.length; c++) {
				C[r][c] = A[r][c] - B[r][c];
			}
		}

		System.out.println("kernel dim: " + C.length + " " + C[0].length);
		return C;
	}

}
