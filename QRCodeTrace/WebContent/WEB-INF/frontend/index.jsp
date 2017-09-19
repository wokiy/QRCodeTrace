<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>主页|<s:property value="#request.companyInfo.name"/>果蔬有限公司</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<link href="${pageContext.request.contextPath}/css/frontendStyle.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/button.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="main">

  <div class="header">
    <div class="header_resize">
      <div class="menu_nav">
        <ul>
          <li class="active"><a href="${rootPath}/">首页</a></li>
          <li><a href="${rootPath}/Company_companyAbout">公司概况</a></li>
          <li><a href="${rootPath}/Product_productInfoShow">产品展示</a></li>
          <li><a href="${rootPath}/News_newsInfoShow">新闻动态</a></li>
          <li><a href="${rootPath}/Comment_commentInfoShow">留言反馈</a></li>
        </ul>
      </div>
      <div class="clr"></div>
      <div class="logo"><h1><a href="${rootPath}/"><span><s:property value="#request.companyInfo.name"/></span> 果蔬有限公司<br /><small>我们只生产优质的果蔬。</small></a></h1></div>
      <div class="clr"></div>
    </div>
  </div>

  <div class="hbg">
    <div class="hbg_resize">
      <img src="${rootPath}/<s:property value='#request.companyInfo.mainPic'/>" width="334" height="223" alt="img" class="hbgimg" />
      <h2>商品信息查询</h2>
      <p><strong>追溯查询提示：请输入产品追溯标签上的追溯码进行查询</strong></p>
      	<span><font color="red">${sessionScope.msg}</font></span>
        <s:form action="Product_qrCodeProductInfoShow" method="post" id="Form1" name="product_id" theme="simple">
            <div style="float: left;">
                <input style="border: 1px solid rgb(160, 181, 46); width: 360px; height: 30px;" type="text" value="" id="traceCode" name="id"/>&nbsp;&nbsp;
            </div>
            <div style="apadding-top: 1px;">
                <input type="image" src="${rootPath}/images/querybtn.jpg" alt="查询" onclick="document.product_id.submit()"/>
                <br style="background:url(blank)"/>
            </div>
        </s:form>
        <div style="float: inherit;">
            <button type="button" value="(" class="button" onclick="inputTraceCode(this.value)">(</button>
            <button type="button" value=")" class="button" onclick="inputTraceCode(this.value)">)</button>
            <button type="button" value="0" class="button" onclick="inputTraceCode(this.value)">0</button>
            <button type="button" value="1" class="button" onclick="inputTraceCode(this.value)">1</button>
            <button type="button" value="2" class="button" onclick="inputTraceCode(this.value)">2</button>
            <button type="button" value="3" class="button" onclick="inputTraceCode(this.value)">3</button>
            <button type="button" value="4" class="button" onclick="inputTraceCode(this.value)">4</button>
            <button type="button" value="5" class="button" onclick="inputTraceCode(this.value)">5</button>
            <button type="button" value="6" class="button" onclick="inputTraceCode(this.value)">6</button>
            <button type="button" value="7" class="button" onclick="inputTraceCode(this.value)">7</button>
            <button type="button" value="8" class="button" onclick="inputTraceCode(this.value)">8</button>
            <button type="button" value="9" class="button" onclick="inputTraceCode(this.value)">9</button>
            <button type="button" title="删除" class="button" onclick="deleteTraceCode()">←</button>
            <button type="button" title="重置" class="button" onclick="clearTraceCode()">C</button>
         </div>
    </div>
    
  </div>
  <div class="content">
    <div class="content_resize">
      <div class="mainbar">
          <div class="article_vert">
              <h2 style="border-bottom:dashed 1px #93a5a8;">
                  产品展示
                  <span class="more_right">
                    <img src="${rootPath}/images/more.jpg"></img>&nbsp;<a href="${rootPath}/Product_productInfoShow">更多</a>
                  </span>
              </h2>
              <div class="index_product_left">
                  <div class="index_product_left_left">
                      <ul id="productUl">
                      <s:if test="#request.productList != null && #request.productList.size() > 0">
                      	<s:iterator var="product" value="%{#request.productList}" status="st">
                          <li id="<s:property value='#st.count'/>" onmousemove="clickProduct(this.id)">
                          	<s:hidden id="pic_%{#st.count}" value="%{#product.pic}"></s:hidden>
                          	<span><s:property value="#product.name"/></span>
                          </li>
                         </s:iterator>
                         </s:if>
                         <s:else>
                         	对不起,暂时没有数据
                         </s:else>
                      </ul>
                  </div>
                  <div class="index_product_left_right">
                      <img id="pic" width="500" height="245" id="productimg"/>
                  </div>
              </div>
          </div>
         <div class="clr"></div>

         <div class="article_vert">
              <h2 style="border-bottom:dashed 1px #93a5a8;">
                  新闻动态
                  <span class="more_right">
                    <img src="${rootPath}/images/more.jpg"></img>&nbsp;<a href="${rootPath}/News_newsInfoShow">更多</a>
                  </span>
              </h2>
              <div>
              <s:if test="#request.newsList != null && #request.newsList.size() > 0">
              	<s:iterator begin="0" end="9" var="news" value="%{#request.newsList}" status="st" >
                  <div class="news_list">
                      <div class="news_list_title">
                          •&nbsp;<a href="${rootPath}/News_newsDetail?id=<s:property value='#news.id'/>"><s:property value="#news.title" />
                          <s:if test="#news.title.length()>32">
                          	<span style="font-size: 9pt;">...</span>
                          </s:if>
                          <s:if test="#st.count < 3">
                         	 &nbsp;<img style="border: 0px currentColor;" src="${rootPath}/images/new.jpg"/>
                        	</s:if>
                        	</a>
                      </div>
                      <div class="news_list_time">
                          <s:date name="%{#news.date}" format="MM-dd"/>
                      </div>
                  </div>
                  </s:iterator>
                  </s:if>
                  <s:else>
                  	对不起,暂时没有数据
                  </s:else>
              </div>
          </div>
         <div class="clr"></div>
      </div>

      
      <div class="sidebar">
        <div class="gadget">
            <h2 class="star" style="border-bottom: dashed 1px #93a5a8;">
                管理员登录
            </h2>
          <s:form action="User_userLogin" method="post" id="login" theme="simple" onsubmit="return checkAll()">
          <s:set name="roleList" value="#{'1':'material','2':'process','3':'transport','4':'sell','5':'all'}"></s:set>
          <ul class="sb_menu" style=" font-size:medium;">
            <li style="padding:0">&nbsp;&nbsp;用户名<span><input id="userName" type="text" name="userName" onfocus="checkUserName()" onblur="userNameTip()"/></span></li>
            <li style="padding:0">&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;码&nbsp;<input id="userPassword" type="password" name="password" onfocus="checkUserPassword()" onblur="userPasswordTip()"/></li>
            <li style="padding:0">&nbsp;&nbsp;角&nbsp;&nbsp;&nbsp;色<s:select style="margin-left:0px; height:22px; width:153px" id="userRole" name="role" list="#roleList" onblur="checkUserRole()">
                </s:select><span id="userRoleTip"></span>
            </li>
            <li>
                <input type="image" src="${rootPath}/images/login.jpg" value="登录"/>
                &nbsp;&nbsp;&nbsp;
                <input type="image" src="${rootPath}/images/reset.jpg" value="重置" onclick="reset();return false;"/>
            </li>
          </ul>
          <span style="color:red" id="userNameTip"></span><br />
          <span style="color:red" id="userPasswordTip"></span><br />
          <span style="color:red"><s:property value="#session.loginMsg" /></span>
          </s:form>
        </div>
        <br/>
        <div class="gadget">
          <h2 class="star" style="border-bottom: dashed 1px #93a5a8;" >相关企业推荐</h2>
          <!--以下部分代替marquee，可以取消滚动开始时的空白部分-->
            <div id="demo" style="overflow: hidden; width: 224px; height: 295px;">
                <div id="demo1">
                    <a href="#">
                        <img style="border: 1px solid rgb(160, 181, 46); width: 200px; height: 50px;" src="${rootPath}/images/xgqy (1).jpg"/></a><br />
                    <br />
                    <a href="#">
                        <img style="border: 1px solid rgb(160, 181, 46); width: 200px; height: 50px;" src="${rootPath}/images/xgqy (2).jpg"/></a><br />
                    <br />
                    <a href="#">
                        <img style="border: 1px solid rgb(160, 181, 46); width: 200px; height: 50px;" src="${rootPath}/images/xgqy (3).jpg"/></a><br />
                    <br />
                    <a href="#">
                        <img style="border: 1px solid rgb(160, 181, 46); width: 200px; height: 50px;" src="${rootPath}/images/xgqy (4).jpg"/></a><br />
                    <br />
                    <a href="#">
                        <img style="border: 1px solid rgb(160, 181, 46); width: 200px; height: 50px;" src="${rootPath}/images/xgqy (5).jpg"/></a><br />
                    <br />
                    <a href="#">
                        <img style="border: 1px solid rgb(160, 181, 46); width: 200px; height: 50px;" src="${rootPath}/images/xgqy (6).jpg"/></a><br />
                    <br />
                    <a href="#">
                        <img style="border: 1px solid rgb(160, 181, 46); width: 200px; height: 50px;" src="${rootPath}/images/xgqy (7).jpg"/></a><br />
                    <br />
                    <a href="#">
                        <img style="border: 1px solid rgb(160, 181, 46); width: 200px; height: 50px;" src="${rootPath}/images/xgqy (8).jpg"/></a><br />
                    <br />
                    <a href="#">
                        <img style="border: 1px solid rgb(160, 181, 46); width: 200px; height: 50px;" src="${rootPath}/images/xgqy (9).jpg"/></a><br />
                    <br />
                    <a href="#">
                        <img style="border: 1px solid rgb(160, 181, 46); width: 200px; height: 50px;" src="${rootPath}/images/xgqy (10).jpg"/></a><br />
                    <br />
                    <a href="#">
                        <img style="border: 1px solid rgb(160, 181, 46); width: 200px; height: 50px;" src="${rootPath}/images/xgqy (11).jpg"/></a><br />
                    <br />
                    <a href="#">
                        <img style="border: 1px solid rgb(160, 181, 46); width: 200px; height: 50px;" src="${rootPath}/images/xgqy (12).jpg"/></a><br />
                    <br />
                </div>
                <div id="demo2">
                </div>
            </div>
            <script language="javascript">
                var speed = 30
                demo2.innerHTML = demo1.innerHTML
                function Marquee() {
                    if (demo2.offsetTop - demo.scrollTop <= 0)
                        demo.scrollTop -= demo1.offsetHeight
                    else {
                        demo.scrollTop++
                    }
                }
                var MyMar = setInterval(Marquee, speed)
                demo.onmouseover = function () { clearInterval(MyMar) }
                demo.onmouseout = function () { MyMar = setInterval(Marquee, speed) } 
            </script>
        </div>
      </div>
      <div class="clr"></div>
    </div>
  </div>

  <div class="fbg">
    <div class="fbg_resize">
      <div class="col c1">
        <h2>公司环境</h2>
        <a href="#"><img src="${rootPath}/<s:property value='#request.companyInfo.enviromentPic1'/>" width="66" height="66" alt="ad" class="ad" /></a>
        <a href="#"><img src="${rootPath}/<s:property value='#request.companyInfo.enviromentPic2'/>" width="66" height="66" alt="ad" class="ad" /></a>
        <a href="#"><img src="${rootPath}/<s:property value='#request.companyInfo.enviromentPic3'/>" width="66" height="66" alt="ad" class="ad" /></a>
        <a href="#"><img src="${rootPath}/<s:property value='#request.companyInfo.enviromentPic4'/>" width="66" height="66" alt="ad" class="ad" /></a>
        <a href="#"><img src="${rootPath}/<s:property value='#request.companyInfo.enviromentPic5'/>" width="66" height="66" alt="ad" class="ad" /></a>
        <a href="#"><img src="${rootPath}/<s:property value='#request.companyInfo.enviromentPic6'/>" width="66" height="66" alt="ad" class="ad" /></a>
        <a href="#"><img src="${rootPath}/<s:property value='#request.companyInfo.enviromentPic7'/>" width="66" height="66" alt="ad" class="ad" /></a>
        <a href="#"><img src="${rootPath}/<s:property value='#request.companyInfo.enviromentPic8'/>" width="66" height="66" alt="ad" class="ad" /></a>
        <div class="clr"></div>
        <a href="${rootPath}/Company_companyAbout">了解更多...</a>
      </div>
      <div class="col c2">
        <h2>关于我们</h2>
        <img src="${rootPath}/images/white.jpg" width="66" height="66" alt="pix" />
        <p><s:property value="#request.companyInfo.introduction.substring(0,20)"/>...<br />
          <a href="${rootPath}/Company_companyAbout">了解更多</a></p>
      </div>
      <div class="col c3">
        <h2>联系我们</h2>
        <p>中国.广东.韶关.浈江区.<s:property value="#request.companyInfo.name" />果蔬有限公司</p>
        <a href="#"><img src="${rootPath}/images/pixa.jpg" width="66" height="66" alt="ad" class="ad" /></a> <a href="#"><img src="${rootPath}/images/pixb.jpg" width="66" height="66" alt="ad" class="ad" /></a> <a href="#"><img src="${rootPath}/images/pixc.jpg" width="66" height="66" alt="ad" class="ad" /></a>
        <p><strong>联系电话:</strong> <s:property value="#request.companyInfo.phone" /><br />
          <strong>传真号码:</strong><s:property value="#request.companyInfo.fax" /><br />
          <strong>电子邮箱:</strong> <a href="mailto:<s:property value='#request.companyInfo.email'/>@sina.com"><s:property value="#request.companyInfo.email" /></a></p>
      </div>
      <div class="clr"></div>
    </div>
  </div>

  <div class="footer">
    <div class="footer_resize">
      <div class="logo_end"><h1><a href="${rootPath}/"><span><s:property value="#request.companyInfo.name"/></span> CORPORATION<br /><small>We only produce high quality fruits and vegetables.</small></a></h1></div>
      <div class="drf">
        <ul class="fmenu">
          <li class="active"><a href="${rootPath}/">首页</a></li>
          <li><a href="${rootPath}/Company_companyAbout">公司概况</a></li>
          <li><a href="${rootPath}/Product_productInfoShow">产品展示</a></li>
          <li><a href="${rootPath}/News_newsInfoShow">新闻动态</a></li>
          <li><a href="${rootPath}/Comment_commentInfoShow">留言反馈</a></li>
        </ul>
        <div class="clr"></div>
        <p class="lf">&copy; copyright 2016 韶关学院. All rights reserved. 技术支持：中国.广东.韶关.韶关学院 丁香苑C416 Jackdaw工作室 邮编:512005</p>
      </div>
      <div class="clr"></div>
    </div>
  </div>

</div>
<%
pageContext.getSession().removeAttribute("msg");
pageContext.getSession().removeAttribute("loginMsg");
%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/productShow.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/traceCode.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/checkUser.js"></script>
</body>
</html>
