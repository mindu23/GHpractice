package com.ssafy.d2;

import java.util.Scanner;

/**
	1/31, 2/28, 3/31, 4/30, 5/31, 6/30, 7/31, 8/31, 9/30, 10/31, 11/30, 12/31
 */
public class Solution_1948_날짜계산기 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int monthS = sc.nextInt();
			int dayS = sc.nextInt();
			int monthE = sc.nextInt();
			int dayE = sc.nextInt();
			
			int cnt = count(monthS, dayS, monthE, dayE);
			System.out.println("#"+t+" "+ cnt);
		}
		
	}
	
	private static int count(int monthS, int dayS, int monthE, int dayE) {
		int cnt = 0;
		
		if(monthS == monthE) {
			return dayE - dayS +1; 
		}
		
		int m = monthS;
		while(true) {
			switch(m) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				if(m == monthS) {
					cnt += 31-dayS+1;					
				}else {
					cnt += 31;
				}
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				if(m == monthS) {
					cnt += 30-dayS+1;					
				}else {
					cnt += 30;
				}
				break;
			case 2:
				if(m == monthS) {
					cnt += 28-dayS+1;					
				}else {
					cnt += 28;
				}
				break;
			}
			m++;
			if(m == monthE) {
				return cnt + dayE;
			}
		}
	}

}
