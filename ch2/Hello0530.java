package ch2;

public class Hello0530 {
    public static void main(String[] args) {
        System.out.println("Test~~출력");
        // 만들었던 클래스를 불러와서, 재사용 해보기
        // 본인 소개 및 간단 계산 해보기
        // 본인 소개
        Introduce.print("유지성", "코딩", "오버워치");

        // introduce클래스에 정의한 사칙연산 메소드를 이용해서, 각각 계산 겨로가를
        // result1,2,3,4변수에 담아서 출력해보기
        int result1 = Introduce.sum(10, 20);
        int result2 = Introduce.minus(20, 30);
        int result3 = Introduce.multiply(10, 4);
        double result4 = Introduce.div(45.0, 9.0);

        System.out.println("더하기 : " + result1);
        System.out.println("빼기 : " + result2);
        System.out.println("곱하기 : " + result3);
        System.out.println("나누기 : " + result4);
    }
}
