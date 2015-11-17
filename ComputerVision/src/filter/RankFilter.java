package filter;

import java.util.ArrayList;
import java.util.Collections;

public class RankFilter implements IFilter {

	int intervalLength;

	public RankFilter(int intervalLength) {
		super();
		this.intervalLength = intervalLength;
	}

	public int[][] filter(int[][] original) {
		int[][] newImg = new int[original.length-1][original[0].length-2];
		for (int i = 1; i < original.length - 1; i++) {
			for (int j = 1; j < original[0].length- 1; j++) {
				ArrayList<Integer> array = new ArrayList<>();
				array.add(original[i - 1][ j - 1]);
				array.add(original[i - 1][ j]);
				array.add(original[i - 1][ j + 1]);
				array.add(original[i][ j - 1]);
				array.add(original[i][ j]);
				array.add(original[i][ j + 1]);
				array.add(original[i + 1][ j - 1]);
				array.add(original[i + 1][ j]);
				array.add(original[i + 1][ j + 1]);
				Collections.sort(array);

				int fin = 0;
				switch (intervalLength) {
				case 1:
					fin = array.get(4);
					break;
				case 3:
					fin = array.get(3) + array.get(4) + array.get(5);
					fin /= 3;
					break;
				case 5:
					fin = array.get(2) + array.get(3) + array.get(4)
							+ array.get(5) + array.get(6);
					fin /= 5;
					break;
				case 7:
					fin = array.get(1) + array.get(2) + array.get(3)
							+ array.get(4) + array.get(5) + array.get(6)
							+ array.get(7);
					fin /= 7;
					break;
				case 9:
					fin = array.get(0) + array.get(1) + array.get(2)
							+ array.get(3) + array.get(4) + array.get(5)
							+ array.get(6) + array.get(7) + array.get(8);
					fin /= 9;
					break;
				default:
					System.err.println("Interval Lenght Not Valid");
					break;

				}

				newImg[i-1][j-1] = fin;
			}

		}

		return newImg;
	}

	@Override
	public int[][] addFilter(int[][] image) {
		return filter(image);
	}

}