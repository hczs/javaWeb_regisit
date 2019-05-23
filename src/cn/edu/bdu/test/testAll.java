package cn.edu.bdu.test;

import cn.edu.bdu.bean.User;
import cn.edu.bdu.dao.UserDao;
import cn.edu.bdu.dao.impl.UserDaoImpl;

public class testAll {
	public static void main(String[] args) {
		UserDao dao = new UserDaoImpl();
		User user = new User();
		user.setName("zhangsan");
		user.setPassword("123456");
		user.setEmail("zhangsan@qq.com");
		user.setDate("1999-12-15");
		boolean b = dao.insertUser(user);
		if(b) {
			System.out.println("success");
		}else {
			System.out.println("fail");
		}
	}
}
