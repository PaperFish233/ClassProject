package dao;

import java.util.List;

import model.Users;

public interface UsersDAO {
	//��ѯ��¼
	public boolean FindLogin(Users users)throws Exception;
	//��ѯȫ��
	public List<Users> FindAllUsers()throws Exception;
	//���
	public boolean doCreate(Users users)throws Exception;
	//ɾ��
	public boolean doDelete(int Uno) throws Exception;
	//�޸�
	public boolean doUpdate(Users users) throws Exception;
}
