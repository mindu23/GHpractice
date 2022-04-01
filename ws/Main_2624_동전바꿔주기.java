package com.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
	현금 출납기에 k가지 동전이 각각 n1, n2 ... nk개 씩 들어있다.
	T원의 지폐를 동전으로 바꿔주자.
	입력으로 지폐금액 T, 동전의 가지 수 k, 동전 하나의 금액 P와 개수 n이 주어진다.
	교환 방법의 가지수를 계산하자.
	
	큰거 가장 많이 부터.. 작은거 제일 많이 까지..
 */
public class Main_2624_동전바꿔주기 {

	static int T, ans;
	static int[][] tmp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		tmp = new int[k][2]; // 금액 p, 개수 n
		for(int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			tmp[i][0] = Integer.parseInt(st.nextToken()); // p
			tmp[i][1] = Integer.parseInt(st.nextToken()); // n
		}
		
		
		
		System.out.println(ans);

	}
	
}
