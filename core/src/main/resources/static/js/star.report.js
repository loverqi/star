/* 页面文件上传的方法 */
function changeFile(input) {
	var file = input.files[0];// 上传的图片的所有信息
	if (file.type != 'application/vnd.ms-excel') {
		alert('上传文件必须是xls格式');
	} else {
		$.ajaxFileUpload({
			url : '/customer/uploadFile.do', // 用于文件上传的服务器端请求地址
			secureuri : false, // 是否需要安全协议，一般设置为false
			fileElementId : 'input_file', // 文件上传域的ID
			dataType : 'json', // 返回值类型 一般设置为json
			success : function(data) {
				if (data.code == 0) {
					alert(data.data);
					$("#form1").submit();
				} else {
					alert("导入失败请重试");
				}
			},
			error : function(data) {
				alert("网络超时");
			}
		})
	}
}

/* 页面文件下载的方法 */
function download() {
	$.download('/customer/downloadFile.do', $("#form1").serialize(), 'post');
}

/* 加载时间选择框的方法 */
function loadDateInput() {
	$('.date-timepicker').datetimepicker({
		language : 'zh-CN',
		format : 'YYYY-MM-DD HH:mm:00',
		autoclose : true,
		todayBtn : true,
		clearBtn : true
	}).next().on(ace.click_event, function() {
		$(this).prev().focus();
	});

	$('.sel_search_orderstatus').multiselect({
        buttonWidth: '160px',
		includeSelectAllOption : true,// 是否现实全选
		enableFiltering: true,//过滤 
	});
}
