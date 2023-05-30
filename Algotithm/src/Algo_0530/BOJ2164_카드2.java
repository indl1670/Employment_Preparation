package Algo_0530;

import java.io.*;
import java.util.*;

public class BOJ2164_카드2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        while (q.size() > 1) {
            q.poll(); // 카드를 버림
            int tmp = q.poll();
            q.offer(tmp); // 카드를 옮김
        }

        System.out.println(q.poll());

    }
}
