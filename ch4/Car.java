package ch4;

public class Car {
    // 객체 : 클래스로부터 만들어진 실체(=인스턴스)
    // 생성자 : 객체 생성시 자동으로 호출되는 메서드
    String model; // 차종, 세단, SUV 등
    String price;// 가격
    String company; // 제조사

    public void showInfo() {
        System.out.println("모델: " + model);
        System.out.println("가격: " + price);
        System.out.println("제조사: " + company);
    }
}
