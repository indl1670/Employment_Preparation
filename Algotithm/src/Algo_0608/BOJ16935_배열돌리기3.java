package Algo_0608;

import java.io.*;
import java.util.*;

public class BOJ16935_배열돌리기3 {
    static int N, M, R;
    static int[][] array;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken()); // 배열 이동
        array = new int[N][M];

        // 배열 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 명령어 저장
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            int opt = Integer.parseInt(st.nextToken());

            switch (opt) {
                case 1:
                    rotate1();
                    break;
                case 2:
                    rotate2();
                    break;
                case 3:
                    rotate3();
                    break;
                case 4:
                    rotate4();
                    break;
                case 5:
                    rotate5();
                    break;
                case 6:
                    rotate6();
                    break;
                default:
                    break;

            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
    static void rotate1() { // 상하 반전
        int[] tmp = new int[N]; // 임시 세로 배열
        for (int i = 0; i < M; i++) {
            // 임시 배열 생성
            for (int j = 0; j < N; j++) {
                tmp[j] = array[j][i];
            }
            // 상하 반전
            int idx = 0;
            for (int j = N-1; j >= 0; j--) {
                if (idx == N) idx = 0;
                array[j][i] = tmp[idx++];

            }
        }
    }
    static void rotate2() { // 좌우 반전
        int[] tmp = new int[M]; // 임시 가로 배열
        for (int i = 0; i < N; i++) {
            // 임시 배열 생성
            for (int j = 0; j < M; j++) {
                tmp[j] = array[i][j];
            }

            // 좌우 반전
            int idx = 0;
            for (int j = M-1; j >= 0; j--) {
                if (idx == M) idx = 0;
                array[i][j] = tmp[idx++];

            }
        }
    }
    static void rotate3() { // 오른쪽 90도 회전
        int[][] tmp = array; // 임시 배열
        array = new int[M][N]; // 회전 후 배열

        // 오른쪽 90도 회전
        int sr = 0;
        int sc = N-1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (sr == M) sr = 0;
                array[sr++][sc] = tmp[i][j];
            }
            sc--;
        }

        // 배열 너비/높이 변화
        int chg = N;
        N = M;
        M = chg;
    }
    static void rotate4() { // 왼쪽 90도 회전
        int[][] tmp = array; // 임시 배열
        array = new int[M][N]; // 회전 후 배열

        // 왼쪽 90도 회전
        int sr = 0;
        int sc = 0;
        for (int i = 0; i < N; i++) {
            for (int j = M-1; j >= 0; j--) {
                if (sr == M) sr = 0;
                array[sr++][sc] = tmp[i][j];
            }
            sc++;
        }

        // 배열 너비/높이 변화
        int chg = N;
        N = M;
        M = chg;
    }
    static void rotate5() { // 4개 그룹 분리 1-2, 2-3, 3-4, 4-1
        int[][] tmp = new int[N][M];

        // 1 -> 2
        for (int i = 0; i < N/2; i++) {
            for (int j = 0; j < M/2; j++) {
                tmp[i][M/2+j] = array[i][j];
            }
        }
        // 2 -> 3
        for (int i = 0; i < N/2; i++) {
            for (int j = M/2; j < M; j++) {
                tmp[N/2+i][j] = array[i][j];
            }
        }
        // 3 -> 4
        for (int i = N/2; i < N; i++) {
            int col = 0;
            for (int j = M/2; j < M; j++) {
                tmp[i][col++] = array[i][j];
            }
        }
        // 4 -> 1
        int row = 0;
        for (int i = N/2; i < N; i++) {
            for (int j = 0; j < M/2; j++) {
                tmp[row][j] = array[i][j];
            }
            row++;
        }
        array = tmp;
    }
    static void rotate6() { // 4개 그룹 분리 1-4, 4-3, 3-2, 2-1
        int[][] tmp = new int[N][M];

        // 1 -> 4
        for (int i = 0; i < N/2; i++) {
            for (int j = 0; j < M/2; j++) {
                tmp[N/2+i][j] = array[i][j];
            }
        }
        // 2 -> 1
        for (int i = 0; i < N/2; i++) {
            int col = 0;
            for (int j = M/2; j < M; j++) {
                tmp[i][col++] = array[i][j];
            }
        }
        // 3 -> 2
        int row = 0;
        for (int i = N/2; i < N; i++) {
            for (int j = M/2; j < M; j++) {
                tmp[row][j] = array[i][j];
            }
            row++;
        }
        // 4 -> 3
        for (int i = N/2; i < N; i++) {
            for (int j = 0; j < M/2; j++) {
                tmp[i][M/2+j] = array[i][j];
            }
        }
        array = tmp;
    }
}
