package Algo_0615;

import java.io.*;
import java.util.*;

public class SWEA4012_요리사 {
    static int T, N, ans;
    static int[][] taste;
    static int[] foodA, foodB;
    static boolean[] select;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            taste = new int[N][N];
            select = new boolean[N];
            foodA = new int[N/2];
            foodB = new int[N/2];
            ans = Integer.MAX_VALUE;

            // 재료 시너지 정보
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    taste[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            subs(0, 0);
            System.out.println("#" + tc + " " + ans);
        }
    }
    static void subs(int depth, int tgt) {
        // 기저조건: 한 음색에서 재료 N/2개 선택
        if (tgt == N/2) {
            int A = 0, B = 0, sumA = 0, sumB = 0;

            // 재료정보 저장
            for (int i = 0; i < N; i++) {
                if (select[i]) foodA[A++] = i;
                else foodB[B++] = i;
            }

            // 맛 시너지 계산
            for (int i = 0; i < N/2; i++) {
                for (int j = 0; j < N/2; j++) {
                    if (i == j) continue;
                    sumA += taste[foodA[i]][foodA[j]];
                    sumB += taste[foodB[i]][foodB[j]];
                }
            }

            // 차이의 최솟값
            ans = Math.min(Math.abs(sumA - sumB), ans);
            return;
        }
        
        // 모든 재료에 대한 선택이 끝났을 경우
        if (depth == N) return;

        // 현재 재료 선택
        select[depth] = true;
        subs(depth+1, tgt+1);
        // 현재 재료 미선택
        select[depth] = false;
        subs(depth+1, tgt);
    }
}
