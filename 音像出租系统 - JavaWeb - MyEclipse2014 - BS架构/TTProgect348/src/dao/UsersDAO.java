package dao;

import java.util.List;

import model.Users;

public interface UsersDAO {
	//查询登录
	public boolean FindLogin(Users users)throws Exception;
	//查询全部
	public List<Users> FindAllUsers()throws Exception;
	//添加
	public boolean doCreate(Users users)throws Exception;
	//删除
	public boolean doDelete(int Uno) throws Exception;
	//修改
	public boolean doUpdate(Users users) throws Exception;
}
