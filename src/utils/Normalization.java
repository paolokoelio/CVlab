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
