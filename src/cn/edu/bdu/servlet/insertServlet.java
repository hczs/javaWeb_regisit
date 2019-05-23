package cn.edu.bdu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.bdu.bean.User;
import cn.edu.bdu.dao.UserDao;
import cn.edu.bdu.dao.impl.UserDaoImpl;

/**
 * Servlet implementation class insertServlet
 */
@WebServlet("/insertServlet")
public class insertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置编码
		request.setCharacterEncoding("UTF-8");
		//获取传送过来的数据
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String date = request.getParameter("date");
		
		//设置user对象
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		user.setEmail(email);
		user.setDate(date);
		
		//获取session对象
		HttpSession session = request.getSession();
		
		UserDao dao = new UserDaoImpl();
		boolean b = dao.insertUser(user);
		if(b) {
			//把user存储到session里面
			session.setAttribute("user",user);
			response.sendRedirect("success.jsp");
		}else {
			response.sendRedirect("fail.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
