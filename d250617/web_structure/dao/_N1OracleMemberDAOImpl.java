package d250617.web_structure.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import d250613.member_project.util.DateUtil;
import d250617.web_structure.Util._4DBConnectionManager;
import d250617.web_structure.dto._10Member;

public class _N1OracleMemberDAOImpl implements _9DAO_Interface {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null; // ResultSet은 조회할 때만 필요함

    // 전체 조회 기능 만들기
    public List<_10Member> findAll() {
        List<_10Member> memberList = new ArrayList();
        try {
            conn = _4DBConnectionManager.getConnection();
            String query = "SELECT * FROM MEMBER501 ORDER BY ID DESC";
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password2 = rs.getString("password");
                String reg_date = rs.getString("reg_date");
                // 콘솔에서 데이터 조회 확인하기
                _10Member member = new _10Member(id, name, email, password2, reg_date);
                memberList.add(member);
            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            _4DBConnectionManager.close(null, pstmt, conn);
        }
        return memberList;
    }

    public _10Member findById(int id) {
        _10Member member = new _10Member();
        try {
            conn = _4DBConnectionManager.getConnection();
            String query = "SELECT * FROM MEMBER501 WHERE ID = ?";
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            pstmt.setInt(1, id);
            if (rs.next()) {
                int user_id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password2 = rs.getString("password");
                String reg_date = rs.getString("reg_date");
                member.setId(id);
                member.setName(name);
                member.setEmail(email);
                member.setPassword(password2);
                member.setReg_date(reg_date);
            }

        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            _4DBConnectionManager.close(null, pstmt, conn);

        }
        return member;
    }

    // 3) 회원 추가
    @Override
    public boolean insert(_10Member member) {
        try {
            conn = _4DBConnectionManager.getConnection();
            String query = "INSERT INTO MEMBER501 (ID,NAME,PASSWORD,EMAIL,REG_DATE) VALUES(member501_seq.nextval, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getPassword());
            pstmt.setString(3, member.getEmail());
            pstmt.setString(4, DateUtil.getCurrentDateTime());

            int result = pstmt.executeUpdate();
            System.out.println(result + "회원가입 완료");
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        } finally {
            _4DBConnectionManager.close(null, pstmt, conn);

        }

        return true;
    }

    @Override
    public boolean update(_10Member member) {
        try {
            System.out.println(member.getName() + member.getEmail() + member.getPassword() + member.getId());
            conn = _4DBConnectionManager.getConnection();
            String query = "UPDATE MEMBER501 SET NAME = ?, PASSWORD = ?, EMAIL = ?, REG_DATE = ? WHERE ID = ?";

            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getPassword());
            pstmt.setString(3, member.getEmail());
            pstmt.setString(4, DateUtil.getCurrentDateTime());
            pstmt.setInt(5, member.getId());

            int result = pstmt.executeUpdate();

        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            _4DBConnectionManager.close(null, pstmt, conn);
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public _10Member findByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByName'");
    }

}
