package ch3;

import java.util.Scanner;

public class Exs_ch3_Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // int result = Exs_ch3.getSum(10);
        // System.out.println("1부터 10까지의 합: " + result);
        // Exs_ch3.ex3_2(scanner);
        // Exs_ch3.count_q(scanner);
        // Exs_ch3.ex3_4();
        // Exs_ch3.ex3_5(scanner);
        // Exs_ch3.ex3_6_2();
        // Exs_ch3.ex_user_ui();
        // System.out.println("============================");
        // Exs_ch3.ex3_7(scanner);
        // Exs_ch3.ex3_8();
        // int[] returnArray = Exs_ch3.ex_8_return();
        // for (int number : returnArray) {
        // System.out.print(number + " ");
        // }
        // Exs_ch3.reverse(scanner);
        // Exs_ch3.arrayInt();
        // Exs_ch3.arrayString();

        String[] a = Exs_ch3.generateRandomStrings(10);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
