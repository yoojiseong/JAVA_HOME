package d250609.ch4;

public class GetterSetterEx2Main {

    // 퀴즈1-1
    // 설계 클래스 만들기, 클래스명 : Member
    // 멤버 변수 : 1) name 2) email 3) password , private 지정,
    // 생성자 만들기
    // getter, setter 만들기. 하나씩 조회 및, 수정,
    // 조회는 : showInfo , 각 멤버 정보 호출하는 기능,
    // 수정 : changeNameEmailPassword : 메서드 이름으로 만들기.
    // 실행 후,
    // 1) 각 인스턴스 생성 3개 해보기 2) 각 인스턴스로 정보 출력, 3) 정보 변경 해보기.

    public static void main(String[] args) {
        GetterSetterEx2 getterSetterEx = new GetterSetterEx2("이상용", "lsy@naver.com", "1234");
        // public, 외부에서 직접 데이터에 접근.
        // 설계 클래스에서 -> name에 대해서, public -> private 변경함.
        // 직접 접근 , 수정이 불가.
        // getterSetterEx.name = "직접 접근해서 이름 수정 이상용"; // 직접 접근해서, 임의로 수정함.
        // private , 데이터 직접 접근을 막는다.
        // getterSetterEx.email = "lsy@naver.com 수정";
        // getterSetterEx.password = "password 수정";
        getterSetterEx.showInfo();
        System.out.println("Getter 라는 메서드를 이용해서, 각 멤버 변수 하나 조회 확인");
        System.out.println("이름 조회 : " + getterSetterEx.getName());
        System.out.println("이메일 조회 : " + getterSetterEx.getEmail());
        System.out.println("패스워드 조회 : " + getterSetterEx.getPassword());
        System.out.println("Setter 라는 메서드를 이용해서, 각 멤버 변수 값 설정 확인");
        getterSetterEx.setName("이상용 setter로 수정");
        getterSetterEx.setEmail("lsy@naver.com  setter로 수정");
        getterSetterEx.setPassword("123456  setter로 수정");
        System.out.println("Setter 를 이용해서, 데이터 변경하고, 값 확인. ");
        getterSetterEx.showInfo();
    }
}
