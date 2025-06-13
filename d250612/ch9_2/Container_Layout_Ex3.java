package d250612.ch9_2;

import java.awt.*;
import javax.swing.*;

public class Container_Layout_Ex3 {
    public static void main(String[] args) {
        // GridLayout예시
        JFrame frame = new JFrame("GridLayou예시");
        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(2, 2));
        // 패널 버튼 4개 추가
        JButton button1 = new JButton("버튼북쪽");
        panel.add(button1);
        JButton button2 = new JButton("버튼남쪽");
        panel.add(button2);
        JButton button3 = new JButton("버튼동쪽");
        panel.add(button3);
        JButton button4 = new JButton("버튼서쪽");
        panel.add(button4);
        frame.add(panel);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
