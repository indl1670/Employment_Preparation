package Algo_0712;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class BOJ1987_알파벳 {
    static int R, C, ans;
    static char[][] map;
    static boolean[] v = new boolean[26];
    // 상-하-좌-우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static ArrayList<Character> pass = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray() ;
        }

        dfs(0, 0, 1);

        System.out.println(ans);
    }
    static void dfs(int sr, int sc, int cnt) {
        ans = Integer.max(ans, cnt);

        v[map[sr][sc] - 'A'] = true; // 해당 알파벳 방문 완료

        for (int d = 0; d < 4; d++) {
            int nr = sr + dr[d];
            int nc = sc + dc[d];

            // 범위 초과 or 방문한 알파벳인 경우 pass
            if (nr < 0 || nc < 0 || nr >= R || nc >= C || v[map[nr][nc] - 'A']) continue;

            dfs(nr, nc, cnt+1);
        }
        // 방문 기록 초기화
        v[map[sr][sc] - 'A'] = false;
    }
}
