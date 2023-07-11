package Algo_0711;

import java.io.*;
import java.util.*;
public class BOJ3109_빵집 {
    static int R, C, ans;
    static char[][] map;
    // 우 - 우상 - 우하
    static int[] dr = {-1, 0, 1};
    static int[] dc = {1, 1, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        ans = 0;
        // 첫 번째 열에서부터 시작
        for (int i = 0; i < R; i++) {
            if (dfs(i, 0)) {
                ans++;
            }
        }
        System.out.println(ans);
    }
    static boolean dfs(int r, int c) {
        map[r][c] = '-';
        for (int d = 0; d < 3; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nc >= 0 && nr < R && nc < C) { // 범위 내 존재
                if (map[nr][nc] == '.') { // 빈칸
                    if (nc == C-1) return true; // 마지막 열 도달 시
                    if (dfs(nr, nc)) return true; // 재귀호출
                }
            }
        }
        return false;
    }
}
