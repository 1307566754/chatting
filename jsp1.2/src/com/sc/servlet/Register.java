package com.sc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.sc.bean.UsersBean;
import com.sc.dao.UsersDao;

@WebServlet("/reg")
@SuppressWarnings("serial")
public class Register extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("uname");
		String pass = req.getParameter("upassword");
		
		UsersDao userdao = new UsersDao();
		boolean isUser = userdao.selectUser(name);
		if (!isUser) {
			JOptionPane.showMessageDialog(null, "该用户已存在!");
			resp.sendRedirect(req.getContextPath() + "/register.jsp");
		}
		else {
			JOptionPane.showMessageDialog(null, "注册成功！");
			req.setAttribute("name", name);
			UsersBean usersbean = new UsersBean(name,pass);
			userdao.insertUser(usersbean);
			
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.print(name + "，欢迎你！");
			out.close();
		}
	}
}
