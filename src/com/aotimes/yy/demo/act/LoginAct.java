package com.aotimes.yy.demo.act;

import com.jfinal.core.ActionKey;
import com.jfinal.plugin.activerecord.Db;

/**
 * @see 登录相关Act
 * @since 2016年1月21日
 * @category action
 * @author 杨阳
 */
public class LoginAct extends BaseAct {

	@ActionKey("/")
	public void login() {// 跳转到登录页
		render("login.jsp");
	}

	@ActionKey("/admin")
	public void admin() {// 跳转到管理端
		render("admin/admin.jsp");
	}

}
