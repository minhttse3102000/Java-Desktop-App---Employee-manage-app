create database EmpManagement
go
use EmpManagement
go
create table tblUsers (
	userID varchar(10) primary key,
	fullname nvarchar(50),
	password varchar(50),
	status bit
)
create table tblEmployees (
	EmpID varchar(10) primary key,
	Fullname nvarchar(50),
	Phone varchar(20),
	Email varchar(50),
	Address nvarchar(50),
	DateOfBirth Date,
	IsDelete bit
)

insert tblUsers
values('minh',N'Tran Tuan Minh','1',1)

insert tblUsers
values('hoang',N'Van Hoang','1',1)

insert tblEmployees
values('E1',N'Van Hoang','0235656','hoang@gmail.com','Binh Duong','10/19/2020',0)
insert tblEmployees
values('E2',N'Tuan Minh','4564645','minh@gmail.com','TP Ho Chi Minh','11/19/2020',0)
insert tblEmployees
values('E3',N'Hai Nam','987654','nam@gmail.com','Binh Phuoc','10/19/2020',0)
insert tblEmployees
values('E4',N'Duc Anh','987456','DucAnh@gmail.com','Phu Quoc','10/19/2020',1)

