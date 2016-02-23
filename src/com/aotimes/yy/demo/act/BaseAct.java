package com.aotimes.yy.demo.act;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

	/***************************************** 返回表格数据方法 *******************************************/
	/**
	 * @see 获取表格数据的公共方法
	 * @param sql
	 *            查询数据的sql语句
	 * @return json数组
	 */
	public String getGridData(String sql) {
		log.debug("---------------------get Table data---------------------");
		log.debug("SQL:[" + sql + "]");

		String offset = getPara("offset");
		String limit = getPara("limit");

		List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();

		Map<String, Object> map = new HashMap<>();

		String totalSql = getTotalSql(sql);
		long total = Db.queryLong(totalSql);
		map.put("total", total);// 返回所有条数

		long totalPage = (total - 1) / 10 + 1;
		map.put("page", totalPage);

		String litmitSql = getLimitSql(sql, offset, limit);
		List<Record> list = Db.find(litmitSql);

		for (int i = 0, length = list.size(); i < length; i++) {
			Record columnValues = list.get(i);
			Map<String, Object> m = columnValues.getColumns();
			rows.add(m);
		}

		map.put("rows", rows);

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
	 *            sql语句
	 * @param startRows
	 *            从第几条数据开始
	 * @param limit
	 *            每页显示几条
	 * @return
	 */
	public String getLimitSql(String sql, String startRows, String limit) {
		log.debug("传入ＳＱＬ:");
		log.debug(sql);

		StringBuffer sb = new StringBuffer();
		try {
			if (null == sql || "".equals(sql)) {
				throw new ExceptionUtils("没有传入SQL语句！");
			}

			sb.append(" select * from ( ");
			sb.append(sql);
			sb.append(" ) tab limit " + startRows + ", " + limit);

			log.debug("转换后ＳＱＬ:");
			log.debug(sb.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return sb.toString();
	}
	/***************************************** 返回表格数据方法 *******************************************/

	/***************************************** 数据库操作方法 *******************************************/
	/**
	 * 保存单一对象
	 * 
	 * @param tableName
	 *            数据库对应的表名
	 * @param rec
	 *            要保存的对象
	 */
	public boolean saveObj(String tableName, Record rec) {
		return Db.save(tableName, rec);
	}

	/**
	 * 根据ID删除某一对象
	 * 
	 * @param tableName
	 *            数据库对应的表名
	 * @param id
	 *            要删除对象的ID
	 * @return
	 */
	public boolean deleteObj(String tableName, String id) {
		return Db.deleteById(tableName, id);
	}

	/**
	 * 根据ＩＤ获得对象
	 * 
	 * @param tableName
	 *            数据库对应的表名
	 * @param id
	 *            对象ID
	 * @return
	 */
	public Record getObjById(String tableName, String id) {
		return Db.findById(tableName, id);
	}

	/**
	 * 更新对象
	 * 
	 * @param tableName
	 *            数据库对应的表名
	 * @param rec
	 *            要更新的对象
	 * @return
	 */
	public boolean updateObj(String tableName, Record rec) {
		return Db.update(tableName, rec);
	}

	/**
	 * 获得数据行数
	 * 
	 * @param sql
	 *            sql语句
	 * @return
	 */
	public long queryLong(String sql) {
		return Db.queryLong(sql);
	}

	/***************************************** 数据库操作方法 *******************************************/

	/***************************************** 操作json方法 *******************************************/
	public String successJson(String msg) {
		JSONObject json = new JSONObject();
		json.put("success", true);
		json.put("msg", msg);
		return json.toString();
	}

	public String errorJson(String msg) {
		JSONObject json = new JSONObject();
		json.put("success", false);
		json.put("msg", msg);
		return json.toString();
	}

	/***************************************** 操作json方法 *******************************************/

	/***************************************** 获取UUID方法 *******************************************/

	public String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	/***************************************** 获取UUID方法 *******************************************/
}
