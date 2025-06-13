package ch4;

public class PhoneMain {
    public static void main(String[] args) {
        Phone phone1 = new Phone();
        phone1.model = "갤럭시 S21";
        phone1.prcie = "100만원";
        phone1.company = "삼성전자";
        phone1.showInfo();

        // 2번째 객체
        Phone phone2 = new Phone("Iphone 15pro", "150만원", "Apple");
        phone2.showInfo();

        Phone phone4 = new Phone("Samsung Galaxy Z Flip", "120만원");
        phone4.company = "삼성전자"; // 기본값으로 삼성전자 설정
        phone4.showInfo();
    }
}
