
package factory;

import impl.*;
import dao.*;

public class DAOFactory {
//静态(静态的方法)工厂类,生产对象(实现类的对象)
	//接口 ——实现类——父类(接口)的变量，指向子类(实现类)，多态性
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
