package filter;

public class DogFilter implements IFilter{

	
	private double sigma,sigma2;
	
	
	
	public DogFilter(double sigma, double sigma2) {
		super();
		this.sigma = sigma;
		this.sigma2 = sigma2;
	}


	@Override
	public int[][] addFilter(int[][] image) {
		return dogFilter(image);
	}
	
	
	public int[][] dogFilter(int[][] image) {

		int dim = (int) Math.ceil(sigma2 * 6);
		if (dim % 2 == 0) {
			dim += 1;
		}

		int matrix[][] = new int[image.length][image[0].length];

		double[][] gauss = new double[dim][dim];
		gauss = Utils.getGaussian(sigma, dim);
		double[][] gauss2 = new double[dim][dim];
		gauss2 = Utils.getGaussian(sigma2, dim);

		double[][] gaussian = new double[dim][dim];

		for (int i = 0; i < gaussian.length; i++) {
			for (int j = 0; j < gaussian.length; j++) {
				gaussian[i][j] = gauss[i][j] - gauss2[i][j];
			}
		}

		for (int i = dim / 2; i < image.length - dim / 2; i++) {
			for (int j = dim / 2; j < image[0].length - dim / 2; j++) {

				double convolution = 0;

				for (int j2 = 0; j2 < dim; j2++) {
					for (int k = 0; k < dim; k++) {
						convolution += image[j2 + i - dim / 2][k + j - dim / 2] * gaussian[j2][k];
					}
				}

				if (convolution < 0) {
					matrix[i][j] = 0;
				} else {
					matrix[i][j] = 255;
				}

			}
		}

		return edgeDetection(matrix);
	}

	private int[][] edgeDetection(int[][] matrix) {

		int[][] matr = new int[matrix.length][matrix[0].length];

		for (int i = 1; i < matrix.length - 1; i++) {
			for (int j = 1; j < matrix[0].length - 1; j++) {
				for (int j2 = -1; j2 <= 1; j2++) {
					for (int k = -1; k <= 1; k++) {
						if (matrix[i][j] != matrix[i + j2][j + k]) {
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



}
