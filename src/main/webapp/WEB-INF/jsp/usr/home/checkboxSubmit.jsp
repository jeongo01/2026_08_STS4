<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<c:set var="pageTitle" value="CHECKBOX_SUBMIT" />

<%@ include file="../common/header.jsp" %>

	<section class="mt-8">
		<div class="container mx-auto">
			<c:forEach var="id" items="${ids }">
				<div>${id }</div>
			</c:forEach>
		</div>
	</section>

<%@ include file="../common/footer.jsp" %>