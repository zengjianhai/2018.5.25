var amount = 1;
var count = document.getElementsByName("count");
function add(i) {
	amount = parseInt(count[i].value);
	amount = amount + 1;
	count[i].value = amount;
}
function del(i) {
	amount = parseInt(count[i].value);
	if (amount > 1) {
		amount = amount - 1;
		count[i].value = amount;
	}
}

function delPro(url, proId, str) {
	if (confirm("你忍心删除么？")) {
		window.location
				.assign("http://localhost:8888/briup-book/shopcar.do?product_id="
						+ proId + "")
	} else {

	}
}
var flag = false;
function change() {
	var all = document.getElementsByName("all");
	var obj = document.getElementsByName("yesorno");
	var price = document.getElementsByName("price");
	var allcount = document.getElementById("allcount");
	var allprice = document.getElementById("allprice");
	var allc = 0;
	var allp = 0;
	if (all[0].checked) {
		for (var i = 0; i < obj.length; i++) {
			obj[i].checked = true;
		}
		flag = true;
	} else if (!all[0].checked && flag) {
		for (var i = 0; i < obj.length; i++) {
			obj[i].checked = false;
		}
		allcount.innerHTML = 0;
		allprice.innerHTML = 0;
		flag = false;
	}
	var count = 0;
	for (var i = 0; i < obj.length; i++) {
		if (obj[i].checked) {
			allc = allc + parseInt(obj[i].value);
			allp = allp + price[i].value * obj[i].value;
			allcount.innerHTML = allc;
			allprice.innerHTML = allp;
			count++;
		}
		if (count == 0) {
			allcount.innerHTML = 0;
			allprice.innerHTML = 0;
		}
	}
}
function account() {
	var id = document.getElementsByName("pro_id");
	var obj = document.getElementsByName("yesorno");
	var price = document.getElementsByName("price");
	var pro;
	var s = '';
	var c = '';
	var amount;
	var flag = false;
	var allc = 0;
	var allp = 0;
	for (var i = 0; i < obj.length; i++) {
		if (obj[i].checked) {
			amount = obj[i].value+"|";
			c=c+amount;
			allc = allc + parseInt(obj[i].value);
			allp = allp + price[i].value * obj[i].value;
			pro = id[i].value + '|';
			s = s + pro;
			flag = true;
		}
	}
	if (flag) {
		if(confirm("结账")){
			window.location
			.assign("http://localhost:8888/briup-book/confirm.do?product_ids="
					+ s + "&allcount="+allc+"&allprice="+allp+"&amount="+c+"")
		}else{}
	} else {
		alert("没选择商品");
	}
}
