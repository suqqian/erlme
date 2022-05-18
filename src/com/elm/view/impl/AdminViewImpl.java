package com.elm.view.impl;

import com.elm.dao.AdminDao;
import com.elm.dao.impl.AdminDaoImpl;
import com.elm.po.Admin;
import com.elm.view.AdminView;

import java.util.Scanner;



public class AdminViewImpl implements AdminView {

	private Scanner input = new Scanner(System.in);

	@Override
	public Admin login() {
		System.out.println("请输入管理员名称：");
		String adminName = input.next();
		System.out.println("请输入密码：");
		String password = input.next();
		AdminDao dao = new AdminDaoImpl();
		return dao.getAdminByNameByPass(adminName, password);
	}

	@Override
	public void insectAdmin() {
		System.out.println("请输入设置管理员姓名：");
		String adminName = input.next();
		System.out.println("请输入设置密码：");
		String password = input.next();
		Admin admin = new Admin();
		admin.setAdminName(adminName);
		admin.setPassword(password);
		AdminDao adminDao = new AdminDaoImpl();
		int adminId = adminDao.insectAdmin(admin);
		if (adminId != 0) {
			System.out.println("\n插入管理者信息成功！\n");
		} else {
			System.out.println("\n插入管理者信息失败！\n");
		}
	}

	@Override
	public void updataAdminPassWord() {
		System.out.println("请输入要修改密码的管理员姓名：");
		String adminName = input.next();
		System.out.println("请输入设置的密码");
		String password = input.next();
		Admin admin = new Admin();
		admin.setAdminName(adminName);
		admin.setPassword(password);
		AdminDao adminDao = new AdminDaoImpl();
		int id = adminDao.updataAdminPassWord(admin);
		if (id != 0) {
			System.out.println("\n修改密码成功！\n");
		} else {
			System.out.println("\n修改密码失败！\n");
		}
	}

	@Override
	public void selectAdminPassWord() {
		System.out.println("请输入管理员姓名：");
		String adminName = input.next();
		AdminDao adminDao = new AdminDaoImpl();
		Admin admin = adminDao.selectAdminPassWord(adminName);
		System.out.println("\n密码为:"+admin.getPassword());
	}
}

