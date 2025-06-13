package d250612.ch9;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;

//익명 클래스
// 이름이 없는 클래스
//보통 객체 생성시 new 클래스명()
// new 인터페이스명()
public class InnerClass_Anonymous_Lambda2 {
    public static void main(String[] args) {

        JFrame frame = new JFrame("익명클래스 예시");
        JButton button = new JButton("닫기");

        // 내부 클래스는

        // 익명 클래스 할당 부분
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        frame.add(button);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
