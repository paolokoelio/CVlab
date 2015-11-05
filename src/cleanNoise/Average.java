package cleanNoise;

public class Average {
	
	private int[][] matrix;

	public Average(int[][] matrix) {
		super();
		this.matrix = matrix;
	}
	
	public int get3by3Avg(int[][] threeByThree) {
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				sum += threeByThree[i][j];
			}
		}
		return sum/9;
	}
	
	public void filter() {
		int[][] tmp = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				tmp[i][j] = matrix[i][j];
			}
		}
		for (int i = 1; i < matrix.length-1; i++) {
			for (int j = 1; j < matrix[0].length-1; j++) {
				tmp[i][j] = get3by3Avg(get3by3Minor(i, j));
			}
		}
		matrix = tmp;
	}
	
	public int[][] get3by3Minor(int xC, int yC) {
		int[][] minor = new int[3][3];
		for (int i = xC-1, k = 0; i < 2+xC; i++, k++) {
			for (int j = yC-1, p = 0; j < 2+yC; j++, p++) {
				minor[k][p] = matrix[i][j];
			}
		}
		return minor;
	}
	
	public int[][] getMatrix() {
		return matrix;
	}

}
