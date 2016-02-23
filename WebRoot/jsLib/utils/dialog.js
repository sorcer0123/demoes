/**
 * @see 封装artDialog，简单化操作,设置全局参数
 * @since 2016年2月17日
 * @category js
 * @author 杨阳
 */
(function($) {
	
	/**
	 * 调用方法 $formDialog({}, divID, url, {});
	 * @param options artDialog参数
	 * @param divID div的ID
	 * @param url 远程加载地址
	 * @param loadParams 加载远程界面是所传递的参数
	 */
	$formDialog = function(options, divID, url, loadParams){
		
		var elem = document.getElementById(divID);
		
		var defaultOptions = {
			content:elem,
			title:"",
			zIndex:9999,
			fixed:true,
			width:600,
			id:divID
		};
		
		// 表示将自己定义的ajaxDefaultsOptions与传入的options相结合，如果后面与前面的属性相同，那么以后面的为准
		var opts = $.extend({}, defaultOptions, options);
		
		if(url) {
			$("#" + divID).load(url, loadParams, function(){
				var d = dialog(opts);
				d.showModal();
			});
		} else {
			var d = dialog(opts);
			d.showModal();
		}
	};
	
})(jQuery);

/**
 * 提示信息的dialog
 */
var $msgDialog = function(successmsg){
	var d = dialog({
		title: '提示',
		content: successmsg,
		width:150,
		height:60,
		zIndex:9999
	});
	d.showModal();
}

/**
 *　封装confirm
 */
var $confirm = function(msg, options){
	var defaultsOptions = {
		title:'提示',
		content: msg,
		width:150,
		height:60,
		zIndex:9999,
		okValue:"确定",
		ok:function(){}
	};
	
	var opts = $.extend({}, defaultsOptions, options);
	var dia = dialog(opts);
	dia.showModal();
}