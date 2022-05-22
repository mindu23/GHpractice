package com.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1225_암호생성기 {

	static Queue<Integer> q;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader("1\r\n" + 
				"9550 9556 9550 9553 9558 9551 9551 9551 \r\n" + 
				"2\r\n" + 
				"2419 2418 2423 2415 2422 2419 2420 2415 \r\n" + 
				"3\r\n" + 
				"7834 7840 7840 7835 7841 7835 7835 7838 \r\n" + 
				"4\r\n" + 
				"4088 4087 4090 4089 4093 4085 4090 4084 \r\n" + 
				"5\r\n" + 
				"2945 2946 2950 2948 2942 2943 2948 2947 \r\n" + 
				"6\r\n" + 
				"670 667 669 671 670 670 668 671 \r\n" + 
				"7\r\n" + 
				"8869 8869 8873 8875 8870 8872 8871 8873 \r\n" + 
				"8\r\n" + 
				"1709 1707 1712 1712 1714 1710 1706 1712 \r\n" + 
				"9\r\n" + 
				"10239 10248 10242 10240 10242 10242 10245 10235 \r\n" + 
				"10\r\n" + 
				"6580 6579 6574 6580 6583 6580 6577 6581"));
		q = new LinkedList<>();
		for(int t = 1; t <= 10; t++) {
			q.clear();
			int tc = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split(" ");
			for(int i = 0; i < 8; i++) {
				q.offer(Integer.parseInt(str[i]));
			}//setting
			
			encoding();
			System.out.print("#"+t+" ");
			while(!q.isEmpty()) {
				System.out.print(q.poll()+" ");
			}
			System.out.println();
		}

	}
	
	private static void encoding() {
		int af = 0, be = 0, i = 0;
		while(true) {
			if(!q.isEmpty()) be = q.poll();
			af = be-(i%5 + 1);
			if(af <= 0) {
				af = 0;
				q.offer(af);
				break;
			}else {
				q.offer(af);
			}
			i++;
		}
	}
	

}
