package d250616.ch10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import d250613.member_project.util.DateUtil;

public class _3JDBC_Insert {
    public static void main(String[] args) {

        // 1. 디비 서버에 접근을 위한 준비물.
        // 1)드라이버 위치, 2) 유저명 3) 패스워드 4) 디비 서버의 아이피 및 포트 번호
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 디비 서버 아이피주소 , 포트, 서비스 이름
        String user = "scott";
        String password = "tiger";
        String driver = "oracle.jdbc.driver.OracleDriver"; // 드라이버 위치

        Connection conn = null;
        PreparedStatement pstmt = null;
        // REsultSet은 조회할 때만 (select이용시)필요함

        try {
            // 2. 드라이버 로딩, ojdbc8_g.jar 압축 파일에서, 필요한 경로를 찾아감
            // ex) Class.forName(driver); 이 명령어 대신 .vscode폴더에서 오라클 드라이버의
            // .jar파일을 메모리상에 로드하고 있음
            Class.forName(driver);

            // 3. Connection 맺기
            // 자바 코드와 오라클 데이터베이스를 연결 함
            // java.sql 패키지에서 Connection 클래스 기능을 이용해서, 접근하기.
            // ex) Connection conn = DriverManager.getConnection(url, user, password)
            conn = DriverManager.getConnection(url, user, password);

            // 4.SQL 문 작성
            // 자바에서 데이터베이스에 요청할 SQL을 문자열로 저장하고 전달.
            // 주의사항) 세미콜론은 입력하지 않음
            // String query = "select sysdate from dual";
            // 시퀀스 안썼을때
            // String query = "INSERT INTO MEMBER501 (ID,NAME,PASSWORD,EMAIL,REG_DATE)" +
            // "VALUES(?,?,?,?,?)";
            // 자동 인덱스 생성으로 id를 넣을 경우(시퀀스)
            String query = "INSERT INTO MEMBER501 (ID,NAME,PASSWORD,EMAIL,REG_DATE)" +
                    "VALUES(member501_seq.nextval, ?, ?, ?, ?)";

            // 5. PreparedStatement 생성
            // 요청할 SQL 문을 데이터베이스로 전송할 때 사용하는 기능이다(API)
            // ex) PreparedStatement pstmt = conn.prepareStatement(query)
            pstmt = conn.prepareStatement(query);
            // 쓰기 작업을 하기 전 추가할 데이터를, 와일드카드(?)에 해당하는 데이터를 임시로
            // 하드코딩으로 넣고 있고, 화면에서 데이터를 사용자로부터 받아서 추가할 예정
            // 시퀀스 안썼을때
            // pstmt.setInt(1, 100);
            // pstmt.setString(2, "유지성1");
            // pstmt.setString(3, "1234");
            // pstmt.setString(4, "gs9046@gmail.com");
            // pstmt.setString(5, DateUtil.getCurrentDateTime());
            // 시퀀스 썼을때
            pstmt.setString(1, "유지성1");
            pstmt.setString(2, "1234");
            pstmt.setString(3, "gs9046@gmail.com");
            pstmt.setString(4, DateUtil.getCurrentDateTime());

            // 6. SQL 문 전송 및 결과값 얻기 두 가지 방향 2)쓰기, 수정, 삭제
            // :executeUpdate()
            // 조회하기
            // ex) ResultSet rs = stmt.executeQuery(query)
            // ResultSet rs : 가상의 테이블, 데이터 베이스에서 조회된 데이터를 테이블 형식으로 메모리상에 저장
            // -> 0행부터 시작 함(배열이랑 같음)
            // ex) while(rs.next()){
            // int deptno = rs.getInt("deptno");
            // String name = rs.getString("danme");
            // }

            // 쓰기 버전,
            // int result = executeUpdate(query)
            // int result = pstmt.executeUpdate(query);
            // executeUpdate시에는 메서드 호출 방법이 다르다.
            int result = pstmt.executeUpdate();

            System.out.println(result + "개의 데이터가 저장됨");

            // 7.자원 반납.
            // 객체를 생성한 역순으로 반납.
            // 1)Connection 2) PreparedStatement 3) ResultSet 객체를 순서로 만들었음.
            // 해당 객체의 자원 반납 객체.close()
            // try ~ resource 구문으로 , 자동으로 autocloseable 이용하거나,
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            try {
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

    }
}