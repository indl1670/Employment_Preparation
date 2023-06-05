package Algo_0605;

import java.io.*;
import java.util.*;

public class BOJ1158_요세푸스문제 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 사람의 수
        int K = Integer.parseInt(st.nextToken()); // 제거할 사람 순번

        // N 숫자 삽입
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }
        sb.append("<");
        int tmp = 0;
        while (!q.isEmpty()) {
            tmp++;
            int num = q.poll();
            if (tmp == K) { // K번째 사람 제거
                sb.append(num).append(", ");
                tmp = 0;
            } else {
                q.add(num);

            }
        }
        
        // 출력 형식 제어
        sb.setLength(sb.length() - 2);
        sb.append(">");
        System.out.println(sb.toString());
    }
}
