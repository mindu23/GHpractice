package Solutions;

import java.util.Scanner;

public class Solution_2806_NQueen {

	static int N, cnt;
	static int[] col;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			col = new int[N+1];
			
			cnt = 0;
			setQueens(1);
			System.out.println("#"+t+" "+cnt);
		}
		
		sc.close();
	}
	
	private static void setQueens(int r) {
		
		if(r > N) {
			cnt++;
			return ;
		}
		
		for(int i = 1; i <= N; i++) {
			col[r] = i;
			if(isAvailable(r))
				setQueens(r+1);
		}
	}
	
	private static boolean isAvailable(int r) {
		for(int i = 1; i < r; i++) {
			if(col[i] == col[r] || Math.abs(r-i) == Math.abs(col[r]-col[i])) return false;
		}
		
		return true;
	}

}
