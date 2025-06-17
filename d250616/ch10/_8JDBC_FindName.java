package d250616.ch10;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import d250616.Util._4DBConnectionManager;
import oracle.net.aso.n;

public class _8JDBC_FindName {
    public static void main(String[] args) {
        // 회원 정보 검색
        ResultSet rs = null; // 가상테이블 선언
        Connection conn = null; // 연결고리 선언
        PreparedStatement pstmt = null;
        try {
            conn = _4DBConnectionManager.getConnection();
            String query = "SELECT * FROM MEMBER501 WHERE NAME LIKE ?";
            pstmt = conn.prepareStatement(query);
            String name1 = "유지성";
            pstmt.setString(1, "%" + name1 + "%");
            // 조회이기 때문에
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password2 = rs.getString("password");
                String reg_date = rs.getString("reg_date");
                // 콘솔에서 데이터 조회 확인하기
                System.out.println("데이터 조회 : ");
                System.out.println("id : " + id);
                System.out.println("이름 : " + name);
                System.out.println("이메일 : " + email);
                System.out.println("비밀번호 : " + password2);
                System.out.println("등록날짜 : " + reg_date);
            }

        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            _4DBConnectionManager.close(null, pstmt, conn);
        }
    }
}
