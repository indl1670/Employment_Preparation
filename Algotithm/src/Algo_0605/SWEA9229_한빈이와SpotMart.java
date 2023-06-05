package Algo_0605;

import java.io.*;
import java.util.*;

public class SWEA9229_한빈이와SpotMart {
    static int T, N, M, ans;
    static int[] snack, select;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 과자봉지 개수
            M = Integer.parseInt(st.nextToken()); // 들고갈 수 있는 최대 무게
            snack = new int[N];
            select = new int[2];
            ans = -1;

            // 과자봉지 무게 채우기
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                snack[i] = Integer.parseInt(st.nextToken());
            }

            comb(0, 0);

            System.out.println("#" + tc + " " + ans);
        }
    }
    static void comb(int src, int tgt) {
        // 기저조건
        if (tgt == 2) { // 두봉지를 모두 고른 경우
            int sum = select[0] + select[1];
            if (sum > M) return;
            ans = Integer.max(ans, sum);
            return;
        }
        // 기저조건
        if (src == N) return;

        select[tgt] = snack[src];

        comb(src+1, tgt+1); // 현재 과자 선택
        comb(src+1, tgt); // 현재 과자 선택 X
    }
}
