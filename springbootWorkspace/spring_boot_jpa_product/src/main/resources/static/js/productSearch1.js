/**
 * ajax 활용한 상품검색요청 스크립트
 */
 
 $(document).ready(function(){
 	$("#prdSearchFrm1").on('submit',function(){
 		event.preventDefault();
 		
 		//form 내부의 여러 input 관련 value를 쿼리스트링 방식의 데이터로 변환
 		//type=prdName&keyword=노트북 으로 자동 구성
 		let formData = $(this).serialize();
 		
 		let keyword = $("#keyword").val(); 
 		let type = $("#type").val();
 		
 		if(keyword==""||type==""){
 			alert("검색조건과 검색어를 입력하세요");
 		}else{
 			$.ajax({
 			  type:"post",
 			  url: "/mybatis/product/productSearch1",
 			  data:formData,
 			  success:function(result){
 			  		console.log(result);
 			  		//반환결과 js 이용 searchResultBox 내부에 테이블 형태로 표현
 			  		//기존 검색 결과 지우기
 			  		$("#searchResultBox").empty();
 			  		$("#searchResultBox").append('<table id="resultTable" border="1" width="500">'+
  												 '<tr><th>상품번호</th><th>상품명</th><th>상품가격</th>' +
	 											 '<th>제조사</th><th>재고</th><th>제조일</th><th>사진</th></tr>');
					 if(result==""){//검색 결과가 없는 경우
					 	$("#resultTable").append('<tr align="center"><td colspan="7">찾는 상품이 없습니다</td></tr>');
					 }else{
					 for(let i=0; i<result.length; i++) {
					 	let prd_date = new Date(result[i].prdDate);
					 	let year = prd_date.getFullYear();
					 	let month = (prd_date.getMonth()+1).toString().padStart(2,'0');
					 	let date = (prd_date.getDate()).toString().padStart(2,'0');
					 	let prdDate = `${year}-${month}-${date}`
					 	$("#resultTable").append('<tr><td>' + result[i].prdNo+'</td><td>' +
				    										  result[i].prdName+'</td><td>' +
				    										  result[i].prdPrice+'</td><td>' +
				    										  result[i].prdCompany+'</td><td>' +
				    										  result[i].prdStock+'</td><td>' +
				    										  prdDate+'</td><td>' +
				    										  '<img src="/mybatis/prd_images/'+
				    											  result[i].prdNo +
				    											  '.jpg" width="30" height="20"></td></tr>');				  
					 	
					 }//for						 			 
					 }//else
					 $("#searchResultBox").append("</table>");
 			  },
 			  error:function(){
 			  	alert("전송실패");
 			  }
 			
 			});//ajax
 			
 			}//else 끝
 		
 		
 		
 	
 	});//on 
 });//ready