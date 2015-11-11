package cleanNoise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Nagao {

	private int[][] matrix;
	private List<List<Integer>> list = new ArrayList<List<Integer>>(9);
	private List<Float> meanList = new ArrayList<Float>(9);

	
	public Nagao(int[][] matrix) {
		super();
		this.matrix = matrix;
	}

	public void fillLists(int indexI, int indexJ)
			throws NoMatrixElementException {
		list.clear();
		if (indexI < 2 || indexJ < 2 || indexI > matrix.length - 3
				|| indexJ > matrix[0].length - 3)
			throw new NoMatrixElementException("NoElement");

		List<Integer> central = new ArrayList<Integer>(9);
	//	System.out.println("ahfhafh" + indexI + " " + indexJ);
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
		bottom.add(matrix[indexI][indexJ]);
		for (int i = indexI + 1; i < indexI + 3; i++) {
			for (int j = indexJ - 1; j < indexJ + 2; j++) {
				bottom.add(matrix[i][j]);
			}
		}

		List<Integer> left = new ArrayList<Integer>(7);
		left.add(matrix[indexI][indexJ]);
		for (int i = indexI - 1; i < indexI + 2; i++) {
			for (int j = indexJ - 2; j < indexJ; j++) {
				left.add(matrix[i][j]);
			}
		}
		List<Integer> right = new ArrayList<Integer>(7);
		right.add(matrix[indexI][indexJ]);
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
	
	public void computeMeans() {
		meanList.clear();
		for (List<Integer> list2 : list) {
			int sum = 0;
			int counter = 0;
			for (Integer integer : list2) {
				sum += integer;
				counter++;
			}
			meanList.add((float)sum/counter);
		}
	}
	
	public float getVariance(int index) {
		List<Integer> l = list.get(index);
		float mean = meanList.get(index);
		float sum = 0;
		for (Integer integer : l) {
			sum += (integer-mean)*(integer-mean);
		}
		//System.out.println("VARiance = " + (float)sum/l.size()+ " size = " + l.size());
		return (float)sum/l.size();
	}
	
	public int[][] filter() {
		int[][] filtered = new int[matrix.length][matrix[0].length];
		System.out.println(matrix.length+" "+ matrix[0].length);
		for (int i = 0; i < filtered.length; i++) {
			for (int j = 0; j < filtered[0].length; j++) {
				filtered[i][j] = matrix[i][j];
			}
		}
		
		for (int i = 0; i < filtered.length; i++) {
			for (int j = 0; j < filtered[0].length; j++) {
				try {
					fillLists(i, j);
					computeMeans();
					LinkedList<Float> f = new LinkedList<Float>();
					for (int j2 = 0; j2 < list.size(); j2++) {
						f.add(getVariance(j2));
					}
					float min = Collections.min(f);
					int indexMin = f.indexOf(min);
					filtered[i][j] = meanList.get(indexMin).intValue();
				} catch (NoMatrixElementException e) {
				}
			}
		}
		return filtered;
	}
}
