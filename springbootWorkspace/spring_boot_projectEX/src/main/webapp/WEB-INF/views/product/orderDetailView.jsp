<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>주문 내역 상세 보기</title>	
		<!-- head.jsp import -->
		<c:import url = "/WEB-INF/views/layout/head.jsp"></c:import>	 
	</head>
	<body>
		<div id="wrap">
			<!-- top.jsp import -->
			<c:import url = "/WEB-INF/views/layout/top.jsp"></c:import>
			<br>
			<h3>주문 조회</h3>	<br>
			<table border="1" width="70%">
				<tr>
					<th>주문 번호</th>
					<td>${orderDto.ordNo}</td>
				</tr>
				<tr>
					<th>주문 날짜</th>
					<td>${orderDto.ordDate}</td>
				</tr>	
				<tr>
					<th>주문자</th>
					<td>${orderDto.ordReceiver}</td>
				</tr>	
				<tr>
					<th>배송지 우편번호</th>
					<td>${orderDto.ordRcvZipcode}</td>
				</tr>	
				<tr>
					<th>배송지 주소 1</th>
					<td>${orderDto.ordRcvAddress1}</td>
				</tr>
				<tr>
					<th>배송지 주소 2</th>
					<td>${orderDto.ordRcvAddress2}</td>
				</tr>
				<tr>
					<th>수령인 휴대폰 번호</th>
					<td>${orderDto.ordRcvPhone}</td>
				</tr>
				<tr>
					<th>요청 메시지</th>
					<td>${orderDto.ordRcvMsg}</td>
				</tr>
				<tr>
					<th>결제 정보</th>
					<td>${orderDto.ordPay}</td>
				</tr>	
					
			</table><br><br>
			
			<!--  index 페이지로 이동 링크 추가 -->
			<a href="<c:url value='/' />">홈으로 이동</a><br><br>
			<!-- footer.jsp import -->
			<c:import url = "/WEB-INF/views/layout/bottom.jsp"></c:import>
		</div>
	</body>
</html>