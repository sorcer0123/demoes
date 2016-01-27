/**
 * @see 封装ajax，简单化操作,设置全局参数
 * @since 2016年1月21日
 * @category js
 * @author 杨阳
 */
// 所有ajax提交事件的提示信息
var ajaxsetup = $.ajaxSetup({
	type : 'post',
	dataType : 'json',
	cache : false
});

(function($) {
	$ajax = function(options) {
		var ajaxDefaultsOptions = {
			url : "",
			data : $("form").serialize(),
			success : function(responseBodyModel) {
				if (responseBodyModel.success) {
					alert(responseBodyModel.msg);
				} else {
					alert(responseBodyModel.msg);
				}
			},
			cache : false,
			dataType : "json",
			type : "post",
			error : function(XMLHttpRequest, errMsg, exception){
				
				console.info(XMLHttpRequest.status);
				
				if(XMLHttpRequest.status == 404) {
					
					alert("请求地址异常!请求地址：["+options.url+"]");
					return;
					
				}
				
				if(XMLHttpRequest.status == 500) {
					
					alert("服务器异常！");
					return;
					
				}
				
			}
		};
		
		// 表示将自己定义的ajaxDefaultsOptions与传入的options相结合，如果后面与前面的属性相同，那么以后面的为准
		var opts = $.extend({}, ajaxDefaultsOptions, options);
		$.ajax(opts);
	};
	
})(jQuery);