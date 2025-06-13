package d250612.member_project.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

import d250612.member_project.model.Member;
import d250612.member_project.util.DateUtil;

import d250612.member_project.util.DateUtil;

public class UserService_ArrayList_version {
    // ==================================================================
    // 추가사항3
    // 파일에 저장하는 메서드
    // 특정 파일 : 예) member.txt , 한 줄 마다 멤버의 정보가 콤마를 기준으로 4개씩 구성된 형태
    // 저장 기능 -> 정보 추가 삭제 수정 할때 맨 마지막에 실행
    private static void saveToFile() {
        // 파일 입출력 할 때는 무조건 try~catch 쓰기, or try ~ reource 형식으로 하기
        // FileWriter fw = new FileWriter("member.txt") 작성시, 자동으로 fw.close()자원 반납

        // 이전
        // try (FileWriter fw = new FileWriter("member.txt")) {

        // 변경 후
        try (OutputStreamWriter fw = new OutputStreamWriter(
                new FileOutputStream("member.txt"), "UTF-8")) {
            // Arraylist 메모리상에 있는 데이터를, 실제 파일에 적는 작업, 반복문 작업
            for (Member member : members) {
                fw.write(member.toCSV() + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 추가사항4
    // 파일 불러오기 메서드(시작시 사용)
    // member.txt에서 한 줄씩 불러온 정보 하나씩 member 인스턴스로 변환
    // -> ArrayList<member> members라는 리스트에 담을 예정

    public static void loadFromFile() {
        // 파일이 존재하는지 확인
        File file = new File("member.txt");
        if (!file.exists())// 파일이 존재하지않으면 null반환
        {
            try {
                file.createNewFile(); // 물리적으로 파일 생성
                // 파일이 정상적으로 생성되었는지 확인할 수 있습니다.
                System.out.println("파일이 생성되었습니다: " + file.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
                // 파일 생성 실패 시 예외 처리
            }
        }
        // 파일이 있다면 문자 기반으로 읽고 -> 버퍼에 담아서 작업
        // 파일 입출력, try ~ catch , try ~ resource사용
        // 1차 -> new Filereader(file) : 물리 파일의 내용을 문자 기반으로 읽기
        // 2차-> BufferedReader br = new BufferedReader(요기에 담기) : 버퍼로 읽기
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line; // member.txt파일에서 한 줄씩 읽을 내용을 임시로 담을 문자열
            // 한 줄의 멤버 정보를 member인스턴스로 생성 , ArrayList에 담는 과정
            while ((line = br.readLine()) != null) {
                Member member = Member.fromCSV(line);
                if (member != null) {
                    members.add(member);
                    userCount++;
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    // ==================================================================
    static final int MAX_USERS = 100; // 최대 회원 수

    // Member 클래스를 담아 둘 배열 생성. 크기는 동일하게 100명으로 정하기.
    // 변경1, 기존 배열 -> 컬렉션으로 변경,
    // 전
    // static Member[] members = new Member[MAX_USERS];
    // 후
    private static ArrayList<Member> members = new ArrayList<>();
    static int userCount = 0; // 현재 등록된 회원 수

    // 회원 추가 메서드
    public static void addUser(Scanner scanner) {
        if (userCount < MAX_USERS) { // 기본 유효성 체크
            System.out.println("이름을 입력하세요: ");
            String name = scanner.nextLine();

            System.out.println("이메일을 입력하세요: ");
            String email = scanner.nextLine();

            System.out.println("패스워드를 입력하세요: ");
            String password = scanner.nextLine();

            // 현재 날짜와 시간 저장
            String registrationDate = DateUtil.getCurrentDateTime();

            Member member = new Member(name, password, email, registrationDate);

            // 변경2. 기존 배열에서 추가 -> 컬렉션에서 추가
            // 전
            // members[userCount] = member;
            // 후
            members.add(member);

            // 회원 수 증가
            userCount++;
            System.out.println("회원이 추가되었습니다: " + name + ", " + email + ", " + registrationDate);
        } else {
            System.out.println("회원 수가 최대치를 초과했습니다.");
        }
        saveToFile();
    } // 회원 추가 메서드

    // 회원 조회 메서드
    public static void viewUsers() {
        if (userCount == 0) {
            System.out.println("등록된 회원이 없습니다.");
            return; // 등록된 회원이 없을 때, 조회 기능 종료, 메서드(함수)를 나가기
        }
        System.out.println("등록된 회원 목록:");

        // 변경3. 기존 배열에서 -> 컬렉션으로 수정.
        // 전
        // for (int i = 0; i < userCount; i++) {
        // members[i].showInfo();
        // }
        // 후
        for (int i = 0; i < members.size(); i++) {
            System.out.println("인덱스 번호 : " + i);
            members.get(i).showInfo();
        }

    } // 회원 조회 메서드

    // 회원 수정 메서드
    // 회원 전체 목록에서, 해당 회원의 인덱스를 번호를 이용해서, 회원 정보를 수정해보기.
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

        System.out.println("수정할 회원의 이메일을 입력하세요: ");
        String email = scanner.nextLine();

        System.out.println("수정할 회원의 패스워드를 입력하세요: ");
        String password = scanner.nextLine();

        // 현재 날짜와 시간 저장
        String registrationDate = DateUtil.getCurrentDateTime();

        // 변경할 정보를 담아둘 Member 객체 생성
        // 변경3-2 , 메모, new Member(); 이런 형식이 새로운 인스턴스를 생성하는 부분이라서,
        Member member = new Member(name, password, email, registrationDate);
        // 해당 인덱스에 수정된 회원 정보 저장

        // 변경4, 기존 member(0x100)에서,
        // 변경할 내용으로 수정이 된 새로운 member(0x200) 로 교체 작업
        // 전
        // members[index] = member;
        // 후
        members.set(index, member);

        System.out.println("회원 정보가 수정되었습니다: " + name + ", " + email + ", "
                + registrationDate);
        saveToFile();
    } // 회원 수정 메서드

    // 회원 삭제 메서드
    // 수정 처럼, 회원의 인덱스 번호를 입력시, 삭제하는 로직.
    public static void deleteUser(Scanner scanner) {
        System.out.println("삭제할 회원의 인덱스를 입력하세요 (0 ~ " + (userCount - 1) + "): ");
        int index = scanner.nextInt(); // 삭제할 회원의 인덱스 입력
        scanner.nextLine(); // 개행 문자 제거

        if (index < 0 || index >= userCount) {
            System.out.println("잘못된 인덱스입니다.");
            return; // 잘못된 인덱스를 입력시, 삭제 기능을 종료 한다는 의미.
        }
        // 변경5,
        // 전
        // Member member = members[index];
        // System.out.println("삭제할 회원 정보: ");
        // member.showInfo(); // 회원 정보 출력

        // members[index] = null; // 해당 인덱스의 회원 정보 삭제
        // for (int i = index; i < userCount - 1; i++) {
        // members[i] = members[i + 1]; // 다음 인덱스의 회원 정보를 현재 인덱스로 이동
        // }
        // members[userCount - 1] = null; // 마지막 인덱스의 회원 정보 삭제
        // 후
        // 기존 삭제 할 회원 정보를 가져오기
        Member member = members.get(index);
        System.out.println("삭제할 회원 정보 : ");
        member.showInfo();
        // 삭제,
        members.remove(index);

        // 회원 수 감소
        userCount--;
        System.out.println("회원이 삭제되었습니다.");
        saveToFile();
    }
    // 회원 삭제 메서드

    // 회원 더미 데이터 5개 추가하는 메서드
    public static void addDummyUsers() {
        for (int i = 0; i < 5; i++) {
            if (userCount < MAX_USERS) {
                Member dummyMember = new Member(
                        "더미회원" + (i + 1),
                        "password" + (i + 1),
                        "dummy" + (i + 1) + "@example.com",
                        DateUtil.getCurrentDateTime());
                // 변경6,
                // 전
                // members[userCount] = dummyMember;
                // 후
                members.add(dummyMember);
                userCount++;
                saveToFile();
            } else {
                System.out.println("더미 회원 추가 실패: 최대 회원 수 초과");
                break;
            }
        }
        System.out.println("더미 회원 5명이 추가되었습니다.");
    }
    // 회원 더미 데이터 5개 추가하는 메서드

    // 검색 기능
    // 회원 목록에서 이름 또는 이메일로 검색하는 기능을 추가할 수 있습니다.
    public static void searchUser(Scanner scanner) {
        System.out.println("검색할 회원의 이름 또는 이메일을 입력하세요: ");
        String searchQuery = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < userCount; i++) {
            // 변경7
            // 전
            // if (members[i].getName().contains(searchQuery) ||
            // members[i].getEmail().contains(searchQuery)) {
            // members[i].showInfo(); // 회원 정보 출력
            // found = true;
            // }
            // 후
            if (members.get(i).getName().contains(searchQuery) ||
                    members.get(i).getEmail().contains(searchQuery)) {
                System.out.println("검색 결과 ");
                members.get(i).showInfo();
                found = true;
            }
        }

        if (!found) { // 검색 결과가 있을 경우, 실행이 안됨, found = true; -> false;
            System.out.println("검색 결과가 없습니다.");
        }
    }
    // 검색 기능
}
