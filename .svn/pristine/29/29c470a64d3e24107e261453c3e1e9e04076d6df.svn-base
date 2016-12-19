<#--
<input type="submit"/> 查询
-->
<#macro search style="">
	<a href="javascript:goPage('1')" class="btn btn-default" id="btn_search">
		<span class="glyphicon glyphicon-search" aria-hidden="true"></span> 查询
	</a>
</#macro>

<#--
<input type="add"/> 新增
-->
<#macro add obj msg="" para="">
	<a class="btn btn-primary btn-xs" onclick="btnHref('#${obj}/write.do')">
		<span class="glyphicon glyphicon-plus" aria-hidden="true"></span> <#if msg ==""> 新增<#else> ${msg}</#if>
	</a>
</#macro>

<#--
返回
-->
<#macro history_back>
	<button type="button" class="btn btn-default pull-right" onclick="javascript:history.back(-1);">
		 <span class="glyphicon glyphicon-arrow-left" aria-hidden="true" ></span>  返回
	</button>
</#macro>


<#--
<input type="submit"/> 保存
-->
<#macro submit>
	<button type="submit" class="btn btn-success pull-right">
		 <span class="glyphicon glyphicon-floppy-saved" aria-hidden="true"></span>  保存
	</button>
</#macro>

<#--
取消
-->
<#macro cancel>
	<button type="button" class="btn btn-link pull-right" onclick="javascript:history.back(-1);" tabindex="-1">
		  取消
	</button>
</#macro>

<#--
下载Excel/PDF
-->
<#macro download fuc>
<div class="btn-group">
  <button type="button" class="btn btn-success">下载数据</button>
  <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    <span class="caret"></span>
    <span class="sr-only">Toggle Dropdown</span>
  </button>
  <ul class="dropdown-menu" style="width:100px;min-width:100px;">
    <li><a href="javascript:window.location.href='${fuc}/excel.do'">Excel</a></li>
  </ul>
</div>
</#macro>

<#--
编辑
-->
<#macro btn_detail ctr id parID dataStatus="1">
	<button type="button" class="btn btn-default  pull-right" style="width:100px;margin:10px;" 
			onclick="javascript:history.back(-1);">
  		<span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span> 返回
	</button>
	<button type="button" class="btn btn-default  pull-right btn-warning" style="width:100px;margin:10px;" 
			<#if dataStatus!="1"> disabled="disabled"</#if>
			onclick="btnHrefNoForm('#${ctr}/edit.do?${parID}=${id}')">
  		<span class="glyphicon glyphicon-edit" aria-hidden="true"></span> 修改
	</button>
</#macro>

<#--
删除
-->
<#macro delete id params parID status="1">
	<button type="button" class="btn btn-default  pull-right btn-danger" style="width:100px;margin:10px;"
			<#if status!="1"> disabled="disabled"</#if>
		 	onclick="btnDel('delete.do?${parID}=${id}&${params}','${parID}','${id}')">
  		<span class="glyphicon glyphicon-trash" aria-hidden="true"></span> 删除
	</button>
</#macro>

<#--
删除按钮前元素及按钮
-->
<#macro delete_pre>
	<button type="button" tabindex="999" class="btn btn-danger  btn-xs" onclick="btnDelPre(this)">
  		<span class="glyphicon glyphicon-trash" aria-hidden="true"></span> 删除
	</button>
</#macro>

<#--
删除按钮所在行
-->
<#macro delete_td>
	<button type="button" tabindex="999" class="btn btn-danger  btn-xs" onclick="btnDelTd(this)">
  		<span class="glyphicon glyphicon-trash" aria-hidden="true"></span> 删除
	</button>
</#macro>

<#--
审核
-->
<#macro check id params parID status="1">
	<button type="button" class="btn btn-default btn-sm btn-info" onclick="btnHref('detail.do?${parID}=${id}&${params}')">
 	 	<span class="glyphicon glyphicon-align-left" aria-hidden="true"></span> 详细
	</button>
	
	<button type="button" class="btn btn-default btn-sm btn-warning" onclick="btnHref('check.do?${parID}=${id}&${params}')"
		<#if status!="1"> disabled="disabled"</#if>
	>
  		<span class="glyphicon glyphicon-edit" aria-hidden="true"></span> 审核
	</button>
</#macro>

<#--
<input type="button"/>模板导出
-->
<#macro export_mod  collectId=''>
	<button type="button" class="btn btn-xs btn-default" onclick="export_mod()">
		<span class="glyphicon glyphicon-download" aria-hidden="true"></span> 模板下载
	</button>
</#macro>

<#--
<input type="button"/>数据导入
-->
<#macro import collectId=''>
	<button type="button" class="btn btn-xs btn-default" onclick="showImport();">
		<span class="glyphicon glyphicon-open" aria-hidden="true"></span> 数据上传
	</button>
</#macro>

<#--
<input type="button"/>数据导出
-->
<#macro export collectId=''>
	<button type="button" class="btn btn-xs btn-default" onclick="exportIn()">
		<span class="glyphicon glyphicon-save" aria-hidden="true"></span> 数据下载
	</button>
</#macro>
