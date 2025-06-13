package ch4;

public class Phone {
    String model;
    String prcie;
    String company;

    public Phone() {
        this.model = "갤럭시 S21";
        this.prcie = "100만원";
        this.company = "삼성전자";
    }

    public Phone(String model, String prcie, String company) {
        this.model = model;
        this.prcie = prcie;
        this.company = company;
    }

    public void showInfo() {
        System.out.println("모델명 : " + this.model);
        System.out.println("가격 : " + this.prcie);
        System.out.println("제조사 : " + this.company);
    }

    public Phone(String model, String price) {
        this.model = model;
        this.prcie = price;
        this.company = "회사 모름"; // 기본값으로 삼성전자 설정
    }

}
