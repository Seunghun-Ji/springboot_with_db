<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE>
<html>
<head>
    <title>HELLO WORLD</title>
</head>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">

$(document).ready(function(){
	$("#btn_add").on("click", function(){
		addData();
	});
	$("#btn_getList").on("click", function(){
		getList();
	});
});

function getList(){
	$.ajax({
		type : "GET",
		url : "${pageContext.request.contextPath}/hello/list",
		contentType : "application/json; charset=utf8",
		dataType : "json",
		async: false,
		success : function(data) {
			alert(JSON.stringify(data));
		},
		fail : function() {
			console.log("실패", data);
		}
	});
}

function addData(){
	var helloWorld = {
			userId : "test01",
			userName : "test01",
			content : "helloWorld add test"
	};
	$.ajax({
		type : "POST",
		url : "${pageContext.request.contextPath}/hello",
		contentType : "application/json; charset=utf8",
		dataType : "json",
		async: false,
		data : JSON.stringify(helloWorld),
		success : function(data) {
			console.log("성공", data);
		},
		fail : function() {
			console.log("실패", data);
		}
	});
}

</script>

<body>

<div style="width:500px; height:50px;">
HELLO WORLD~!
</div>

<input id="btn_add" type="button" value="등록"/>
<input id="btn_getList" type="button" value="목록 조회"/>

</body>
</html>