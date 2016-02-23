/**
 * @see 封装表单验证方法，简化操作
 * @since 2016年1月21日
 * @category js
 * @author 杨阳
 */

(function($) {
	
	/**
	 * 序列化表单中的所有数据
	 * @param formID 表单的ID
	 */
	$formParams = function(formID) {
		return $("#"+formID).serialize();
	};
	
})(jQuery);