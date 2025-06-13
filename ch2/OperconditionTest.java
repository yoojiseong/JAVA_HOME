package ch2;

public class OperconditionTest {
    public static void oper1() {
        // 1. 산술 연산자
        int a = 10;
        int b = 20;
        System.out.println("산술 연산자 테스트");
        System.out.println("a + b = " + (a + b)); // 덧셈
        System.out.println("a - b = " + (a - b)); // 뺄셈
        System.out.println("a * b = " + (a * b)); // 곱셈
        System.out.println("몫: b / a = " + (b / a)); // 나눗셈
        System.out.println("나머지: b % a = " + (b % a)); // 나머지
    }

    // 퀴즈 ,
    // 1) 여기에 임의의 산술 연산하는 기능의 정적 메서드 만들기. 메서드명 : oper2()
    // 2) 클래스명 : OperConditionTestMain, 여기에서 메서드명 : oper2( 1차 실행 확인
    // 3) 클래스명 : MainClass, 여기에 4번 메뉴로 추가하기
    // 4) MainClass에서 실행 확인하기
    public static void oper2() {
        int a = 30;
        int b = 20;
        System.out.println("산술 연산 테스트2");
        System.out.println("(a * b + a) / b" + ((a * b + a) / b));
    }

    public static void ConditionExample() {
        int number = 10;

        switch (number) {
            case 1:
                System.out.println("1입니다");
                break;
            case 0:
                System.out.println("0입니다");
                break;
            default:
                System.out.println("1,0둘 다 아닙니다");
                break;

        }
    }
}
