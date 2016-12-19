<#--
表格标签：用于显示列表数据。
	value：列表数据，可以是Pagination也可以是List。
	class：table的class样式。默认"pn-ltable"。
	sytle：table的style样式。默认""。
	width：表格的宽度。默认100%。
-->
<#macro table  value paging showPage=true listAction="list.do" >
	<div style="overflow:auto;">
		<table class="table table-striped table-hover table-condensed table-list" style="border: 1px solid #e1e6eb;table-layout: fixed;margin-top:20px;">
			<#assign i=-1 />
			<thead style="background-color: #F5F6FA;">
					<tr><#nested 1,i,true/></tr>
			</thead>	
			<#if value?is_sequence><#local pageList=value/></#if>
			<#list pageList as row>
			<#assign i=row_index has_next=row_has_next/>
			<#if row_index==0>	
				<tbody>
					<tr>
			<#else>		
					<tr>
			</#if>
			<#nested row,row_index,row_has_next/>
			<#if !row_has_next>		
					</tr>
				</tbody>
			<#else>		
					</tr>
			</#if>
		</#list>
		</table>
		<#if (value?size==0)>
			<div class="alert alert-warning" style="text-align:center;">
					<i class="fa fa-warning"></i> 没有查询到符合条件的记录
			</div> 
		</#if>
	</div>
		<#if (value?size>0) && showPage  >
		<nav>
  			<ul class="pagination" style="margin:0;">
  				<li><span>共有${paging.totalResults}条，每页显示：${paging.pagingLinks}条</span></li>
  				<li class="<#if paging.currentPage==1>disabled</#if>"><a <#if paging.currentPage!=1>onclick="javascript:goPage('1')"</#if>>«</a></li>
				<li class="<#if paging.currentPage==1>disabled</#if>"><a <#if paging.currentPage!=1>onclick="javascript:goPage('${paging.currentPage-1}')"</#if>>‹</a></li>
				<#list paging.startPagingLink..paging.endPagingLink as page>
						<li class="<#if paging.currentPage==page>active</#if>"><a onclick="javascript:goPage('${page}')">${page}</a></li>
				</#list>
				<li class="<#if paging.currentPage==paging.lastPage>disabled</#if>"><a <#if paging.currentPage!=paging.lastPage>onclick="javascript:goPage('${paging.currentPage+1}')"</#if>>›</a></li>
				<li class="<#if paging.currentPage==paging.lastPage>disabled</#if>"><a <#if paging.currentPage!=paging.lastPage>onclick="javascript:goPage('${paging.lastPage}')"</#if>>»</a></li>
  			</ul>
		</nav>
	</#if>
</#macro>

