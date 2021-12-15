
package factory;

import impl.*;
import dao.*;

public class DAOFactory {
//��̬(��̬�ķ���)������,��������(ʵ����Ķ���)
	//�ӿ� ����ʵ���ࡪ������(�ӿ�)�ı�����ָ������(ʵ����)����̬��
	//UsersDAO ud=new UsersDAOImpl();
	public static UsersDAO getUsersDAOInstance(){
		return new UsersDAOImpl();
	}
	public static PublicsDAO getPublicsDAOInstance(){
		return new PublicsDAOImpl();
	}
	public static MessagessDAO getMessagessDAOInstance(){
		return new MessagessDAOImpl();
	}
	public static TapsDAO getTapsDAOInstance(){
		return new TapsDAOImpl();
	}
	public static TapsTypeDAO getTapsTypeDAOInstance(){
		return new TapsTypeDAOImpl();
	}
	public static LetTapsDAO getLetTapsDAOInstance(){
		return new LetTapsDAOImpl();
}
}
