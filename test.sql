-- 샘플 확인용 테이블 만들기, 시퀀스 만들기
create sequence member501_seq start with 1 increment by 1;
drop sequence member501_seq;
drop table member501;
-- 샘플 확인용 테이블 만들기
create table member501 (
   id       number primary key,
   name     varchar2(100),
   password varchar2(100),
   email    varchar2(100),
   reg_date varchar2(50)
)
-- 샘플 데이터 하나 넣기.
insert into member501 (
   id,
   name,
   password,
   email,
   reg_date
) values ( member501_seq.nextval,
           '유지성',
           '1234',
           'ujs@naver.com',
           '2025년06월16일12시09분' );
commit;

--테이블 조회
select *
  from member501;

select *
  from member501
 where name like '%유지성%';

select *
  from member501
 order by id desc;