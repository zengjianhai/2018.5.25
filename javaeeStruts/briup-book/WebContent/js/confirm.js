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
		alert("订单提交成功!");
	};
	ajax.send(url, 'POST', query.join('&'), success, fail);
};
function sub(url,pros,amounts) {
	var name = document.getElementById("name");
	var address = document.getElementById("address");
	var tel = document.getElementById("tel");
	var nat = name.value+"|"+address.value+"|"+tel.value;
	var flag = true;
	if(null==name.value||""==name.value||"undefined"==name.value){
		flag = false;
	}
	if(null==address.value||""==address.value||"undefined"==address.value){
		flag = false;
	}
	if(null==tel.value||""==tel.value||"undefined"==tel.value){
		flag = false;
	}
	fail = function(status) {
		alert(status);
	};
	if(flag){
		ajax.post(url, {product_ids:pros,amounts:amounts,nat:nat}, fail);
	}
	alert(url+":"+pros+":"+amounts+":"+nat);
}
