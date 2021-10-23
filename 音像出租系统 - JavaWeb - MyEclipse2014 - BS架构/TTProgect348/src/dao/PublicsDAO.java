package dao;

import java.util.List;

import model.Publics;

public interface PublicsDAO {
	
	//查询全部
		public List<Publics> FindAllPublics()throws Exception;
		//添加
		public boolean doCreate(Publics publics)throws Exception;
		//删除
		public boolean doDelete(int Pno) throws Exception;
		//修改
		public boolean doUpdate(Publics publics) throws Exception;
}
