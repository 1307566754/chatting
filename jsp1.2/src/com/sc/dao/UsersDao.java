package com.sc.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sc.bean.UsersBean;

import java.sql.Connection;
import java.sql.ResultSet;

public class UsersDao {
	
	private Connection con;
	private PreparedStatement pre;
	private ResultSet re;
	private String sql = null;
	
	public boolean selectUser(String uname) {
		try {
			sql = "select * from users where uname=?";
			con = Conn.getConn();
			pre = con.prepareStatement(sql);
			pre.setObject(1, uname);
			re = pre.executeQuery();
			if (re != null && re.next())
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("��ȡ��������Ԥ����sql���ʧ��...");
		} finally {
			try {
				if (re != null)
					re.close();
				if (pre != null)
					pre.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("�ر����ݿ�ʧ��...");
			}
		}
		return true;
	}
	
	public void insertUser(UsersBean ub){
		sql = "insert into users(uname,upass) values(?,?)";
		try {
			con = Conn.getConn();
			pre = con.prepareStatement(sql);
			pre.setObject(1, ub.getUname());
			pre.setObject(2, ub.getUpass());
			pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("��ȡ��������Ԥ����sql�����û����ʧ��...");
		} finally {
			try {
				if (re != null)
					re.close();
				if (pre != null)
					pre.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("�ر����ݿ�ʧ��...");
			}
		}
	}

}
