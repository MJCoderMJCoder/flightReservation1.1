<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="../css/decorate.css">
<script type="text/javascript" src="../javascript/checkFilter.js"></script>
<title>个人信息详情</title>
</head>
<body onload="checkBrowser()" background="../image/016.png">
	<div class="banner">
		<table width="100%" cellpadding="7">
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td align="right"><a id="a" href="dateCity.jsp" style=""><strong>预订机票</a>
					&nbsp;</strong></td>
			</tr>
		</table>
	</div>

	<div id="loginDiv"></div>

	<br />
	<br />
	<br />
	<br />
	<table width="100%">
		<tr>
			<td width="60%" align="right"><!-- <img src="image/register.png"
				style="width: 100%;" /> --></td>
			<td align="center" width="40%">
				<table cellspacing="10%">
					<form method="post" action="../update">
						<tr>
							<td align="center" nowrap="nowrap"><b>个人信息详情</b></td>
						</tr>
						<tr>
							<td align="left" nowrap="nowrap"><strong>身份证号：</strong><input
								type="text" value="${user.userID }" disabled="disabled" /><input
								type="hidden" name="userID" id="userID" readonly="readonly"
								value="${user.userID }" /><b style="color: red;"
								id="userIDAlert">&nbsp; *</b></td>
						</tr>
						<tr>
							<td align="left" nowrap="nowrap">
								<strong>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</strong><input
								id="password" type="password" name="password" value="${user.password }" size="21"
								onblur="passwordTest()" /><b style="color: red;" id="passwordAlert">&nbsp;
									*</b>
							</td>
						</tr>
						<tr>
							<td align="left" nowrap="nowrap"><strong>确认密码：</strong><input
								id="passwordAgain" type="password" name="passwordAgain" value="${user.password }"
								size="21" onblur="passwordAgainTest()" /><b style="color: red;"
								id="passwordAgainAlert">&nbsp; *</b>
							</td>
						</tr>
						<tr>
							<td align="left" nowrap="nowrap"><strong>手&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;机：</strong><input
								type="text" name="phone" id="phone" value="${user.phone }" onblur="phoneTest()" /><b
								style="color: red;" id="phoneAlert">&nbsp; *</b></td>
						</tr>
						<tr>
							<td align="left" nowrap="nowrap"><strong>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：</strong><input
								type="text" name="email" id="email" value="${user.email }" onblur="emailTest()" /><b
								style="color: red;" id="emailAlert">&nbsp; *</b></td>
						</tr>
						<tr>
							<td align="left" nowrap="nowrap">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
								type="button" value="提交" id="button" onclick="checkInputUpdate()" />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
								type="reset" value="重置" />
							</td>
						</tr>
					</form>
				</table>
			</td>
		</tr>
	</table>

	<div class="bottom">
		<br /><strong> 纸纷飞 <font class="bottomFont">&copy;</font> 2015-2016 版权所有 </strong><br />
		<br />
	</div>
</body>
</html>