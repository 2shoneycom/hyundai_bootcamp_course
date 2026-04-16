<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>내 정보</title>
		<c:import url="/WEB-INF/views/layout/head.jsp" />		
	</head>
	<body>
		<div id="wrap">
        	<!--  top -->         
        	<c:import url="/WEB-INF/views/layout/top.jsp" />
			<section>		
				<h1>내 정보</h1>
				<table>
					<tr>
						<th>아이디</th>
						<td>${memInfo.memId}</td>
					</tr>
					<tr>
						<th>이름</th>
						<td>${memInfo.memName}</td>
					</tr>	
					<tr>
						<th>이메일</th>
						<td>${memInfo.memEmail}</td>
					</tr>	
					<tr>
						<th>핸드폰 번호</th>
						<td>${memInfo.memHp}</td>
					</tr>	
					<tr>
						<th>주소</th>
						<td>${memInfo.memAddress1} ${memInfo.memAddress2}</td>
					</tr>						
				</table>
				<button><a href="<c:url value='/member/updateInfo/${memInfo.memId}'/>">정보 수정</a></button>
				<button><a id="deleteMember" data-id="${memInfo.memId}">회원 탈퇴</a></button>
			</section>
		
			<!--  bottom -->         
        	<c:import url="/WEB-INF/views/layout/bottom.jsp" />
      </div>
	</body>
</html>