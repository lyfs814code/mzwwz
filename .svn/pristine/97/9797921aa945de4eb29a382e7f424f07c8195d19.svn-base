/* 查询及翻页 */
function goPage(pageNo) {
	document.getElementsByName("paging.currentPage")[0].value = pageNo;
	var from = $("#tableForm");
	$("#target_url").attr("href",
			"#" + from.attr('action') + "?" + from.serialize()).children()
			.click();
}

/* 按钮页面跳转 */
function btnHref(url) {
	$("#target_url").attr("href", url).children().click();
}
/* 按钮页面跳转 */
function btnHrefNoForm(url) {
	$("#target_url").attr("href", url).children().click();
}

/* 删除时，首先校验是否允许删除 */
function btnDel(url, parID, id, checkDel) {
	BootstrapDialog.show({
		title : '提示信息',
		message : "确认删除该数据吗？",
		type : BootstrapDialog.TYPE_DANGER,
		closable : true, // <-- Default value is false
		draggable : true, // <-- Default value is false
		buttons : [
				{
					icon : "glyphicon glyphicon-ban-circle",
					label : ' 取消',
					cssClass : 'type-default',
					action : function(dialogRef) {
						dialogRef.close();
					}
				},
				{
					icon : 'glyphicon glyphicon-check',
					label : ' 删除',
					cssClass : 'btn-danger',
					action : function(dialogRef) {
						if (checkDel) {
							$.post(url.replace("#", "").replace("delete",
									"checkDel"), function(data) {
								if (data == "Success") {
									$.web.delData(url);
								} else {
									showMsg(data);
									dialogRef.close();
								}
							}, "text");
						} else {
							$.web.delData(url);
						}
					}
				} ]
	});
}

// 弹出提示信息
function showMsg(msg) {
	BootstrapDialog.show({
		title : '提示信息',
		message : msg,
		buttons : [ {
			id : 'btn-ok',
			label : '确定',
			autospin : false,
			action : function(dialogRef) {
				dialogRef.close();
			}
		} ]
	});
}
// 弹出确认详细框
function showComfirmMsg(msg) {
	BootstrapDialog.confirm({
		title : '提示信息',
		message : msg,
		closable : true, // <-- Default value is false
		draggable : true, // <-- Default value is false
		btnCancelLabel : '取消', // <-- Default value is 'Cancel',
		btnOKLabel : '确定', // <-- Default value is 'OK',
		btnOKClass : 'btn-warning', // <-- If you didn't specify it, dialog type
		callback : function(result) {
		}
	});
}

// 弹出包含iframe的窗口
function alertDialogMsg(msg) {
	BootstrapDialog.confirm({
		title : '提示信息',
		message : msg,
		closable : true, // <-- Default value is false
		draggable : true, // <-- Default value is false
		btnCancelLabel : '取消', // <-- Default value is 'Cancel',
		btnOKLabel : '确定', // <-- Default value is 'OK',
		btnOKClass : 'btn-warning', // <-- If you didn't specify it, dialog type
		// will be used,
		callback : function(result) {
			// result will be true if button was click, while it will be false
			// if users close the dialog directly.
			if (result) {
				parent.closeDialog();
			}
		}
	});
}

// 关闭弹出窗口
function closeDialog() {
	BootstrapDialog.closeAll();
}

/* 弹出框 URL类型 */
function alertDialogUrl(title, url) {
	BootstrapDialog
			.show({
				size : 'size-wide',
				type : BootstrapDialog.TYPE_INFO,
				draggable : true,
				title : title,
				message : $('<div></div>')
						.append(
								"<iframe src='"
										+ url
										+ "' style='width:100%;min-height:100%;' frameborder='0' onload='Javascript:SetWinHeight(this)'></iframe>")
			});
}

// iframe高度随内容自适应
function SetWinHeight(obj) {
	var win = obj;
	if (document.getElementById) {
		if (win && !window.opera) {
			if (win.contentDocument && win.contentDocument.body.offsetHeight)
				win.height = win.contentDocument.body.offsetHeight + 20;
			else if (win.Document && win.Document.body.scrollHeight)
				win.height = win.Document.body.scrollHeight + 20;
		}
	}
}

// 删除按钮所在TR
function btnDelTr(obj) {
	BootstrapDialog.confirm({
		title : '提示信息',
		message : "确认移除该行吗？",
		btnCancelLabel : '取消', // <-- Default value is 'Cancel',
		btnOKLabel : '确定', // <-- Default value is 'OK',
		callback : function(result) {
			if (result) {
				$(obj).closest("tr").remove();
			}
			// 判断是否有添加的传感器数据
			if ($("input[name='ids']").length == 0) {
				$("#saveDataItem").hide();// 隐藏“保存”
			}
		}
	});
}

// 删除选中行
function btnDelCheckboxTr() {
	BootstrapDialog.confirm({
		title : '提示信息',
		message : "确认移除选中行吗？",
		btnCancelLabel : '取消', // <-- Default value is 'Cancel',
		btnOKLabel : '确定', // <-- Default value is 'OK',
		callback : function(result) {
			if (result) {
				$("input[name='ids']:checked").each(function() {
					$(this).closest("tr").remove();
				});
			}
		}
	});
}

/** 选择后图片的预览功能 */
function preImg(sourceId, targetId) {
	var url = "";
	if (navigator.userAgent.indexOf("MSIE") >= 1) { // IE
		url = document.getElementById(sourceId).value;
	} else if (navigator.userAgent.indexOf("Firefox") > 0) { // Firefox
		url = window.URL
				.createObjectURL(document.getElementById(sourceId).files
						.item(0));
	} else if (navigator.userAgent.indexOf("Chrome") > 0) { // Chrome
		url = window.URL
				.createObjectURL(document.getElementById(sourceId).files
						.item(0));
	}
	var imgPre = document.getElementById(targetId);
	imgPre.src = url;
}

/** 删除按钮前元素及按钮 */
function btnDelPre(obj) {
	if ($(obj).closest("td").children("span").length > 2) {
		$(obj).closest("span").remove();
	} else {
		showComfirmMsg("不可继续删除，至少保留两个可选项！");
	}
}

/** 删除按钮所在行 */
function btnDelTd(obj) {
	if ($("input", $(obj).closest("table")).length > 6) {
		$(obj).closest("tr").remove();
	} else {
		showComfirmMsg("不可继续删除，至少保留两个区间！");
	}
}
