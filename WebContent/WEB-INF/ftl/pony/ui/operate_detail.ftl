<#--
表格标签：用于显示详情页面 返回 编辑 删除按钮。
-->
<#macro operate_detail params id="">

	<input type="hidden" name="pageNo" value="${pageNo!}"/>
	<div class="pop_btn">
		<form class="ropt" id="ropt" action="list.do" method="get">
		<div class="button">
			<a href="javascript:void(document.getElementById('ropt').submit())">
				<div class="button_ico">
					<img src="${base}/res/cms/images/ico/button_Return.png" />
				</div>
				<span>返回</span>
			</a>
		</div>
		</form>
		<div class="button">
			<a href="edit.do?id=${id}${params}">
				<div class="button_ico">
					<img src="${base}/res/cms/images/ico/button_Save.png" />
				</div> 
				<span>编辑</span>
			</a>
		</div>
		<div class="button">
			<a href="delete.do?id=${id}${params}" onclick="if(!confirm('<@s.m "global.confirm.delete"/>')) {return false;}">
				<div class="button_ico">
					<img src="${base}/res/cms/images/ico/button_Close.png" />
				</div> <span>删除</span>
			</a>
		</div>
	</div>

</#macro>