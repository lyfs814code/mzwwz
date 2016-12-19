<#--
表格标签：用于显示增删查改标签。
	value：列表数据，可以是Pagination也可以是List。
	class：table的class样式。默认"pn-ltable"。
	sytle：table的style样式。默认""。
	width：表格的宽度。默认100%。
-->
<#macro operate id parID obj dataStatus="1" checkDel="true">
<a class="btn btn-default btn-info btn-xs"
		<#if dataStatus!="1"> disabled="disabled"</#if>
		onclick="btnHref('#${obj}/edit.do?${parID}=${id}')" >
  <span class="glyphicon glyphicon-edit" aria-hidden="true"></span> 修改
</a>

<a type="button" class="btn btn-default btn-danger btn-xs "
		<#if dataStatus!="1"> disabled="disabled"</#if>
		onclick="btnDel('${obj}/delete.do?${parID}=${id}','${parID}','${id}',${checkDel})">
  <span class="glyphicon glyphicon-trash" aria-hidden="true"></span> 删除
</a>
</#macro>