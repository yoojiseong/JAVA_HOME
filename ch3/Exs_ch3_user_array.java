package ch3;

import java.util.Scanner;
import util.Date.DateUtil;

public class Exs_ch3_user_array {
    static final int MAX_USERS = 100; // 최대 회원 수
    // 이름, 이메일, 패스워드, 등록일을 저장할 배열 선언
    static String[] names = new String[MAX_USERS];
    static String[] emails = new String[MAX_USERS];
    static String[] passwords = new String[MAX_USERS];
    static String[] registrationDates = new String[MAX_USERS];
    static int userCount = 0; // 현재 등록된 회원 수

    // 회원 추가 메서드
    public static void addUser(Scanner scanner) {
        if (userCount < MAX_USERS) {
            System.out.println("이름을 입력하세요: ");
            String name = scanner.nextLine();
            names[userCount] = name; // 이름 저장

            System.out.println("이메일을 입력하세요: ");
            String email = scanner.nextLine();
            emails[userCount] = email; // 이메일 저장

            System.out.println("패스워드를 입력하세요: ");
            String password = scanner.nextLine();
            passwords[userCount] = password; // 패스워드 저장

            // 현재 날짜와 시간 저장
            String registrationDate = DateUtil.getCurrentDateTime();
            registrationDates[userCount] = registrationDate; // 등록일 저장

            // 회원 수 증가
            userCount++;
            System.out.println("회원이 추가되었습니다: " + name + ", " + email + ", " + registrationDate);
        } else {
            System.out.println("회원 수가 최대치를 초과했습니다.");
        }
    } // 회원 추가 메서드

    // 회원 조회 메서드
    public static void viewUsers() {
        if (userCount == 0) {
            System.out.println("등록된 회원이 없습니다.");
            return;
        }
        System.out.println("등록된 회원 목록:");
        for (int i = 0; i < userCount; i++) {
            System.out.println((i + 1) + ". " + names[i] + ", " + emails[i] + ", " + registrationDates[i]);
        }
    } // 회원 조회 메서드

    // 회원 수정 메서드
    public static void updateUser(Scanner scanner) {
        System.out.println("수정할 회원의 인덱스를 입력하세요 (0 ~ " + (userCount - 1) + "): ");
        int index = scanner.nextInt(); // 수정할 회원의 인덱스 입력
        scanner.nextLine(); // 개행 문자 제거
        if (index < 0 || index >= userCount) {
            System.out.println("잘못된 인덱스입니다.");
            return;
        }
        System.out.println("수정할 회원의 이름을 입력하세요: ");
        String name = scanner.nextLine();
        names[index] = name; // 이름 수정

        System.out.println("수정할 회원의 이메일을 입력하세요: ");
        String email = scanner.nextLine();
        emails[index] = email; // 이메일 수정

        System.out.println("수정할 회원의 패스워드를 입력하세요: ");
        String password = scanner.nextLine();
        passwords[index] = password; // 패스워드 수정

        // 현재 날짜와 시간 저장
        String registrationDate = DateUtil.getCurrentDateTime();
        registrationDates[index] = registrationDate; // 등록일 수정

        System.out.println("회원 정보가 수정되었습니다: " + names[index] + ", " + emails[index]);
    } // 회원 수정 메서드

    // 회원 삭제 메서드
    public static void deleteUser(Scanner scanner) {
        System.out.println("삭제할 회원의 인덱스를 입력하세요 (0 ~ " + (userCount - 1) + "): ");
        int index = scanner.nextInt(); // 삭제할 회원의 인덱스 입력
        scanner.nextLine(); // 개행 문자 제거

        if (index < 0 || index >= userCount) {
            System.out.println("잘못된 인덱스입니다.");
            return; // 잘못된 인덱스를 입력시, 삭제 기능을 종료 한다는 의미.
        }
        // 삭제할 회원 정보 출력
        System.out.println("삭제할 회원 정보: " + names[index] + ", " + emails[index] + ", " + registrationDates[index]);

        // 해당 인덱스의 회원 정보를 삭제하고, 뒤에 있는 회원 정보를 앞으로 이동
        for (int i = index; i < userCount - 1; i++) {
            names[i] = names[i + 1];
            emails[i] = emails[i + 1];
            passwords[i] = passwords[i + 1];
            registrationDates[i] = registrationDates[i + 1];
        }
        // 마지막 회원 정보는 null로 설정
        names[userCount - 1] = null;
        emails[userCount - 1] = null;
        passwords[userCount - 1] = null;
        registrationDates[userCount - 1] = null;

        // 회원 수 감소
        userCount--;
        System.out.println("회원이 삭제되었습니다.");
    }
    // 회원 삭제 메서드

    // 회원 더미 데이터 5개 추가하는 메서드
    public static void addDummyUsers() {
        for (int i = 0; i < 5; i++) {
            if (userCount < MAX_USERS) {
                names[userCount] = "더미회원" + (i + 1);
                emails[userCount] = "dummy" + (i + 1) + "@example.com";
                passwords[userCount] = "password" + (i + 1);
                registrationDates[userCount] = DateUtil.getCurrentDateTime();
                userCount++;
            } else {
                System.out.println("더미 회원 추가 실패: 최대 회원 수 초과");
                break;
            }
        }
        System.out.println("더미 회원 5명이 추가되었습니다.");
    }
    // 회원 더미 데이터 5개 추가하는 메서드

}
