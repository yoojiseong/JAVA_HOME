package d250612.ch9_2;

import java.awt.*;
import javax.swing.*;

public class Container_Layout_Ex2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BoarderLayout 예시");
        frame.setLayout(new BorderLayout());
        // 동서남북 중앙
        JButton button1 = new JButton("버튼북쪽");
        frame.add(button1, BorderLayout.NORTH);
        JButton button2 = new JButton("버튼남쪽");
        frame.add(button2, BorderLayout.SOUTH);
        JButton button3 = new JButton("버튼동쪽");
        frame.add(button3, BorderLayout.EAST);
        JButton button4 = new JButton("버튼서쪽");
        frame.add(button4, BorderLayout.WEST);
        JButton button5 = new JButton("버튼 중앙");
        frame.add(button5, BorderLayout.CENTER);

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
