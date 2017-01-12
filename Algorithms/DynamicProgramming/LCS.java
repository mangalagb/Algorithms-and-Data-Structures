
public class LCS {

	public int[][] findLCS(char[] X, char[] Y, int m, int n) {
		int[][] LCS = new int[m + 1][n + 1];
		if (m == 0 || n == 0) {
			System.out.print("Empty sequence");
			return null;
		}

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					LCS[i][j] = 0;
				}

				else if (X[i - 1] == Y[j - 1]) {
					LCS[i][j] = 1 + LCS[i - 1][j - 1];
				} else {
					LCS[i][j] = max(LCS[i - 1][j], LCS[i][j - 1]);
				}
			}
		}
		printLCS(LCS, X, Y, m, n);
		return LCS;
	}

	public void printLCS(int[][] LCS, char[] X, char[] Y, int m, int n) {
		int i = m;
		int j = n;
		// sizeOfLCS = 4
		int sizeOfLCS = LCS[m][n];
		char[] LCSSequence = new char[sizeOfLCS];

		while (i > 0 && j > 0) {
			if (X[i - 1] == Y[j - 1]) {
				LCSSequence[sizeOfLCS - 1] = X[i - 1];
				i--;
				j--;
				sizeOfLCS--;
			} else {
				if (LCS[i - 1][j] > LCS[i][j - 1]) {
					i--;
				} else {
					j--;
				}
			}
		}
		System.out.print("\n");
		for (char c : LCSSequence) {
			System.out.print(c + "\t");
		}
		System.out.print("\nLength of LCS : " + LCS[m][n]);
	}
	
	/*
	 * Given two strings X and Y, print the shortest string that has both X and Y as subsequences.
	 * If multiple shortest supersequence exists, print any one of them.
	 */
	public void shortestCommonSuperSequence(int[][] LCS, char[] X, char[] Y, int m, int n){		
		int[][] lcs = (int[][]) findLCS(X, Y, m, n);
		int len = n + m - Math.abs(lcs[m][n]);
		System.out.print("\nLength of ShortestCommonSuperSequence : " + len);
	}
	
	/*
	 * The edit distance (Levenshtein distance) when only insertion and deletion is allowed (no substitution),is:
	 */
	public void editDistance(int[][] LCS, char[] X, char[] Y, int m, int n){		
		int[][] lcs = (int[][]) findLCS(X, Y, m, n);
		int len = n + m - (2 * Math.abs(lcs[m][n]));
		System.out.print("\nLength of Edit distance : " + len);
	}

	public int max(int a, int b) {
		return (a > b) ? a : b;
	}

	public static void main(String[] args) {
		LCS lcs = new LCS();
		String X = "AGGTAB";
		String Y = "GXTXAYB";
		int[][] LCS = lcs.findLCS(X.toCharArray(), Y.toCharArray(), X.length(), Y.length());
		//lcs.shortestCommonSuperSequence(LCS, X.toCharArray(), Y.toCharArray(), X.length(), Y.length());
		//lcs.editDistance(LCS, X.toCharArray(), Y.toCharArray(), X.length(), Y.length());
	}
}
