<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="sidebar-scroll">
	<div class="logo">
		<a href="${ctx}/index"><img src="${ctx }/static/images/logo_icon.png" alt="">示例系统</a>
	</div>
	<div class="sidebar-collapse">
		<div class="nav-header" id="side-head">
			<div class="dropdown profile-element text-center">
				<span><img alt="image" class="img-circle " src="${ctx }/static/img/profile_small.jpg" /></span> <a data-toggle="dropdown" class="dropdown-toggle" href="#"><span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">Jack</strong></span>
						<span class="text-muted text-xs block">用户设置<b class="caret"></b></span>
				</span> </a>
				<ul class="dropdown-menu animated fadeInRight m-t-xs">
					<li><a href="profile.html">Profile</a></li>
					<li><a href="contacts.html">Contacts</a></li>
					<li><a href="mailbox.html">Mailbox</a></li>
					<li class="divider"></li>
					<li><a href="${ctx }/logout">Logout</a></li>
				</ul>
			</div>
		</div>
		<ul class="nav metismenu" id="side-menu">
			
			<c:if test="${not empty permission_session}">
				<c:forEach var="one" items="${permission_session }" varStatus="oneStat">
					<li class="${oneStat.index==1 ? 'active' : ''}">
						<c:if test="${empty one.url }">
							<a href="javascript:void(0)">
						</c:if>
						<c:if test="${not empty one.url }">
							<a href="${ctx }/${one.url}">
						</c:if>
							
						<!-- 只是单纯的一级菜单，没有子菜单 -->
						<c:if test="${empty one.children || fn:length(one.children) == 0 }">
								<i class="${one.cssClass} fa"></i> 
								<span class="nav-label">${one.name}</span>
							</a>
						</c:if>
						
						<!-- 一级菜单，有子菜单 -->
						<c:if test="${not empty one.children && fn:length(one.children) > 0 }">
								<i class="${one.cssClass} fa"></i> 
								<span class="nav-label">${one.name}</span>
								<span class="fa arrow"></span>
							</a>
							
							<!-- 迭代显示子菜单 -->
							<c:forEach var="two" items="${one.children }">
								<ul class="nav nav-second-level collapse">
									<li>
										<c:if test="${empty two.url }">
											<a href="javascript:void(0)">
										</c:if>
										<c:if test="${not empty two.url }">
											<a href="${ctx }/${two.url}">
										</c:if>
											<i class="${two.cssClass}  fa"></i>
											${two.name}
										</a>
										<c:if test="${not empty two.children && fn:length(two.children) > 0 }">
											<c:forEach var="three" items="${two.children }">
												<ul class="nav nav-third-level">
													<li>
														<a href="${ctx }/${three.url}">
															<i class="${three.cssClass} fa"></i>
															${three.name}"
														</a>
													</li>
												</ul>
											</c:forEach>
										</c:if>
									</li>
								</ul>
							</c:forEach>
						</c:if>
					</li>
				</c:forEach>
			</c:if>

			<li class="landing_link"><a target="_blank" href="landing.html"><i class="fa fa-star"></i> <span class="nav-label">系统更新</span> <span class="label label-warning pull-right">NEW</span></a></li>
			<li class="special_link"><a href="package.html"><i class="fa fa-database"></i> <span class="nav-label">购买服务</span></a></li>
		</ul>
	</div>
</div>