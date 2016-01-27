package com.aotimes.yy.demo;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.wall.WallFilter;
import com.aotimes.yy.demo.act.AdminAct;
import com.aotimes.yy.demo.act.LoginAct;
import com.aotimes.yy.demo.model.TProject;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
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
		me.setDevMode(true);
		me.setViewType(ViewType.JSP);

		// 加载配置文件
		loadPropertyFile("property.txt");
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
		String url = getProperty("jdbc.url");
		String user = getProperty("jdbc.user");
		String pwd = getProperty("jdbc.pwd");

		DruidPlugin dp = new DruidPlugin(url, user, pwd);
		dp.addFilter(new StatFilter());
		WallFilter wall = new WallFilter();
		wall.setDbType("mysql");
		dp.addFilter(wall);
		plugins.add(dp);

		ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
		arp.addMapping("t_project", TProject.class);// 项目表
		plugins.add(arp);

	}

	@Override
	public void configRoute(Routes routes) {
		// 配置登录的ACT，并且将路径指向page文件夹下
		routes.add("/", LoginAct.class, "page");

		// 配置后台管理的ACT，并且将路径指向page/admin文件夹下
		routes.add("/admin", AdminAct.class, "page/admin");
	}

}
