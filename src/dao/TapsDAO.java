package dao;

import java.util.List;

import model.Taps;

public interface TapsDAO {
	//��ѯȫ��
	public List<Taps> FindAllTaps()throws Exception;
	//���
	public boolean doCreate(Taps taps)throws Exception;
	//ɾ��
	public boolean doDelete(int Tno) throws Exception;
	//�޸�
	public boolean doUpdate(Taps taps) throws Exception;
}
