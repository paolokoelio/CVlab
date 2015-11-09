package cleanNoise;

import java.util.ArrayList;
import java.util.List;

public class Nagao {

	private int[][] matrix;
	private List<List<Integer>> list = new ArrayList<List<Integer>>(9);

	public Nagao(int[][] matrix) {
		super();
		this.matrix = matrix;
	}

	public void fillLists(int indexI, int indexJ)
			throws NoMatrixElementException {
		if (indexI < 2 || indexJ < 2 || indexI > matrix.length - 3
				|| indexJ > matrix.length - 3)
			throw new NoMatrixElementException("NoElement");

		List<Integer> central = new ArrayList<Integer>(9);
		System.out.println("ahfhafh" + indexI + " " + indexJ);
		for (int i = indexI - 1; i < indexI + 2; i++) {
			for (int j = indexJ - 1; j < indexJ + 2; j++) {
				central.add(matrix[i][j]);
			}
		}

		List<Integer> top = new ArrayList<Integer>(7);
		top.add(matrix[indexI][indexJ]);

		for (int i = indexI - 2; i < indexI; i++) {
			for (int j = indexJ - 1; j < indexJ + 2; j++) {
				top.add(matrix[i][j]);
			}
		}

		List<Integer> bottom = new ArrayList<Integer>(7);
		top.add(matrix[indexI][indexJ]);
		for (int i = indexI + 1; i < indexI + 3; i++) {
			for (int j = indexJ - 1; j < indexJ + 2; j++) {
				bottom.add(matrix[i][j]);
			}
		}

		List<Integer> left = new ArrayList<Integer>(7);
		top.add(matrix[indexI][indexJ]);
		for (int i = indexI - 1; i < indexI + 2; i++) {
			for (int j = indexJ - 2; j < indexJ; j++) {
				left.add(matrix[i][j]);
			}
		}
		List<Integer> right = new ArrayList<Integer>(7);
		top.add(matrix[indexI][indexJ]);
		for (int i = indexI - 1; i < indexI + 2; i++) {
			for (int j = indexJ + 1; j < indexJ + 3; j++) {
				right.add(matrix[i][j]);
			}
		}

		List<Integer> topLeft = new ArrayList<Integer>(7);
		for (int i = indexI - 2; i < indexI + 1; i++) {
			for (int j = indexJ - 2; j < indexJ + 1; j++) {
				if ((i == indexI - 2 & j == indexJ)
						|| (i == indexI & j == indexJ - 2)) {
					continue;
				}else {
					topLeft.add(matrix[i][j]);
				}

			}
		}
		List<Integer> topRight = new ArrayList<Integer>(7);
		for (int i = indexI - 2; i < indexI + 1; i++) {
			for (int j = indexJ; j < indexJ + 3; j++) {
				if ((i == indexI - 2 & j == indexJ)
						|| (i == indexI & j == indexJ + 2)) continue;
				else {
					topRight.add(matrix[i][j]);
				}
				
			}
		}
		List<Integer> bottomLeft = new ArrayList<Integer>(7);
		for (int i = indexI; i < indexI + 3; i++) {
			for (int j = indexJ - 2; j < indexJ + 1; j++) {
				if ((i == indexI + 2 & j == indexJ)
						|| (i == indexI & j == indexJ - 2))
					continue;
				else {
					bottomLeft.add(matrix[i][j]);
				}
			}
		}
		List<Integer> bottomRight = new ArrayList<Integer>(7);
		for (int i = indexI; i < indexI + 3; i++) {
			for (int j = indexJ; j < indexJ + 3; j++) {
				if ((i == indexI + 2 & j == indexJ)
						|| (i == indexI & j == indexJ + 2))
					continue;
				else {
					bottomRight.add(matrix[i][j]);
				}
			}
		}

		list.add(central);
		list.add(top);
		list.add(right);
		list.add(bottom);
		list.add(left);
		list.add(topLeft);
		list.add(topRight);
		list.add(bottomLeft);
		list.add(bottomRight);

	}

	public List<List<Integer>> getList() {
		return list;
	}
}
