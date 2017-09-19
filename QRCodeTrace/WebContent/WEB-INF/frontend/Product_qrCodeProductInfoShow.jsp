<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>产品追溯信息</title>
		<meta charset="utf-8" />
		<c:set var="rootPath" value="${pageContext.request.contextPath}"></c:set>
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
	</head>
	<body>
	<s:token></s:token>
		<!-- Sidebar -->
			<section id="sidebar">
				<div class="inner">
					<nav>
						<ul>
							<li><a href="#intro">基本信息</a></li>
							<li><a href="#two">原料信息</a></li>
							<li><a href="#three">加工信息</a></li>
							<li><a href="#four">运输信息</a></li>
							<li><a href="#five">销售信息</a></li>
						</ul>
					</nav>
				</div>
			</section>
		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Intro -->
					<section id="intro" class="wrapper style1 fullscreen fade-up">
						<div class="inner">
							<h1>产品名称</h1>
							<h3>产品追溯码:<s:property value="#request.productInfo.id"/></h3>
							<ul style="text-align:justify; text-justify:inter-ideograph;">
								<li>种植企业:<span style="margin-left:8em"><s:property value="#request.productInfo.material.companyName"/></span></li>
								<li>农产品品质:<span style="margin-left:7em"><s:property value="#request.productInfo.material.qulity"/></span></li>
								<li>农药残留检测结果:<span style="margin-left:4em"><s:property value="#request.productInfo.material.pesticide"/></span></li>
								<li>加工企业名称:<span style="margin-left:6em"><s:property value="#request.productInfo.process.companyName"/></span></li>
								<li>加工方式:<span style="margin-left:8em"><s:property value="#request.productInfo.process.method"/></span> </li>
								<li>出厂前微生物检测结果:<span style="margin-left:2em"><s:property value="#request.productInfo.process.animalcule"/></span> </li>
								<li>运输公司名称:<span style="margin-left:6em"><s:property value="#request.productInfo.transport.companyName"/></span> </li>
								<li>运输车辆类型:<span style="margin-left:6em"><s:property value="#request.productInfo.transport.carType"/></span></li>
								<li>运输出发时间:<span style="margin-left:6em"><s:date format="yyyy-MM-dd" name="#request.productInfo.transport.departureTime"/></span></li>
								<li>运输到达时间:<span style="margin-left:6em"><s:date format="yyyy-MM-dd" name="#request.productInfo.transport.arrivalTime"/></span></li>
								<li>销售企业名称:<span style="margin-left:6em"><s:property value="#request.productInfo.sell.companyName"/></span></li>
								<li>产品进货后检验情况:<span style="margin-left:3em"><s:property value="#request.productInfo.sell.examination"/></span></li>
								<li>营养标签:<span style="margin-left:8em"><s:property value="#request.productInfo.sell.nutrition"/></span></li>
								<li>过敏提示:<span style="margin-left:8em"><s:property value="#request.productInfo.sell.allergy"/></span></li>
								<li><a href="#one" class="button scrolly">更多信息</a><span style="margin-left:2em"><a href="${rootPath}/" class="button scrolly">点我去首页</a></span></li>
							</ul>
						</div>
					</section>

				<!-- One -->
					<section id="one" class="wrapper style2 spotlights">
						<section>
							<div class="content">
								<div class="inner">
									<h2>原料信息</h2>
									<p>原料信息</p>
									<ul class="actions">
										<li><a href="#two" class="button">更多</a></li>
									</ul>
								</div>
							</div>
						</section>
						<section>
							<div class="content">
								<div class="inner">
									<h2>加工信息</h2>
									<p>加工信息</p>
									<ul class="actions">
										<li><a href="#three" class="button">更多</a></li>
									</ul>
								</div>
							</div>
						</section>
						<section>
							<div class="content">
								<div class="inner">
									<h2>运输信息</h2>
									<p>运输信息</p>
									<ul class="actions">
										<li><a href="#four" class="button">更多</a></li>
									</ul>
								</div>
							</div>
						</section>
						<section>
							<div class="content">
								<div class="inner">
									<h2>销售信息</h2>
									<p>销售信息</p>
									<ul class="actions">
										<li><a href="#five" class="button">更多</a></li>
									</ul>
								</div>
							</div>
						</section>
					</section>

				<!-- Two -->
					<section id="two" class="wrapper style3 fade-up">
						<div class="inner">
							<h2>原料信息</h2>
							<div class="features">
								<section>
									<!-- <span class="icon major fa-code"></span> -->
									<h3>种植企业名称</h3>
									<h1><s:property value="#request.productInfo.material.companyName"/></h1>
								</section>
								<section>
									<!-- <span class="icon major fa-code"></span> -->
									<h3>农产品品质</h3>
									<h1><s:property value="#request.productInfo.material.qulity"/></h1>
								</section>
								<section>
									<!-- <span class="icon major fa-lock"></span> -->
									<h3>产地总金属检测结果</h3>
									<h1><s:property value="#request.productInfo.material.heavyMetal"/></h1>
								</section>
								<section>
									<!-- <span class="icon major fa-cog"></span> -->
									<h3>施肥情况</h3>
									<h1><s:property value="#request.productInfo.material.fertilization"/></h1>
								</section>
								<section>
									<!-- <span class="icon major fa-desktop"></span> -->
									<h3>施药结果</h3>
									<h2><s:property value="#request.productInfo.material.medicine"/></h2>
								</section>
								<section>
									<!-- <span class="icon major fa-desktop"></span> -->
									<h3>农药残留检测结果</h3>
									<h2><s:property value="#request.productInfo.material.pesticide"/></h2>
								</section>
								<section>
									<!-- <span class="icon major fa-chain"></span> -->
									<h3>亚硝酸盐检测结果</h3>
									<h2><s:property value="#request.productInfo.material.nitrate"/></h2>
								</section>
								<section>
									<!-- <span class="icon major fa-diamond"></span> -->
									<h3>微生物检测结果</h3>
									<h2><s:property value="#request.productInfo.material.animalcule"/></h2>
								</section>
							</div>
						</div>
					</section>


				<!-- Three -->
					<section id="three" class="wrapper style3 fade-up">
						<div class="inner">
							<h2>加工信息</h2>
							<div class="features">
								<section>
									<!-- <span class="icon major fa-code"></span> -->
									<h3>加工企业名称</h3>
									<h1><s:property value="#request.productInfo.process.companyName"/></h1>
								</section>
								<section>
									<!-- <span class="icon major fa-code"></span> -->
									<h3>加工方式</h3>
									<h1><s:property value="#request.productInfo.process.method"/></h1>
								</section>
								<section>
									<!-- <span class="icon major fa-lock"></span> -->
									<h3>加工车间温度</h3>
									<h1><s:property value="#request.productInfo.process.workshopTemperature"/></h1>
								</section>
								<section>
									<!-- <span class="icon major fa-cog"></span> -->
									<h3>包装形式</h3>
									<h1><s:property value="#request.productInfo.process.packing"/></h1>
								</section>
								<section>
									<!-- <span class="icon major fa-desktop"></span> -->
									<h3>入库时间</h3>
									<h1><s:date name="#request.productInfo.process.storageTime" format="yyyy/MM/dd"/></h1>
								</section>
								<section>
									<!-- <span class="icon major fa-chain"></span> -->
									<h3>冷温库温度</h3>
									<h1><s:property value="#request.productInfo.process.refrigeratorTemperature"/></h1>
								</section>
								<section>
									<!-- <span class="icon major fa-diamond"></span> -->
									<h3>出厂前微生物检测</h3>
									<h2><s:property value="#request.productInfo.process.animalcule"/></h2>
								</section>
							</div>
						</div>
					</section>


				<!-- Four -->
					<section id="four" class="wrapper style3 fade-up">
						<div class="inner">
							<h2>运输信息</h2>
							<div class="features">
								<section>
									<!-- <span class="icon major fa-code"></span> -->
									<h3>法人代表</h3>
									<h1><s:property value="#request.productInfo.transport.companyName"/></h1>
								</section>
								<section>
									<!-- <span class="icon major fa-code"></span> -->
									<h3>法人代表</h3>
									<h1><s:property value="#request.productInfo.transport.legalPerson"/></h1>
								</section>
								<section>
									<!-- <span class="icon major fa-lock"></span> -->
									<h3>运输车辆类型</h3>
									<h1><s:property value="#request.productInfo.transport.carType"/></h1>
								</section>
								<section>
									<!-- <span class="icon major fa-cog"></span> -->
									<h3>运输车设定温度/℃</h3>
									<h1><s:property value="#request.productInfo.transport.temperature"/></h1>
								</section>
								<section>
									<!-- <span class="icon major fa-desktop"></span> -->
									<h3>运输车相对湿度/%</h3>
									<h1><s:property value="#request.productInfo.transport.humidity"/></h1>
								</section>
								<section>
									<!-- <span class="icon major fa-chain"></span> -->
									<h3>运输货柜消毒情况</h3>
									<h1><s:property value="#request.productInfo.transport.disinfection"/></h1>
								</section>
								<section>
									<!-- <span class="icon major fa-diamond"></span> -->
									<h3>货物种类</h3>
									<h1><s:property value="#request.productInfo.transport.goodsType"/></h1>
								</section>
								<section>
									<!-- <span class="icon major fa-diamond"></span> -->
									<h3>货物数量</h3>
									<h1><s:property value="#request.productInfo.transport.goodsCount"/></h1>
								</section>
								<section>
									<!-- <span class="icon major fa-diamond"></span> -->
									<h3>运输货来源地</h3>
									<h1><s:property value="#request.productInfo.transport.placeFrom"/></h1>
								</section>
								<section>
									<!-- <span class="icon major fa-diamond"></span> -->
									<h3>运输货目的地</h3>
									<h1><s:property value="#request.productInfo.transport.placeTo"/></h1>
								</section>
								<section>
									<!-- <span class="icon major fa-diamond"></span> -->
									<h3>运输出发时间</h3>
									<h1><s:date name="#request.productInfo.transport.departureTime" format="yyyy/MM/dd"/></h1>
								</section>
								<section>
									<!-- <span class="icon major fa-diamond"></span> -->
									<h3>运输到达时间</h3>
									<h1><s:date name="#request.productInfo.transport.arrivalTime" format="yyyy/MM/dd"/></h1>
								</section>
								<section>
									<!-- <span class="icon major fa-diamond"></span> -->
									<h3>运输负责人姓名</h3>
									<h1><s:property value="#request.productInfo.transport.personInCharge"/></h1>
								</section>
								<section>
									<!-- <span class="icon major fa-diamond"></span> -->
									<h3>运输负责人电话</h3>
									<h1><s:property value="#request.productInfo.transport.phone"/></h1>
								</section>
							</div>
						</div>
					</section>


				<!-- Five -->
					<section id="five" class="wrapper style3 fade-up">
						<div class="inner">
							<h2>销售信息</h2>
							<div class="features">
								<section>
									<!-- <span class="icon major fa-code"></span> -->
									<h3>销售企业名称</h3>
									<h1><s:property value="#request.productInfo.sell.companyName"/></h1>
								</section>
								<section>
									<!-- <span class="icon major fa-code"></span> -->
									<h3>经营许可证号</h3>
									<h3><s:property value="#request.productInfo.sell.license"/></h3>
								</section>
								<section>
									<!-- <span class="icon major fa-lock"></span> -->
									<h3>法人代表</h3>
									<h1><s:property value="#request.productInfo.sell.logalPerson"/></h1>
								</section>
								<section>
									<!-- <span class="icon major fa-cog"></span> -->
									<h3>直接负责人姓名</h3>
									<h1><s:property value="#request.productInfo.sell.inChargePerson"/></h1>
								</section>
								<section>
									<!-- <span class="icon major fa-desktop"></span> -->
									<h3>直接负责人电话</h3>
									<h1><s:property value="#request.productInfo.sell.inChargePhone"/></h1>
								</section>
								<section>
									<!-- <span class="icon major fa-chain"></span> -->
									<h3>进货日期</h3>
									<h1><s:date name="#request.productInfo.sell.purchaseDate" format="yyyy/MM/dd"/></h1>
								</section>
								<section>
									<!-- <span class="icon major fa-diamond"></span> -->
									<h3>进货数量</h3>
									<h1><s:property value="#request.productInfo.sell.purchaseCount"/></h1>
								</section>
								<section>
									<!-- <span class="icon major fa-diamond"></span> -->
									<h3>产品进货后检验情况</h3>
									<h1><s:property value="#request.productInfo.sell.examination"/></h1>
								</section>
								<section>
									<!-- <span class="icon major fa-diamond"></span> -->
									<h3>检验人</h3>
									<h1><s:property value="#request.productInfo.sell.examPerson"/></h1>
								</section>
								<section>
									<!-- <span class="icon major fa-diamond"></span> -->
									<h3>存货冷库消毒情况</h3>
									<h1><s:property value="#request.productInfo.sell.disinfection"/></h1>
								</section>
								<section>
									<!-- <span class="icon major fa-diamond"></span> -->
									<h3>存货冷库温度/℃</h3>
									<h1><s:property value="#request.productInfo.sell.temperature"/></h1>
								</section>
								<section>
									<!-- <span class="icon major fa-diamond"></span> -->
									<h3>存货冷库相对湿度/%</h3>
									<h1><s:property value="#request.productInfo.sell.humidity"/></h1>
								</section>
								<section>
									<!-- <span class="icon major fa-diamond"></span> -->
									<h3>存货负责人</h3>
									<h1><s:property value="#request.productInfo.sell.stockPerson"/></h1>
								</section>
								<section>
									<!-- <span class="icon major fa-diamond"></span> -->
									<h3>存货负责人联系电话</h3>
									<h1><s:property value="#request.productInfo.sell.stockPhone"/></h1>
								</section>
								<section>
									<!-- <span class="icon major fa-diamond"></span> -->
									<h3>营养标签</h3>
									<h1><s:property value="#request.productInfo.sell.nutrition"/></h1>
								</section>
								<section>
									<!-- <span class="icon major fa-diamond"></span> -->
									<h3>过敏提示</h3>
									<h1><s:property value="#request.productInfo.sell.allergy"/></h1>
								</section>
							</div>
						</div>
					</section>


				<!-- Six -->
					<section id="six" class="wrapper style1 fade-up">
						<div class="inner">
							<h2>投诉</h2>
							<p>欢迎投诉，填写以下信息</p>
							<div class="split style1">
								<section>
									<s:form method="post" action="Comment_commentSave" theme="simple" onsubmit="return checkComment()">
										<s:token></s:token>
										<s:hidden name="pro_id" value="%{#request.productInfo.id}"></s:hidden>
										<div class="field half first">
											<label for="name">您的姓名</label>
											<input type="text" name="username" id="name" />
										</div>
										<div class="field half">
											<label for="email">您的邮箱</label>
											<input type="text" name="email" id="email" />
										</div>
										<div class="field">
											<label for="message">投诉内容</label>
											<textarea name="content" id="message" rows="5"></textarea>
										</div>
										<ul class="actions">
											<li>
												<input type="submit" class="button submit" value="发送" />
											</li>
										</ul>
									</s:form>
								</section>
								<section>
									<ul class="contact">
										<li>
											<h3><a href="${rootPath}/Product_productInfoShow">了解更多</a></h3>
											<span>本公司其他产品</span>
										</li>
										<li>
											<h3>公司邮箱</h3>
											<span><s:property value="#request.companyInfo.email"/></span>
										</li>
										<li>
											<h3>公司电话</h3>
											<span><s:property value="#request.companyInfo.phone"/></span>
										</li>
										<li>
											<h3>监管部门电话</h3>
											<ul class="icons">
												<li style="display:block"><span>工商局:88650000 </span></li>
												<li style="display:block"><span>质监局:12365</span></li>
												<li><span>消费者权益保护:12315</span></li>
											</ul>
										</li>
									</ul>
								</section>
							</div>
						</div>
					</section>

			</div>

		<!-- Footer -->
			<footer id="footer" class="wrapper style1-alt">
				<div class="inner">
					<ul class="menu">
						<li>&copy; 版权所有：丁香C416</li><li>Hello World: <a href="#">SGU</a></li>
					</ul>
				</div>
			</footer>

		<!-- Scripts -->
			<script type="text/javascript" src="${pageContext.request.contextPath}/js/qrcodeComment.js"></script>
			<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
			<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.scrollex.min.js"></script>
			<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.scrolly.min.js"></script>
			<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/skel.min.js"></script>
			<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/main.js"></script>
			

	</body>
</html>