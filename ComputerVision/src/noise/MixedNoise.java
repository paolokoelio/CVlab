package noise;

import java.util.Random;

public class MixedNoise implements INoise {

	private int constant;
	private double upper;
	private double lower;

	public MixedNoise(double lower, double upper, int constant) {
		super();
		this.constant = constant;
		this.upper = upper;
		this.lower = lower;
	}

	@Override
	public int[][] addNoise(int[][] image) {

		int[][] matrix = new int[image.length][image[0].length];

		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[0].length; j++) {

				float tmp = casual();

				if (tmp > upper) {
					matrix[i][j] = 255;
				} else if (tmp < lower) {
					matrix[i][j] = 0;
				} else {
					matrix[i][j] = image[i][j] + uniform(constant);
					if (matrix[i][j] < 0) {
						matrix[i][j] = 0;
					}
					if (matrix[i][j] > 255) {
						matrix[i][j] = 255;
					}
				}

			}
		}

		return matrix;

	}

	private float casual() {
		Random random = new Random();
		return random.nextFloat();
	}

	private int uniform(int constant) {
		Random random = new Random();
		return (int) ((random.nextFloat() - (float) 0.5) * 2 * constant);
	}

}
