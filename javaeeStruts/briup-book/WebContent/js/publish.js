function publish(i) {
	rep("publish","search","price","http://localhost:8888/briup-book/list.jsp",i);
}
function price(i) {
	rep("price","search","publish","http://localhost:8888/briup-book/list.jsp",i);
}
function delprice() {
	delrep("price","publish","http://localhost:8888/briup-book/list.jsp");
}
function delpublish() {
	delrep("publish","price","http://localhost:8888/briup-book/list.jsp");
}
delrep = function(start, end,pathUrl) {
	var url = location.href;
	url = pathUrl + url.split(".jsp")[1];
	var param;
	if (url.indexOf(start) > 0) {
		param = url.split(start+"=")[0];
		if (url.split(start+"=")[1].indexOf(end) > 0) {
			var publish = url.split(start+"=")[1].split("&")[1];
			url = param + publish;
		} else {
			url = url.split("&"+start+"=")[0];
		}
		self.location.replace(url);
	}
}
rep = function(start,search, end,pathUrl,i){
	var url = location.href;
	url = pathUrl + url.split(".jsp")[1];
	var param;
	var target = document.getElementsByName(start);
	if (target[i].innerHTML != "" || target[i].innerHTML != null
			|| target.innerHTML != "undefined") {
		/* 判断是否存在search,存在就替换成publish */
		if (url.indexOf(search) > 0) {
			param = url.split(search+"=")[0];
			url = param + start+"=" + target[i].innerHTML;
		} else if (url.indexOf(start) > 0) {
			param = url.split(start+"=")[0];
			if (url.split(start+"=")[1].indexOf(end) > 0) {
				var publish = url.split(start+"=")[1].split("&")[1];
				url = param + start+"=" + target[i].innerHTML + "&" + publish;
			} else {
				url = param + start+"=" + target[i].innerHTML;
			}
		} else {
			/* 不存在publish，是否存在？ */
			if (url.indexOf("?") > 0) {
				url = url + "&"+start+"=" + target[i].innerHTML;
			} else {
				url = url + "?"+start+"=" + target[i].innerHTML;
			}
		}
		self.location.replace(url);
	}
}

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
		document.getElementById("val").innerHTML = responseText;
	};
	ajax.send(url, 'POST', query.join('&'), success, fail);
};
function chance(url,i,catalog,detail,price,publish,search){
	for(var j=0;j<4;j++){
		if(j==parseInt(i)){
			document.getElementById("this"+j).className="current";
		}else{
			document.getElementById("this"+j).className="";
		}
	}
	fail = function(status) {
		alert(status);
	};
	ajax.post(url, {chance:i,catalog:catalog,detail:detail,price:price,publish:publish,search:search}, fail);
}