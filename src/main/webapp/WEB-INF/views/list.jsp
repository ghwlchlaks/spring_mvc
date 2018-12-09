<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/HTML;charset=UTF-8" pageEncoding="UTF-8" %>
<%
request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
	<title>list</title>
</head>
<body>

	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>제목</td>
			<td>날짜</td>
			<td>조회수</td>
		</tr>
		<c:forEach items="${list}" var="dtos">
			<tr>
				<td>${dtos.bId}</td>
				<td>${dtos.bName}</td>
				<td>
					<c:forEach begin="1" end="${dtos.bIndent}">-</c:forEach>
					<a href="content_view?bId=${dtos.bId}">${dtos.bTitle}</a>
				</td>
				<td>${dtos.bDate}</td>
				<td>${dtos.bHit}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5"><a href="write_view">글 작성</a></td>
		</tr>
	</table>
	
</body>
</html>
