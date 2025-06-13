package d250612.web_structure.ui;

import javax.swing.*;
import java.awt.*;

public class _3MainFrame extends JFrame {
    // 설계 클래스들은, 인스턴스를 이용해서 화면을 호출 하기 때문에
    // 실제 화면을 그리는 작업, 기본 생성자에서 작업을 한다.
    public _3MainFrame() {
        setTitle("메인 화면");
        setSize(400, 200);
        setLocationRelativeTo(null);// 화면의 중앙에 위치
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 회원가입 버튼 생성
        JButton signUpBtn = new JButton("회원가입");
        // 회원가입 버튼, 이벤트 작업, 클릭시 회원가입 화면으로 이동
        signUpBtn.addActionListener(e -> {
            new _4SignupFrame();
            dispose();
        });

        // 버튼을 패널에 추가, 프레임에 배치
        JPanel panel = new JPanel();
        panel.add(signUpBtn);
        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }
}
