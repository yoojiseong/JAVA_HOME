package d250612.ch9;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.*;

public class SwingUI_Test_EX7 {
    public static void main(String[] args) {
        // JTextArea 여러줄 입력 받을 수 있는 창
        // 저장 버튼 클릭시, 콘솔에 출력

        JFrame frame = new JFrame("메모를 입력시 콘솔에 출력하는 프로그램");
        // 여러줄 입력 가능한 UI , JTextArea 객체 생성,
        JTextArea textarea = new JTextArea(10, 30);// 10줄 가로 30글자
        JButton button = new JButton("저장");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(textarea.getText());
            }
        });
        JPanel panel = new JPanel();
        // 페널에 텍스트 영역 추가시 범위를 넘어감녀 스크롤이 생기는 기능 추가.

        panel.add(new JScrollPane(textarea));
        panel.add(button);
        frame.add(panel);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
