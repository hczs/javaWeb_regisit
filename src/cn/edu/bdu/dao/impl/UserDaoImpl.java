package cn.edu.bdu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.edu.bdu.bean.User;
import cn.edu.bdu.dao.UserDao;
import cn.edu.bdu.util.JDBCUtils;

public class UserDaoImpl implements UserDao{

	@Override
	public boolean insertUser(User user) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			//获取连接
			connection = JDBCUtils.getConnection();
			//写sql语句用PreparedStatement预处理
			String sql = "INSERT INTO user(name,password,email,birthday) VALUES(?,?,?,?)";
			//收到PreparedStatement对象
			prepareStatement = connection.prepareStatement(sql);
			//赋值
			prepareStatement.setString(1, user.getName());
			prepareStatement.setString(2, user.getPassword());
			prepareStatement.setString(3, user.getEmail());
			prepareStatement.setString(4, user.getDate());
			//执行
			int result = prepareStatement.executeUpdate();
			//判断 result>0 true else false
			if(result>0) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtils.release(connection, prepareStatement);
		return false;
	}
	
}
