package com.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;

/**
	stack사용
 */
public class Solution_3499_퍼펙트셔플 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader("3\r\n" + 
				"6\r\n" + 
				"A B C D E F\r\n" + 
				"4\r\n" + 
				"JACK QUEEN KING ACE\r\n" + 
				"5\r\n" + 
				"ALAKIR ALEXSTRASZA DR-BOOM LORD-JARAXXUS AVIANA"));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			Queue<String> q1 = new LinkedList<>();
			Queue<String> q2 = new LinkedList<>();
			
			int N = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split(" ");
			double d = Math.round(N/2.0);
			for(int n = 0; n < N; n++) {
				if(n < d) q1.add(str[n]);
				else q2.add(str[n]);
			}
			
			System.out.print("#"+t+" ");
			for(int i = 0; i < str.length; i++) {
				if(i%2 == 0 && !q1.isEmpty()) System.out.print(q1.poll()+" ");
				if(i%2 == 1 && !q2.isEmpty()) System.out.print(q2.poll()+" ");
			}
			System.out.println();
		}
	}

}
