package cn.edu.bdu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCUtils {
	
	//��ȡ���Ӷ���
	public static Connection getConnection() {
		Connection connection = null;
		try {
			//1.ע������
			Class.forName("com.mysql.jdbc.Driver");
			//2.��ȡ���Ӷ���
			String url = "jdbc:mysql://localhost:3306/chapter01";
			String username = "root";
			String password = "123456";
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	//�ͷ���Դ ��д�ͷ������ģ��ͷ�connection �� preparedStatement
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
