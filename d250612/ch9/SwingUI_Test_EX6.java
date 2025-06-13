package d250612.ch9;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SwingUI_Test_EX6 {
    public static void main(String[] args) {
        // 이름 입력이라는 라벨, 텍스트 필드(JTextField)
        JFrame frame = new JFrame("이름 입력 필드 예시");
        JPanel panel = new JPanel();
        JLabel label = new JLabel("이름 입력");
        JTextField textfield = new JTextField(10);
        panel.add(label);
        panel.add(textfield);
        frame.add(panel);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
