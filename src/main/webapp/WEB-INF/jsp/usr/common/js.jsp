<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>

<scripte>
	let msg = '${msg}'.trim();
	
	if (msg) {
		alert(msg);
	}
	
	history.back();
</scripte>