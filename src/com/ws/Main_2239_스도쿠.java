package com.ws;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2239_스도쿠 {

	static int[][] map;
	static boolean[][] row, col, mat3;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		row = new boolean[10][10];
		col = new boolean[10][10];
		mat3 = new boolean[10][10];
		for(int i = 0; i < 9; i++) {
			char[] c = br.readLine().toCharArray();
			for(int j = 0; j < 9; j++) {
				map[i][j] = c[j] - '0';
				if(map[i][j] != 0) {
					row[i][map[i][j]] = true;
					col[j][map[i][j]] = true;
					mat3[(j/3)+(i/3)*3][map[i][j]] = true;
					
				}
			}
		}

		// 완탐 dfs
		find(0);
		
	}
	
	private static void find(int cnt) {
		if(cnt == 81) {
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
			return;
		}
		
		int r = cnt/9, c = cnt%9;
		if(map[r][c] == 0) {
			for(int i = 1; i <= 9; i++) {
//				System.out.println(row[r][i]+" "+ col[c][i]+" "+mat3[(r/3)*3+(c/3)][i]);
				if(!row[r][i] && !col[c][i] && !mat3[(r/3)*3+(c/3)][i]) {
					row[r][i] = col[c][i] = mat3[(r/3)*3+(c/3)][i] = true;
					map[r][c] = i; 
					find(cnt+1);
					row[r][i] = col[c][i] = mat3[(r/3)*3+(c/3)][i] = false;
					map[r][c] = 0; 
				}
			}
		}else
			find(cnt+1);
	
		
		
	}

}
