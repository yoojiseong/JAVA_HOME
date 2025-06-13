package d250612.ch9;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.*;

public class SwingUI_Test_EX5 {
    public static void main(String[] args) {
        // 프레임안에 닫기 버튼 추가해서 이벤트 처리를 클릭시 (event handler),닫기 기능 구현
        JFrame frame = new JFrame("이벤트 핸들러");
        JButton button = new JButton("닫기");
        // 이벤트 리스너 작업
        // 방법1) 내부 클래스
        // 방법2) 익명 클래스
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Jㄹrame.Exit_ON_CLOSE : 프로그램 자체 종료
                // DISPOSE_ON_CLOSE : 현재 창만 닫기 위해서
                frame.dispose();
                // 창 종료 후 메모리에서 자원 해제
            }
        });
        frame.add(button);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // 방법3) 람다시(화살표 함수)
    }
}
