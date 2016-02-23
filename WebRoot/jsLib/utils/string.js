/**
 * @see 字符串拼接方法
 * @since 2016年2月18日
 * @category js
 * @author 杨阳
 * @使用方法：$stringFormat('字符串{0}字符串{1}字符串','第一个变量','第二个变量');
 */
var $stringFormat = function(str) {
	for (var i = 0; i < arguments.length - 1; i++) {
		str = str.replace("{" + i + "}", arguments[i + 1]);
	}
	return str;
};