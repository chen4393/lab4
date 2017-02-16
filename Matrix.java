public class Matrix {
	static int[][] add(int[][] a, int[][] b) {
		if (a == null || b == null)
			return null;
		if (a.length != b.length || a[0].length != b[0].length)
			return null;
		int[][] res = new int[a.length][a[0].length];
		for (int row = 0; row < a.length; row++) {
			for (int col = 0; col < a[row].length; col++)
				res[row][col] = a[row][col] + b[row][col];
		}
		return res;
	}
	static int[][] multiply(int[][] a, int[][] b) {
		if (a == null || b == null)
			return null;
		if (a[0].length != b.length)
			return null;
		int[][] res = new int[a.length][b[0].length];
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[i].length; j++) {
				int sum = 0;
				for (int k = 0; k < a[0].length; k++)
					sum += a[i][k] * b[k][j];
				res[i][j] = sum;
			}
		}
		return res;
	}
	static int[][] transpose(int[][] m) {
		if (m == null)
			return null;
		int[][] res = new int[m[0].length][m.length];
		for (int i = 0; i < m.length; i++)
			for (int j = 0; j < m[i].length; j++)
				res[j][i] = m[i][j];
		return res;
	}
	public static void main(String[] args) {
		int[][] a = {{1, 2, 3}, {4, 5, 6}};
		int[][] b = {{3, 2, 1}, {6, 5, 4}};
		int[][] res = add(a, b);
		if (res == null) {
			System.out.println("Invalid matrix");
			return;
		}
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[i].length; j++)
				System.out.print(res[i][j] + "\t");
			System.out.println();
		}

		System.out.println();
		int[][] c = {{1, 2, 3}, {4, 5, 6}};
		int[][] d = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
		int[][] res2 = multiply(c, d);
		if (res2 == null) {
			System.out.println("Invalid matrix");
			return;
		}
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res2[i].length; j++)
				System.out.print(res2[i][j] + "\t");
			System.out.println();
		}

		System.out.println();
		int[][] e = {{1, 2, 3}, {4, 5, 6}};
		int[][] res3 = transpose(e);
		if (res3 == null) {
			System.out.println("Invalid matrix");
			return;
		}
		for (int i = 0; i < res3.length; i++) {
			for (int j = 0; j < res3[i].length; j++)
				System.out.print(res3[i][j] + "\t");
			System.out.println();
		}
	}
}