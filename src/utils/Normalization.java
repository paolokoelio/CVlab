package utils;

public class Normalization {

	float mean;
	float variance;
	int[][] original;

	public Normalization(float mean, float variance) {
		super();
		this.mean = mean;
		this.variance = variance;

	}

	public Normalization() {
		super();

	}

	public static int[][] normalizeImage(double[][] matrix) {

		double min = matrix[0][0];
		double max = matrix[0][0];
		for (int k = 0; k < matrix.length; k++) {
			for (int k2 = 0; k2 < matrix[0].length; k2++) {
				if (matrix[k][k2] < min)
					min = matrix[k][k2];
				if (matrix[k][k2] > max)
					max = matrix[k][k2];
			}
		}
		int[][] newMatrix = new int[matrix.length][matrix[0].length];

		for (int k = 0; k < matrix.length; k++) {
			for (int k2 = 0; k2 < matrix[0].length; k2++) {
				double grayPixel = matrix[k][k2];
				int newGrayPixel = 0;

				newGrayPixel = (int) (255 * (grayPixel - min) / (max - min));

				newMatrix[k][k2] = newGrayPixel;
			}
		}

		return newMatrix;
	}

	public int[][] run(int[][] original) {

		int height = original.length;
		int width = original[0].length;

		float globalMean = Mean(original);
		float globalVariance = Variance(original, globalMean);

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {

				int g = original[i][j];
				float common = (float) Math.sqrt((variance * (float) Math.pow(g - globalMean, 2)) / globalVariance);
				int n = 0;
				if (g > globalMean) {
					n = (int) (mean + common);
				} else {
					n = (int) (mean - common);
				}

				n = n > 255 ? 255 : n;
				n = n < 0 ? 0 : n;

				original[i][j] = n;
			}
		}

		return original;
	}

	public float[][] run(float[][] original) {

		int height = original.length;
		int width = original[0].length;

		float[][] tmp = new float[original.length][original[0].length];

		for (int i = 0; i < tmp.length; i++)
			for (int j = 0; j < tmp[0].length; j++)
				tmp[i][j] = original[i][j];

		float globalMean = Mean(original);
		float globalVariance = Variance(original, globalMean);

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {

				float g = original[i][j];
				float common = (float) Math.sqrt((variance * (float) Math.pow(g - globalMean, 2)) / globalVariance);
				float n = 0;
				if (g > globalMean) {
					n = (int) (mean + common);
				} else {
					n = (int) (mean - common);
				}

				n = n > 255 ? 255 : n;
				n = n < 0 ? 0 : n;

				tmp[i][j] = n;
			}
		}

		return tmp;
	}

	private float Mean(int[][] original) {
		int height = original.length;
		int width = original[0].length;

		float mean = 0;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				mean += original[i][j];
			}
		}
		return mean / (width * height);
	}

	private float Mean(float[][] original) {
		int height = original.length;
		int width = original[0].length;

		float mean = 0;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				mean += original[i][j];
			}
		}
		return mean / (width * height);
	}

	private float Variance(int[][] original, float mean) {
		int height = original.length;
		int width = original[0].length;

		float sum = 0;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				sum += Math.pow(original[i][j] - mean, 2);
			}
		}
		return sum / (float) ((width * height) - 1);
	}

	private float Variance(float[][] original, float mean) {
		int height = original.length;
		int width = original[0].length;

		float sum = 0;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				sum += Math.pow(original[i][j] - mean, 2);
			}
		}
		return sum / (float) ((width * height) - 1);
	}

}
