package dao;

import java.util.List;

import model.Publics;

public interface PublicsDAO {
	
	//��ѯȫ��
		public List<Publics> FindAllPublics()throws Exception;
		//���
		public boolean doCreate(Publics publics)throws Exception;
		//ɾ��
		public boolean doDelete(int Pno) throws Exception;
		//�޸�
		public boolean doUpdate(Publics publics) throws Exception;
}
