package dao;

import java.util.List;

import model.Messagess;

public interface MessagessDAO {
	
	//��ѯȫ��
		public List<Messagess> FindAllMessagess()throws Exception;
		//���
		public boolean doCreate(Messagess messagess)throws Exception;
		//ɾ��
		public boolean doDelete(int Mno) throws Exception;
		//�޸�
		public boolean doUpdate(Messagess messagess) throws Exception;
}
