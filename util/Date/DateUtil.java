package util.Date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    public static String getCurrentDateTime() {
        // 현재 날짜를 알려주는 클래스 : LocalDateTime
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY년 MM월 dd일 a h시 m분");
        String result = now.format(formatter);
        return result;
    }

}
