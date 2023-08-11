import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int[][] arr = new int[9][9];
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int r = 0;
			outerLoop: for (int i = 0; i < 9; i++) {
				int[] temp = new int[9];
				for (int j = 0; j < 9; j++) {
					temp[j] = arr[i][j];
				}
				if (!all(temp))
					break outerLoop;
				for (int j = 0; j < 9; j++) {
					temp[j] = arr[j][i];
				}
				if (!all(temp))
					break outerLoop;
				for (int j = 0; j < 9; j++) {
					temp[j] = arr[3 * (i / 3) + j / 3][3 * (i % 3) + j % 3];
				}
				if (!all(temp))
					break outerLoop;
				r++;
			}
			System.out.println("#" + tc + " " + (r == 9 ? 1 : 0));
		}
	}

	static boolean all(int[] a) {
		Set<Integer> set = new HashSet<>();
		for (int num : a) {
			if (!set.add(num)) {
				return false;
			}
		}
		return true;
	}

}