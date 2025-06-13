package Bookprogram;

import java.util.Scanner;

import util.Date.DateUtil;

public class gkatn {
    static final int MAX_BOOK = 100;

    static String[] names = new String[MAX_BOOK];
    static String[] author = new String[MAX_BOOK];
    static String[] si_no = new String[MAX_BOOK];
    static String[] registrationDates = new String[MAX_BOOK];
    static int bookCount = 0;

    public static void addBook(Scanner scanner) {
        if (bookCount < MAX_BOOK) {
            System.out.println("이름을 입력하세요: ");
            String name = scanner.nextLine();
            names[bookCount] = name;

            System.out.println("작가의 이름을 입력하세요: ");
            String authors = scanner.nextLine();
            author[bookCount] = authors;

            System.out.println("시리얼넘버를 입력하세요: ");
            String password = scanner.nextLine();
            si_no[bookCount] = password;

            String registrationDate = DateUtil.getCurrentDateTime();
            registrationDates[bookCount] = registrationDate;

            bookCount++;
            System.out.println("책이 추가되었습니다: " + name + ", " + author + ", " + si_no + "," + registrationDate);
        } else {
            System.out.println("책이 최대치를 초과했습니다.");
        }
    }

    public static void viewBook() {
        if (bookCount == 0) {
            System.out.println("등록된 책이 없습니다.");
            return;
        }
        System.out.println("등록된 책 목록:");
        for (int i = 0; i < bookCount; i++) {
            System.out.println(
                    (i + 1) + ". " + names[i] + ", " + author[i] + ", " + si_no[i] + "," + registrationDates[i]);
        }
    }

    public static void updateBook(Scanner scanner) {
        System.out.println("수정할 책의 이름를 입력하세요 : ");
        String name = scanner.nextLine(); // 수정할 회원의 인덱스 입력
        // scanner.nextLine(); // 개행 문자 제거
        for (int i = 0; i < bookCount; i++) {
            if (names[i].equals(name)) {
                System.out.println("수정할 책의 이름을 입력하세요");
                String bookName = scanner.nextLine();
                names[i] = bookName; // 책 이름 수정
                System.out.println("수정할 책의 작가 이름을 입력하세요: ");
                String authorName = scanner.nextLine();
                author[i] = authorName; // 작가 이름 수정

                System.out.println("수정할 책의 시리얼 넘버를 입력하세요: ");
                String serialNumber = scanner.nextLine();
                si_no[i] = serialNumber; // 시리얼 넘버 수정

                // 현재 날짜와 시간 저장
                String registrationDate = DateUtil.getCurrentDateTime();
                registrationDates[i] = registrationDate; // 등록일 수정

                System.out.println("책 정보가 수정되었  습니다: " + names[i] + ", " + author[i] + ", " + si_no[i]);
                return;
            }
        }
        System.out.println("책이 존재하지 않습니다.");
    }

    public static void deleteBook(Scanner scanner) {
        System.out.println("삭제할 책의 이름을 입력하세요 : ");
        int index;
        String name = scanner.nextLine();
        scanner.nextLine(); // 개행 문자 제거

        for (index = 0; index < bookCount; index++) {
            if (names[index].equals(name)) {
                return;
            }
        }
        // 삭제할 회원 정보 출력
        System.out.println("삭제할 회원 정보: " + names[index] + ", " + author[index] + ", " + registrationDates[index]);

        // 해당 인덱스의 회원 정보를 삭제하고, 뒤에 있는 회원 정보를 앞으로 이동
        for (int i = index; i < bookCount - 1; i++) {
            names[i] = names[i + 1];
            author[i] = author[i + 1];
            si_no[i] = si_no[i + 1];
            registrationDates[i] = registrationDates[i + 1];
        }
        // 마지막 회원 정보는 null로 설정
        names[bookCount - 1] = null;
        author[bookCount - 1] = null;
        si_no[bookCount - 1] = null;
        registrationDates[bookCount - 1] = null;

        // 회원 수 감소
        bookCount--;
        System.out.println("책이 삭제되었습니다.");
    }

    public static void addDummyBook() {
        for (int i = 0; i < 5; i++) {
            if (bookCount < MAX_BOOK) {
                names[bookCount] = "더미책" + (i + 1);
                author[bookCount] = "dummy" + (i + 1) + "@example.com";
                si_no[bookCount] = "가" + (i + 1);
                registrationDates[bookCount] = DateUtil.getCurrentDateTime();
                bookCount++;
            } else {
                System.out.println("더미 책 추가 실패: 최대 책수 초과");
                break;
            }
        }
        System.out.println("더미 책 5개가 추가되었습니다.");
    }

    public static void SearchBook(Scanner scanner) {
        System.out.println("검색할 책의 이름을 입력하세요 : ");
        String name = scanner.nextLine();
        for (int i = 0; i < bookCount; i++) {
            if (names[i].equals(name)) {
                System.out.println(
                        "책 정보: " + names[i] + ", " + author[i] + ", " + si_no[i] + ", " + registrationDates[i]);
                return;
            }

        }
        System.out.println("책이 존재하지 않습니다.");
    }

}
