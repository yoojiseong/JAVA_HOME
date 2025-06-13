package d250609.ch4;

public class MemberEx3QuizMain {
    public static void main(String[] args) {
        // 인스턴스 생성 3개 하기.
        MemberEx3Quiz memberEx3Quiz1 = new MemberEx3Quiz("이상용1", "lsy@naver.com", "1234");
        MemberEx3Quiz memberEx3Quiz2 = new MemberEx3Quiz("이상용2", "lsy2@naver.com", "1234");
        MemberEx3Quiz memberEx3Quiz3 = new MemberEx3Quiz("이상용3", "lsy3@naver.com", "1234");

        // 방금 만든 설계 클래스를 담을 배열 생성하기.
        // MemberEx3Quiz[] memberArray = new MemberEx3Quiz[3];
        MemberEx3Quiz[] memberArray = { memberEx3Quiz1, memberEx3Quiz2, memberEx3Quiz3 };

        // 반복문으로 담기
        // for (int i = 0; i < memberArray.length; i++) {
        // memberArray[i] = MemberTempArray[i];
        // }

        System.out.println("===============인스턴스 기본 생성 후 , 확인 해보기 ============================");
        // 각 인스턴스를 , 반복문 이용해서 출력 해보기.
        for (MemberEx3Quiz member : memberArray) {
            member.showInfo();
        }
        System.out.println("===============수정 후 , 확인 해보기 ============================");
        // 각 인스턴스 멤버의 변수를 한번에 3개 다 변경하는 메서드 이용해서 수정하고,
        // 다시 출력 해보기.
        memberEx3Quiz1.changeNameEmailPassword("수정1 이상용", "수정1lsy@naver.com", "수정1 1234");
        memberEx3Quiz2.changeNameEmailPassword("수정2 이상용", "수정2lsy@naver.com", "수정2 1234");
        memberEx3Quiz3.changeNameEmailPassword("수정3 이상용", "수정3lsy@naver.com", "수정3 1234");

        for (MemberEx3Quiz member : memberArray) {
            member.showInfo();
        }
    }
}
