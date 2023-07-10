package Algo_0710;

import java.io.*;
import java.util.*;

public class BOJ1992_쿼드트리 {
    static int N;
    static int[][] array;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        array = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                array[i][j] = s.charAt(j) - '0';
            }
        }
        quadTree(0, 0, N);
        System.out.println(sb.toString());
    }
    static void quadTree(int x, int y, int n) {
        if (check(x, y, n)) {
            sb.append(array[x][y]);
            return;
        }

        int size = n/2;

        sb.append("(");
        quadTree(x, y, size);
        quadTree(x, y+size, size);
        quadTree(x+size, y, size);
        quadTree(x+size, y+size, size);
        sb.append(")");
    }
    static boolean check(int x, int y, int n) {
        int tmp = array[x][y];

        for (int i = x; i < x+n; i++) {
            for (int j = y; j < y+n; j++) {
                if (tmp != array[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
