package dao;

import java.util.List;

import model.Messagess;

public interface MessagessDAO {
	
	//查询全部
		public List<Messagess> FindAllMessagess()throws Exception;
		//添加
		public boolean doCreate(Messagess messagess)throws Exception;
		//删除
		public boolean doDelete(int Mno) throws Exception;
		//修改
		public boolean doUpdate(Messagess messagess) throws Exception;
}
