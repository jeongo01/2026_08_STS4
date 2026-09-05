<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>LIST</title>
</head>
<body>
	<h1>LIST PAGE</h1>
	
<section class="mt-8 text-xl">
	<div class="container mx-auto px-3">
		<div>
			<table class="table table-lg">
				<thead class="text-lg">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성일</th>
						<th>작성자</th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach var="article" items="${articles }">
						<tr>
							<td>${article.id }</td>
							<td class="hover:underline"><a href="detail?id=${article.id }">${article.title }</a></td>
							<td>${article.writerName }</td>
							<td>${article.regDate.substring(2, 16) }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</section>
<%@ include file="../common/footer.jsp" %>