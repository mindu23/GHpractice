package com.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	부먹왕국은 찍먹 무리에게 침략
	부먹왕국은 모든 도시를 건설 할 때 일렬로 이어지게 한다.
	어느 도시에 관문을 설치하면 그 도시와 거리가 D이하인 다른 도시에서 차원 관문이 있는 곳으로 들어오거나,
	혹은 차원 관문에서 거리 D이하인 다른 도시로 나가는 것이 가능하다.
	
	모든 차원 관문 사이와 직접적 이동이 가능하도록 차원 관문 재건
	0번 위치와 N+1번 위치에는 차원 관문이 존재한다.
	최소 개수를 설치하자
 */
public class Solution_7964_부먹왕국의차원관문 {

	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			String[] s = br.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int D = Integer.parseInt(s[1]);
			
			int[] input = new int[N+2];
			input[0] = input[N+1] = 1;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = 0;
			for(int i = 1; i <= N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i < input.length; i++) {
				if(input[i] == 0) {
					n++;
				}else {
					ans += n/D;
					n = 0;
				}
			}
			
			System.out.println("#"+t+" "+ans);
			ans = 0;
		}
		
	}

}
