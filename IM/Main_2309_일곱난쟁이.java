package com.IM;

import java.util.Arrays;
import java.util.Scanner;

/**
	9명 중 7명을 뽑아야 한다 -> 조합
 */
public class Main_2309_일곱난쟁이 {

	static int[] dwarf, sel;
	static boolean check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		dwarf = new int[9];
		sel = new int[7];
		for(int i = 0; i < 9; i++) {
			dwarf[i] = sc.nextInt();
		}//setting
		
		Arrays.sort(dwarf);
		check = comp(0,0);
		for(int i = 0; i < 7; i++) {
			System.out.println(sel[i]);
		}
		sc.close();
	}

	private static boolean comp(int cnt, int start) {
		if(cnt == 7) {
			int sum = 0;
			for(int s: sel) {
				sum += s;
			}
			if(sum == 100) {
				check = true;
			}
			return check;
		}
		
		for(int i = start; i < 9; i++) {
			sel[cnt] = dwarf[i];
			if(comp(cnt+1, i+1)) {
				return true;
			}
		}
		return false;
	}
}
