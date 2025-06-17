package d250617.web_structure.service;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import d250617.web_structure.dao._9DAO_Interface;
import d250617.web_structure.dao._N1OracleMemberDAOImpl;
import d250617.web_structure.dto._10Member;
import d250617.web_structure.ui._4SignupFrame;
import d250617.web_structure.Util.DateUtil;

import javax.swing.*;

public class _5MemberService {

    _9DAO_Interface dao = new _N1OracleMemberDAOImpl();

    private List<_10Member> members = new ArrayList<>();

    // 없는 부분 받아서 임시로 사용하기.
    private DefaultTableModel tableModel;

    private JTextField searchField;

    public void setSignupFrame(_4SignupFrame signupFrame) {
        this.signupFrame = signupFrame;
    }

    private _4SignupFrame signupFrame;

    public void setTableModel(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }

    public void setSearchField(JTextField searchField) {
        this.searchField = searchField;
    }

    public List<_10Member> getMembers() {
        return members;
    }

    public void addMember(_10Member member) {
        members.add(member);
        saveMembersToFile();
    }

    public void loadMembersFromDB() {

        members.clear();
        try {
            members = dao.findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    public void addMemberDB(_10Member member) {
        boolean result = dao.insert(member);
        System.out.println("회원가입 완료");
    }

    public _10Member getMemberOne(int member_id) {
        _10Member member = dao.findById(member_id);
        return member;
    }

    // 회원 수정기능 디비 저장
    public void updateMember(_10Member member) {
        dao.update(member);
    }

    public void saveMembersToFile() {

    }

    public void dummyMake() {

        for (int i = 0; i < 10; i++) {

            members.add(null);
        }

        saveMembersToFile();

        refreshTable();

        signupFrame.showDialog("10명의 더미 회원 추가!!");

    }

    // 3) JTable에 회원 데이터 반영 (새로고침), 전체 모든 회원 조회
    public void refreshTable() {
        tableModel.setRowCount(0);
        for (_10Member member : members) {

            tableModel.addRow(new Object[] {
                    member.getId(), member.getName(), member.getEmail(), member.getPassword(), member.getReg_date()
            });
        }
    }

    // 4) 검색 결과 테이블에 반영, 기존 전체데이터를 삭제하고, 검색된 결과 멤버들만 조회,
    public void showSearchResults(ArrayList<_10Member> results) {
        tableModel.setRowCount(0);
        for (_10Member member : results) {
            // tableModel 에, 데이터 쓰기, 기본 데이터 테이블 데이터를 쓰고, -> 출력용 테이블 연결하기.
            tableModel.addRow(new Object[] {
                    // member.getName(), member.getEmail(), member.getPassword(),
                    // member.getRegDate()
            });
        }
    }

    // 5) 검색 기능 (이름 또는 이메일 검색어가 포함된 회원만 표시), 검색 결과만 표기.
    public void searchMembers() {
        // 검색어 입력창에서, 검색어를 가져오기, 양쪽 공백 제거, 영어 인경우 모두 소문자로 변경하고
        String query = searchField.getText().trim().toLowerCase();
        // 유효성 체크. 검색어 비어 있는지 체크.
        if (query.isEmpty()) {
            refreshTable(); // 기본 전체 조회가 실행이 됨.
            return;// 검색 기능 메서드 나가기,
        }
        // 임시로 담아둘 멤버 리스트 하나 정의.
        ArrayList<_10Member> resultList = new ArrayList<>();
        // members : 파일에서 읽어서, 담아둔 임시 전체 멤버 리스트,
        // resultList, 아래 반복문에서, 검색어 일치하는 멤버들만 담을 공간.
        for (_10Member member : members) {
            if (member.getName().toLowerCase().contains(query) ||
                    member.getEmail().toLowerCase().contains(query)) {
                resultList.add(member);
            }
        }
        // 검색 된 결과를, 화면에 출력하는 메서드에, 검색된 멤버 리스트를 넘겨주기.
        showSearchResults(resultList);

        // 검색된 결과가 없다면, 알림창으로 검색 결과가 없습니다.
        if (resultList.isEmpty()) {
            // JOptionPane.showMessageDialog(this, "검색 결과가 없습니다.");
            // JOptionPane.showMessageDialog(this, "파일 생성 오류 : " + e.getMessage());
            signupFrame.showDialog("검색 결과가 없습니다.");
            // System.out.println("다른 방법으로 알림등 알려줄 예정");
        }

    }

}
