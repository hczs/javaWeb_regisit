package cn.edu.bdu.dao;

import cn.edu.bdu.bean.User;

/**
 * д��user���������ط���
 * @author Administrator
 *
 */
public interface UserDao {
	
	/**
	 * ����һ���û�
	 * @param user  user����
	 * @return  true or false
	 */
	boolean insertUser(User user);
}
