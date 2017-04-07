package com.imooc.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.domain.User;
import com.imooc.service.UserService;
import com.imooc.service.impl.UserServiceImpl;

/**
 * Servlet implementation class ActiveServlet
 */
public class ActiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActiveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收激活码
		String code = request.getParameter("code");
		UserService userService = new UserServiceImpl();
		try {
			User user=  userService.findUserByCode(code);
			if(null !=user)
			{
				//已经查询到用户，修改用户状态
				user.setState(1);//已经激活
				user.setCode(null);
				userService.update(user);
				request.setAttribute("msg", "你已经激活成功，请登录。");
			}else {
				//根据激活码没有查询到用户
				request.setAttribute("msg", "你的激活码有误，请重新激活。");
			}
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//根据激活码查询用户
		
		//查询到用户后，更改状态
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
