Create database ClassName
--===========================================================================================================
go
use ClassName
go
--===========================================================================================================
create table admin(adminID int primary key identity(1,1),
username varchar(30) unique, password varchar(32) not null check(len(password)>=8))
go
Create table  Category(cateID int primary key identity(1,1), cateName nvarchar(50),
status bit default 1)
go
Create table Product(pid varchar(30) primary key,pname nvarchar(100) not null,
quantity int check(quantity>=0), price money check(price>=0), image varchar(100),
description nvarchar(max),status bit default 1,cateID int foreign key references Category(cateID))
go
create table Customer(cid int primary key identity(1,1), cname nvarchar(30) not null,
cphone varchar(30), cAddress nvarchar(100), username varchar(30) not null unique,
password varchar(32) not null check(len(password)>=8), status bit default 1)
go
Create table Bill(oID varchar(32) primary key,dateCreate dateTime default getdate(),
cname nvarchar(30) not null,cphone varchar(30), cAddress nvarchar(100), total money,
status int default 0,cid int foreign key references Customer(cid) )
go
create table BillDetail(pid varchar(30) foreign key references Product(pid),
oID varchar(32) foreign key references Bill(oID), quantity int, price money, total money,
primary key(pid,oID))
--===========================================================================================================
go
insert into Category(cateName,status) values
('Apple',1),
('Samsung',1),
('Oppo',1),
('Xiaomi',1),
('Vivo',1),
('Google',1)
go
insert into admin(username,password) values
('huuhuy123','11111111'),
('huutrinh.123','11111111'),
('congthinh.123','11111111'),
('huyanh.123','11111111')
go
insert into Customer(cname,cphone,cAddress,username,password,status) values
(N'Nguyễn Hữu Trình','0328339123','bacninh','trinh.123','11111111',1),
(N'Nguyễn Công Thịnh','0645612311','thanhchuong','thinh.123','11111111',1),

go
insert into Product values
('P01','Iphone 13','20',1000.0,'img/iphone13.jpg','RAM:8GB+ROM:128GB',1,1),
('P02','Iphone 12','20',800.0,'img/iphone12.jpg','RAM:8GB+ROM:128GB',1,1),
('P03','Iphone 11','20',600.0,'img/iphone11.jpg','RAM:8GB+ROM:128GB',1,1),
('P04','Samsung Galaxy Z Flip','20',1400.0,'img/ssZFlip.jpg','RAM:8GB+ROM:256GB,Win10',1,2),
('P05','Samsung Galaxy A71','20',1200.0,'img/ssA71.jpg','RAM:8GB+ROM:512GB,Win10',1,2),
('P06','Samsung Galaxy A11','20',1000.0,'img/ssA11.jpg','RAM:8GB+ROM:512GB,Win10',1,2),
('P07','Oppo Reno 5','20',1700.0,'img/opreno5.jpg','RAM:16GB+ROM:512GB,Win10',1,3),
('P08','Oppo A74','20',900.0,'img/opa74.jpg','RAM:16GB+ROM:1TB,Win10',1,3),
('P09','Oppo A54','20',700.0,'img/opa54.jpg','RAM:16GB+ROM:1TB,Win10',1,3),
('P10','Xiaomi Redmi 9T','20',800.0,'img/9T.jpg','RAM:8GB+ROM:256TB,Win10',1,4),
('P11','Xiaomi Redmi 9A','20',800.0,'img/9A.jpg','RAM:8GB+ROM:256TB,Win10',1,4),
('P12','Xiaomi Mi Note 10','20',800.0,'img/MN10.jpg','RAM:8GB+ROM:256TB,Win10',1,4),
('P13','Vivo U10','20',800.0,'img/U10.jpg','RAM:8GB+ROM:256TB,Win10',1,5),
('P14','Vivo Y11','20',800.0,'img/Y11.jpg','RAM:8GB+ROM:256TB,Win10',1,5),
('P15','VIVO Y30','20',800.0,'img/Y30.jpg','RAM:8GB+ROM:256TB,Win10',1,5),
('P16','Google Pixel 5','20',800.0,'img/GP5.jpg','RAM:8GB+ROM:256TB,Win10',1,6),
('P17','Google Pixel 4A','20',800.0,'img/GP4a.jpg','RAM:8GB+ROM:256TB,Win10',1,6),
('P18','Google Pixel 4XL','20',800.0,'img/GP4XL.jpg','RAM:8GB+ROM:256TB,Win10',1,6)
go
insert into Bill values
('B01','2021-11-08 12:58:06.503',N'Nguyễn Hữu Trình','0328339123','vinh',8600,0,1),
('B02','2021-10-22 14:08:58.340',N'Nguyễn Công Thịnh','0328339123','bacninh',6900,0,2)
go
insert into BillDetail values
('P01','B01',7,1000,7000),
('P10','B01',2,800,1600),
('P02','B02',2,950,1900),
('P03','B02',3,1100,3300),
('P05','B02',1,1700,1700)
go
--===========================================================================================================
create Trigger update_Quantity_Bill
on BillDetail
for update,insert
as
begin
    if update(quantity)
    begin
	  Update BillDetail
	  set total = price * quantity
    end
    begin
	  Update Bill
	  set total = (
	  select sum(price * quantity)
	  from BillDetail
	  where BillDetail.oID = Bill.oID
	  )
    end
end
go