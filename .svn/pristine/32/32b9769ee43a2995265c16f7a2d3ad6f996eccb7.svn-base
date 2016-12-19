[#--
家庭成员查询
--]
[#macro upload_image name src item value isDetail="false" width="100%" height="100%"]
<div class="file-input">
	<div class="file-preview ">
	    <div class=" file-preview-zone">
	    	[#if src==""]
	    		<img id="file-preview-img${item}" class="file-preview-zone-img" src="res/images/img_priview.png">
	    	[#else]
	    		<img id="file-preview-img${item}" class="file-preview-zone-img" src="${src}">
	    	[/#if]
	    </div>
	</div>
	
	[#if isDetail=="false" ]
	<div class="input-group">
	   <div tabindex="500" class="form-control">
	   		<div id="file-input-name${item}" class="file-input-name" title=""></div>
		</div>

	   <div class="input-group-btn">
	       <div tabindex="500" class="btn btn-primary btn-file">
	       		<i class="glyphicon glyphicon-folder-open"></i>&nbsp;  <span class="hidden-xs">选择图标</span>
	       		<input id="file-upload-file${item}" name="file-upload-file${item}"  type="file" class="form-control">
	       		<input type="hidden" name="${name}" id="file-upload-name${item}" value="${src}">
	       	</div>
	       	<small class="help-block" id="msg_${name}"></small>
	   </div>
	</div>
	<script type="text/javascript">
	 	$(function () {
			$("#file-upload-file${item}").uploadPreview({ Img: "file-preview-img${item}", Width:"${width}",Height:"${height}" });
			$("#file-upload-file${item}").on("change",null,function(){
				var _obj = $("#file-upload-file${item}").clone(true);
				$.web.ajaxFileUpload(${item});
				$("#file-upload-file${item}").replaceWith(_obj);
			});
		});
	 </script>
	[/#if]
 </div>
[/#macro]