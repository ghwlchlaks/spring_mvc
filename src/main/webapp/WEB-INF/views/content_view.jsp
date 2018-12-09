<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/HTML;charset=UTF-8" pageEncoding="UTF-8" %>
<%
request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
	<title>insert list</title>
</head>
<body>

	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<form action="modify" method="post">
			<input type="hidden" name="bId" value="${content_view.bId}">
			<tr>
				<td>번호</td>
				<td>${content_view.bId}</td>
			</tr>
			<tr>
				<td>히트</td>
				<td>${content_view.bHit}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="bName" value="${content_view.bName}"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="bTitle" value="${content_view.bTitle}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" name="bContents" value="${content_view.bContents}"></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="수정">&nbsp;&nbsp; 
				<a href="list">목록보기</a>&nbsp;&nbsp; 
				<a href="delete?bId=${content_view.bId}">삭제</a> &nbsp;&nbsp;
				<%-- <a href="reply_view?bId=${content_view.bId}">댓글</a> --%>
				</td>
			</tr>
		</form>
	</table>
	
</body>
</html>
