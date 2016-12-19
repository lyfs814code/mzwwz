<label class="radio-inline">
	<input type="radio"
		name="${name}"
		value="${rkey}" 
		<#if onchange!=""> onchange="${onchange}"</#if><#rt/>
		<#if disabled!=""> disabled="${disabled}"</#if><#rt/>
		<#if value?string==rkey?string> checked="checked"</#if>
	/>${rvalue}
</label>
