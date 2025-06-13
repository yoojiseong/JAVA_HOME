package user_mini_project;

import java.util.Scanner;

import ch2.OperconditionTest;
import util.User.UserService;

public class MainClass_switch {

    public static void main(String[] args) {
        while (true) {
            // 공용 사용 스캐너 생성
            Scanner scanner = new Scanner(System.in);
            System.out.println("=====================================================");
            System.out.println("회원 가입 시스템에 오신 것을 환영합니다.");
            System.out.println("1. 회원가입 2.로그인   3.산술 연산자 테스트 4.산술 연산자 테스트2 0.종료");
            System.out.println("=====================================================");
            System.out.println("메뉴 번호를 선택해주세요 (1~3)");
            // 사용자가 입력한 번호를 문자열로 받기
            String choice = scanner.nextLine();
            // if형태의 조건
            switch (choice) {
                case "1":
                    UserService.registerUser(scanner);
                    break;

                case "2":
                    UserService.login(scanner);
                    break;

                case "3":
                    OperconditionTest.oper1();
                    break;

                case "4":
                    OperconditionTest.oper2();
                    break;

                case "0":
                    System.out.println("프로그램을 종료합니다. 감사합니다.");
                    scanner.close();
                    return;

                default:
                    System.out.println("잘못된 입력입니다 0,1,2 중에서 선택해주세요");
            }

        }
    }
}
