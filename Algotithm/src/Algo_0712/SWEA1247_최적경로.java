package Algo_0712;

import java.io.*;
import java.util.*;

public class SWEA1247_최적경로 {
    static int T, N, ans, sx, sy, ex, ey;
    static Node[] people;
    static int[] select;
    static boolean[] v;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            people = new Node[N];
            select = new int[N];
            v = new boolean[N];

            st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken()); // 회사 x 좌표
            sy = Integer.parseInt(st.nextToken()); // 회사 y 좌표
            ex = Integer.parseInt(st.nextToken()); // 집 x 좌표
            ey = Integer.parseInt(st.nextToken()); // 집 y 좌표

            // 고객 좌표
            for (int i = 0; i < N; i++) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                people[i] = new Node(x, y);
            }

            ans = Integer.MAX_VALUE;
            perm(0);

            System.out.println("#" + tc + " " + ans);
        }
    }
    static void perm(int depth) {
        if (depth == N) { // 기저조건
            // 경로 계산
            check();

            return;
        }

        for (int i = 0; i < N; i++) {
            if (v[i]) continue;
            select[depth] = i;
            v[i] = true;
            perm(depth+1);
            v[i] = false;
        }
    }
    static void check() {
        int sum = 0;

        // 회사 - 첫 번째 고객
        sum += Math.abs(sx - people[select[0]].x) + Math.abs(sy - people[select[0]].y);

        for (int i = 0; i < N-1; i++) {
            sum += Math.abs(people[select[i]].x - people[select[i+1]].x) + Math.abs(people[select[i]].y - people[select[i+1]].y);
        }

        // 마지막 고객 - 집
        sum += Math.abs(ex - people[select[N-1]].x) + Math.abs(ey - people[select[N-1]].y);

        ans = Integer.min(ans, sum);
    }
    static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
