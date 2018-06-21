var ajax = {};
ajax.x = function() {
	if (typeof window.XMLHttpRequest != 'undefined') {
		return new XMLHttpRequest();
	}
	var versions = [ "MSXML2.XmlHttp.6.0", "MSXML2.XmlHttp.5.0",
			"MSXML2.XmlHttp.4.0", "MSXML2.XmlHttp.3.0", "MSXML2.XmlHttp.2.0",
			"Microsoft.XmlHttp" ];
	var xhr;
	for (var i = 0; i < versions.length; i++) {
		try {
			xhr = new ActiveObject(versions[i]);
			break;
		} catch (e) {
		}
	}
	return xhr;
};
ajax.send = function(url, method, data, success, fail) {
	var async = true;
	var x = ajax.x();
	x.onreadystatechange = function() {
		if (x.readyState == 4) {
			var status = x.status;
			if (status >= 200 && status < 300) {
				success && success(x.responseText);
			} else {
				fail && fail(status);
			}
		}
	};
	x.open(method, url, async);
	if (method == 'POST') {
		x.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	}
	x.send(data);
};
ajax.post = function(url, data, fail) {
	var query = [];
	for ( var key in data) {
		query.push(encodeURIComponent(key) + '='
				+ encodeURIComponent(data[key]));
	}
	success = function(responseText) {
		alert("修改成功!");
	};
	ajax.send(url, 'POST', query.join('&'), success, fail);
};

function sub(url) {
	var userInfo = document.getElementsByName("txtUser");
	var flag = true;
	for(var i = 0;i<userInfo.length;i++){
		if(null==userInfo[i].value||""==userInfo[i].value||"undefined"==userInfo[i].value){
			flag = false;
		}
	}
	fail = function(status){
		alert(status);
	};
	if(flag){
		ajax.post(url, {name:userInfo[0].value,pass:userInfo[1].value,code:userInfo[2].value,
			address:userInfo[3].value,tel:userInfo[4].value,email:userInfo[5].value}, fail);
	}else{
		alert("含有空项");
	}
}
function change(){
	var userInfo = document.getElementsByName("txtUser");
	if(userInfo[1].value==""){
		document.getElementById("ps").innerHTML="密码不能为空";
	}else {
		document.getElementById("ps").innerHTML="";
	}
	if(userInfo[2].value==""){
		document.getElementById("co").innerHTML="邮编为空";
	}else{
		document.getElementById("co").innerHTML="";
	}
	if(userInfo[3].value==""){
		document.getElementById("ad").innerHTML="地址为空";
	}else {
		document.getElementById("ad").innerHTML="";
	}
	if(userInfo[4].value==""){
		document.getElementById("te").innerHTML="电话号码为空";
	}else{
		document.getElementById("te").innerHTML="";
	}
	if(userInfo[5].value==""){
		document.getElementById("em").innerHTML="email is null";
	}else{
		document.getElementById("em").innerHTML="";
	}
}
