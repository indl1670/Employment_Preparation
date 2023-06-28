package Algo_0628;

import java.io.*;
import java.util.*;

public class SWEA5644_무선충전 {
    static int T, M, A, ans, ay, ax, by, bx;
    static int[] userA, userB;
    static BC[] battery;
    // 이동X - 상 - 우 - 하 - 좌
    static int[] dy = {0, -1, 0, 1, 0};
    static int[] dx = {0, 0, 1, 0, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine()); // 테스트케이스 개수
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            userA = new int[M]; // 사용자 A의 이동 정보
            userB = new int[M]; // 사용자 B의 이동 정보
            battery = new BC[A]; // BC 정보

            StringTokenizer stA = new StringTokenizer(br.readLine());
            StringTokenizer stB = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                userA[i] = Integer.parseInt(stA.nextToken());
                userB[i] = Integer.parseInt(stB.nextToken());
            }

            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());

                battery[i] = new BC(y, x, c, p);
            }

            ans = 0;
            ay = ax = 1;
            by = bx = 10;

            // 첫 위치에서 충전 확인
            charge();

            for (int i = 0; i < M; i++) {
                ay += dy[userA[i]];
                ax += dx[userA[i]];
                by += dy[userB[i]];
                bx += dx[userB[i]];

                // 이동한 위치에서 충전 확인
                charge();
            }

            System.out.println("#" + tc + " " + ans);
        }
    }
    static void charge() {
        int max = 0;
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < A; j++) {
                int sum = 0;

                int ap = power(battery[i], ay, ax);
                int bp = power(battery[j], by, bx);

                // 둘 다 충전소를 지나지 않는 경우 pass
                if (ap == 0 && bp == 0) continue;

                if (i != j) {
                    sum = ap + bp;
                } else {
                    sum = Math.max(ap, bp);
                }
                max = Math.max(max, sum);
            }
        }
        ans += max;
    }
    static int power(BC bc, int y, int x) {
        if ((Math.abs(bc.y - y) + Math.abs(bc.x - x)) <= bc.c) return bc.p;
        return 0;
    }
    static class BC {
        int y, x, c, p;
        public BC(int y, int x, int c,  int p) {
            this.y = y;
            this.x = x;
            this.c = c;
            this.p = p;
        }
    }
}
