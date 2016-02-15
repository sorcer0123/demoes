/**
 * @see 扩展jquery，增加一个table的方法
 * @category js
 * @since 2016年2月15日
 * @param tableID 表格的ID
 * @param options 表格的一些属性
 * @author 杨阳
 */

(function($) {
	
	$table = function(tableID, options){
		var gridDefaultsOptions = {
			url:"<%=basePath%>admin/projectTable",//请求数据地址
			method:"post",//请求数据方法
			dataType:"json",//数据格式
			columns:[],//列
			pagination:true,//是否显示分数工具条
			showPaginationSwitch:false,//显示隐藏分页的工具条，没啥用
			sidePagination:'server',//采用服务端分页还是客户端分页，参数：'server' or 'client'
			pageNumber:1,//初始显示第几页数据
			pageSize:10,
			pageList:[10,25,50,100],		
			showColumns:true,//动态控制显示的列，在表格的右上角
			showRefresh:true,//显示刷新按钮
			showToggle:true,//切换表格的显示方式,
			cardView:false,//设定为true则默认以文本方式显示表格
			buttonsAlign:"left"//刷新表格等按钮显示在左边,参数：'left' or 'right'
		};
		
		// 表示将自己定义的ajaxDefaultsOptions与传入的options相结合，如果后面与前面的属性相同，那么以后面的为准
		var opts = $.extend({}, gridDefaultsOptions, options);
		$('#'+tableID).bootstrapTable(opts);
	};
	
})(jQuery);


/**
 * 格式化表格中日期的方法
 * @param value 日期字段的值，一般都是long型的
 * @param row 整个行
 * @param index 下标
 * @returns {String} 格式化后的字符串
 */
function dateFormatter(value, row, index){
	var formatterStr = "";
	if(null != value && "" != value) {
		formatterStr = getSmpFormatDate(new Date(value));
	} 
	return formatterStr;
}






