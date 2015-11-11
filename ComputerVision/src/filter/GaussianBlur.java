package filter;

public class GaussianBlur  implements IFilter{


	private double sigma;
	
	public GaussianBlur(double sigma) {
		super();
		this.sigma = sigma;
	}


	@Override
	public int[][] addFilter(int[][] image) {
		return blurFilter(image);
	}
	
	
	public int[][] blurFilter(int[][] image) {

		int dim = (int) Math.ceil(sigma * 6);
		if (dim % 2 == 0) {
			dim += 1;
		}

		int matrix[][] = new int[image.length][image[0].length];

		double[][] gauss = new double[dim][dim];
		gauss = Utils.getGaussian(sigma, dim);

		for (int i = dim / 2; i < image.length - dim / 2; i++) {
			for (int j = dim / 2; j < image[0].length - dim / 2; j++) {

				double convolution = 0;

				for (int j2 = 0; j2 < dim; j2++) {
					for (int k = 0; k < dim; k++) {
						convolution += image[j2 + i - dim / 2][k + j - dim / 2] * gauss[j2][k];
					}
				}

				matrix[i][j] = (int) Math.ceil(convolution);

				if (convolution < 0) {
					matrix[i][j] = 0;
				}
				if (convolution > 255) {
					matrix[i][j] = 255;
				}

			}
		}

		return matrix;

	}


}
