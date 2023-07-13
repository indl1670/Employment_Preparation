package Algo_0713;

import java.io.*;
import java.util.*;

public class BOJ2098_외판원순회 {
    static int N, max;
    static int[][] map, dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        // 현재 위치한 도시, 방문한 도시 수(2진수)
        dp = new int[N][(1<<N)-1];
        max = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp 배열 초기화
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], max);
        }

        System.out.println(tsp(0, 1));
    }
    static int tsp(int cur, int bitmask) {
        if (bitmask == (1<<N)-1) { // 모든 도시를 방문했을 경우
            if (map[cur][0] == 0) {
                return max;
            }
            return map[cur][0]; // 현재 도시 -> 0번째 도시
        }

        if (dp[cur][bitmask] != max) { // dp에 값이 존재하는 경우
            return dp[cur][bitmask];
        }

        for (int i = 0; i < N; i++) {
            if ((bitmask & (1 << i)) == 0 && map[cur][i] != 0) { // 처음 방문하는 도시인 경우
                // 다음 도시 & 다음 도시 방문 시 거리 총합
                dp[cur][bitmask] = Math.min(dp[cur][bitmask], tsp(i, bitmask | (1 << i)) + map[cur][i]);
            }
        }
        return dp[cur][bitmask];
    }
}
