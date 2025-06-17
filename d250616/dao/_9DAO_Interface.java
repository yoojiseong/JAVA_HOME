package d250616.dao;

import java.util.List;

import d250616.dto.*;

// DAO(Data Access Objuect) : DB에 접근하는 기능 모음집
// CRUD, 검색, 한명 조회, 필터 등
// 인터페이스를 만들어서 구현하는 클래스 형식
//스프링의 기본 뼈대 작업 방식

//DTO(Data Transfer Object) : DB에 전달하는 모델 클래스
// 데이터베이스에서 회원 정보를 따로 전달하기보다는 모델 클래스에 담아서 인스턴스로 전달하는 방식
public interface _9DAO_Interface {
    // 자바 특성상 클래스끼리는 단일 상속만 가능함
    // 다양한 기능을 추가하기 위해 Interface사용

    // 1) 전체 조회
    List<_10Member> findAll();

    // 2) 환명 회원 조회
    _10Member findById(int id);

    // 3) 회원 추가
    boolean insert_10(_10Member member);

    // 4) 회원 수정
    boolean update(_10Member member);

    // 5) 회원 삭제
    boolean delete(_10Member member);

    // 6) 회원 검색
    _10Member findByName(String name);
}
