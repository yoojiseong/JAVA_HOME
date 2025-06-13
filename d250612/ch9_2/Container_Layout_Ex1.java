package d250612.ch9_2;

import java.awt.*;

//컨테이너
// 버튼, 라벨, UI를 담는 도화지
import javax.swing.*;

//배치 관리자(LayoutManager)
// 정렬을 어떻게 할건지 웹 : flex -> 자동으로 나란히 배치, 
// grid -> 지정한 행과 열 형태로 배치
// 종류 : FlowLayout(flex) , BoarderLayout(동,서,남,북,중앙), GridLayout(Grid)

//기본 문법
// 1) 패널 만들기 2) 컴포넌트 추가(버튼 패널) 3) 패널 -> 프레임(윈도우창)에 붙이기 작업
// JPanel panel = new JPanel();
// panel.setLayout(배치ㅗ간리자 인스턴스 생성)
// panel.setLayout(new FlowLayout()) FlowLayout배치 관리자 선택, 기능 : 나란히 배치
// panel.add(button)
// 프레임 -> 패널 붙이기

// 자주 사용하는 옵션
//setLayout(LayoutManager manager), ex) new FlowLayout() , new BoarderLayout() , new GridLayout()
// add(Component comp) : 버튼 추가
//add (Component comp, Object constraints) : 특정 위치에 배치
public class Container_Layout_Ex1 {
    public static void main(String[] args) {

        JFrame frame = new JFrame("FlowLayout 예시");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JButton button1 = new JButton("샘플버튼1");
        JButton button2 = new JButton("샘플버튼2");
        JButton button3 = new JButton("샘플버튼3");
        JButton button4 = new JButton("샘플버튼4");
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        frame.add(panel);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
