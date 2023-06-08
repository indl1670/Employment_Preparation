package Algo_0608;

import java.io.*;
import java.util.*;

public class BOJ16926_배열돌리기1 {
    static int N, M, R;
    static int[][] array;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 초기화
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken()); // 반시계방향 회전 횟수
        array = new int[N][M];

        // 배열 설정
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < R; i++) {
            rotate();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
    static void rotate() {
        int sr = 0, sc = 0; // 시작
        int er = N-1, ec = M-1; // 끝

        while (true) {
            // 기저조건
            if (er - sr < 1 || ec - sc < 1) break;

            // 시작 값
            int tmp = array[sr][sc];

            // top: 우 -> 좌
            for (int i = sc; i < ec; i++) {
                array[sr][i] = array[sr][i+1];
            }
            // right: 하 -> 상
            for (int i = sr; i < er; i++) {
                array[i][ec] = array[i+1][ec];
            }
            // bottom: 좌 -> 우
            for (int i = ec; i > sc; i--) {
                array[er][i] = array[er][i-1];
            }
            // left: 상 -> 하
            for (int i = er; i > sr; i--) {
                array[i][sc] = array[i-1][sc];
            }

            array[sr+1][sc] = tmp;

            // 좌표값 변화
            sr++;
            sc++;
            er--;
            ec--;
        }
    }
}
