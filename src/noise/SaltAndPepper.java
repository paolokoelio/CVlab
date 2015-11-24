package noise;

import java.util.Random;

public class SaltAndPepper implements INoise {

	private float up;
	private float low;

	public SaltAndPepper(float upper, float lower) {
		super();
		this.up = upper;
		this.low = lower;
	}

	/**
	 * Adding noise between an upper and a lower boundary passed as params.
	 */
	@Override
	public int[][] addNoise(int[][] image) {

		int[][] matrix = new int[image.length][image[0].length];

		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[0].length; j++) {

				float tmp = random();

				if (tmp > up) {
					matrix[i][j] = 255;
				} else if (tmp < low) {
					matrix[i][j] = 0;
				} else {
					matrix[i][j] = image[i][j];
				}

				//System.out.println(image[i][j] + " " + matrix[i][j]);

			}
		}

		return matrix;
	}

	private float random() {
		Random random = new Random();
		return random.nextFloat();
	}
}
