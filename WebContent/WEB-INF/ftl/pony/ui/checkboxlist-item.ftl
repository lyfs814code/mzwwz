<label class="checkbox-inline" style="margin-left:10px;">
	<#assign valueLists=value?split('^')/>
	<input 
		type="checkbox"<#rt/>
	 	name="${name}"<#rt/>
	 	value="${rkey}"<#rt/>
		<#if valueLists?seq_contains(rkey)> checked="checked"</#if><#rt/>
	/>${rvalue}
</label>
	<#if hasNext> </#if>