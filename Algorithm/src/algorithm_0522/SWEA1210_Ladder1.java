package algorithm_0522;

import java.io.*;
import java.util.*;

public class SWEA1210_Ladder1 {
	static int[][] ladder;
	static boolean[][] v;
	// 좌-우-하
	static int[] dr = {0, 0, 1};
	static int[] dc = {-1, 1, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine(); // 테스트케이스 번호
			
			// 값 초기화
			ladder = new int[100][100];
			int ans = 0;
			
			// 사다리 경로 설정
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < 100; i++) {
				if (ladder[0][i] == 1) {
					if (bfs(0, i)) {
						ans = i; // 시작 위치
						break;
					}
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	static boolean bfs(int x, int y) {
		// 초기화
		v = new boolean[100][100];
		Queue<int[]> q = new ArrayDeque<>();
		
		// 시작 지점 방문 처리
		v[x][y] = true;
		q.offer(new int[] {x, y});
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 3; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				// 범위 초과 / 방문 완료 / 갈 수 없는 길 => continue
				if (nr < 0 || nc < 0 || nr >= 100 || nc >= 100 || v[nr][nc] || ladder[nr][nc] == 0) continue;
				
				// 다음 위치 방문 완료
				v[nr][nc] = true;
				q.offer(new int[] {nr, nc});
				
				cur[0] = nr;
				cur[1] = nc;
				
				// 도착지 도달
				if (ladder[nr][nc] == 2) {
					return true;
				}
			}
		}
		return false;
	}
}
