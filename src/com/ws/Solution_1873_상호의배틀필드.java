package com.ws;
/**
	오류 발생 TC 71/98
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_1873_상호의배틀필드 {

	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static char[][] map;
	static char[] input;
	static int H, W, N, r, c, dir;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src//inputFile//input_1873.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			String[] s = br.readLine().split(" ");
			H = Integer.parseInt(s[0]);
			W = Integer.parseInt(s[1]);
			
			map = new char[H][W];
			for(int h = 0; h < H; h++) {
				map[h] = br.readLine().toCharArray();
			}
			
			N = Integer.parseInt(br.readLine());
			input = new char[N];
			input = br.readLine().toCharArray();
			
			//전차 위치 찾기
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					if("^V<>".indexOf(map[i][j]) != -1) { // ><^v중에 있다면
						r = i;
						c = j;
						dir = "^v<>".indexOf(map[i][j]);
						break;
					}
				}
			}
			
			for(int i = 0; i < N; i++) {
				move(i);
			}
			
			System.out.print("#"+t+" ");
			Arrays.stream(map).forEach(System.out::println);
		}

	}
	
	private static void move(int i) {
		switch(input[i]) {
		case 'U':
			if(r >= 0 && r < H && c >= 0 && c < W) {
				
				map[r][c] = '^';
				dir = 0;
				if(r-1 < 0)
					return;
				if(map[r-1][c] == '.') {
					map[r][c] = '.';
					r -= 1;
					map[r][c] = '^';
				}
			}
			break;
		case 'D':
			if(r >= 0 && r < H && c >= 0 && c < W) {
				
				map[r][c] = 'v';
				dir = 1;
				if(r+1 >= H)
					return;
				if(map[r+1][c] == '.') {
					map[r][c] = '.';
					r += 1;
					map[r][c] = 'v';
				}
			}
			break;
		case 'L':
			if(r >= 0 && r < H && c >= 0 && c < W) {
				
				map[r][c] = '<';
				dir = 2;
				if(c-1 < 0)
					return;
				if(map[r][c-1] == '.') {
					map[r][c] = '.';
					c -= 1;
					map[r][c] = '<';
				}
				break;
			}
		case 'R':
			if(r >= 0 && r < H && c >= 0 && c < W) {
				map[r][c] = '>';
				dir = 3;
				if(c+1 >= W)
					return;
				if(map[r][c+1] == '.') {
					map[r][c] = '.';
					c += 1;
					map[r][c] = '>';
				}
			}
			break;
		case 'S':
			shooting();
			break;
		}
	}
	
	private static void shooting() {
		int nr = r, nc = c;
		while(true) {
			nr += dr[dir];
			nc += dc[dir];
			if(nr >= H || nr < 0 || nc >= W || nc < 0) break;
			switch(map[nr][nc]) {
			case '.':
			case '-': 
				break;
			case '#':
				return ;
			case '*':
				map[nr][nc] = '.';
				return ;
			}
		}
	}
}
