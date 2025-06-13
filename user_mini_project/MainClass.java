package user_mini_project;

import java.util.Scanner;

import ch2.OperconditionTest;
import util.User.UserService;

public class MainClass {
    public static void main(String[] args) {
        while (true) {
            // 공용 사용 스캐너 생성
            Scanner scanner = new Scanner(System.in);
            System.out.println("=====================================================");
            System.out.println("회원 가입 시스템에 오신 것을 환영합니다.");
            System.out.println("1. 회원가입 2.로그인   3.산술 연산자 테스트 4.산술 연산자 테스트2 5.로또 번호 6.문자 갯수 0.종료");
            System.out.println("=====================================================");
            System.out.println("메뉴 번호를 선택해주세요 (0~5)");
            // 사용자가 입력한 번호를 문자열로 받기
            String choice = scanner.nextLine();
            // if형태의 조건
            if (choice.equals("1")) {
                UserService.registerUser(scanner);
            } else if (choice.equals("2")) {
                UserService.login(scanner);
            } else if (choice.equals("3")) {
                // 산술연산자 테스트 기능 호출
                OperconditionTest.oper1();

            } else if (choice.equals("4")) {
                // 산술연산자 테스트 기능 호출
                OperconditionTest.oper2();

            } else if (choice.equals("5")) {
                // 산술연산자 테스트 기능 호출
                util.Random.RandomUtil.rotto();

            } else if (choice.equals("6")) {
                // 산술연산자 테스트 기능 호출
                int count = ch3.Exs_ch3.count_q(scanner);
                System.out.println("입력한 문자의 갯수" + count);

            } else if (choice.equals("0")) {
                System.out.println("프로그램을 종료합니다. 감사합니다.");
                scanner.close();
                return;
            } else {
                System.out.println("잘못된 입력입니다 0,1,2 중에서 선택해주세요");
            }

        }
    }
}
