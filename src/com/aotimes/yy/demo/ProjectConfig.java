package com.aotimes.yy.demo;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.wall.WallFilter;
import com.aotimes.yy.demo.act.AdminAct;
import com.aotimes.yy.demo.act.LoginAct;
import com.aotimes.yy.demo.act.UserAct;
import com.aotimes.yy.demo.model.TProject;
import com.aotimes.yy.demo.model.TUser;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.druid.DruidStatViewHandler;
import com.jfinal.render.ViewType;

/**
 * @see jfinal架初始化
 * @since 2016年1月21日
 * @category config
 * @author 杨阳
 */
public class ProjectConfig extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {
		// 加载配置文件,用这种方式加载，只可以在当前的ProjectConfig.java类中使用
		// loadPropertyFile("property.txt");

		// 加载配置文件,用这种方式加载,可以在全局中使用，所以通过使用这种方式加载配置文件
		PropKit.use("property.txt");

		// 设置开发模式
		me.setDevMode(PropKit.getBoolean("devMode"));

		// 设置视图解析器，此处设置的是jsp
		me.setViewType(ViewType.JSP);

		// 设置默认视图层的路径
		// me.setBaseViewPath("/WEB-INF/jsp");

		// 设置默认的上传路径,以及设置最大允许上传文件大小，可以是相对路径也可以是绝对路径
		// me.setBaseUploadPath("/upload");
		me.setMaxPostSize(1024 * 1024 * 20);// 20M

		// 设置默认的下载路径,可以是相对路径也可以是绝对路径
		// me.setBaseDownloadPath("/down");

		// 设置错误页面
		me.setError404View("404.html");
		me.setError500View("500.html");

		// 设置网站默认编号
		me.setEncoding("UTF-8");

	}

	@Override
	public void configHandler(Handlers handlers) {
		// 添加druid监控
		DruidStatViewHandler dvh = new DruidStatViewHandler("/druid");
		handlers.add(dvh);
	}

	@Override
	public void configInterceptor(Interceptors interceptors) {

	}

	@Override
	public void configPlugin(Plugins plugins) {
		// 配置数据源
		String url = PropKit.get("jdbc.url");
		String user = PropKit.get("jdbc.user");
		String pwd = PropKit.get("jdbc.pwd");

		DruidPlugin dp = new DruidPlugin(url, user, pwd);
		dp.addFilter(new StatFilter());
		WallFilter wall = new WallFilter();
		wall.setDbType("mysql");
		dp.addFilter(wall);
		plugins.add(dp);

		ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
		arp.addMapping("t_project", TProject.class);// 项目表
		arp.addMapping("t_user", TUser.class);// 用户表
		plugins.add(arp);

	}

	@Override
	public void configRoute(Routes routes) {
		// 配置登录的ACT，并且将路径指向page文件夹下
		routes.add("/", LoginAct.class, "page");

		// 配置后台管理的项目管理ACT，并且将路径指向page/admin/project文件夹下
		routes.add("/project", AdminAct.class, "page/admin/project");

		// 配置后台管理的用户管理ACT，并且将路径指向page/admin/user文件夹下
		routes.add("/user", UserAct.class, "page/admin/user");
	}

}
