	var amount = 1;
	function add() {
		var count = document.getElementById("count");
		amount = parseInt(count.value);
		amount = amount + 1;
		count.value = amount;
	}
	function del() {
		if (amount > 1) {
			amount = amount - 1;
			count.value = amount;
		}
	}
	/**
	 * ajax部分刷新，可以不用跳转
	 */
	var ajax = {};
	ajax.x = function() {
		if (typeof window.XMLHttpRequest != 'undefined') {
			return new XMLHttpRequest();
		}
		var versions = [ "MSXML2.XmlHttp.6.0", "MSXML2.XmlHttp.5.0",
				"MSXML2.XmlHttp.4.0", "MSXML2.XmlHttp.3.0",
				"MSXML2.XmlHttp.2.0", "Microsoft.XmlHttp" ];
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
	ajax.send = function(url, method, data, success, fail,name) {
		var	async = true;
		var x = ajax.x();
		x.onreadystatechange = function() {
			if (x.readyState == 4) {
				var status = x.status;
				if (status >= 200 && status < 300) {
					success && success(x.responseText,name,x,data,method);
				} else {
					fail && fail(status);
				}
			}
		};
		x.open(method, url, async);
		if(method == 'POST'){
			x.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
		}
		x.send(data);
	};
	ajax.post = function(url, data, fail,name){
		var query=[];
		for(var key in data){
			query.push(encodeURIComponent(key) + '='+encodeURIComponent(data[key]));
		}
		success = function(responseText,proName,xmlhttprs,data,method){
			if("update"==responseText){
				if(confirm("《"+proName+"》已存在，小子任性点，这样才是男人")){
					alert("this is a update: "+xmlhttprs);
					xmlhttprs.open(method, url, true);
					xmlhttprs.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
					xmlhttprs.send(data+"&flag=true");
				}else{
					
				}
			}else if("add"==responseText){
				alert("《"+proName+"》加入购物车成功!");
			}else{
				alert(responseText);
			}
		};
		ajax.send(url, 'POST', query.join('&'), success, fail,name);
	};
	function addShopCart(url,name,product_id){
		fail = function(status){
			alert(status);
		};
		ajax.post(url, {product_id:product_id,count:amount}, fail,name);
	}
