package Algo_0525;

import java.io.*;
import java.util.*;

public class SWEA1225_암호생성기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;

        for (int tc = 1; tc <= 10; tc++) {
            br.readLine(); // 테스트케이스 번호
            sb = new StringBuilder();
            sb.append("#" + tc + " ");
            Queue<Integer> q = new ArrayDeque<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 8; i++) {
                q.offer(Integer.parseInt(st.nextToken()));
            }

            int cycle = 1;
            while (true) {
                int num = q.poll() - cycle;

                // 기저조건
                if (num <= 0) {
                    q.offer(0);
                    break;
                }

                // 사이클 돌기
                q.offer(num);
                cycle += 1;
                if (cycle > 5) cycle = 1;
            }

            for (int i = 0; i < 8; i++) {
                sb.append(q.poll()).append(" ");
            }
            System.out.println(sb.toString());
        }
    }
}
