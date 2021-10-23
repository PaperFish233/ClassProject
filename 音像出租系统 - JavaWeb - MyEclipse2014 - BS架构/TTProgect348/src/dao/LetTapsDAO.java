package dao;

import java.util.List;

import model.LetTaps;
import model.Publics;


public interface LetTapsDAO {

	//���
	public boolean doLetTaps(LetTaps lettaps)throws Exception;
	//��ȡ
	public LetTaps FindTapsById(int Lno) throws Exception;
	//��ȫ��
	public List<LetTaps> FindAllLetTaps()throws Exception;
	//���������--����
	public boolean doDelete(int Tno) throws Exception;
	//���������--�黹
		public boolean doUp(int Tno) throws Exception;
	//ɾ��
	public boolean doDelete1(int Lno) throws Exception;
	//�޸�
	public boolean doUpdate(LetTaps lettaps) throws Exception;
	//���
	public boolean doCreate(LetTaps lettaps)throws Exception;
}
