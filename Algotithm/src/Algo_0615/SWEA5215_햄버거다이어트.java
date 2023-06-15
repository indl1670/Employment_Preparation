package Algo_0615;

import java.io.*;
import java.util.*;

public class SWEA5215_햄버거다이어트 {
    static int T, N, L, ans;
    static List<Food> food;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 재료의 수
            L = Integer.parseInt(st.nextToken()); // 칼로리 최대
            food = new ArrayList<>();

            // 재료 정보 저장
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int score = Integer.parseInt(st.nextToken());
                int cal = Integer.parseInt(st.nextToken());

                food.add(new Food(score, cal));
            }

            ans = 0;
            subs(0, 0, 0);
            System.out.println("#" + tc + " " + ans);
        }
    }
    static void subs(int idx, int score, int cal) {
        if (cal > L) return; // 칼로리 초과시
        if (cal <= L) ans = Math.max(ans, score); // 칼로리 미초과시 맛 점수 갱신
        if (idx == N) return; // 모든 조합에 대해 확인된 경우

        // 현재 재료 선택
        subs(idx+1, food.get(idx).s + score, food.get(idx).c + cal);
        // 현재 재료 미선택
        subs(idx+1, score, cal);
    }
    static class Food {
        int s, c;
        public Food(int s, int c) {
            this.s = s;
            this.c = c;
        }
    }
}
