package filter;

public class SobelFilter {

	private int[][] verticalMask = { { 1, 0, -1 }, { 2, 0, -2 }, { 1, 0, -1 } };
	private int[][] horizontalMask = { { 1, 2, 1 }, { 0, 0, 0 }, { -1, -2, -1 } };
	
	private int[][] matrix;
	
	public SobelFilter(int[][] matrix) {
		super();
		this.matrix = matrix;
	}

	public int[][] getSobelMatrix() {
		int[][] horizontal = filter(horizontalMask);
		int[][] vertical = filter(verticalMask);
		int[][] sobel = new int[vertical.length][vertical[0].length];
		
		for (int i = 0; i < vertical.length; i++) {
			for (int j = 0; j < vertical[0].length; j++) {
				sobel[i][j] = (int) Math.sqrt(horizontal[i][j]*horizontal[i][j] + vertical[i][j]*vertical[i][j]);
			}
		}
		return sobel;
	}
	
	public int[][] filter(int[][] mask) {
		int[][] filtered = new int[matrix.length][matrix[0].length];
		for (int i = 1; i < filtered.length-1; i++) {
			for (int j = 1; j < filtered.length-1; j++) {
				int convolution = 0;
				for (int j2 = 0; j2 < 3; j2++) {
					for (int k = 0; k < 3; k++) {
						convolution += filtered[j2+i-1][k+j-1];
					}
				}
				filtered[i][j] = convolution;
			}
		}
		return filtered;
	}
	
}
