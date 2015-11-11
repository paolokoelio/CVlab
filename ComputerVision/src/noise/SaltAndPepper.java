package noise;

import java.util.Random;

public class SaltAndPepper implements INoise {

	private double upper;
	private double lower;

	public SaltAndPepper(double lower, double upper) {
		super();
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
					matrix[i][j] = image[i][j];
				}

			//	System.out.println(image[i][j] + " " + matrix[i][j]);

			}
		}

		return matrix;
	}

	private float casual() {
		Random random = new Random();
		return random.nextFloat();
	}
}
