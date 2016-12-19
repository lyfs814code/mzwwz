<#--
<form></form>
-->
<#macro form action="" method="post" id="" class="" onsubmit="" enctype="">
<form<#rt/>
 method="${method}"<#rt/>
 action="${action}"<#rt/>
 class="form form-edit ${class}"<#rt/>
<#if id!=""> id="${id}"</#if><#rt/>
<#if onsubmit!=""> onsubmit="${onsubmit}"</#if><#rt/>
<#if enctype!=""> enctype="${enctype}"</#if><#rt/>
>
<#nested/><#rt/>
</form>
</#macro>
