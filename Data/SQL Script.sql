use tphonedb

go
--创建评论表
create table comment
(
	c_no int not null primary key,
	c_cid varchar(12) not null,
	c_text varchar(255) not null,
	c_caccount varchar(12) not null,
	c_ctime date not null
)
go
--插入评论数据

insert into comment values('201909101141','真好玩','admin',GETDATE())

--创建粉丝表

create table fans
(
	f_id int not null primary key,
	f_focus varchar(12) not null,
	f_account varchar(12) not null
)
go
--创建帖子表
create table posts
(
	p_id varchar(15) not null,
	p_theme varchar(50) not null,
	p_time date not null,
	p_account varchar(12) not null,
	p_nick varchar(16) not null,
	p_text varchar(8000) not null,
	p_good int not null
)
go



--创建用户信息表

create table [user]
(
	u_uid varchar(50) not null,
	u_account varchar(12) not null,
	u_password varchar(20) not null,
	u_email varchar(50) not null,
	u_ip varchar(20),
	u_state int not null,
	u_num int
)
insert into [user] values(NEWID(),'jjk123','yjj0720','1134510293@qq.com','192.168.137.1',0,0),
(NEWID(),'kkl113','yjj0720','2390107310@qq.com','192.168.137.1',0,0)

go

--创建用户扩展信息表

create table userinfo
(
	u_uid varchar(50) not null,
	u_nick varchar(20),
	u_points int not null,
	u_birthday date,
	u_code int not null,
	u_sex varchar(20),
	u_idcard varchar(20) not null,
	u_dev varchar(50),
	u_regtime date not null,
)

go

--创建用户组表
create table usertype
(
	utype_code int not null,
	utype_name varchar(50) not null,
)

insert into usertype values(00,'普通用户组'),
(01,'会员用户组'),
(02,'管理用户组')

go

--创建操作日志表
create table operationlog
(
	log_id varchar(50) not null,
	log_admin varchar(20) not null,
	log_date date not null,
	log_text varchar(8000) not null,
	log_state int not null
)

go

--创建管理员表

create table [admin]
(
	a_uid varchar(50) not null,
	a_account varchar(20) not null,
	a_pwd varchar(20) not null,
	a_name varchar(50) not null,
	a_state int not null
)

insert into [admin] values(NEWID(),'admin','yjj0720.','杨俊杰',0),
(NEWID(),'tpww','asd123','运维组',0)

go

--建立登录存储过程
drop proc p_SelectAdminByPwd
create proc p_SelectAdminByPwd
(
	@account varchar(50),
	@pwd varchar(50),
	@msg varchar(50) out
)

as
declare @count int

select @count=COUNT(*) from admin where a_state = 0 and  a_account = @account;

if(@count != 1)
	set @msg = '输入的账号不存在！'
else
	begin
        select @count=COUNT(*) from [admin] where [a_state]=0 and a_account =@account and a_pwd =@pwd
        
        --如果数量不唯一 则密码错误
        if(@count!=1)
			set @msg='输入的密码错误！'
		else
			select * from [admin] where [a_state]=0 and a_account =@account and a_pwd =@pwd
    end

go

