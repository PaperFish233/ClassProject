package dao;

import java.util.List;

import model.TapsType;

public interface TapsTypeDAO {
	//��ѯȫ��
	public List<TapsType> FindAllTapsType()throws Exception;
	//���
	public boolean doCreate(TapsType tapstype)throws Exception;
	//ɾ��
	public boolean doDelete(int TTno) throws Exception;
	//�޸�
	public boolean doUpdate(TapsType tapstype) throws Exception;
	
}
