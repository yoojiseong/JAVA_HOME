package d250612.ch9_2;

import java.awt.*;
import javax.swing.*;

public class Container_Layout_Ex4 {
    public static void main(String[] args) {
        // BoarderLayout이용해서 북: 제목 , 중앙 JTextARea(5,20)
        // 남, 저장 버튼 배치 해보기.
        JFrame frame = new JFrame("BoarderLayout 예시");
        frame.setLayout(new BorderLayout());
        // 동서남북 중앙

        JLabel label = new JLabel("제목", SwingConstants.CENTER);
        frame.add(label, BorderLayout.NORTH);
        JTextArea textbox = new JTextArea(5, 20);
        frame.add(textbox, BorderLayout.CENTER);
        JButton button4 = new JButton("저장");
        frame.add(button4, BorderLayout.SOUTH);

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
