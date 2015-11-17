package filter;

public class SharpeningFilter implements IFilter {

	public int[][] filter(int[][] original) {
		
		int[][] newImg = new int[original.length-2][original[0].length-2];

		for (int i = 1; i < original.length - 1; i++) {
			for (int j = 1; j < original[0].length - 1; j++) {

				int sum = 0;
				sum += original[i - 1][ j - 1];
				sum += original[i - 1][ j];
				sum += original[i - 1][ j + 1];
				sum += original[i][ j - 1];
				sum += original[i][ j];
				sum += original[i][ j + 1];
				sum += original[i + 1][ j - 1];
				sum += original[i + 1][ j];
				sum += original[i + 1][ j + 1];
				sum /= 9;

				int a = 2 * original[i][ j];
				int value = a - sum;
				if (value > 255)
					value = 255;
				else if(value < 0)
					value = 0;

				newImg[i-1][j-1] = value ;
			}

		}

		return newImg;
	}

	@Override
	public int[][] addFilter(int[][] image) {
		return filter(image);
	}
}