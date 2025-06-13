package d250612.ch9;
// 자바 버전으로 GUI(그래픽 유저 인터페이스)

// HTML화면구성 처럼 데스크톱 화면 구성.
// 실제로 실무에서 Swing UI 도구를 많이 사용함
// javax.swing 패키지(클래스들의 모음집)
// 기본이 되는 클래스 : JFrame, JPanel, JButton

import javax.swing.JFrame;

//JFrame 
//: 프로그램의 기본 윈도우창
// setTitle(String title) : 창의 제목 설정
// setSize(int width, int height) : 창의 크기
// setDefaultCloseOepration(int op) : 창을 닫을 때 동작 설정
// setvisible(boolean b) : 창 보이기, 숨기기

// JButton
// setText(String text) : 버튼에 표시되는 텍스트

// JLabel : 텍스트나 이미지를 표시하는 컴포넌트
public class SwingUI_Test_EX1 {
    public static void main(String[] args) {
        // 기본 윈도우 창 생성
        JFrame frame = new JFrame("Hello GUI 창 제목");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
