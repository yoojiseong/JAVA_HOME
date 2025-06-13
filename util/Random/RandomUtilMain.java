package util.Random;

public class RandomUtilMain {
    public static void main(String[] args) {
        System.out.println("난수 : " + RandomUtil.generateRandom());
        System.out.println("정수형 난수 : " + RandomUtil.generateRandomInt(1, 45));
        RandomUtil.rotto();
        // 퀴즈
        // 로또 번호를 생성하는 기능 만들기
    }
}
