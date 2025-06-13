package d250612.ch9;

import javax.swing.*; // JFrame, JButton 등
import java.awt.event.*; // ActionListener, ActionEvent

public class InnerClass_Anonymous_Lambda {
    JFrame frame = new JFrame("내부클래스 옛;");
    JButton button = new JButton("닫기");

    // 생성자,
    public InnerClass_Anonymous_Lambda() {
        // 버튼에 이벤트 리스너 붙이기
        button.addActionListener(new SampleListener());
        // 화면에 버튼 붙이기 작업,
        frame.add(button);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // 배누에 또 다른 클래스 정의
    class SampleListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // 이벤트 기능, 닫기 기능
            frame.dispose();
        }
    }

    public static void main(String[] args) {
        new InnerClass_Anonymous_Lambda();
    }
}
