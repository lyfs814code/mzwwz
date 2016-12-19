<#--
<select><option></option></select>
-->
<#macro select
	list listKey="" listValue="" listOther="" value="" valueList="" multiple="" headerKey="" headerValue="" 
	id="" name=""  disabled="" tabindex="" class=""
	onclick="" onchange="" vld="" style=""
	>
<select<#rt/>
<#if id!=""> id="${id}"</#if><#rt/>
<#if name!=""> name="${name}"</#if><#rt/>
<#if class!=""> class="${class}"</#if><#rt/>
<#if disabled!=""> disabled="${disabled}"</#if><#rt/>
<#if tabindex!=""> tabindex="${tabindex}"</#if><#rt/>
<#if multiple!=""> multiple="${multiple}"</#if><#rt/>
<#if vld!=""> vld="${vld}"</#if><#rt/>
<#if style!=""> style="${style}"</#if><#rt/>
<#if onclick!=""> onclick="${onclick}"</#if><#rt/>
<#if onchange!=""> onchange="${onchange}"</#if><#rt/>
><#rt/>
	<#if headerKey!="" || headerValue!="">
		<option value="${headerKey}"<#if headerKey==value> selected="selected"</#if>>${headerValue}</option><#t/>
	</#if>
	<#assign valueLists=valueList?split(',')/>
	<#list list as item>
		<option value="${item[listKey]}"<#if (item[listKey]?string==value?string || valueLists?seq_contains(item[listKey]?string))> selected="selected"</#if>>
			<#if listOther!="">${item[listOther]}-</#if>${item[listValue]}
		</option><#t/>
	</#list>
</select>
</#macro>
