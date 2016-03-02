create database spring_test default character set utf8;

create table t_user(
  user_id int auto_increment primary key,
  user_name varchar(30),
  credits int,
  password varchar(30),
  last_visit datetime,
  last_ip varchar(32)
) ENGINE=InnoDB;


create table t_login_log(
  login_log_id int auto_increment primary key,
  user_id int,
  ip varchar(32),
  login_datetime datetime
) ENGINE=InnoDB;


insert into t_user(user_name, passowrd) values('admin', '123456');