package com.aotimes.yy.demo.act;

import java.util.Date;

import com.jfinal.plugin.activerecord.Record;

/**
 * @see 管理端,项目管理Act
 * @since 2016年1月21日
 * @category action
 * @author 杨阳
 */
public class AdminAct extends BaseAct {

	public void admin_project() {// 跳转到项目管理页面
		render("admin_project.jsp");
	}

	public void projectTable() {// 获得项目管理列表
		String sql = " select * from t_project ";
		String searchKey = getPara("searchKey", "");
		if (!"".equals(searchKey)) {
			sql += " where name like '%" + searchKey + "%' or content like '%" + searchKey + "%' ";
		}
		String json = this.getGridData(sql);
		renderJson(json);
	}

	public void addOrUpdatePro() {// 跳转到增加或者是修改项目的页面
		String id = getPara("id", "");
		Record project = new Record();
		if (!"".equals(id)) {
			project = getObjById("t_project", id);
		}
		setAttr("project", project);
		render("addOrUpdatePro.jsp");
	}

	public void savePro() {// 保存项目数据
		String id = getPara("id", "");
		String name = getPara("name");
		String content = getPara("content");
		String result = "";
		if ("".equals(id)) {// 表示是增加
			Record pro = new Record();
			pro.set("id", getUUID());
			pro.set("name", name);
			pro.set("content", content);
			pro.set("createtime", new Date());
			if (saveObj("t_project", pro)) {
				result = successJson("增加项目成功!");
			} else {
				result = errorJson("增加项目失败，请重试!");
			}
		} else {
			Record pro = getObjById("t_project", id);
			pro.set("name", name);
			pro.set("content", content);
			if (updateObj("t_project", pro)) {
				result = successJson("修改项目成功!");
			} else {
				result = errorJson("修改项目失败，请重试!");
			}
		}
		renderJson(result);
	}

	public void deletePro() {// 删除项目
		String id = getPara("id");
		String result = "";
		if (deleteObj("t_project", id)) {
			result = successJson("删除项目成功!");
		} else {
			result = errorJson("删除项目失败，请重试!");
		}
		renderJson(result);
	}
}
