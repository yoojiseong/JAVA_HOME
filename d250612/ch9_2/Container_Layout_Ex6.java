package d250612.ch9_2;

import java.awt.*;
import javax.swing.*;

//BorderLayou이용
//북 : 회원가입 JLabel붙이고
// 중앙: 2x2 GridLayout JLabel ("아이디")
public class Container_Layout_Ex6 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("회원가입 간단구조 예시");
        // 북, 회원가입 라벨 붙이기

        frame.setLayout(new BorderLayout());

        frame.add(new JLabel("회원가입", SwingConstants.CENTER), BorderLayout.NORTH);

        JPanel centerpanel = new JPanel(new GridLayout(2, 2));
        centerpanel.add(new JLabel("아이디"));
        centerpanel.add(new JTextField(20));
        // centerpanel.add(new JLabel("이메일"));
        // centerpanel.add(new JTextField(20));
        centerpanel.add(new JLabel("페스워드"));
        centerpanel.add(new JPasswordField(20));

        frame.add(new JButton("가입"), BorderLayout.SOUTH);
        frame.add(centerpanel, BorderLayout.CENTER);

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
