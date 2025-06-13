package d250612.ch9;

import javax.swing.JButton;
import javax.swing.JFrame;

//람다식(Lambda Expression)
//자바 8 이후부터 등장
// 함수형 인터페이스(메서드가 1개인 경우에만 사용가능)
//기본 구조
// 버튼.addActionListener(1)내부 클래스, 2) 익명 클래스 3)화살표 함수)
public class InnerClass_Anonymous_Lambda3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("람다시 표현으로 이벤트 처리");
        JButton button = new JButton("닫기");

        // 이벤트 작업, 버튼에 이벤트 기능 탑제
        button.addActionListener(e -> frame.dispose());
        frame.add(button);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
