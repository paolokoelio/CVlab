package filter;

public class PrewittFilter implements IFilter {

	
	int[][] horizontalMask = {{-1, 0, 1}, {-1, 0, 1}, {-1, 0, 1}};
	int[][] verticalMask = {{1, 1, 1}, {0, 0, 0}, {-1, -1, -1}};
	
	public int[][] filter(int[][] original) {
		int[][] newImg = new int[original.length][original[0].length];
		for (int i = 1; i < original.length - 1; i++) {
			for (int j = 1; j < original[0].length - 1; j++) {
				int x = 0;
				for (int k = 0; k < horizontalMask.length; k++) {
					for (int k2 = 0; k2 < horizontalMask.length; k2++) {
						x += original[i - 1 + k][j - 1 + k2]*horizontalMask[k][k2];
					}
				}
				
				int y = 0;
				for (int k = 0; k < verticalMask.length; k++) {
					for (int k2 = 0; k2 < verticalMask.length; k2++) {
						y += original[i - 1 + k][j - 1 + k2]*verticalMask[k][k2];
					}
				}
				
				int sum = (int) Math.sqrt(x*x + y*y);
				
				if (sum > 255)
					sum = 255;
				else if (sum < 0)
					sum= 0;
				
				newImg[i][j] = sum;
			}

		}

		return newImg;

	}

	@Override
	public int[][] addFilter(int[][] image) {
		return filter(image);
	}

}

