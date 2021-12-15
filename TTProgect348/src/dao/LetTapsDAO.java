package dao;

import java.util.List;

import model.LetTaps;
import model.Publics;


public interface LetTapsDAO {

	//添加
	public boolean doLetTaps(LetTaps lettaps)throws Exception;
	//获取
	public LetTaps FindTapsById(int Lno) throws Exception;
	//查全部
	public List<LetTaps> FindAllLetTaps()throws Exception;
	//更新音像表--租赁
	public boolean doDelete(int Tno) throws Exception;
	//更新音像表--归还
		public boolean doUp(int Tno) throws Exception;
	//删除
	public boolean doDelete1(int Lno) throws Exception;
	//修改
	public boolean doUpdate(LetTaps lettaps) throws Exception;
	//添加
	public boolean doCreate(LetTaps lettaps)throws Exception;
}
