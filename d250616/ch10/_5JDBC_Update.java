package d250616.ch10;

import java.sql.Connection;
import java.sql.PreparedStatement;

import d250613.member_project.util.DateUtil;
import d250616.Util._4DBConnectionManager;

public class _5JDBC_Update {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = _4DBConnectionManager.getConnection();

            String query = "UPDATE MEMBER501 SET NAME = ?, EMAIL =?, PASSWORD = ? , REG_DATE = ? WHERE ID = ?";

            pstmt = conn.prepareStatement(query);

            pstmt.setString(1, "구보경");
            pstmt.setString(2, "pepep@gmail.com");
            pstmt.setString(3, "0809");
            pstmt.setString(4, DateUtil.getCurrentDateTime());
            pstmt.setInt(5, 2);

            int result = pstmt.executeUpdate();
            System.out.println(result + "저장완료");
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            _4DBConnectionManager.close(null, pstmt, conn);
        }
    }
}
