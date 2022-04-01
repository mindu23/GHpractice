package com.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_3499_퍼펙트셔플 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			Queue<String> q1 = new LinkedList<String>();
			Queue<String> q2 = new LinkedList<>();
			
			int N = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");
			for(int i = 0; i < N; i++) {
				if(i < Math.ceil(N/2.0)) {
					q1.offer(s[i]);
				}else
					q2.offer(s[i]);
			}
			
			System.out.print("#"+t+" ");
			for(int i = 0; i < N; i++) {
				if(!q1.isEmpty() && i%2==0) {
					System.out.print(q1.poll()+" ");;
				}else if(!q2.isEmpty() && i%2 != 0) {
					System.out.print(q2.poll()+" ");;
				}
			}
			System.out.println();
		}
	}

}
