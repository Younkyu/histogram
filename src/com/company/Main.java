package com.company;

///히스토그램

import java.util.*;

public class Main {

    public static ArrayList<Integer> box = new ArrayList<>();

    //ex
    //7
    //2 1 4 5 1 4 4
    //answer
    //8
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //총 몇개의 숫자를 입력 받을 것인지
        int a;
        int[] b;
        int[] c;
        int d = 0;
        int max = Integer.MIN_VALUE;
        int result = 0;

        Stack<int[]> stack = new Stack<>();

        a = sc.nextInt();

        b = new int[a + 1];
        b[a] = -1;

        for (int i = 0; i < a; i++) {
            b[i] = sc.nextInt();
        }
        stack.push(new int[]{-1, -1});

        sc.close();

        result = a;
        int tmp;
        for (int i = 0; i <= a; i++) {

            if (!stack.isEmpty() && stack.peek()[0] < b[i]) {
                stack.push(new int[]{b[i], i});
            } else {
                while (!stack.isEmpty() && stack.peek()[0] > b[i]) {
                    int[] tmpInt = stack.pop();
                    tmp = tmpInt[0] * (i - 1 - stack.peek()[1]);

                    if (tmp > result) result = tmp;
                }

                stack.push(new int[]{b[i], i});
            }
        }

        System.out.println(result);

    }


}


