package com.SW.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

/**
	1주일에 L분 이상 U분 이하의 운동
	이번주에 x분만큼 운동. 준환이의 운동시간이 넘었는지 아니면 몇분 더 운동해야 제한에 맞출 수 있는지 출력.
 */
public class Solution_3431_준환이의운동관리 {

	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader("3\r\n" + 
				"300 400 240\r\n" + 
				"300 400 350\r\n" + 
				"300 400 480"));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			String[] str = br.readLine().split(" ");
			int L = Integer.parseInt(str[0]);
			int U = Integer.parseInt(str[1]);
			int X = Integer.parseInt(str[2]);
			
			if(X > U) ans = -1;
			else if (U >= X && X >= L) ans = 0;
			else ans = L-X;
			System.out.println("#"+t+ " "+ans);
		}
	}

}
