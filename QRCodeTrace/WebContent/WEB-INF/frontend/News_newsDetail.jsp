<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>新闻动态|寒鸦果蔬有限公司</title>
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
          <li><a href="${rootPath}/">首页</a></li>
          <li><a href="${rootPath}/Company_companyAbout">公司概况</a></li>
          <li><a href="${rootPath}/Product_productInfoShow">产品展示</a></li>
          <li class="active"><a href="${rootPath}/News_newsInfoShow">新闻动态</a></li>
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
        <div>
            <div style="float: left;">
                <input style="border: 1px solid rgb(160, 181, 46); width: 360px; height: 30px;" type="text" id="traceCode" name="id"/>&nbsp;&nbsp;
            </div>
            <div style="float: left; apadding-top: 1px;">
                <input type="image" src="${rootPath}/images/querybtn.jpg" alt="查询" onclick="document.product_id.submit()"/>
            	<br style="background:url(blank)"/>
            </div>
            <div>
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
        </s:form>
    </div>
  </div>
  
  <div class="content">
    <div class="content_resize">
      <div class="mainbar">

         <div class="article_vert">
              <h2 style="border-bottom:dashed 1px #93a5a8;">
                  当前位置：首页 > 新闻动态
              </h2>
             <div>
                 <table border="0" cellpadding="0" cellspacing="0" width="100%">
                     <tbody>
                         <tr>
                             <td style="border-bottom: #a0b52e 1px dashed; color: #a0b52e; height: 70px; text-align: center;
                                 font-size: 20px; font-weight: bold;">
                                 <span><s:property value="#request.newsInfo.title"/></span>
                             </td>
                         </tr>
                         <tr>
                             <td style="color: #696969; font-size: 14px; text-align: center; height: 35px;">
                                 <span><s:date name="%{#request.newsInfo.date}" format="yyyy-MM-dd HH:mm:ss"/></span> &nbsp;&nbsp;&nbsp;&nbsp;
                             </td>
                         </tr>
                         <tr>
                             <td style="color: #696969; font-size: 16px; padding-top: 20px; line-height: 35px;
                                 padding-bottom: 100px;">
                                     	${requestScope.newsInfo.content}
                             </td>
                         </tr>
                         <tr>
                             <td style="color: #a0b52e; font-size: 14px; line-height: 25px; padding-bottom: 30px;">
                             <s:if test="#request.preNews == null">
                             	 上一篇:无<br/>
                             </s:if>
                             <s:else>
                             	 上一篇:<a class="prea" href="${rootPath}/News_newsDetail?id=<s:property value='#request.preNews.id'/>"><s:property value="#request.preNews.title"/></a> <br/>
                             </s:else>
                             
                             <s:if test="#request.nextNews == null">
                             	下一篇:无<br/>
                             </s:if>
                              <s:else>
                             	 下一篇:<a class="prea" href="${rootPath}/News_newsDetail?id=<s:property value='#request.nextNews.id'/>"><s:property value="#request.nextNews.title"/></a> <br/>
                             </s:else>
                             </td>
                         </tr>
                     </tbody>
                 </table>
             </div>
          </div>

         <div class="clr"></div>
      </div>
    </div>
    <div class="clr"></div>
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
          <li><a href="${rootPath}/">首页</a></li>
          <li><a href="${rootPath}/Company_companyAbout">公司概况</a></li>
          <li><a href="${rootPath}/Product_productInfoShow">产品展示</a></li>
          <li class="active"><a href="${rootPath}/News_newsInfoShow">新闻动态</a></li>
          <li><a href="${rootPath}/Comment_commentInfoShow">留言反馈</a></li>
        </ul>
        <div class="clr"></div>
        <p class="lf">&copy; copyright 2016 韶关学院. All rights reserved. 技术支持：中国.广东.韶关.韶关学院 丁香苑C416 Jackdaw工作室 邮编:512005</p>
      </div>
      <div class="clr"></div>
    </div>
  </div>
</div>
<% pageContext.getSession().removeAttribute("msg");%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/traceCode.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/check.js"></script>
</body>
</html>
