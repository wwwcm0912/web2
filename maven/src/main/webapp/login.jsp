<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>

<%
	pageContext.setAttribute("path", request.getContextPath());
%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>持名法州后台管理中心</title>
			
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
	<link rel="icon" href="${path }/img/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/common.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/login.css" type="text/css"></link>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/themes/default/easyui.css">   
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/themes/IconExtension.css">   
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>   
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.easyui.min.js"></script>  
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript">
	
		$(function(){
			//点击更换验证码：
			$("#captchaImage").click(function(){//点击更换验证码
				$("#enCode").val("");
						$("#captchaImage").prop(
							"src",
							"${pageContext.request.contextPath}/cap/generateCaptcha?time="
								+ new Date().getTime());
			});
			
			//  form 表单提交
			/* $("#loginForm").bind("submit",function(){
				return false;
			}); */
			$("input").blur(function() {
				$(this).parent().find(".ok").remove();
				/* if($(this).is("#enCode")){
					validateCode();
				} */
				if ($(this).is("#username")) {
					if ($(this).val() == "") {
						$(this).parent().append(
							"<span  class='erro ok' style='padding-left: 10px;'> 昵称不能为空 </span>");
							//$(this).next().prop("style","display: none");
					} else {
						$(this).parent().append(
							"<span  class='success ok' style='padding-left: 20px;'> 验证通过</span>");
							//$(this).next().prop("style","display: none");
						}
					}
				if ($(this).is("#password")) {
					if ($(this).val() == "") {
						$(this).parent().append(
							"<span  class='erro ok' style='padding-left: 20px;'> 密码不能为空 </span>");
							//$(this).next().prop("style","display: none");
					} else {
						if ($(this).val().length < 6) {
							$(this).parent().append("<span  class='erro ok' style='padding-left: 20px;'> 密码长度不能小于6位 </span>");
							//$(this).next().prop("style","display: none");
						} else if ($(this).val().length > 20) {
							$(this).parent().append(
								"<span  class='erro ok' style='padding-left: 20px;'> 密码长度不能大于20位 </span>");
								//$(this).next().prop("style","display: none");
						} else {
							$(this).parent().append("<span  class='success ok' style='padding-left: 20px;'> 密码可用</span>");
							//$(this).next().prop("style","display: none");
						}
					}
				}
			});
			$("input").focus(function() {
				$(this).next().prop("style", "display: block");
				$(this).parent().find(".ok").remove();
			});
			$("form").submit(function() {
				$("input").trigger("blur");
				if ($(".erro").length > 0) {
					return false;
				}
			});
		});
	</script>
</head>
<body>
		<%-- action="${path }/admin/login" --%>
		<div class="login">
			<form id="loginForm" method="post" action="${pageContext.request.contextPath }/admin/login">
				
				<table>
					<tbody>
						<tr>
							<td width="190" rowspan="2" align="center" valign="bottom">
								<img src="${path }/img/header_logo.gif" />
							</td>
							<th>
								用户名:
							</th>
							<td>
								<input type="text"  name="name" id="username" class="text" value="" maxlength="20"/>
							</td>
					  </tr>
					  <tr>
							<th>
								密&nbsp;&nbsp;&nbsp;码:
							</th>
							<td>
								<input type="password" name="password" id="password" class="text" value="" maxlength="20" autocomplete="off"/>
							</td>
					  </tr>
					
						<tr>
							<td>&nbsp;</td>
							<th>验证码:</th>
							<td>
								<input type="text" id="enCode" name="enCode" class="text captcha" maxlength="4" autocomplete="off"/>
								<img id="captchaImage" class="captchaImage" src="${path }/cap/generateCaptcha" title="点击更换验证码"/>
							</td>
						</tr>					
					<tr>
						<td>
							&nbsp;
						</td>
						<th>
							&nbsp;
						</th>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<th>&nbsp;</th>
						<td>
							<input type="button" class="homeButton" value="" onclick="location.href='/'"><input type="submit" class="loginButton" value="登录">
						</td>
					</tr>
				</tbody></table>
				<div class="powered">COPYRIGHT © 2008-2017.</div>
				<div class="link">
					<a href="http://www.chimingfowang.com/">持名佛网首页</a> |
					<a href="http://www.chimingbbs.com/">交流论坛</a> |
					<a href="">关于我们</a> |
					<a href="">联系我们</a> |
					<a href="">授权查询</a>
				</div>
			</form>
		</div>
</body>
</html>