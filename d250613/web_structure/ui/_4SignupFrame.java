package d250613.web_structure.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import d250613.member_project.model.Member;
import d250613.member_project.util.DateUtil;

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
    private void loadMembersFromFile() {
        members.clear();
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("새로운 파일 생성 : " + FILE_NAME);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "파일 생성 오류 : " + e.getMessage());

                return;
            }
        }
        // 파일 있는 경우 members에서 한 줄씩 읽어오기
        // Member클래스에 객체를 만들고 저장하기
        // 파일 읽기 작업, 반드시 try-catch작업 하기
        // 한 바이트씩 읽기보다는 버퍼에 담아서 작업하면 성능이 좋음
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                Member member = Member.fromCSV(line);
                if (member != null) {
                    members.add(member);
                }
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    // 2) 회원 목록을 CSV파일에 저장, saveMembersToFile();
    private void saveMembersToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Member member : members) {
                bw.write(member.toCSV());
                bw.newLine();
            }

        } catch (Exception e) {
            // 오류 발생시 간단히 알림창 띄우기
            JOptionPane.showMessageDialog(this, "파일 저장 오류 : " + e.getMessage());
        }
    }

    // 3) JTable에 회원 데이터 반영 (새로고침)
    private void refreshTable() {
        tableModel.setRowCount(0); // 기존 데이터 모두 제거, 모든 행 삭제,
        for (Member member : members) {
            // tableModel 에, 데이터 쓰기, 기본 데이터 테이블 데이터를 쓰고, -> 출력용 테이블 연결하기.
            tableModel.addRow(new Object[] {
                    member.getName(), member.getEmail(), member.getPassword(), member.getRegDate()
            });
        }
    }

    // 4) 검색 결과 테이블에 반영
    private void showSearchResults(ArrayList<Member> results) {
        tableModel.setRowCount(0);
        for (Member member : results) {
            // tableModel 에, 데이터 쓰기, 기본 데이터 테이블 데이터를 쓰고, -> 출력용 테이블 연결하기.
            tableModel.addRow(new Object[] {
                    member.getName(), member.getEmail(), member.getPassword(), member.getRegDate()
            });
        }
    }

    // 5) 검색 기능 (이름 or 이메일), 검색 결과만 표기
    private void searchMembers() {
        // 검색어 입력창에서, 검색어를 가져오기, 양쪽 공백 제거, 영어 인경우 모두 소문자로 변경하고
        String query = searchField.getText().trim().toLowerCase();
        // 유효성 체크. 검색어 비어 있는지 체크.
        if (query.isEmpty()) {
            refreshTable(); // 기본 전체 조회가 실행이 됨.
            return;// 검색 기능 메서드 나가기,
        }
        // 임시로 담아둘 멤버 리스트 하나 정의.
        ArrayList<Member> resultList = new ArrayList<>();
        // members : 파일에서 읽어서, 담아둔 임시 전체 멤버 리스트,
        // resultList, 아래 반복문에서, 검색어 일치하는 멤버들만 담을 공간.
        for (Member member : members) {
            if (member.getName().toLowerCase().contains(query) ||
                    member.getEmail().toLowerCase().contains(query)) {
                resultList.add(member);
            }
        }
        // 검색 된 결과를, 화면에 출력하는 메서드에, 검색된 멤버 리스트를 넘겨주기.
        showSearchResults(resultList);

        // 검색된 결과가 없다면, 알림창으로 검색 결과가 없습니다.
        if (resultList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "검색 결과가 없습니다.");
        }

    }

    // 6) 회원가입 입력 폼은 자바버전으로 작업함
    private void showAddDialog() {
        JTextField nameField = new JTextField("10글자 미만", 10);
        JTextField emailField = new JTextField("15글자 미만", 15);
        JTextField passwordField = new JTextField("10글자 미만", 10);

        // 그리드 레이아웃으로 2열짜리 배치작업 하기
        // 행(rows)을 0으로 설정하면 자동생성됨
        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.add(new JLabel("이름 : "));
        panel.add(nameField);
        panel.add(new JLabel("이메일 : "));
        panel.add(emailField);
        panel.add(new JLabel("패스워드 : "));
        panel.add(passwordField);

        // 회원가입 버튼을 누를 경우 확인 알림창 띄우기
        // 확인을 누르면 JOptionPane.showConfirmDialog() -> 특정 값 반환
        // 수락-> JOptionPane.OK_OPTION (정수값 전달)
        int result = JOptionPane.showConfirmDialog(
                this, // 알림창을 이 창에 띄우게 this : 현재 윈도우창
                panel, // 사용자에게 보여줄 컨텐츠(JPanel)
                "회원 가입", // 알림 창의 제목
                JOptionPane.OK_CANCEL_OPTION, // 확인, 취소 버튼을 구성하는 옵션
                JOptionPane.PLAIN_MESSAGE);// 아이콘이 없는 일반 메시지 형식의 알림창을 의미함 => 기본 알림창

        if (result == JOptionPane.OK_OPTION) {
            // 화면에서 입력창에 입력 했던 데이터 들을 다 가지고 와서, 임의의 변수를 담고
            // Member 클래스 형식으로 인스턴스 만들고, 리스트 members추가하고
            // ㅠ파일에 쓰기
            String name = nameField.getText().trim(); // 텍스트 가져오고 양쪽 공백 제거
            String email = emailField.getText().trim();
            String password = passwordField.getText().trim();
            String regDate = DateUtil.getCurrentDateTime();
            // 값 입출력 할때는 유효성 체크
            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "모든 항목을 입력해주세요");
                // 롤백 설정 필요
                return;
            }
            Member member = new Member(name, password, email, regDate);
            members.add(member);
            saveMembersToFile();
            // 변경사항 새로고침, 즉 다 지우고 전체 회원을 다시 그리기.
            refreshTable();
        }
    }

    // 7) 회원 수정 창
    private void showUpdateDialog() {

        // 테이블 상에서 선택된 행의 번호를 가져와서 수정하는 작업
        int row = memberTable.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "수정할 회원을 선택하세요.");
            return;
        }

        // 전체 회원 목록 리스트에서 해당 회원 정보 가져오기
        Member oldmember = members.get(row);

        // 회원 정보 불러오기
        JTextField nameField = new JTextField(oldmember.getName(), 10);
        JTextField emailField = new JTextField(oldmember.getEmail(), 15);
        JTextField passwordField = new JTextField(oldmember.getPassword(), 10);

        // 그리드 레이아웃으로 2열짜리 배치작업 하기
        // 행(rows)을 0으로 설정하면 자동생성됨
        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.add(new JLabel("이름 : "));
        panel.add(nameField);
        panel.add(new JLabel("이메일 : "));
        panel.add(emailField);
        panel.add(new JLabel("패스워드 : "));
        panel.add(passwordField);

        // 회원수정 버튼을 누를 경우 확인 알림창 띄우기
        // 확인을 누르면 JOptionPane.showConfirmDialog() -> 특정 값 반환
        // 수락-> JOptionPane.OK_OPTION (정수값 전달)
        int result = JOptionPane.showConfirmDialog(
                this, // 알림창을 이 창에 띄우게 this : 현재 윈도우창
                panel, // 사용자에게 보여줄 컨텐츠(JPanel)
                "회원 정보 수정", // 알림 창의 제목
                JOptionPane.OK_CANCEL_OPTION, // 확인, 취소 버튼을 구성하는 옵션
                JOptionPane.PLAIN_MESSAGE);// 아이콘이 없는 일반 메시지 형식의 알림창을 의미함 => 기본 알림창

        if (result == JOptionPane.OK_OPTION) {
            // 화면에서 입력창에 입력 했던 데이터 들을 다 가지고 와서, 임의의 변수를 담고
            // Member 클래스 형식으로 인스턴스 만들고, 리스트 members추가하고
            // ㅠ파일에 쓰기
            String name = nameField.getText().trim(); // 텍스트 가져오고 양쪽 공백 제거
            String email = emailField.getText().trim();
            String password = passwordField.getText().trim();
            String regDate = DateUtil.getCurrentDateTime();
            // 값 입출력 할때는 유효성 체크
            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "모든 항목을 입력해주세요");
                // 롤백 설정 필요
                return;
            }
            // Member member = new Member(name, password, email, regDate);
            oldmember.setName(name);
            oldmember.setEmail(email);
            oldmember.setPassword(password);
            oldmember.setRegDate(regDate);
            saveMembersToFile();
            // 변경사항 새로고침, 즉 다 지우고 전체 회원을 다시 그리기.
            refreshTable();
        }
    }

    // 8) 회원 삭제 기능.
    private void deleteSelectedMemberDialog() {

        // 테이블 상에서 선택된 행의 번호를 가져와서 삭제하는 작업
        int row = memberTable.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "삭제할 회원을 선택하세요.");
            return;
        }

        // 회원수정 버튼을 누를 경우 확인 알림창 띄우기
        // 확인을 누르면 JOptionPane.showConfirmDialog() -> 특정 값 반환
        // 수락-> JOptionPane.OK_OPTION (정수값 전달)
        int result = JOptionPane.showConfirmDialog(
                this, // 알림창을 이 창에 띄우게 this : 현재 윈도우창
                "정말 삭제하시겠습니까?", // 사용자에게 보여줄 컨텐츠(JPanel)
                "WARRNING", // 알림 창의 제목
                JOptionPane.YES_NO_CANCEL_OPTION// 확인, 취소 버튼을 구성하는 옵션
        );// 아이콘이 없는 일반 메시지 형식의 알림창을 의미함 => 기본 알림창

        if (result == JOptionPane.YES_OPTION) {
            members.remove(row);
            saveMembersToFile();
            // 변경사항 새로고침, 즉 다 지우고 전체 회원을 다시 그리기.
            refreshTable();
        }
    }
    // =====================================================================================

}
