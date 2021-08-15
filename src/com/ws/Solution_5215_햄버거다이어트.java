package com.ws;
/**
	조합
	재료 점수, 재료 칼로리가 주어진다.
	정해진 칼로리 L이하로 가장 선호하는 햄버거를 조합해보자
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Solution_5215_햄버거다이어트 {

	static int N, L, ans, Tsum, Ksum;
	static int[] T, K;
	static boolean[] sel;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader("1\r\n" + 
				"5 1000\r\n" + 
				"100 200\r\n" + 
				"300 500\r\n" + 
				"250 300\r\n" + 
				"500 1000\r\n" + 
				"400 400"));
		
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			String[] str = br.readLine().split(" ");
			N = Integer.parseInt(str[0]);
			L = Integer.parseInt(str[1]);
			
			sel = new boolean[N];
			T = new int[N];
			K = new int[N];
			Tsum = 0;
			Ksum = 0;
			ans = Integer.MIN_VALUE;
			for(int i = 0; i < N; i++) {
				String[] str2 = br.readLine().split(" ");
				T[i] = Integer.parseInt(str2[0]);
				K[i] = Integer.parseInt(str2[1]);
			}
			
			sub(0);
			System.out.println("#"+ t+ " "+ ans);
		}
		
	}
	//부분집합
	private static void sub(int cnt) {
		
		if(cnt == N) {
			if(Ksum < L) {
				ans = Math.max(ans, Tsum);
			}
			return;
		}
		
		sel[cnt] = true;
		Tsum += T[cnt];
		Ksum += K[cnt];
		sub(cnt+1);
		sel[cnt] = false;
		Tsum -= T[cnt];
		Ksum -= K[cnt];
		sub(cnt+1);
	}

}
