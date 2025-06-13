package d250612.web_structure.ui;

import javax.swing.*;
import java.awt.*;

// 인트로 화면을 약 3초 보여주고 메인 화면으로 자동 전환
public class _2IntroFrame extends JFrame { // JFrame부모 클래스를 상속 받아서 기능이 많아짐
    // 실행 클래스 아니라, 설계 클래스 이므로
    // 생성자에 필ㅇ한 기능을 넣고
    // 클래스의 기본 생성자를 호출(인스턴스 생성시 동작 하게끔 하는 원리)
    public _2IntroFrame() {
        // JFrame frame = new JFrame("창의제목 작성")
        // 이거 안해도 됨 JFrame상속 받아서
        setTitle("인트로 화면 예시");
        setSize(400, 200);
        setLocationRelativeTo(null);// 화면 중앙 배치 기능

        // 안내 문구 표시
        JLabel label = new JLabel("환영합니다. 3초후 메인으로 이동합니다.", JLabel.CENTER);
        // 프레임에 붙이기
        add(label);
        // 화면에 보이게 하기
        setVisible(true);

        // 3초 후, 다른 화면으로 이동하는 기능, 타이머 기능 사용
        // Timer timer = new Timer(3000,1)내부클래스 2) 익명 3)람다식)
        Timer timer = new Timer(3000,
                e -> {
                    new _3MainFrame();// 메인 화면 생성, 해당 클래스의 기본 생성자 호출
                    // 현재 화면 닫기
                    dispose();
                });
        timer.setRepeats(false);
        timer.start();
    }

}
