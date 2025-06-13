package ch3;

import java.util.Scanner;

public class Exs_ch3 {
    // ex 3-1
    // 기본 for이용해서 1~10까지 의 합을 구하는 내용
    // 입력값에 원하는 숫자를 입력시, 1~n까지의 합을 구하는 메소드
    public static int getSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void ex3_2(Scanner scanner) {
        int sum = 0;
        int input;
        System.out.println("숫자를 입력하세요 (0을 입력하면 종료):");
        while (true) {
            input = scanner.nextInt();
            if (input == 0) {
                break;
            }
            sum += input;
        }
        System.out.println("입력한 숫자의 합: " + sum);
    }

    // 퀴즈
    // 사용자로부터 문자를 입력받아, q가 나올때까지 문자의 개수를 세는 프로그램을 작성
    public static int count_q(Scanner scanner) {
        int count = 0;
        String sub = "";
        System.out.println("문자를 입력하세요(q가 나오면 종료)");
        while (true) {
            String d = scanner.next();
            sub += d;
            count++;
            if (d.equals("q")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }

        return count;
    }

    public static void ex3_3() {
        char a = 'a';
        do {
            System.out.print(a);
            a = (char) (a + 1);
        } while (a <= 'z');
    }

    // 중첩 반복
    public static void ex3_4() {
        for (int i = 0; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.print(i + "*" + j + "=" + i * j);
                System.out.print('\t');
            }
            System.out.println();
        }
    }

    public static void ex3_5(Scanner scanner) {
        System.out.println("정수를 5개 입력하세요.");
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int n = scanner.nextInt();
            if (n <= 0)
                continue; // 0이나 음수인 경우 더하지 않고 다음 반복으로 진행
            else
                sum += n; // 양수인 경우 덧셈
        }
        System.out.println("양수의 합은 " + sum);
    }

    public static void ex3_6_2() {
        int[] numbers = { 1, 2, 3, 4, 5 };

        // 배열 값 출력
        // 향상된 for 문 기본 문법 형식
        // for(자료형 변수 : 배열이름)=> 배열에서 각 요소를 하나씩 꺼내서 변수에 할당
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    // 회원 추가 관련프로그램 UI그리는 메소드
    public static void ex_user_ui() {
        int menu;

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("회원 관리 프로그램 예시");
            System.out.println("=================================================================");
            System.out.println("1. 회원 추가 , 2. 회원 조회, 3. 회원 수정, 4. 회원 삭제, 5.더미 데이터 추가 0. 종료");
            System.out.println("=================================================================");
            System.out.print("메뉴를 선택하세요(0 ~ 4): ");
            menu = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 제거
            switch (menu) {
                case 1:
                    Exs_ch3_user_array.addUser(scanner); // 회원 추가
                    break;
                case 2:
                    Exs_ch3_user_array.viewUsers(); // 회원 조회
                    break;
                case 3:
                    Exs_ch3_user_array.deleteUser(scanner); // 회원 삭제
                    break;
                case 4:
                    Exs_ch3_user_array.updateUser(scanner); // 회원 수정
                    break;
                case 5:
                    Exs_ch3_user_array.addDummyUsers(); // 더미 데이터 추가
                    System.out.println("더미 데이터 5개가 추가되었습니다.");
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 메뉴 선택입니다. 다시 시도하세요.");
            }

        } while (menu != 0); // 메뉴가 0이 아닐 때까지 반복
    }

    public static void ex3_7(Scanner scanner) {
        // ex3-7, 퀴즈, 1~n 까지의 합을 구하는 메소드 작성하기.

        int intArray[];
        intArray = new int[5];
        int max = 0; // 현재 가장 큰 수
        System.out.println("양수 5개를 입력하세요.");
        for (int i = 0; i < 5; i++) {
            intArray[i] = scanner.nextInt();
            // 입력 받은 정수를 배열에 저장
            if (intArray[i] > max)
                max = intArray[i]; // max 변경
        }
        System.out.print("가장 큰 수는 " + max + "입니다.");
    }

    public static void ex3_8() {
        // 1차원 배열
        int[] numbers = new int[5];
        int[] numbers2 = { 1, 2, 3, 4, 5 };
        // 각 요소의 값을 하나씩 접근
        // numbers[3] 조회
        int value = numbers2[3];
        System.out.println("numbers2[3]의 값은: " + value);

        for (int number : numbers2) {
            System.out.println(number + " ");
        }
    }

    public static int[] ex_8_return() {
        // 1차원 배열을 반환하는 메소드
        int[] numbers = { 1, 2, 3, 4, 5 };
        return numbers; // 배열 반환
    }

    // 정수 5개 받아서 역순 출력
    public static void reverse(Scanner scanner) {
        int[] array = new int[5];
        System.out.println("5가지의 정수 입력 : ");
        for (int i = 0; i < 5; i++) {
            array[i] = scanner.nextInt();
        }
        for (int i = 0; i < 5; i++)
            System.out.println(array[4 - i] + " ");

    }

    // 3*3 배열을 만들어 모든 요소에 1~9 채우고 출력
    public static void arrayInt() {
        int[][] array = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 문자열 배열을 메서드로 받아 가장 긴 문자열을 반환
    public static void arrayString() {
        int length = 0;
        int max = 0;
        String[][] array = {
                { "My name is Jisung" },
                { "What is your name" },
                { "Today wheater is very good" }
        };
        for (int i = 0; i < 3; i++) {
            String sentence = array[i][0];
            if (sentence.length() > max)
                max = sentence.length();
            length = i;
        }
        System.out.println(array[length][0]);
    }

    // 임의로 크기가 5개인 문자열의 길이는 10개 이하인 랜덤한 문자열을 생성하는 메서드
    // 반환 타입 : 문자열 배열
    public static String[] generateRandomStrings(int size) {
        String[] randomStrings = new String[size];
        String characters = "abcdefghijklmnopqrstuvwxyz"; // 소문자 알파벳

        for (int i = 0; i < size; i++) {
            int length = (int) (Math.random() * 10) + 1; // 1~10 사이의 길이
            StringBuilder sb = new StringBuilder();
            // StringBuilder : 문자열인데, 메모리 절약하는 문자열

            for (int j = 0; j < length; j++) {
                int index = (int) (Math.random() * characters.length());
                sb.append(characters.charAt(index)); // 랜덤 문자 추가
            }

            randomStrings[i] = sb.toString(); // 문자열로 변환하여 배열에 저장
        }

        return randomStrings; // 생성된 문자열 배열 반환
    }
    // 기본 예외 처리 방법
    // try{
    // catch(예외타입 e){}
    // }
    // finally{} : 예외 발생 여부와 상관없이 항상 실행되는 블록

    // 0으로 나누는 예외 처리 예시
    public static void ex3_9() {
        int a = 10;
        int b = 0;
        try {
            // 정상인 경우 try구문 실행
            int result = a / b; // 0으로 나누기 시도
            System.out.println("결과: " + result);
        } catch (ArithmeticException e) {
            // 예외가 발생하면 catch 블록 실행
            System.out.println("0으로 나눌 수 없습니다: " + e.getMessage());
        } finally {
            // 예외 발생 여부와 상관없이 항상 실행되는 블록
            System.out.println("예외 처리 블록이 실행되었습니다.");
        }
    }
}
