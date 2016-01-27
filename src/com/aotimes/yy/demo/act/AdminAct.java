package com.aotimes.yy.demo.act;

import com.jfinal.core.ActionKey;

/**
 * @see 管理端的Act
 * @since 2016年1月21日
 * @category action
 * @author 杨阳
 */
public class AdminAct extends BaseAct {

	@ActionKey("/admin/admin_project")
	public void adminProject() {// 跳转到项目管理页面
		render("admin_project.jsp");
	}

	@ActionKey("/admin/projectTable")
	public void projectTable() {// 获得项目管理列表

		String sql = " select * from t_project ";

		String json = this.getGridData(sql);

		renderJson(json);
	}
}
