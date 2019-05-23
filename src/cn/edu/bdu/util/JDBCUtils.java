package cn.edu.bdu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCUtils {
	
	//获取连接对象
	public static Connection getConnection() {
		Connection connection = null;
		try {
			//1.注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.获取连接对象
			String url = "jdbc:mysql://localhost:3306/chapter01";
			String username = "root";
			String password = "123456";
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	//释放资源 先写释放两个的，释放connection 和 preparedStatement
	public static void release(Connection connection,PreparedStatement prepareStatement) {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(prepareStatement != null) {
			try {
				prepareStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
