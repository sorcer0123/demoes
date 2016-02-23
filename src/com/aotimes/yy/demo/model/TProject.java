package com.aotimes.yy.demo.model;

import com.jfinal.plugin.activerecord.Model;

/**
 * @see 项目的实体类
 * @since 特别注意： User 中定义的 public static final User dao 对象是全局共享的， 只能用于数据库查询，
 *        不能用于数据承载对象。数据承载需要使用 new User().set(…)来实现
 * @category bean
 * @author 杨阳
 */
public class TProject extends Model<TProject> {

	private static final long serialVersionUID = 1L;

	public static final TProject dao = new TProject();
}
