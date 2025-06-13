package d250612.ch9_2;

import java.awt.*;
import javax.swing.*;

public class Container_Layout_Ex5 {
    public static void main(String[] args) {
        // 패널 2개 생성, 각각 패널에 배치 관리자를
        // FlowLayout , GridLayout 적용하기
        // 북 : FlowLayout 중앙 : GridLayout

        JFrame frame = new JFrame("복합 패널 레이아웃 예시");
        JPanel northpanel = new JPanel(new FlowLayout());
        northpanel.add(new JButton("샘플버튼1"));
        northpanel.add(new JButton("샘플버튼2"));
        JPanel centerpanel = new JPanel(new GridLayout(2, 1));
        centerpanel.add(new JButton("샘플버튼4"));
        centerpanel.add(new JButton("샘플버튼3"));

        frame.setLayout(new BorderLayout());

        frame.add(northpanel, BorderLayout.NORTH);
        frame.add(centerpanel, BorderLayout.CENTER);

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
