package Algo_0614;

import java.io.*;
import java.util.*;

public class BOJ17406_배열돌리기4 {

    static int[][] array, tmp, rcs;
    static int N, M, K, min;
    static int[] select;
    static boolean[] v;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        //초기화
        min = Integer.MAX_VALUE;
        array = new int[N][M];
        tmp = new int[N][M];
        rcs = new int[K][3];
        select = new int[K];
        v = new boolean[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int n = Integer.parseInt(st.nextToken());
                array[i][j] = n;
                tmp[i][j] = n;
            }
        }



        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            rcs[i][0] = Integer.parseInt(st.nextToken());
            rcs[i][1] = Integer.parseInt(st.nextToken());
            rcs[i][2] = Integer.parseInt(st.nextToken());
        }

        //순열
        perm(0);
        System.out.println(min);
    }

    static void perm(int depth) {
        //1. 기저조건
        if (depth == K) {
            //순열 완성
            //회전 - 최소값 갱신 - 배열 초기화
            rotate();

            for (int i = 0; i < N; i++) {
                int sum = 0;
                for (int j = 0; j < M; j++) {
                    sum += array[i][j];
                }
                min = Math.min(min, sum);
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    array[i][j] = tmp[i][j];
                }
            }

            return;
        }

        for (int i = 0; i < K; i++) {
            if (v[i]) continue;
            select[depth] = i;
            v[i] = true;
            perm(depth + 1);
            v[i] = false;
        }
    }


    static void rotate() {

        // select 배열에는 완성된 현재 순열이 저장되어 있다.
        // 첫 번째 주어진 배열 연산 순서로 실행
        for (int k = 0; k < K; k++) {

            int n = select[k]; // 현재 완성된 순열 index

            int r = rcs[n][0] - 1; // 0 base 보정
            int c = rcs[n][1] - 1; // 0 base 보정
            int s = rcs[n][2]; // 반복 횟수가 됨.

            int sr = r - s;
            int er = r + s;
            int sc = c - s;
            int ec = c + s;

            while (true) {

                // 기저 조건 s만큼 수행 for 문도 가능
                if (s == 0)
                    break;

                int temp = array[sr][sc]; // 백업 (왼쪽 위)
                // 이동 방향의 앞쪽부터 이동해야 함 <- 1 <- 2 <- 3 <- 4
                // 뒷쪽 부터 이동하면 계속 덮어씀 <- 4 < -3 <- 2 <- 1

                // 왼쪽 위로 1칸 이동
                for (int i = sr; i < er; i++) {
                    array[i][sc] = array[i + 1][sc];
                }

                // 아래 왼쪽 1칸 이동
                for (int i = sc; i < ec; i++) {
                    array[er][i] = array[er][i + 1];
                }

                // 오른쪽 아래로 1칸 이동
                for (int i = er; i > sr; i--) {
                    array[i][ec] = array[i - 1][ec];
                }

                // 위 오른쪽으로 한칸 이동
                for (int i = ec; i > sc; i--) {
                    array[sr][i] = array[sr][i - 1];
                }

                // temp 로부터 이동 마지막 부분 복사( 왼쪽 위의 한칸 오른쪽 )
                array[sr][sc + 1] = temp;

                sr += 1; // 시작 y는 하나 아래로
                sc += 1; // 시작 x는 하나 오른쪽으로
                er -= 1; // 종료 y는 하나 위
                ec -= 1; // 종료 x는 하나 왼쪽으로

                s--;
            }

        }
    }
}