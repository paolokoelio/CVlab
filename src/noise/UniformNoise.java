package noise;

import java.util.Random;

public class UniformNoise implements INoise {

	private int constant;

	public UniformNoise(int constant) {
		super();
		this.constant = constant;
	}

	/**
	 * Adding noise to the single pixel by a random controlled function (
	 * uniform() ) through a constant parameter.
	 */
	@Override
	public int[][] addNoise(int[][] image) {

		int[][] matrix = new int[image.length][image[0].length];

		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[0].length; j++) {

				matrix[i][j] = image[i][j] + uniform(constant);
				if (matrix[i][j] < 0) {
					matrix[i][j] = 0;
				}
				if (matrix[i][j] > 255) {
					matrix[i][j] = 255;
				}
				//System.out.println(image[i][j] + " " + matrix[i][j]);

			}
		}

		return matrix;
	}

	/**
	 * funzione che restituisce un float casuale tra -0.5 e 0.5 e lo moltiplica
	 * per 2*constant
	 */
	private int uniform(int constant) {
		Random random = new Random();
		return (int) ((random.nextFloat() - (float) 0.5) * 2 * constant);
	}

}
