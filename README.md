<img src="https://s2.loli.net/2022/09/29/14sLDBjhu53UWS2.jpg" style="zoom:15%;" />

**BS系统开发音像出租系统**

**2020年7 月10日**



本系统功能模块设计如图所示：

![](https://s2.loli.net/2022/09/29/dF5X2KJygOIRpwq.png)



### 数据库设计

用户（Users）表：

| 属性     | 列名       | 数据类型 | 长度 | 约束 |
|----------|------------|----------|------|------|
| 用户账号 | Uno        | Int      |      | 主键 |
| 用户姓名 | Uname      | Char     | 20   |      |
| 用户密码 | Upassword  | VarChar  | 20   |      |
| 用户权限 | Uauthority | Int      |      |      |

 

音像（Taps）表：

| 属性     | 列名    | 数据类型 | 长度 | 约束 |
|----------|---------|----------|------|------|
| 音像编号 | Tno     | Int      |      | 主键 |
| 音像名称 | Tname   | Char     | 20   |      |
| 类型编号 | TTypeno | Char     | 20   |      |
| 音像状态 | Tstate  | Char     | 20   |      |



 音像类型（TapsType）表：

| 属性     | 列名       | 数据类型 | 长度 | 约束 |
|----------|------------|----------|------|------|
| 类型编号 | TTno       | Char     | 10   | 主键 |
| 类型名称 | TTTypename | Varchar  | 30   |      |



租赁（LetTaps）表：

| 属性     | 列名       | 数据类型 | 长度 | 约束 |
|----------|------------|----------|------|------|
| 租赁编号 | Lno        | Int      |      | 主键 |
| 音像名称 | LTaps      | Char     | 20   |      |
| 类型编号 | LTTypename | Char     | 20   |      |
| 用户姓名 | Lname      | Char     | 20   |      |
| 租赁时间 | LTime      | Char     | 50   |      |



公告（Publics）表：

| 属性       | 列名     | 数据类型 | 长度 | 约束 |
|------------|----------|----------|------|------|
| 公告编号   | Pno      | Int      |      | 主键 |
| 发布者署名 | Pname    | Char     | 20   |      |
| 公告内容   | Pcontent | Varchar  | 200  |      |
| 发布时间   | Ptime    | Char     | 50   |      |



匿名留言板（Messagess）表：

| 属性     | 列名     | 数据类型 | 长度 | 约束 |
|----------|----------|----------|------|------|
| 留言编号 | Mno      | Char     | 20   | 主键 |
| 留言内容 | Mcontent | Varchar  | 200  |      |
| 发布时间 | Mtime    | Char     | 50   |      |



### SQL代码

```sql
CREATE DATABASE TTaps

create table Users
(	Uno int not null primary key,
	Uaccount char(20) null,
	Uname char(20) null,
	Upassword varchar(20) null,
	Uauthority int)

create table Taps
(	Tno int not null primary key,
	Tname char(20) null,
	TTypeno int null,
	Tstate char(20))

create table TapsType
(	TTno int not null primary key,
	TTTypename varchar(30) null,)

create table LetTaps
(	Lno int not null primary key,
	LTaps char(20) null,
	LTTypename char(20) null,
	LTime char(50) null)

create table Publics
(	Pno int not null primary key,
	Pname char(20) null,
	Pcontent varchar(200) null,
	Ptime char(50) null)

create table Messagess
(	Mno int not null primary key,
	Mcontent varchar(200) null,
	Mtime char(50) null)

INSERT INTO Users VALUES (1,111,'管理员','111','1')
INSERT INTO Users VALUES (2,222,'用户','222','2')

INSERT INTO Publics VALUES (2,'张三','哎呦不错喔')

update Publics set Pcontent='hello',Pname='222' where Pno=2

INSERT INTO Messagess VALUES (1,'哎呦不错哦！')

INSERT INTO Taps VALUES (1,'平凡的生活',1,'在库')
INSERT INTO Taps VALUES (2,'楚门的世界',2,'不在库')

INSERT INTO TapsType VALUES (1,'摇滚')
INSERT INTO TapsType VALUES (2,'流行')

select * from Users where Uname='管理员'

select Tno,Tname,TTTypename from Taps LEFT join TapsType on Taps.TTypeno=TapsType.TTno where Tno=2

select Tno,Tname,TTTypename,Tstate from Taps LEFT join TapsType on Taps.TTypeno=TapsType.TTno

update Taps set Tstate='在库' where Tno=1

select * from LetTaps
```



### 系统框架

基于MVC设计的音像租赁系统通过 Java 语言进行开发设计，应用的数据库是SQL SERVER 2008 版本。JSP 技术是以 Java 语言作为脚本语言，JSP 网页为整个服务器端的 Java 库单元提供了一个接口来服务于 HTTP 的应用程序。本系统采用分层的模式设计，设计包括实体类、接口类、实现类、数据库工厂类、控制器类、数据库连接类。音像出租系统框架结构图，如图所示：

![](https://s2.loli.net/2022/09/29/Sf9aGijLwcnheyU.png)



dao包类：

| 文件名            | 说明           |
|-------------------|----------------|
| LetTapsDAO.java   | 租赁接口类     |
| MessagessDAO.java | 留言板接口类   |
| PublicsDAO.java   | 公告接口类     |
| TapsDAO.java      | 音像接口类     |
| TapsTypeDAO.java  | 音像类型接口类 |
| UsersDAO.java     | 用户接口类     |



dbc包类：

| 文件名            | 说明         |
|-------------------|--------------|
| DBConnection.java | 数据库连接类 |



factory包类：

| 文件名          | 说明         |
|-----------------|--------------|
| DAOFactory.java | 数据库工厂类 |



impl包类：

| 文件名                | 说明           |
|-----------------------|----------------|
| LetTapsDAOImpl.java   | 租赁实现类     |
| MessagessDAOImpl.java | 留言板实现类   |
| PublicsDAOImpl.java   | 公告实现类     |
| TapsDAOImpl.java      | 音像实现类     |
| TapsTypeDAOImpl.java  | 音像类别实现类 |
| UsersDAOImpl.java     | 用户实现类     |



model包类：

| 文件名         | 说明           |
|----------------|----------------|
| LetTaps.java   | 租赁实体类     |
| Messagess.java | 留言板实体类   |
| Publics.java   | 公告实体类     |
| Taps.java      | 音像实体类     |
| TapsType.java  | 音像类别实体类 |
| Users.java     | 用户实体类     |



servlet包类：

| 文件名                               | 说明                   |
|--------------------------------------|------------------------|
| Admins_LetTapsAddServlet.java        | 添加租赁信息控制器类   |
| Admins_LetTapsDeleteServlet.java     | 删除租赁信息控制器类   |
| Admins_LetTapsQueryAllServlet.java   | 查看租赁信息控制器类   |
| Admins_LetTapsUpServlet.java         | 更新租赁信息控制器类   |
| Admins_MessagessAddServlet.java      | 添加留言板信息控制器类 |
| Admins_MessagessDeleteServlet.java   | 删除留言板信息控制器类 |
| Admins_MessagessQueryAllServlet.java | 查看留言板信息控制器类 |
| Admins_MessagessUpServlet.java       | 更新留言板信息控制器类 |
| Admins_PublicsAddServlet.java        | 添加公告控制器类       |
| Admins_PublicsDeleteServlet.java     | 删除公告控制器类       |
| Admins_PublicsQueryAllServlet.java   | 查看公告控制器类       |
| Admins_PublicsUpServlet.java         | 更新公告控制器类       |
| Admins_TapsAddServlet.java           | 添加音像控制器类       |
| Admins_TapsDeleteServlet.java        | 删除音像控制器类       |
| Admins_TapsQueryServlet.java        | 查看音像控制器类       |
| Admins_TapsTypeAddServlet.java      | 添加类别控制器类       |
| Admins_TapsTypeDeleteServlet.java   | 删除类别控制器类       |
| Admins_TapsTypeQueryServlet.java    | 查看类别控制器类       |
| Admins_TapsTypeUpServlet.java       | 更新类别控制器类       |
| Admins_TapsUpServlet.java           | 更新类别控制器类       |
| Admins_UsersAddServlet.java         | 添加用户控制器类       |
| Admins_UsersDeleteServlet.java      | 删除用户控制器类       |
| Admins_UsersQueryServlet.java       | 查看用户控制器类       |
| Admins_UsersUpServlet.java          | 更新用户控制器类       |
| ewer.java                           | 获取下拉框类别控制器类 |
| ewer1.java                          | 获取下拉框类别控制器类 |
| LoginAddServlet.java                | 注册控制器类           |
| LoginServlet.java                   | 登录控制器类           |
| Users_FindTapsByIdServlet.java      | 获取租赁信息控制器类   |
| Users_LetTapsDeleteServlet.java     | 归还音像控制器类       |
| Users_LetTapsQueryAllServlet.java   | 查看租赁控制器类       |
| Users_LetTapsServlet.java           | 租赁控制器类           |
| Users_MessagessAddServlet.java      | 添加留言控制器类       |
| Users_MessagessQueryAllServlet.java | 查看留言控制器类       |
| Users_PublicsQueryAllServlet.java   | 查看公告控制器类       |
| Users_TapsdoDeleteServlet.java      | 更新音像状态控制器类   |
| Users_TapsdoUpServlet.java          | 更新音像状态控制器类   |
| Users_TapsQueryAllServlet.java      | 查看音像控制器类       |



### 运行实例

![](https://s2.loli.net/2022/09/29/FgBz3kiCu4rZQfX.png)

![](https://s2.loli.net/2022/09/29/lB6JPMnFfRpa5v7.png)

![](https://s2.loli.net/2022/09/29/q7NLMBGr2z9npJZ.png)

![](https://s2.loli.net/2022/09/29/iK8mvr4hHUpR91g.png)

![](https://s2.loli.net/2022/09/29/6BoZ43uxFdMvpEi.png)

![](https://s2.loli.net/2022/09/29/MJQs4YyE1VXe2vo.png)
