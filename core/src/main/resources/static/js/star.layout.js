$('.nav-list').find('a').each(loadActiveMenu);

/* 加载按钮激活项的方法 */
function loadActiveMenu() {
	if (this.href == document.location.href || document.location.href.search(this.href) >= 0) {
		var lis = $(this).parents('li');
		lis.addClass('active');
		var size = lis.size() - 1;
		lis.each(function(index) {
			loadActiveBar(size, index, $(this));
		});
	}
}

/* 加载导航条的方法 */
function loadActiveBar(size, index, obj) {
	var text = obj.children("a").children("span").text();
	var href = obj.children("a").attr("href");
	if (index == 0 && size == index) {
		var icno = obj.children("a").children("i").attr("classname");
		$("#breadcrumb_list").prepend('<li><i class="ace-icon fa home-icon ' + icno + '"></i>&nbsp;&nbsp;<a href="javascript:void(0)">' + text + '</a></li>');
	} else if (index == 0) {
		$("#breadcrumb_list").prepend('<li><a href="javascript:void(0)">' + text + '</a></li>');
	} else if (index == size) {
		var icno = obj.children("a").children("i").attr("classname");
		$("#breadcrumb_list").prepend('<li><i class="ace-icon fa home-icon ' + icno + '"></i>&nbsp;&nbsp;<a href="' + href + '">' + text + '</a></li>');
	} else {
		$("#breadcrumb_list").prepend('<li><a href="' + href + '">' + text + '</a></li>');
	}
}
