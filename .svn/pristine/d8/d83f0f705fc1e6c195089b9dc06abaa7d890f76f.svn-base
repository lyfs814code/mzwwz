<#--
<input type="checkboxlist"/>
-->
<#macro checkboxlist
	list listKey="" listValue="" value="" name="" >
<#if list?is_sequence>
		<#list list as item>
			<#local rkey=item[listKey]>
			<#local rvalue=item[listValue]>
			<#local index=item_index>
			<#local hasNext=item_has_next>
			<#include "checkboxlist-item.ftl"><#t/>
		</#list>
</#if>
</#macro>