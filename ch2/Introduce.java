package ch2;

//public : 접근 지정자, 파란색으로 표기 되는 부분은 예약어
//변수 명으로 사용 안됨
// 파일명.java -> 파일명 = 클래스명, 주의사항, 클래스 명 시작은 대문자
//특수문자는 _,$와 이용가능
//패키지명, 변수명, 함수명(메소드) 소문자로 시작
public class Introduce {// class : 변수, 상수, 함수 기능들의 묶음
    // static : 정적 자원, 공유 자원 인스턴스 개념과 구분해서 이해
    public static int sum(int n, int m) {
        return n + m;
    }

    public static int multiply(int n, int b) {
        return n * b;
    }

    public static int minus(int a, int b) {
        if (a >= b) {
            return a - b;
        } else
            return b - a;
    }

    public static double div(double a, double b) {
        if (a > b)
            return a / b;
        else
            return b / a;
    }

    public static void print(String name, String number, String email) {
        System.out.println("저는 " + name + " 입니다");
        System.out.println("제 전화번호 : " + number + " 이고");
        System.out.println("이메일 : " + email + " 입니다.");
    }

    public static void print_hoby(String food, String hobby, String game) {
        System.out.println("제가 좋아하는 음식은 : " + food + "입니다.");
        System.out.println("제 취미 : " + hobby + "이고,");
        System.out.println("좋아하는 게임 : " + game + "입니다.");
    }

    // public : 접근 지정자, 누구나 다 접근이 된다
    // static : 공유 자원의 의미
    // void : 반환갑싱 없다는 으미ㅣ
    // main : 함수 이름, 메인 함수에서 실행해서 메인으로 종료함
    // String[]args : 무자열 타입
    // [] : 배열을 의미
    // args , 배열의 이름(변경 가능)
    public static void main(String[] args) {
        int result = sum(100, 200);
        System.out.println("sum이라는 함수 이용해서 결과 출력 : " + result);
        int i = 20;
        int s;
        char a;

        s = sum(i, 10);
        a = '?';

        System.out.println(a);
        System.out.println("hello");
        System.out.println(s);

        // 퀴즈
        // 정적 메소드 하나 만들어서 곱하기 기능
        // result2에 담아서 출력
        int result2 = multiply(100, 200);
        System.out.println("두 개의 숫자를 곱하는 함수 : " + result2);

        // 퀴즈2
        // 빼기
        int result3 = minus(200, 100);
        System.out.println("두 개의 숫자를 빼는 함수 : " + result3);

        // 퀴즈3
        // 정적 메소드 하나 ㅁ나들어서 나누기 기능만들고 result에 담아서 출력
        double result4 = div(345.0, 45.0);
        System.out.println("두 개의 숫자 나누기 : " + result4);

        int t;
        char q;
        t = 100;
        q = 'd';
        System.out.println("정수 표현 : " + t);
        System.out.println("문자 표현 : " + q);

        // 퀴즈
        // 본인의 이름과, 전화번호, 이메일을 입력 받는 매개변수가 3개이고
        // 출력값 저는{이름{입니다}
        // 제 전화번호 : 전화번호 이고
        // 이메일 : 이메일 입니다

        String name = "유지성";
        String phonenumber = "010-5525-5273", email = "yujiseong588@gmail.com";

        print(name, phonenumber, email);
    }
}
