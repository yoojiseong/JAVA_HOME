
package ch2;
//Scanner : 자바에서 사용자의 입력을 받는 방법

// 자주 사용하는 메서드 , next(), nextLine(), nextInt(), Nextdouble()
// next() : 공백 전 까지 문자열 입력,
// 예시) " 홍 길 동 -> next로 가져온 문자열은 '홍'임"
// nextLine() : 한 줄 전체를 문자열로 입력, 
//예시) " 홍 길 동 -> nextLine로 가져온 문자열은 "홍 길 동
// nextInt() : 정수 입력]
// nextBoolean() : 불리언 입력
// hasNext() : 다음에 입력할 값이 있는지 확인하는 메서드

import java.util.Scanner;

//기본 문법: 
//1.import java.util.Scanner;
//2.Scanner scanner = new Scanner(System.in);
//3.String name = scanner.nextLine();
public class Scannertest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);

        // System.out.println("이름을 입력하세요 : ");
        // String name = scanner.nextLine();
        // System.out.println("입력한 이름 : " + name);

        // // 퀴즈
        // // 본인이 좋아하는 숫자 입력받아보기
        // System.out.println("좋아하는 숫자를 입력하시오 : ");
        // int favorite = scanner.nextInt();
        // System.out.println("당신이 좋아하는 숫자는 : " + favorite + "입니다");

        // 퀴즈2번
        // 새로운 scannerTest2 클래스 만들기
        // 회원가입 해보기
        // consol에 출력 되는 내용
        // 유지성 홈피 회원가입
        // 이름 입력해주세요 >
        // 이메일 입력해주세요 >
        // 패스워드 입력해주세요 >
        // 출력 결과는
        // 이름 :
        // 이메일 :
        // 패스워드 :
        System.out.println("유지성 홈페이지 회원가입");
        System.out.println("이름을 입력해주세요 : ");
        String name = scanner2.nextLine();
        System.out.println("이메일 입력해주시요");
        String email = scanner2.nextLine();
        System.out.println("패스워드를 입력해주세요 : ");
        String password = scanner2.nextLine();
        System.out.println("출력 결과는");
        System.out.println("이름 : " + name);
        System.out.println("이메일 : " + email);
        System.out.println("패스워드 : " + password);

        // 위에서 입력 받는 내용이 전부 작업 후 맨 마지막에 실행
        scanner.close();

    }
}