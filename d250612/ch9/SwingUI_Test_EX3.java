package d250612.ch9;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class SwingUI_Test_EX3 {
    public static void main(String[] args) {
        // 라벨 붙이기
        JFrame frame = new JFrame("라벨 붙이기 예시");
        JLabel label = new JLabel("Hello 스윙의 JLabel");
        // 프레임에 라벨 붙이기
        frame.add(label);

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
