package util.User;

import java.util.Scanner;

import util.Date.DateUtil;

public class UserService {
    // 회원가입 기능, 정적 메소드 생성
    // 콘솔로 입력을 받고 결과를 문자열로 반환하는 기능을 포함
    // 추후 업그레이드는 반환타입을 : 문자열에서, 사용자 클래스 객체로 변경 예정
    // 실행을 이 파일에서 안하기 때문에 메인 메소드 없음

    public static void registerUser(Scanner scanner) {
        System.out.println("유지성 홈페이지 회원가입");
        System.out.println("이름을 입력해주세요 : ");
        String name = scanner.nextLine();
        System.out.println("이메일 입력해주시요");
        String email = scanner.nextLine();
        String password;
        while (true) {
            System.out.println("패스워드를 입력해주세요 : ");
            password = scanner.nextLine();

            System.out.println("패스워드 재입력 : ");
            String password2 = scanner.nextLine();
            if (password.isEmpty())
                System.out.println("패스워드는 비워둘 수 없습니다.");
            else if (password.equals(password2)) {
                System.out.println("패스워드가 일치합니다.");
                break;
            } else {
                System.out.println("패스워드가 일치하지 않습니다. 다시 입력해주세요.");
            }
        }
        String DateNow = DateUtil.getCurrentDateTime();
        System.out.println("출력 결과는");
        System.out.println("이름 : " + name);
        System.out.println("이메일 : " + email);
        System.out.println("패스워드 : " + password);
        System.out.println("유지성 님은 " + DateNow + "에 회원가입 하셨습니다.");

    }

    public static void login(Scanner scanner) {
        String email, password;
        while (true) {
            System.out.println("로그인 이메일 입력해주세요 : ");
            email = scanner.nextLine();
            System.out.println("로그인 패스워드 입력해주세요 : ");
            password = scanner.nextLine();

            if (email.equals("admin@naver.com") && password.equals("1234")) {
                System.out.println("로그인 성공");
                break;
            } else if (email.isEmpty()) {
                System.out.println("이메일은 비워둘 수 없습니다.");
            } else if (password.isEmpty()) {
                System.out.println("패스워드는 비워둘 수 없습니다.");
            } else
                System.out.println("로그인 실패");
        }
        System.out.println("로그인 이메일 정보 : " + email);
        System.out.println("로그인 패스워드 정보 :" + password);
        System.out.println("로그인 완료되었습니다.현재 임시로 단순 출력요입니다.");
    }
}
