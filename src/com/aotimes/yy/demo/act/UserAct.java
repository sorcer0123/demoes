package com.aotimes.yy.demo.act;

/**
 * @see 管理端的，用户管理Act
 * @since 2016年2月23日
 * @category action
 * @author 杨阳
 */
public class UserAct extends BaseAct {

	public void admin_user() {// 跳转到用户管理界面
		render("admin_user.jsp");
	}

	public void userTable() {// 获得用户管理列表
		String sql = " select * from t_user ";
		String searchKey = getPara("searchKey", "");
		if (!"".equals(searchKey)) {
			sql += " where name like '%" + searchKey + "%' or content like '%" + searchKey + "%' ";
		}
		String json = this.getGridData(sql);
		renderJson(json);
	}

	public void addOrUpdateUser() {// 跳转到增加或者是修改页面
		
	}

}
