use newhr;

create table request_log(
	id int auto_increment primary key,
    req_class varchar(50),
    req_method varchar(50),
    req_time timestamp);
    
drop table request_log;
    