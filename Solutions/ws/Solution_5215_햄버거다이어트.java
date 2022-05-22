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
			
			//부분집합을 사용한 문제
			sub(0);
			System.out.println("#"+ t+ " "+ ans);
		}
		
	}
	//부분집합
	private static void sub(int cnt) {
		
		//부분집합으로 선택했든 안하든 cnt는 고려횟수를 말하는 것이므로 끝까지 고려했다면 cnt == N일때 끝난다.
		if(cnt == N) {
			if(Ksum < L) {
				ans = Math.max(ans, Tsum);
			}
			return;
		}
		
		//sel은 입력받은 재료를 선택했는지 안했는지를 알려준다.
		sel[cnt] = true;
		//Tsum은 맛에 대한 점수이다.
		Tsum += T[cnt];
		//Ksum은 칼로리에 대한 점수이다.
		Ksum += K[cnt];
		//부분집합 중 하나를 선택했으니 다음을 선택하겠다고 말한다.
		sub(cnt+1);
		//해당 재료를 선택하지않고 다음으로 넘어간다.
		sel[cnt] = false;
		Tsum -= T[cnt];
		Ksum -= K[cnt];
		//재료를 선택하지 않았더라도 고려횟수는 증가한다.
		sub(cnt+1);
	}

}
