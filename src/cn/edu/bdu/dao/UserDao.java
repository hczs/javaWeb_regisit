package cn.edu.bdu.dao;

import cn.edu.bdu.bean.User;

/**
 * 写对user表操作的相关方法
 * @author Administrator
 *
 */
public interface UserDao {
	
	/**
	 * 插入一个用户
	 * @param user  user对象
	 * @return  true or false
	 */
	boolean insertUser(User user);
}
