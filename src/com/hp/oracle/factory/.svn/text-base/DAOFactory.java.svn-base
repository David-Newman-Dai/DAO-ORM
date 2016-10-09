package cn.mldn.oracle.factory;

/**
 * 取得DAO接口的工厂类
 * @author mldn
 */
public class DAOFactory {
	private DAOFactory() {} ;	// 为了不产生实例化对象
	/**
	 * 定义DAO接口的对象取得
	 * @param cls 子类的Class对象
	 * @return 一个接口的实例化对象
	 */ 
	public static <T> T getInstance(Class<T> cls) {
		try {
			return cls.newInstance() ; 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null ;
	}
}
