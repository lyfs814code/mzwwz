$.address.init(function(event) {
	var _url = window.location.href.split("/main.do")[1];
	if (_url == "" || _url == "home.do") {
		$("#menu a:first").children().click();
	} else {
		var subMenu = $("a[href='" + _url.split("/")[0] + "/list.do']");
		subMenu.parent().addClass("select");
	}
}).change(function(event) {
	// 个人中心
	var href = event.value.replace("/", "");
	if (href != "") {
		// 加载数据
		$.web.htmlLoad(href, null, "#page-info");
	}
});
var funResult = {
	'SUCCESS_S' : "数据新增成功！",
	'SUCCESS_U' : "数据修改成功！",
	'SUCCESS_D' : "数据删除成功！"
};
$.web = {
	/** form提交* */
	submit : function(fid) {
		var $f = $("#" + fid);
		if ($f) {
			$.post($f.attr('action'), $f.serialize(), function(result) {
				if (funResult[result]) {
					// 新增与修改后，重新查询
					history.go(-1);
					// 显示提示信息
					$.web.showFunMsg(funResult[result]);
				} else {
					showMsg(result);
				}
			}, 'html');
		}
	},
	submitWIthFIle : function(fid) {
		var $f = $("#" + fid);
		if ($f) {
			$.post($f.attr('action'), $f.serialize(), function(result) {
				if (funResult[result]) {
					// 新增与修改后，重新查询
					history.go(-1);
					// 显示提示信息
					$.web.showFunMsg(funResult[result]);
				} else {
					showMsg(result);
				}
			}, 'html');
		}
	},
	delData : function(url) {
		$.post(url, function(result) {
			if (funResult[result]) {
				// 删除后，重新查询
				history.go(0);
				// 显示提示信息
				$.web.showFunMsg(funResult[result]);
			} else {
				showMsg(result);
			}
		}, 'html');
	},
	/** 页面加载* */
	htmlLoad : function(url, data, target) {
		$(target).empty();
		$.post(url, data, function(result) {
			$(target).html(result);
		});
	},
	/** 新增修改删除后信息提示框 */
	showFunMsg : function(msg) {
		$("#funMsg").text(msg);
		$("#fun_success_msg").show().delay(2000).fadeOut(1000);
	},
	ajaxFileUpload : function(item) {
		$.ajaxFileUpload({
			url : 'fileUpload.do',
			secureuri : false,
			fileElementId : "file-upload-file"+item,
			dataType : 'json',
			success : function(data, status) {
				$("#file-upload-name"+item).val(data.fileUrl);
			}
		})
		return false;
	}
};