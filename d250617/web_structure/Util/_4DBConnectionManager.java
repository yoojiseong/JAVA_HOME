package d250617.web_structure.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 반복되는 코드
// 1) 연결시 필요한 정보들, 반복되는 코드이니 상수로 선언해서 재사용하기
// 2) 드라이버 로딩
// 3)데이터베이스 연겨 ㄹ객체 얻기
// 4) 자원 해제
public class _4DBConnectionManager {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; // 디비 서버 아이피주소 , 포트, 서비스 이름
    private static final String USER = "scott"; // 접속할 유저
    private static final String PASSWORD = "tiger"; // 패스워드
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver"; // 드라이버 위치

    // 드라이버 로딩
    static {
        try {
            Class.forName(DRIVER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 데이터베이스 연결
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // 자원 해제
    public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
        try {
            if (rs != null)
                rs.close();
            if (pstmt != null)
                pstmt.close();
            if (conn != null)
                conn.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
}
