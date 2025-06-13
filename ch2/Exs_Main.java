package ch2;

public class Exs_Main {
    public static void main(String[] args) {
        Exs.getIncDecExam();

        System.out.println("----------------------------");
        // 강제 형변환 예시
        Exs.getTypeExam();
        System.out.println("----------------------------");
        System.out.println("파이널 상수 이용한 원면적 구하기 예제");
        String result = Exs.getCircleArea(5.0);

        System.out.println(result);
        String result1 = Exs.getTernaryExam(75);
        System.out.println(result1);

        Exs.getnameFavorit();
    }

}
