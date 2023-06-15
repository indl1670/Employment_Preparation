package Algo_0615;

import java.io.*;
import java.util.*;

public class BOJ2961_도영이가만든맛있는음식 {
    static int N, ans;
    static Food[] food;
    static boolean[] v;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        food = new Food[N];
        v = new boolean[N];
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            food[i] = new Food(s, b);
        }
        subs(0);
        System.out.println(ans);
    }
    static void subs(int depth) {
        if (depth == N) { // 부분집합 선택 완료
            int s = 1, b = 0, cnt = 0;

            for (int i = 0; i < N; i++) {
                if (!v[i]) continue;
                s *= food[i].s; // 신맛 곱셈
                b += food[i].b; // 쓴맛 덧셈
                cnt++;
            }
            if (cnt > 0) // 재료를 한가지 이상 골랐을 경우
                ans = Math.min(ans, Math.abs(s - b)); // 맛의 차이 최솟값 구하기
            return;
        }

        // 현재 재료 선택
        v[depth] = true;
        subs(depth+1);
        // 현재 재료 미선택
        v[depth] = false;
        subs(depth+1);
    }
    static class Food {
        int s, b;
        public Food(int s, int b) {
            this.s = s;
            this.b = b;
        }
    }
}
