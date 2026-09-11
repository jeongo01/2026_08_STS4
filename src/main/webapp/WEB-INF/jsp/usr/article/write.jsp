<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<c:set var="pageTitle" value="WRITE"/>
	
<%@ include file="../common/header.jsp" %>

	<script>
		const writeForm_onSubmit = function(form) {
			form.title.value = form.title.value.trim();
			form.body.value = form.body.value.trim();
			
			if(form.title.value.length == 0) {
				alert('제목을 입력해주세요.');
				form.title.focus();
				return;
			}
				
			if(form.body.value.length == 0) {
				alert('내용을 입력해주세요.');
				form.body.focus();
				return;	
			}
			
			form.submit();
		}
	</script>

		
	<sction class="mt-8 text-xl">
		<div class="container mx-auto px-3">
			<form action="doWrite" method="post" onsubmit="writeForm_onSubmit(this) return false;">
				<div>
					<table class="table table-lg">
						<tr>
							<th>게시판 종류</th>
							<td>
								<div class="flex">
									<label class="flex items-center">
										<input class="radio radio-info radio-xs" name="boardId" type="radio" value="1" checked/>
										&nbsp;&nbsp;공지사항
									</label>
									<div class="w-20"></div>
									<label class="flex items-center">
										<input class="radio radio-info radio-xs" name="boardId" type="radio" value="2"/>
										nbsp;&nbsp;자유
									</label>
								</div>
							</td>
						</tr>
						<tr>
							<td>제목</td>
							<th><input class="input input-bordered input-info w-9/12" name="title" type="text" placeholder="제목을 입력해주세요." /></th>
						</tr>
						<tr>
							<td>내용</td>
							<th><textarea class="textarea textarea-bordered textarea-info w-9/12" name="body" placeholder="내용을 입력해주세요."></textarea></th>
						</tr>
						<tr>
							<td class="text-center" colspan="2"><buttonㅈ class="btn btn-wide btn-outline btn-sm">작성</button></td>
						</tr>
					</table>
				</div>
			</form>
			
			<div>
				<button class="btn btn-outline btn-sm" onclick="history.back();">뒤로가기</button>
			</div>
		</div>
	</sction>

<%@ include file="../common/footer.jsp" %>