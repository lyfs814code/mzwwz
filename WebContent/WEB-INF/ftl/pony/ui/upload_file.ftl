[#--
家庭成员查询
--]
[#macro upload_file name item value]
		<div style="padding-top: 20px;padding-left: 20px;">
			<span class="label">导入数据信息：</span>
			<input type="hidden" id="uploadImgPath${item}" name=${name} style="width:170px" class="files" >
			<span id="ufc1" style="position:relative">
				<input type='text' id='uploadFileText${item}' size="34" class="files"/>  
				<input class="browse" type='button' value='浏览'/>
				<input onchange="$('#uploadFileText${item}').val(this.value)" size="14" type="file" id="uploadFile${item}" class="file-button"/>
			</span>
			<label>
			<input type="button" value="上传" onclick="upload(${item},${item});" class="upload-button"/>
			</label>
		</div>
		
[/#macro]