CREATE DATABASE TTaps



create table Users
(
	Uno int not null primary key,
	Uaccount char(20) null,
	Uname char(20) null,
	Upassword varchar(20) null,
	Uauthority int
)

create table Taps
(
	Tno int not null primary key,
	Tname char(20) null,
	TTypeno int null,
	Tstate char(20)
)

create table TapsType
(
	TTno int not null primary key,
	TTTypename varchar(30) null,
)

create table LetTaps
(
	Lno int not null primary key,
	LTaps char(20) null,
	LTTypename char(20) null,
	LTime char(50) null
)

create table Publics
(
	Pno int not null primary key,
	Pname char(20) null,
	Pcontent varchar(200) null,
	Ptime char(50) null
)

create table Messagess
(
	Mno int not null primary key,
	Mcontent varchar(200) null,
	Mtime char(50) null
	
)

INSERT INTO Users VALUES (1,111,'����Ա','111','1')
INSERT INTO Users VALUES (2,222,'�û�','222','2')

INSERT INTO Publics VALUES (2,'����','���ϲ����')

update Publics set Pcontent='hello',Pname='222' where Pno=2



INSERT INTO Messagess VALUES (1,'���ϲ���Ŷ��')

INSERT INTO Taps VALUES (1,'ƽ��������',1,'�ڿ�')
INSERT INTO Taps VALUES (2,'���ŵ�����',2,'���ڿ�')

INSERT INTO TapsType VALUES (1,'ҡ��')
INSERT INTO TapsType VALUES (2,'����')

select * from Users where Uname='����Ա'

select Tno,Tname,TTTypename from Taps LEFT join TapsType on Taps.TTypeno=TapsType.TTno where Tno=2

select Tno,Tname,TTTypename,Tstate from Taps LEFT join TapsType on Taps.TTypeno=TapsType.TTno

update Taps set Tstate='�ڿ�' where Tno=1

select * from LetTaps