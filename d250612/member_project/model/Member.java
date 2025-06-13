package d250612.member_project.model;

// 변경 사항,
// 기존 1) 메모리 상에서 데이터를 임시로 저장, 배열 -> 컬렉션(AraayList, HashMap)
// 변경 -> 파일 형식으로 데이터를 저장, 불러오기 작업
// 파일 형식 : member.txt -> 실제 구조는 csv(,기준으로 데이터 구분) 파일 형식임
// csv 예시) 이름 ,이메일, 패스워드, 등록날짜
// 회원 관리 프로그램 시작 -> 파일에서 데이터 불러온 후 -> 
// 임시로 ArrayList 저장 -> 추가 수정 삭제 -> 파일에 저장 
// 주석, 추가 사항 1 형식으로 라벨링 작업.
public class Member {
    String name;
    String password;
    String email;
    String regDate;

    // ==================================================================
    // 추가사항1,
    // 회원의 정보 내용을 csv 형식으로 문자열 반환 기능.
    // 멤버 정보, ex) 유지성,1234,유지성@naver.com,2025-06-12 12:00:00
    public String toCSV() {
        return name + "," + password + "," + email + "," + regDate;
    }

    // 추가사항2
    // 매개변수의 정보 : 멤버 정보
    // 한 줄의 멤버 정보를 ex) 유지성,1234,유지성@naver.com,2025-06-12 12:00:00]
    // Member인스턴스를 생성하는 재료로 사용하기
    // 매개변수가 4개인 인스턴스를 생성
    public static Member fromCSV(String csvLine) {
        String[] parts = csvLine.split(",", -1); // -1 ->데이터가 없어도 형태를 유지 (정보가 4개인 형태를 유지)
        // parts = {"유지성","1234","유지성@naver.com","2025-06-12 12:00:00"}
        if (parts.length != 4) {
            return null;
        }
        return new Member(parts[0], parts[1], parts[2], parts[3]);
        // 이름 패스워드 이메일 등록 시간
    }

    // ==================================================================
    public Member(String name, String password, String email, String regDate) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.regDate = regDate;
    }

    public void showInfo() {
        System.out.println("회원 이름 : " + this.name);
        System.out.println("회원 이메일 : " + this.email);
        System.out.println("회원 패스워드 : " + this.password);
        System.out.println("회원 등록일 : " + this.regDate);
    }

    public String getName() {
        return name;
    }

    // 이메일 조회 기능, 게터 getter
    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    // 나머지 맴버, 이름, 이메일, 패스워드, 등록일 각가의 세터 / 게터 모두 만들기.
}
