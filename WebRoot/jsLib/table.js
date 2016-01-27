/**
 * 扩展jquery，增加一个table的方法
 */

(function($) {
	
	var startPage = "1";
	var pages = "10";
	
	$table = function(obj, options) {
		
		var tableStr = "";
		
		if(obj == undefined) {
			
			alert("没有找到列表对象!");
			return;
			
		}
		
		if(options == undefined) {
			
			alert("没有表格属性!");
			return;
			
		}
		
		if(options.url == undefined) {
			
			alert("请写入请求地址!");
			return;
			
		}
		
		var postData = options.postData == undefined ? {} : options.postData;
		
		var url = options.url + "?startPage="+startPage+"&pages="+pages;
		
		$ajax({
			url : options.url,
			data : postData,
			success : function(r){
				if(r) {
					
					var total = r.total;//总记录数
					var totalPages = r.totalPage;//总页数
					
					//为表格对象增加样式
					obj.addClass("am-table am-table-striped am-table-hover table-main");
					
					var colTitle = options.colTitle;
					tableStr += "<thead>";
					tableStr += "	<tr>";
					
					//如果checkbox为true,那么追加上多选
					if(options.checkbox) {
						
						tableStr += "	<th class=\"table-check\"><input type=\"checkbox\" /></th>	";
						
					}
					
					//循环表格的列头
					for(var i = 0; i < colTitle.length; i++) {
						
						var title = colTitle[i];
						
						tableStr += "<th>"+title+"</th>";
						
					}
					
					//是否需要在最后增加一个编辑列
					if(options.isEditCol) {
						
						tableStr += "<th>操作</th>";
						
					}
					
					tableStr += "	</tr>";
					tableStr += "</thead>";

					
					var cols = options.colModel;
					
					for(var i = 0; i < r.tableDatas.length; i++) {
						var columns = r.tableDatas[i].columns;
						
						if(i == 0) {
							tableStr += "<tbody>";
						}
						
						tableStr += "	<tr>";
						
						//如果checkbox为true,那么追加上多选
						if(options.checkbox) {
							
							tableStr += "	<td class=\"table-check\"><input type=\"checkbox\" /></td>	";
							
						}
						
						for(var j = 0; j < cols.length; j++) {
							var colName = cols[j].colName;
							
							var value = eval("columns." + colName);
							
							tableStr += "		<td>"+value+"</td>";
							
						}
						
						//是否需要在最后增加一个编辑列
						if(options.isEditCol) {
							
							tableStr += "<td>";
							tableStr += "	<div class=\"am-btn-toolbar\">";
							tableStr += "		<div class=\"am-btn-group am-btn-group-xs\">";
							tableStr += "			<button class=\"am-btn am-btn-default am-btn-xs am-text-secondary\"><span class=\"am-icon-pencil-square-o\"></span>编辑</button>";
							tableStr += "			<button class=\"am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only\"><span class=\"am-icon-trash-o\"></span>删除</button>";
							tableStr += "			<button class=\"am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only\"><span class=\"am-icon-trash-o\"></span>删除</button>";
							tableStr += "		</div>";
							tableStr += "	</div>";
							tableStr += "</td>";
							
						}
						
						tableStr += "	</tr>";
						
						if(i == r.length - 1) {
							
							tableStr += "</tbody>";
							
						}
						
					}
				}
				
				obj.html(tableStr);
				
				var fenye = "";
				fenye += "<div class=\"am-cf\">";
				fenye += "	共 "+total+" 条记录";
				fenye += "	<div class=\"am-fr\">";
				fenye += "		<ul class=\"am-pagination\">";
				
				if(startPage == "1" || startPage == undefined) {//如果同第一页，上一页的图标要禁用
					fenye += "		<li class=\"am-disabled\"><a>«</a></li>";
				} else {
					fenye += "		<li><a href=\"javascript:jumpPage();\">«</a></li>";
				}
				
				for(var p = 1; p <= totalPages; p++) {
					fenye += "		<li><a href=\"javascript:jumpPage();\">"+p+"</a></li>";
				}
				
				if(totalPages == startPage) {//说明已经到了最后一页，开始页等于结束页
					fenye += "		<li class=\"am-disabled\"><a>»</a></li>";
				} else {
					fenye += "		<li><a href=\"javascript:jumpPage();\">»</a></li>";
				}
				
				fenye += "		</ul>";
				fenye += "	</div>";
				fenye += "</div>";
				
				obj.after(fenye);
			}
		});
	}
	
	
	
	
})(jQuery);