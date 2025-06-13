package ch2;

import java.util.Scanner;

public class Exs {
    public static String getCircleArea(double radius) {
        final double PI = 3.14159; // 상수
        if (radius < 0) {
            return "반지름은 음수가 될 수 없습니다.";
        }
        double area = PI * radius * radius;
        // String.format 기본 옵션
        // 소수점 둘 째 자리까지 출력
        // %.2f : 소수점 둘째자리까지 출력
        return String.format("반지름 %.2f인 원의 면적은 %.2f입니다.", radius, area);
    }

    public static void getTypeExam() {
        long num1 = 100L; // long타입 변수, 8바이트
        long num2 = 100;
        // 작은쪽 -> 큰 쪽으로 형변환 시에만 문제가 안됨

        byte num3 = 127;
        int num4 = 128;
        // 강제 형변환 int -> byte

        byte num5 = (byte) num4;
        System.out.println("num5 : " + num5);
    }

    public static void getIncDecExam() {
        int a = 10;
        int b = 20;

        System.out.println("a++ : " + (a++));
        System.out.println("결과1 a: " + a);
        System.out.println("++a : " + (++a));
        System.out.println("결과2 a: " + a);

        b += 5; // b = b + 5; b는 이제 25
        System.out.println("b += 5: " + b);
    }

    public static String getTernaryExam(int score) {
        String result = (score >= 60) ? "합격" : "불합격";
        return result;
    }

    // 퀴즈
    // 사용자 이름 입력 받고, 좋아하는 월을 입력받고
    // 좋아하는 월에 따른 계절의 이름 출력 봄(3~5),여름(6~8),가을(9~11),겨울
    // switch문 또는 if문 이용
    public static void getnameFavorit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("이름을 입력하세요 : ");
        String name = scanner.nextLine();
        System.out.println("좋아하는 월을 입력하세요 : ");
        int month = scanner.nextInt();
        String weather = "";
        switch (month) {
            case 3, 4, 5:
                weather = "봄";
                break;
            case 6, 7, 8:
                weather = "여름";
                break;
            case 9, 10, 11:
                weather = "가을";
                break;
            case 12, 1, 2:
                weather = "겨울";
                break;
            default:
                System.out.println("1~12월 사이를 작성하시오");

        }
        System.out.println("당신의 이름은 " + name + "이고, 당신이 좋아하는 계절은 " + weather + "입니다.");
        scanner.close();
    }
}
