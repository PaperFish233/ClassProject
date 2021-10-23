package dao;

import java.util.List;

import model.Taps;

public interface TapsDAO {
	//查询全部
	public List<Taps> FindAllTaps()throws Exception;
	//添加
	public boolean doCreate(Taps taps)throws Exception;
	//删除
	public boolean doDelete(int Tno) throws Exception;
	//修改
	public boolean doUpdate(Taps taps) throws Exception;
}
