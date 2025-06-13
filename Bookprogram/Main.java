package Bookprogram;

import java.util.Scanner;

import ch3.Exs_ch3_user_array;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // int result = Exs_ch3.getSum(10);
        // System.out.println("1부터 10까지의 합: " + result);
        // Exs_ch3.ex3_2(scanner);
        // Exs_ch3.count_q(scanner);
        // Exs_ch3.ex3_4();
        // Exs_ch3.ex3_5(scanner);
        // Exs_ch3.ex3_6_2();
        int menu;
        do {
            System.out.println("책 관리 프로그램 예시");
            System.out.println("=================================================================");
            System.out.println("1. 책 추가 , 2. 책 조회, 3. 책 삭제, 4. 책 수정, 5.더미 데이터 추가 6. 책 조회 0. 종료");
            System.out.println("=================================================================");
            System.out.print("메뉴를 선택하세요(0Book): ");
            menu = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 제거
            switch (menu) {
                case 1:
                    gkatn.addBook(scanner); // 책 추가
                    break;

                case 2:
                    gkatn.viewBook(); // 책 조회
                    break;
                case 3:
                    gkatn.deleteBook(scanner); // 책 삭제
                    break;
                case 4:
                    gkatn.updateBook(scanner); // 책 수정
                    break;
                case 5:
                    gkatn.addDummyBook(); // 더미 데이터 추가
                    System.out.println("더미 데이터 5개가 추가되었습니다.");
                    break;
                case 6:
                    gkatn.SearchBook(scanner); // 책 조회
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 메뉴 선택입니다. 다시 시도하세요.");
            }

        } while (menu != 0); // 메뉴가 0이 아닐 때까지 반복
        System.out.println("============================");

    }
}
