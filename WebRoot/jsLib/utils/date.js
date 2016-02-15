/**
 * @see 扩展Date的format方法，将long转换为date 
 * @since 2016年2月15日
 * @category js
 * @author 杨阳
 */
Date.prototype.format = function (format) {
	var o = {
		"M+":this.getMonth() + 1,
		"d+":this.getDate(),
		"h+":this.getHours(),
		"m+":this.getMinutes(),
		"s+":this.getSeconds(),
		"q+":Math.floor((this.getMonth() + 3) / 3),
		"S":this.getMilliseconds()
	}
	if (/(y+)/.test(format)) {
		format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	}
	for (var k in o) {
		if (new RegExp("(" + k + ")").test(format)) {
			format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
		}
	}
	return format;
}

/** 
 * 转换日期对象为日期字符串   
 * @param date 日期对象   
 * @param pattern 数据格式化后的格式 yyyy-MM-dd
 * @return 符合要求的日期字符串   
 */
function getSmpFormatDate(date, pattern){
	var pattern = "";  
	if (undefined != pattern) {
		pattern = "yyyy-MM-dd hh:mm:ss";
	} else {
		pattern = "yyyy-MM-dd";
	}
	return date.format("yyyy-MM-dd");
}  
