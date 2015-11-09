package filter;

import java.text.DecimalFormat;

public class GaussianMatrix {

	public double[][] kernel;

	public GaussianMatrix(double sigma, int dimensionKernel) {

		double[][] kernel = new double[dimensionKernel][dimensionKernel];
		double mean = dimensionKernel / 2;
		double sum = 0.0;

		// Choose how many decimal numbers to display
		DecimalFormat numberFormat = new DecimalFormat("#.00000");

		for (int i = 0; i < dimensionKernel; i++)
			for (int j = 0; j < dimensionKernel; j++) {
				kernel[i][j] = Math.exp(-0.5 * (Math.pow((i - mean) / sigma, 2.0) + Math.pow((j - mean) / sigma, 2.0)))
						/ Math.sqrt(2 * sigma * sigma * Math.PI);

				sum += kernel[i][j];
			}

		// Normalize the kernel
		for (int i = 0; i < dimensionKernel; i++)
			for (int j = 0; j < dimensionKernel; j++)
				kernel[i][j] /= sum;

		// Print the kernel
		for (int i = 0; i < dimensionKernel; i++)
			for (int j = 0; j < dimensionKernel; j++) {
				System.out.print(numberFormat.format(kernel[i][j]) + ", ");
				if (j == dimensionKernel - 1)
					System.out.println();
			}
		System.out.println();
		
		this.kernel = kernel;
	}

	public double[][] getMatrix() {

		return this.kernel;
	}
}