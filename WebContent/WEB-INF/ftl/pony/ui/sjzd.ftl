<!-- 数据字典-显示  value:单值;valueList:多值，以逗号间隔-->
<#macro constant_value
   code_type="" value="" valueList=""  id="" name="" 
>
	<#list Application['constants'] as item>
		<#if item.codeType?string==code_type?string>
			<#if (value?string!='' &&  item.code?string=value?string)>
				${item.name}
			</#if>
			<#if (valueList?length > 0 )>
				<#assign valueLists=valueList?split(',')/>
				<#if valueLists?seq_contains(item.code?string)>
					${item.name} 
				</#if>
			</#if>
		</#if>
	</#list>

</#macro>

<!-- 数据字典-select-->
<#macro constant_select
	code_type="" value=""  id="" name=""
	class=""  style="" headerKey="" headerValue=""  headerButtom="false" required="" combobox="" onchange=""
	rule="" disabled=""
	>
	
	<select class="form-control"<#rt/>
		<#if id!=""> id="${id}"</#if><#rt/>
		<#if name!=""> name="${name}"</#if><#rt/>
		<#if required!=""> data-rule="${required}"</#if><#rt/>
		<#if combobox=="true"> combobox="true"</#if><#rt/>
		<#if onchange!=""> onchange="${onchange}"</#if><#rt/>
		<#if rule!=""> data-rule="${rule}"</#if><#rt/>
		<#if style!=""> style="${style}"</#if><#rt/>
		<#if disabled!=""> disabled="${disabled}"</#if><#rt/>
		><#rt/>
		<#if headerButtom=="false">
			<#if headerKey!="" || headerValue!="">
				<option value="${headerKey}"<#if headerKey==value?string> selected="selected"</#if>>${headerValue}</option><#t/>
			</#if>
		</#if>
		<#list Application['constants'] as item>
			<#if item.codeType?string==code_type?string>
				<option value="${item.code}"<#if item.code?string==value?string> selected="selected"</#if>>${item.name}</option><#t/>
			</#if>	
		</#list>
	</select>
</#macro>

<!-- 数据字典-radio -->
<#macro constant_radio
	code_type="" value=""  id="" name="" class=""
	required="false" rule="" disabled="" onchange=""
	search="false"
	>
	<div class="form-control" style="border: none;box-shadow: none;padding-left: 0px;">
		<#if search=="true">
			<#local rkey="">
			<#local rvalue="不限">
			<#include "/ftl/pony/ui/radio-item.ftl"><#t/>
		</#if>
		<#list Application['constants'] as item>
			<#if item.codeType?string==code_type?string>
				<#local rkey=item.code>
				<#local rvalue=item.name>
				<#include "/ftl/pony/ui/radio-item.ftl"><#t/>
			</#if>	
		</#list>
	</div>
</#macro>

<!-- 数据字典-checkbox  value：默认值，以逗号间隔-->
<#macro constant_checkbox
	code_type="" value=""  id="" name=""
	label="" noHeight="false" colspan="" width="100" help="" helpPosition="2" colon=":" hasColon="true"
	class="" style="" size="" title="" disabled="" tabindex="" accesskey="" rule=""
	>
	
	<#assign valueList=value?split(',')/>
	<#list Application['constants'] as item>
		<#if  item.codeType?string==code_type?string>
			<#local rkey=item.code>
			<#local rvalue=item.name>
			<#local index=item_index>
			<#local hasNext=item_has_next>
			<#include "/ftl/pony/ui/checkboxlist-item.ftl"><#t/>
		</#if>
	</#list>
</#macro>

<!-- 指标值转义显示 -->
<#macro item_value
   list="" value="" valueList=""  id=""
>
	<#list list as item>
			<#if (value?string!='' &&  item.id?string=value?string)>
				${item.name}
			</#if>
			<#if (valueList?length > 0 )>
				<#assign valueLists=valueList?split('^')/>
				<#if valueLists?seq_contains(item.id?string)>
					${item.name} 
				</#if>
			</#if>
	</#list>

</#macro>