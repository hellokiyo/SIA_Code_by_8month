use newhr;

select * from addrbook;

insert into addrbook(ab_name,ab_comdept,ab_birth) values('haha','test');

delete from addrbook where ab_id < 50;

drop table addrbook;


Create table addrbook (
	ab_id int(11) auto_increment,
    ab_name varchar(15) not null,
    ad_email varchar(50) default null,
    ad_comdept varchar(20) default null,
    ab_birth varchar(10) default null,
    ab_tel varchar(20) default null,
    ab_memo varchar(100) default null,
    primary key(ab_id)
);

begin; 

insert into addrbook(ab_name, ab_comdept) values('huhu', 'test');
select * from addrbook;

commit;  -- 강제 커밋

select @@autocommit;

set autocommit = false;

insert into addrbook(ab_name, ab_comdept) values('hoho', 'test');
select * from addrbook;

commit;


update;
