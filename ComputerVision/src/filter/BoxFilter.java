package filter;

public class BoxFilter implements IFilter{

	@Override
	public int[][] addFilter(int[][] image) {
		int[][] newImg = new int[image.length-2][image[0].length-2];
		for (int i = 1; i < image.length - 1; i++) {
			for (int j = 1; j < image[0].length - 1; j++) {

				int sum = 0;
				sum += image[i-1][j-1];
				sum += image[i-1][j];
				sum += image[i-1][j+1];
				sum += image[i][j-1];
				sum += image[i][j];
				sum += image[i][j+1];
				sum += image[i+1][j-1];
				sum += image[i+1][j];
				sum += image[i+1][j+1];
				sum /= 9;

				newImg[i-1][j-1] = sum;
			}

		}

		return newImg;	}
		
}
