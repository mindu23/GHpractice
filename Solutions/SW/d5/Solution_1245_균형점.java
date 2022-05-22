package com.SW.d5;
/**
 * 실패
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1245_균형점 {

	static int N;
	static int[] m, x;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			m = new int[N];
			x = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				x[i] = Integer.parseInt(st.nextToken()); // x좌표
				m[i] = Integer.parseInt(st.nextToken()); // 질량
			}
			
			System.out.print("#"+t+" ");
			for(int i = 0; i < N-1; i++) {
				binarySearch(i, m[i], m[i+1]);
			}
			System.out.println();
		}

	}
	
	private static void binarySearch(int point, double left, double right) {
		double x = 0;
		double sum = 0;
		int cnt = 0;
		while(cnt <= 100) {
			x = (left+right)/2.0; // 중간 값
			sum = 0;
			
			for(int i = 0; i <= point; i++) {
				sum += power(i, x);
			}
			
			for(int i = point+1; i < N; i++) {
				sum -= power(i, x);
			}
			
			if(sum > 0)
				left = x;
			else if(sum < 0)
				right = x;
			cnt++;
		}
		System.out.printf("%.10f", x);
	}

	private static double power(int i, double p) {
		return m[i]/(x[i]-p)*(x[i]-p);
	}

}
