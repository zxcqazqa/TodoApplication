drop sequence todo_seq;
drop table todo_table;
create table todo_table(
    id number(5) primary key, 
    memo varchar2(200) not null,
    toDoDate date  not null, -- 할일 기록 날짜
    regDate date  default sysdate --등록날짜
);
create sequence todo_seq;

-- 6월
insert into todo_table(id,memo,todoDate)
values(todo_seq.nextval,'테스트1',to_date('20230625','yyyyMMdd'));

-- 7월
insert into todo_table(id,memo,todoDate)
values(todo_seq.nextval,'테스트2',to_date('20230701','yyyyMMdd'));

-- 8월
insert into todo_table(id,memo,todoDate)
values(todo_seq.nextval,'테스트3',to_date('20230801','yyyyMMdd'));

select * from todo_table where todoDate 
between to_date('20230701','yyyyMMdd')
and last_day(to_date('20230701','yyyyMMdd'));

commit;

select to_date('20230601','yyyyMMdd') from dual;
select last_day(to_date('20230601','yyyyMMdd')) from dual;

select sysdate from dual;
select * from todo_table;

select * from todo_table where todoDate 
between to_date('20230701','yyyyMMdd')
and to_date(to_date('20230701','yyyyMMdd'));

//select * from(select id,memo,todoDate from todo_table where todoDate between to_date('20230718','yyyyMMdd')
//and to_date(to_date('20230718','yyyyMMdd'))) WHERE memo ='' ;

// delete from todo_table where id='';
//update todo_table set memo='' where id=;