-- ----------------------------
-- Table structure for t_user_account
-- ----------------------------
drop table t_user_account if exists;

create table t_user_account (
  id int primary key auto_increment,
  account varchar(20),
  passwd varchar(64),
  passwd int,
  ctime datetime,
  mtime datetime
);