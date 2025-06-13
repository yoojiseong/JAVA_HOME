package util.Random;

public class RandomUtil {
    // 설계 클래스
    // Math클래스에 있는 random()메소드
    public static double generateRandom() {
        double randomValue = Math.random();
        return randomValue;
    }

    // 특정 범위의 정수형 난수를 생성 1~10
    public static int generateRandomInt(int min, int max) {
        int randomValue = (int) (Math.random() * (max - min + 1)) + min;
        return randomValue;
    }

    // 랜덤한 숫자를 생성하는 기능.
    // 퀴즈1
    // 로또 번호를 생성하는 기능을 만들기.
    // 아직 배열 안배워서, 각각의 6자리 숫자를 따로 받아서,
    // 출력만 한번에 생성하는 기능으로,
    // 정적 메소드를 만들어서, 출력 문장에서, 랜덤 숫자 6개 보여주기 형식으로 하기.
    // 출력문 모양: 이상용의 자동 로또 번호 생성기 사용한 번호 : 1, 20 ,30, 11, 17 ,45
    // 조건문을 활용해서, 중복된 숫자가 발생 안하게끔 , 해보기
    public static void rotto() {
        int n1, n2, n3, n4, n5, n6;
        n1 = generateRandomInt(1, 45);

        do {
            n2 = generateRandomInt(1, 45);
        } while (n2 == n1);
        do {
            n3 = generateRandomInt(1, 45);
        } while (n3 == n1 || n3 == n2);
        do {
            n4 = generateRandomInt(1, 45);
        } while (n4 == n1 || n4 == n2 || n4 == n3);
        do {
            n5 = generateRandomInt(1, 45);
        } while (n5 == n1 || n5 == n2 || n5 == n3 || n5 == n4);
        do {
            n6 = generateRandomInt(1, 45);
        } while (n6 == n1 || n6 == n2 || n6 == n3 || n6 == n4 || n6 == n5);

        System.out.println("내가 생성한 번호 : "
                + n1 + "," + n2 + "," + n3 + "," + n4 + "," + n5 + "," + n6);
    }
}
