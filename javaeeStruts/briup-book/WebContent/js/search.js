function search() {
	var url = location.href;
	url = "http://localhost:8888/briup-book/list.jsp" + url.split(".jsp")[1];
	var param;
	var target = document.getElementById("target");
	if (target != "" || target != null || target != "undefined") {
		/* 判断是否存在publish,存在就替换成search */
		if (url.indexOf("publish") > 0) {
			param = url.split("publish=")[0];
			url = param + "search=" + target.value;
		} else if (url.indexOf("search") > 0) {
			param = url.split("search=")[0];
			url = param + "search=" + target.value;
		} else {
			/* 不存在search，是否存在？ */
			if (url.indexOf("?") > 0) {
				url = url + "&search=" + target.value;
			} else {
				url = url + "?search=" + target.value;
			}
		}
		self.location.replace(url);
	}
}
