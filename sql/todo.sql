drop sequence todo_seq;
drop table todo_table;
create table todo_table(
    id number(5) primary key, 
    memo varchar2(200) not null,
    toDoDate date  not null, -- ���� ��� ��¥
    regDate date  default sysdate --��ϳ�¥
);
create sequence todo_seq;

-- 6��
insert into todo_table(id,memo,todoDate)
values(todo_seq.nextval,'�׽�Ʈ1',to_date('20230625','yyyyMMdd'));

-- 7��
insert into todo_table(id,memo,todoDate)
values(todo_seq.nextval,'�׽�Ʈ2',to_date('20230701','yyyyMMdd'));

-- 8��
insert into todo_table(id,memo,todoDate)
values(todo_seq.nextval,'�׽�Ʈ3',to_date('20230801','yyyyMMdd'));

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