package cn.edu.bdu.mc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class test {
	public static void main(String[] args) {
		try {
			//1.注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.获取连接对象
			String url = "jdbc:mysql://localhost:3306/chapter01";
			String username = "root";
			String password = "123456";
			Connection connection = DriverManager.getConnection(url, username, password);
			//3.获取PreparedStatement对象 （和数据库打交道）      先写sql语句进行一个简单地查询
			String sql = "select * from user";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			//4.执行查询 返回结果集
			ResultSet resultSet = prepareStatement.executeQuery();
			//5.遍历结果集
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String pwd = resultSet.getString("password");
				String email = resultSet.getString("email");
				String birthday = resultSet.getString("birthday");
				System.out.println("|"+id+"|"+name+"|"+pwd+"|"+email+"|"+birthday);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
