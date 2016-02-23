<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="admin-sidebar am-offcanvas" id="admin-offcanvas"><!-- 左边菜单　side bar -->
	<div class="am-offcanvas-bar admin-offcanvas-bar" style="min-height: 550px;">	
		<ul class="am-list admin-sidebar-list">
			<li><a href="/admin"><span class="am-icon-home"></span> 首页</a></li>
			<li class="admin-parent">
				<a class="am-cf" data-am-collapse="{target: '#collapse-nav'}"><span class="am-icon-file">
					</span> 功能菜单 <span class="am-icon-angle-right am-fr am-margin-right"></span>
				</a>
				<ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
					<li>
						<a href="/user/admin_user">
							<span class="am-icon-puzzle-piece"></span>用户管理
						</a>
					</li>
					<li>
						<a href="/project/admin_project" class="am-cf">
							<span class="am-icon-check"></span> 
								项目管理
							<span class="am-badge am-badge-secondary am-margin-right am-fr"></span>
						</a>
					</li>
					<li>
						<a href="admin-gallery.html">
							<span class="am-icon-th"></span> 
							相册页面
							<span class="am-badge am-badge-secondary am-margin-right am-fr">24</span>
						</a>
					</li>
					<li><a href="admin-log.html"><span class="am-icon-calendar"></span>系统日志</a></li>
					<li><a href="admin-404.html"><span class="am-icon-bug"></span>404</a></li>
				</ul>
			</li>
		</ul>
	</div>
</div><!-- 左边菜单　side bar end -->
	
