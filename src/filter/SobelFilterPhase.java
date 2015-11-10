package filter;

public class SobelFilterPhase {

	private float[][] verticalMask = { { 1, 0, -1 }, { (float) Math.sqrt(2), 0, -(float) Math.sqrt(2) }, { 1, 0, -1 } };
	private float[][] horizontalMask = { { 1, (float) Math.sqrt(2), 1 }, { 0, 0, 0 },
			{ -1, -(float) Math.sqrt(2), -1 } };

	private int[][] matrix;

	public SobelFilterPhase(int[][] matrix) {
		super();
		this.matrix = matrix;
	}

	public float[][] getSobelMatrix() {
		float[][] horizontal = filter(horizontalMask);
		float[][] vertical = filter(verticalMask);
		float[][] sobel = new float[vertical.length][vertical[0].length];

		for (int i = 0; i < vertical.length; i++) {
			for (int j = 0; j < vertical[0].length; j++) {
				//sobel[i][j] = (float) Math.sqrt(horizontal[i][j]*horizontal[i][j] + vertical[i][j]*vertical[i][j]);
				sobel[i][j] += (float) (180 * Math.atan2(vertical[i][j], horizontal[i][j]));
				System.out.println(sobel[i][j]);
				if (sobel[i][j] > 255) {
					sobel[i][j] = 255;
				}
				if (sobel[i][j] < 0) {
					sobel[i][j] = 0;
				}
			}
		}
	
		
		//equalizzazione di bardo (per cambiare mettere int[][] come ritorno
		
		
		double min = sobel[0][0];
		double max = sobel[0][0];
		for (int k = 0; k < sobel.length; k++) {
			for (int k2 = 0; k2 < sobel[k].length; k2++) {
				if (sobel[k][k2] < min)
					min = sobel[k][k2];
				if (sobel[k][k2] > max)
					max = sobel[k][k2];
			}
		}
		int[][] newMatrix = new int[sobel.length][sobel[0].length];

		for (int k = 0; k < sobel.length; k++) {
			for (int k2 = 0; k2 < sobel[k].length; k2++) {
				double grayPixel = sobel[k][k2];
				double newGrayPixel = 0;
				if (grayPixel <= min) {
					newGrayPixel = 0;
				} else if (grayPixel >= max) {
					newGrayPixel = 255;
				} else {
					newGrayPixel = 255 * (grayPixel - min) / (max - min);
				}
				newMatrix[k][k2] = (int) newGrayPixel;
				//System.out.println(newGrayPixel);
			}
		}
		
		
		//-- fine bardo
		
		

		return sobel;
	}

	public float[][] filter(float[][] mask) {
		float[][] filtered = new float[matrix.length][matrix[0].length];
		float[][] filtered1 = new float[matrix.length][matrix[0].length];

		for (int i = 0; i < filtered.length; i++) {
			for (int j = 0; j < filtered[0].length; j++) {
				filtered[i][j] = matrix[i][j];
				if (filtered[i][j] > 255) {
					//System.out.println(filtered[i][j]);
				}
			}
		}
		for (int i = 0; i < filtered.length; i++) {
			for (int j = 0; j < filtered[0].length; j++) {
				filtered1[i][j] = matrix[i][j];
				if (filtered[i][j] > 255) {
					//System.out.println(filtered[i][j]);
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
				// System.out.println(convolution);

				filtered1[i][j] = convolution;
			}

		}
		System.out.println(filtered.length + " " + filtered[0].length);
		return filtered1;
	}

}
