package d250612.ch9;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingUI_Test_EX2 {
    public static void main(String[] args) {
        // JFrame 틀 안에 버튼도 추가하기
        JFrame frame = new JFrame("버튼 테스트");
        JButton button = new JButton("Click Me!");
        frame.add(button);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}
