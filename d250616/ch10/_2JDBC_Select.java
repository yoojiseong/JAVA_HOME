package d250616.ch10;
//JDBC실행 순서

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.spi.DirStateFactory.Result;

// 1. 디비 서버에 접근을 위한 준비물.
// 1)드라이버 위치, 2) 유저명 3) 패스워드 4) 디비 서버의 아이피 및 포트 번호

// 2. 드라이버 로딩, ojdbc8_g.jar 압축 파일에서, 필요한 경로를 찾아감
// ex) Class.forName(driver); 이 명령어 대신 .vscode폴더에서 오라클 드라이버의 
//.jar파일을 메모리상에 로드하고 있음

// 3. Connection 맺기
// 자바 코드와 오라클 데이터베이스를 연결 함
// java.sql 패키지에서 Connection 클래스 기능을 이용해서, 접근하기.
// ex) Connection conn = DriverManager.getConnection(url, user, password)

// 4.SQL 문 작성
// 자바에서 데이터베이스에 요청할 SQL을 문자열로 저장하고 전달.
// 주의사항) 세미콜론은 입력하지 않음
// String query = "select sysdate from dual";

// 5. PreparedStatement 생성
// 요청할 SQL 문을 데이터베이스로 전송할 때 사용하는 기능이다(API)
// ex) PreparedStatement pstmt = conn.prepareStatement(query)

// 6. SQL 문 전송 및 결과값 얻기 두 가지 방향 1) 조회하기  :executeQuery() 2)쓰기, 수정, 삭제 :executeUpdate()
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

// 7.자원 반납.
// 객체를 생성한 역순으로 반납.
// 1)Connection 2) PreparedStatement 3) ResultSet 객체를 순서로 만들었음.
// 해당 객체의 자원 반납 객체.close()
// try ~ resource 구문으로 , 자동으로 autocloseable 이용하거나,
public class _2JDBC_Select {
    public static void main(String[] args) {
        // 1. 디비 서버에 접근을 위한 준비물.
        // 1)드라이버 위치, 2) 유저명 3) 패스워드 4) 디비 서버의 아이피 및 포트 번호
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 디비 서버 아이피주소 , 포트, 서비스 이름
        String user = "scott"; // 접속할 유저
        String password = "tiger"; // 패스워드
        String driver = "oracle.jdbc.driver.OracleDriver"; // 드라이버 위치

        // 객체를 미리 선언만 해서, 초기화를 밑에서 하고, 전역처럼 사용하기.
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null; // ResultSet은 조회할 때만 필요함

        // 파일 입출력, 네트워크 통신 이용해서, 접근시, try ~ 구문 이용하기
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

            // 4.SQL 문 작성(조회)
            // 자바에서 데이터베이스에 요청할 SQL을 문자열로 저장하고 전달.
            // 주의사항) 세미콜론은 입력하지 않음
            // String query = "select * from dual";
            String query = "select * from member501";

            // 5. PreparedStatement 생성
            // 요청할 SQL 문을 데이터베이스로 전송할 때 사용하는 기능이다(API)
            // ex) PreparedStatement pstmt = conn.prepareStatement(query)
            pstmt = conn.prepareStatement(query);

            // 6. SQL 문 전송 및 결과값 얻기 두 가지 방향 1) 조회하기 :executeQuery() 2)쓰기, 수정, 삭제
            // :executeUpdate()
            // 조회하기
            // ex) ResultSet rs = stmt.executeQuery(query)
            // ResultSet rs : 가상의 테이블, 데이터 베이스에서 조회된 데이터를 테이블 형식으로 메모리상에 저장
            // -> 0행부터 시작 함(배열이랑 같음)
            // ex) while(rs.next()){
            // int deptno = rs.getInt("deptno");
            // String name = rs.getString("danme");
            // }
            rs = pstmt.executeQuery(query); // 디비에 연결해서 실행 결과를 받아옴. (조회)
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
            // 쓰기 버전,
            // int result = executeUpdate(query)

        } catch (Exception e) {
            // TODO: handle exception
            // 7.자원 반납.
            // 객체를 생성한 역순으로 반납.
            // 1)Connection 2) PreparedStatement 3) ResultSet 객체를 순서로 만들었음.
            // 해당 객체의 자원 반납 객체.close()
            // try ~ resource 구문으로 , 자동으로 autocloseable 이용하거나,
        } finally {
            try {
                if (rs != null)
                    rs.close();
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