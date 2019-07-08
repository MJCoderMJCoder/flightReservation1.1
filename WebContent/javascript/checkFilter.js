function checkBrowser() { // 检查浏览器
// var browser = navigator.appName
// var b_version = navigator.appVersion
// var version = parseFloat(b_version)
	var ua = navigator.userAgent.toLowerCase().substring(0, 51);
//	document.getElementById("userID").value = ua;
	if ((ua == "mozilla/5.0 (msie 9.0; windows nt 6.1; trident/7.0;")) {
	} else {
		alert("建议使用IE9.0以上版本的浏览器\n（兼容模式下，效果更佳）")
	}
}

function login() { // 登录界面显示
	var login = document.getElementById("loginDiv");
	login.innerHTML = '<div id="login"></div><form action="login" method="post"><table id="loginTable" width="295" cellspacing="8%"><tr><td width="25%" nowrap="nowrap">登录</td><td align="right" width="75%" nowrap="nowrap"><label style="cursor: pointer" onclick="closeLogin()">关闭</label></td></tr><tr></tr><tr></tr><tr><td align="right" nowrap="nowrap">身份证号：</td><td nowrap="nowrap"><input type = "text" name = "userID" id="userID" value=""/><b style="color: red;">&nbsp; *</b></td></tr><tr><td  align="right" nowrap="nowrap">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</td><td nowrap="nowrap"><input type = "password" id="password" name = "password" value="" size="21"/><b style="color: red;">&nbsp; *</b></td></tr><tr></tr><tr></tr><tr><td align="center" nowrap="nowrap" colspan="2"><input type="button" id="loginButton" onmousedown="checkLogin()" value="登 录"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type = "reset" value="重 置"/></td></tr></table></form>';
	document.getElementById("login").style.display = "block";
	document.getElementById("loginTable").style.display = "block";

}

// function clearUserNo(){
// var userNo = document.getElementById("userNo").value="";
// }

function checkLogin() { // 登录信息检测
	var userID = document.getElementById("userID").value;
	var password = document.getElementById("password").value;

	var xmlhttp;
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			var responseText = xmlhttp.responseText;

			if (responseText == "noID") {
				alert("身份证号有误，请重新输入");
			} else if (responseText == "noPW") {
				alert("密码错误，请重新输入");
			} else {
				document.getElementById("loginButton").type = "submit";
			}

		}
	}
	xmlhttp.open("GET", "login?userID=" + userID + "&password=" + password,
			true);
	xmlhttp.send();
}
function closeLogin() { // 关闭登录界面
	document.getElementById("login").style.display = "none";
	document.getElementById("loginTable").style.display = "none";
}

function checkInput() { // 注册输入检测
	var userID = document.getElementById("userID").value;
	var password = document.getElementById("password").value;
	var passwordAgain = document.getElementById("passwordAgain").value;
	var phone = document.getElementById("phone").value;
	var email = document.getElementById("email").value;
	var responseText = document.getElementById("responseText").innerHTML;
	var userIDRegex = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
	var phoneRegex = new RegExp("1" + "\\d{10}");
	var emailRegex = new RegExp("\\S+" + "@" + "\\w+" + "." + "\\w+");
	if (userIDRegex.test(userID) && password != null && password != ""
			&& phoneRegex.test(phone) && emailRegex.test(email)
			&& password == passwordAgain && responseText == "yes") {
		document.getElementById("button").type = "submit";
	} else {
		alert("信息填写有误，请您认证核对相关重要信息后，重新输入");
	}
}

function checkInputUpdate() { // 更新输入检测
	var userID = document.getElementById("userID").value;
	alert(userID);
	var password = document.getElementById("password").value;
	var passwordAgain = document.getElementById("passwordAgain").value;
	var phone = document.getElementById("phone").value;
	var email = document.getElementById("email").value;
	var phoneRegex = new RegExp("1" + "\\d{10}");
	var emailRegex = new RegExp("\\S+" + "@" + "\\w+" + "." + "\\w+");
	if (password != null && password != "" && phoneRegex.test(phone)
			&& emailRegex.test(email) && password == passwordAgain) {
		document.getElementById("button").type = "submit";
	} else {
		alert("信息填写有误，请您认证核对相关重要信息后，重新输入");
	}
}

function userIDTest() { // 身份证号检测
	var userID = document.getElementById("userID").value;

	var xmlhttp;
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {

			document.getElementById("responseText").innerHTML = xmlhttp.responseText;

			var userIDRegex = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
			var responseText = document.getElementById("responseText").innerHTML;
			// alert(responseText);
			if (!userIDRegex.test(userID)) {
				document.getElementById("userIDAlert").innerHTML = '<font size="2">&nbsp; 身份证号信息有误</font>';
			} else if (responseText == "no") {
				document.getElementById("userIDAlert").innerHTML = '<font size="2">&nbsp; 该身份证号已注册</font>';
			} else {
				document.getElementById("userIDAlert").innerHTML = '<font size="2">&nbsp; *</font>';
			}

		}
	}
	xmlhttp.open("GET", "query?userID=" + userID, true);
	xmlhttp.send();
}

function passwordTest() { // 密码不能为空
	var password = document.getElementById("password").value;
	if (password != null && password != "") {
		document.getElementById("passwordAlert").innerHTML = '&nbsp; *';
	} else {
		document.getElementById("passwordAlert").innerHTML = '<font size="2">&nbsp; 密码不能为空</font>';
	}
}
function passwordAgainTest() { // 两次密码要一致
	var password = document.getElementById("password").value;
	var passwordAgain = document.getElementById("passwordAgain").value;
	if (password == passwordAgain) {
		document.getElementById("passwordAgainAlert").innerHTML = '&nbsp; *';
	} else {
		document.getElementById("passwordAgainAlert").innerHTML = '<font size="2">&nbsp; 两次密码输入不一致</font>';
	}
}
function phoneTest() { // 手机号格式
	var phone = document.getElementById("phone").value;
	var phoneRegex = new RegExp("1" + "\\d{10}");
	if (phoneRegex.test(phone)) {
		document.getElementById("phoneAlert").innerHTML = '&nbsp; *';
	} else {
		document.getElementById("phoneAlert").innerHTML = '<font size="2">&nbsp; 手机号信息有误</font>';
	}
}

function emailTest() { // 邮箱格式
	var email = document.getElementById("email").value;
	var emailRegex = new RegExp("\\S+" + "@" + "\\w+" + "." + "\\w+");
	if (emailRegex.test(email)) {
		document.getElementById("emailAlert").innerHTML = '&nbsp; *';
	} else {
		document.getElementById("emailAlert").innerHTML = '<font size="2">&nbsp; email信息有误</font>';
	}
}
