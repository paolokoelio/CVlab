package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cleanNoise.Nagao;
import cleanNoise.NoMatrixElementException;

public class NagaoTest {

	@Test
	public void test() {
		int[][] m = new int[5][5];
		int k = 0;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				m[i][j] = k;
				System.out.print(k+ "\t");
				k++;
			}
			System.out.println();
		}
		Nagao n = new Nagao(m);
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				try {
					n.fillLists(i, j);
				} catch (NoMatrixElementException e) {
				}
			}
		}
		List<List<Integer>> l = n.getList();
		
//		for (List<Integer> list : l) {
//			for (Integer integer : list) {
//				System.out.print(integer+" ");
//			}
//			System.out.println();
//		}
	}

}
