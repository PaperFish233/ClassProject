package dao;

import java.util.List;

import model.TapsType;

public interface TapsTypeDAO {
	//查询全部
	public List<TapsType> FindAllTapsType()throws Exception;
	//添加
	public boolean doCreate(TapsType tapstype)throws Exception;
	//删除
	public boolean doDelete(int TTno) throws Exception;
	//修改
	public boolean doUpdate(TapsType tapstype) throws Exception;
	
}
