package Algo_0605;

import java.io.*;
import java.util.*;
public class BOJ2493_탑 {
    static int N;
    static Stack<int[]> tower = new Stack<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            int height = Integer.parseInt(st.nextToken());

            while(!tower.isEmpty()) {
                // 이전 탑의 높이가 현재 탑의 높이보다 높은 경우
                if (tower.peek()[1] >= height) {
                    sb.append(tower.peek()[0]).append(" ");
                    break;
                }
                // 이전 탑의 높이가 현재 탑의 높이보다 작은 경우
                tower.pop();
            }
            if (tower.isEmpty()) {
                sb.append("0 ");
            }
            // 타워 높이 저장
            tower.push(new int[] {i, height});
        }
        System.out.println(sb.toString());
    }
}
