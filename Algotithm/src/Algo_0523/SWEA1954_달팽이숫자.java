package Algo_0523;

import java.io.*;
import java.util.*;

public class SWEA1954_달팽이숫자 {
	static int T, N;
	static int[][] snail;
	// 달팽이 방향(우-하-좌-상)
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			snail = new int[N][N];
			
			int index = 1;
			int dir = 0;
			int cr = 0, cc = 0;
			snail[cr][cc] = index;
			while(index < N*N) {
				index++;
				int nr = cr + dr[dir];
				int nc = cc + dc[dir];
				
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || snail[nr][nc] != 0) {
					dir = (dir+1)%4;
					index--;
					continue;
				}
				snail[nr][nc] = index;
				cr = nr;
				cc = nc;
			}
			System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
		}
		
		
		
	}

}
