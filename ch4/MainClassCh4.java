package ch4;

public class MainClassCh4 {
    public static void main(String[] args) {
        // 설계한 클래스를 이용해서 객체 생성
        Car car1 = new Car();
        car1.model = "suv";
        car1.price = "4000만원";
        car1.company = "기아자동차";
        car1.showInfo();
        Car car2 = new Car();
        car2.model = "k5세단";
        car2.price = "3000만원";
        car2.company = "기아자동차";
        car2.showInfo();

        Radius radius1 = new Radius();
        radius1.radius = 2.4;
        radius1.height = 7;
        radius1.width = 5.1;
        radius1.getCircle();
        radius1.getRactangle();

        Radius radius2 = new Radius(3.0);
        Radius radius3 = new Radius(6.0, 5.6);
        Radius radius4 = new Radius(3.0, 4.0, 5.0);
        radius2.getCircle();
        radius3.getRactangle();
        radius4.getCircle();
        radius4.getRactangle();

        // 객체를 배열로 선언
        Phone[] phones = new Phone[5];
        phones[0] = new Phone("갤럭시 S21", "100만원", "삼성전자");
        phones[1] = new Phone("Iphone 15pro", "150만원", "Apple");
        phones[2] = new Phone("Samsung Galaxy Z Flip", "120만원", "삼성전자");
        phones[3] = new Phone("LG Velvet", "80만원", "LG전자");
        phones[4] = new Phone("Google Pixel 6", "90만원", "구글");


        


        Phone[] phone_array = new Phone[3];
        phone_array[0] = new Phone("갤럭시 S21", "100만원", "삼성전자");
        phone_array[1] = new Phone("Iphone 15pro", "150만원", "Apple");
        phone_array[2] = new Phone("Samsung Galaxy Z Flip", "120만원", "삼성전자");

        System.out.println("폰 정보 출력");
        for (int i = 0; i < phones.length; i++) {
            phones[i].showInfo();
        }
        System.out.println("각 맴버 주소값");
        for (int i = 0; i < phone_array.length; i++) {
            System.out.println("phone_array[" + i + "] 주소값 : " + phone_array[i]);
        }

    }
}
