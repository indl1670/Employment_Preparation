package Algo_0525;

import java.io.*;
import java.util.*;

public class SWEA1218_괄호짝짓기 {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int tc = 1; tc <= 10; tc++) {
            Stack<Character> stack = new Stack<>();
            N = Integer.parseInt(br.readLine());
            char[] letter = new char[N];
            letter = br.readLine().toCharArray();

            for (int i = 0; i < N; i++) {
                char c = letter[i];
                if (c == ')' && stack.peek() == '(') stack.pop();
                else if (c == ']' && stack.peek() == '[') stack.pop();
                else if (c == '}' && stack.peek() == '{') stack.pop();
                else if (c == '>' && stack.peek() == '<') stack.pop();
                else {
                    stack.push(c);
                }
            }
            System.out.println("#" + tc + " " + (stack.size() == 0 ? 0 : 1));
        }

    }
}
