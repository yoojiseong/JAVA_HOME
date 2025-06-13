package d250612.web_structure.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.lang.reflect.Member;
import java.util.ArrayList;

public class _4SignupFrame extends JFrame {

    // 파일 불러오는 경로를 전역으로 설정.
    private static final String FILE_NAME = "member.txt"; // 회원 정보 저장 파일명
    // 파일에서 불러온 멤버의 모든 정보를 담아둘 임시 공간 리스트
    private ArrayList<Member> members = new ArrayList<>();

    // Swing 관련 변수
    // 전체 흐름
    // 테이블 구성 -> DefaultTableModel에 데이터 입력 -> JTable이 모델을 받아
    // 화면에 테이블로 출력
    // 테이블에서 수정,추가,삭제,검색하거나 tableModel 갱신됨.
    private DefaultTableModel tableModel; // Swing에서 테이블 데이터를 저장관리하는 모델 클래스
    // 셀 형식으로 UI보여줌
    private JTable memberTable; // Swing에서 표 형태(UI)의 테이블 컴포넌트

    // 검색 관련
    private JTextField searchField;// 검색어 입력
    private JButton searchBtn; // 검색 버튼
    private JButton resetBtn; // 검색 초기화 버튼
    // ==========================================================================================

    public _4SignupFrame() {
        setTitle("회원 가입");
        setSize(900, 500);
        setLocationRelativeTo(null);// 화면의 중앙에 위치
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // 테이블 작업=====================================================================
        // 1) 테이블 헤더 만들기. 이름, 이메일, 패스워드, 가입일
        String[] cols = { "이름", "이메일", "패스워드", "가입일" };
        // 헤더 제목을 tableModel에
        // String 배열로 입력 해줌 0은 빈 테이블을 생성한다 라는 뜻
        tableModel = new DefaultTableModel(cols, 0) { // 익명클래스
            public boolean isCellEditable(int row, int column) {
                return false; // 각 테이블의 셀 클릭시 값이 변경이 되는 모드인데
                // 기본으로 변경 불가 모드로 변경
            }
        };
        // 표 형태의 데이터를 -> 화면 출력용 테이블에 데이터 연결
        memberTable = new JTable(tableModel);
        // 보여주는 테이블에 데이터가 많아지면 스크롤 가능하게 하기
        // 스크롤 기능이 있는 패널에 테이블 연결한거임
        JScrollPane scrollPane = new JScrollPane(memberTable);

        // 버튼 패널 추가
        JPanel btnPanel = new JPanel(); // JPanel의 기본 배치 관리자는 FlowLayout -> 나란히 배치
        JButton addBtn = new JButton("회원가입");
        JButton updateBtn = new JButton("수정");
        JButton deleteBtn = new JButton("삭제");
        JButton reloadBtn = new JButton("새로고침");
        btnPanel.add(addBtn);
        btnPanel.add(updateBtn);
        btnPanel.add(deleteBtn);
        btnPanel.add(reloadBtn);

        // 검색 패널 추가
        JPanel searchPanel = new JPanel();
        searchField = new JTextField(20);
        searchBtn = new JButton("검색");
        resetBtn = new JButton("초기화");
        searchPanel.add(new JLabel("이름 또는 이메일 검색 : "));
        searchPanel.add(searchField);
        searchPanel.add(searchBtn);
        searchPanel.add(resetBtn);

        // 레이아웃 배치
        // 총 3개의 패널 1.스크롤 패널 , 2. 버튼 패널 , 3.검색패널
        setLayout(new BorderLayout());
        add(searchPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);

        // ==========================================================================================

        // 파일에서 데이터 불러오고, 테이블에 표시

        // 새로고침 기능

        // 각각의 버튼에 기능들을 붙이는 이벤트 핸들러 작업.

        // 안내 문구 표시
        // JLabel label = new JLabel("회원가입 화면 입니다.", JLabel.CENTER);
        // add(label);

    }
    // 각 기능 정의
    // 1) csv파일에서 회원 목록 불러오기 member.txt 메서드 이름 : loadMEmbersFromFile();

    // 2) 회원 목록을 CSV파일에 저장, saveMembersToFile();

    // 3) JTable에 회원 데이터 반영 (새로고침)

    // 4) 검색 결과 테이블에 반영

    // 5) 검색 기능 (이름 or 이메일), 검색 결과만 표기

    // 6) 회원가입 입력 폼은 자바버전으로 작업함

    // 7) 회원 수정 창

    // 8) 회원 삭제 기능.

    // =====================================================================================

}
