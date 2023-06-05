package Algo_0605;
import java.io.*;
import java.util.*;
public class SWEA1228_암호문1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int tc = 1; tc <= 10; tc++) {
            // 초기화
            List<Integer> password = new ArrayList<>();

            // 원본 암호문의 길이
            int N = Integer.parseInt(br.readLine());

            // 원본 암호문
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                password.add(Integer.parseInt(st.nextToken()));
            }

            // 명령어 개수
            int cmd = Integer.parseInt(br.readLine());

            // 명령어
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < cmd; i++) {
                st.nextToken(); // 삽입 명령어 I
                int place = Integer.parseInt(st.nextToken()); // 삽입 위치
                int num = Integer.parseInt(st.nextToken()); // 삽입 개수

                for (int j = 0; j < num; j++) {
                    password.add(place++, Integer.parseInt(st.nextToken()));
                }
            }
            System.out.print("#" + tc);
            for (int i = 0; i < 10; i++) {
                System.out.print(" " + password.get(i));
            }
            System.out.println();
        }
    }
}
