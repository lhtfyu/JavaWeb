<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>bookStore首页</title>
<%--导入css --%>
<link rel="stylesheet" href="css/main.css" type="text/css" />
</head>

<body class="main">

	<%@include file="head.jsp"%>
	<%@include file="menu_search.jsp" %>
	<div id="divad">
		<img src="ad/index_ad.jpg" />
	</div>

	<div id="divcontent">
		<table width="900px" border="0" cellspacing="0">
			<tr>
				<td width="497"><img src="images/billboard.gif" width="497"
					height="38" />
					<table cellspacing="0" class="ctl">
						<tr>
							<td>&middot;<a href="news.html" style="color:#000000">图书3折起，支持在线浏览
									先看再买不后悔,任何商品免费送货</a></td>
						</tr>
						<tr>
							<td>&middot;<a href="news.html" style="color:#000000">Lonely
									Planet 已出版600多种旅行指南，几乎覆盖了全世界的每个角落。</a></td>
						</tr>
						<tr>
							<td>&middot;<a href="news.html" style="color:#000000">2007年中旅游图书畅销榜速递
									中国游,世界游,旅游图书全部7折封顶</a></td>
						</tr>
						<tr>
							<td>&middot;<a href="news.html" style="color:#000000">50万种图书3折,百货团购价热卖
									畅销榜新书速递,促销天天有</a></td>
						</tr>
						<tr>
							<td>&middot;<a href="news.html" style="color:#000000">50万种图书3折,百货团购价热卖
									畅销榜新书速递,促销天天有</a></td>
						</tr>
					</table></td>
				<td style="padding:5px 15px 10px 40px"><table width="100%"
						border="0" cellspacing="0">
						<tr>
							<td><img src="images/hottitle.gif" width="126" height="29" />
							</td>
						</tr>
					</table>
					<table width="100%" border="0" cellspacing="0">
						<tr>
							<td style="width:50; text-align:center"><a href="info.html"><img
									src="bookcover/travelbook.jpg" width="102" height="130"
									border="0" /> </a><br /> <a href="info.html">TravelBook<br />
									作者:Lonley Plant</a></td>
							<td style="width:50; text-align:center"><a href="info.html"><img
									src="bookcover/java2.jpg" width="102" height="130" border="0" />
							</a><br /> <a href="info.html">Java2入门经典(JDK5) <br /> 作者:(美)霍顿</a>
							</td>
						</tr>
					</table></td>
			</tr>
		</table>
	</div>
	
<c:if test="${searchpage!=null}">
	<div id="divpagecontent">
		<table width="100%" border="0" cellspacing="0">
			<tr>

				<td>
					<div style="text-align:right; margin:5px 10px 5px 0px">
						<a href="index.jsp">搜索</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;${searchpage.category}&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;图书列表
					</div>

					<table cellspacing="0" class="listcontent">
						<tr>
							<td>
								<h1>商品目录</h1>
								<hr />
								<h1>${searchpage.category}</h1>&nbsp;&nbsp;&nbsp;&nbsp;共${searchpage.totalCount }种商品
								<hr />
								<div style="margin-top:20px; margin-bottom:5px">
									<img src="images/productlist.gif" width="100%" height="38" />
								</div>
								<table cellspacing="0" class="booklist">
									<tr>
										<!-- 遍历列表 -->
										<c:forEach items="${searchpage.list }" var="book">
											<td>
												<div class="divbookpic">
													<p>
														<a href="${pageContext.request.contextPath}/showProductByPage?method=productInfo&id=${book.id}"><img src="${book.imgurl}" width="115"
															height="129" border="0" /> </a>
													</p>
												</div>
	
												<div class="divlisttitle">
													<a href="${pageContext.request.contextPath}/showProductByPage?method=productInfo&id=${book.id}">书名:${book.name}<br />售价:${book.price} </a>
												</div>
											</td>
										</c:forEach>									
									</tr>
								</table>
								
								<div class="pagination">
									<!--  disablepage nextpage-->
									<ul>
										<!-- 显示上一页 -->
										<c:if test="${searchpage.currentPage > 1}">
											<li><a href="${pageContext.request.contextPath}/Search?currentPage=${searchpage.currentPage-1}">上一页</a></li>
										</c:if>
										<span>第${searchpage.currentPage}页/共 ${searchpage.totalPage}页</span> 
										<!-- 显示下一页 -->
										<c:if test="${searchpage.currentPage < searchpage.totalPage}">
											<li><a href="${pageContext.request.contextPath}/Search?currentPage=${searchpage.currentPage+1}">下一页</a></li>
										</c:if>
										</ul>
									
								</div>									
							</td>
						</tr>
					</table>
					</td>
			</tr>
		</table>
	</div>
</c:if>
	


	<jsp:include page="foot.jsp"/>


</body>
</html>
