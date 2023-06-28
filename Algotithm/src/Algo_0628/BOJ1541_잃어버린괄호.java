package Algo_0628;

import java.io.*;
import java.util.*;

public class BOJ1541_잃어버린괄호 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("-");
        String[] str2;
        int min = 0;

        for (int i = 0; i < str.length; i++) {
            str2 = str[i].split("\\+");
            int tmp = 0;

            for (int j = 0; j < str2.length; j++) {
                tmp += Integer.parseInt(str2[j]);
            }

            if (i == 0) min += tmp;
            else min -= tmp;
        }
        System.out.println(min);
    }
}
