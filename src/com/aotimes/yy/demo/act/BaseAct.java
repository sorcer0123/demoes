package com.aotimes.yy.demo.act;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aotimes.yy.demo.exception.ExceptionUtils;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

/**
 * @see 基础Act，封装了一些方法
 * @since 2016年1月21日
 * @category action
 * @author 杨阳
 */
public class BaseAct extends Controller {

	private static final Logger log = Logger.getLogger(BaseAct.class);

	/**
	 * @see 获取表格数据的公共方法
	 * @param sql
	 *            查询数据的sql语句
	 * @return json数组
	 */
	public String getGridData(String sql) {
		log.debug("---------------------get Table data---------------------");
		log.debug("SQL:[" + sql + "]");
		Map<String, Object> map = new HashMap<>();

		String totalSql = getTotalSql(sql);
		long total = Db.queryLong(totalSql);
		map.put("total", total);// 返回所有条数

		long totalPage = (total - 1) / 10 + 1;
		map.put("totalPage", totalPage);

		String litmitSql = getLimitSql(sql);
		List<Record> list = Db.find(litmitSql);
		map.put("tableDatas", list);

		String result = JSON.toJSONString(map);

		log.debug("data:[" + result + "]");
		log.debug("---------------------get Table data---------------------");
		return result;
	}

	/**
	 * 获得查询全部条数的ＳＱＬ语句
	 * 
	 * @param sql
	 * @return
	 */
	public String getTotalSql(String sql) {
		StringBuffer sb = new StringBuffer();
		try {
			if (null == sql || "".equals(sql)) {
				throw new ExceptionUtils("没有传入SQL语句！");
			}

			sb.append(" select count(*) from ( ");
			sb.append(sql);
			sb.append(" ) tab");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return sb.toString();
	}

	/**
	 * 获得可以分页的语句
	 * 
	 * @param sql
	 * @return
	 */
	public String getLimitSql(String sql) {

		String startPage = getPara("startPage") == null ? "1" : getPara("startPage");
		String rows = getPara("rows") == null ? "10" : getPara("rows");

		int startRows = (Integer.parseInt(startPage) - 1) / Integer.parseInt(rows);

		log.debug("传入ＳＱＬ:");
		log.debug(sql);

		StringBuffer sb = new StringBuffer();
		try {
			if (null == sql || "".equals(sql)) {
				throw new ExceptionUtils("没有传入SQL语句！");
			}

			sb.append(" select * from ( ");
			sb.append(sql);
			sb.append(" ) tab limit " + startRows + ", " + rows);

			log.debug("转换后ＳＱＬ:");
			log.debug(sb.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return sb.toString();
	}
}
