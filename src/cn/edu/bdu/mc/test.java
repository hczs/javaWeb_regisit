package cn.edu.bdu.mc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class test {
	public static void main(String[] args) {
		try {
			//1.ע������
			Class.forName("com.mysql.jdbc.Driver");
			//2.��ȡ���Ӷ���
			String url = "jdbc:mysql://localhost:3306/chapter01";
			String username = "root";
			String password = "123456";
			Connection connection = DriverManager.getConnection(url, username, password);
			//3.��ȡPreparedStatement���� �������ݿ�򽻵���      ��дsql������һ���򵥵ز�ѯ
			String sql = "select * from user";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			//4.ִ�в�ѯ ���ؽ����
			ResultSet resultSet = prepareStatement.executeQuery();
			//5.���������
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
