package cn.mldn.oracle.factory;

import cn.mldn.oracle.service.proxy.ServiceProxy;

public class ServiceFactory {
	private ServiceFactory() {}
	public static <T> T getInstance(Class<T> cls) {
		try {
			return new ServiceProxy().bind(cls) ;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null ; 
	}
}
